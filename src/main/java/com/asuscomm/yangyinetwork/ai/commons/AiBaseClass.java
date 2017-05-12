package com.asuscomm.yangyinetwork.ai.commons;

import lombok.extern.slf4j.Slf4j;


import static com.asuscomm.yangyinetwork.consts.GAME_RULE.REAL_TIME_LIMITS;
import static com.asuscomm.yangyinetwork.consts.GAME_RULE.TIMELIMIT_CHECK_PERIOD;
import static com.asuscomm.yangyinetwork.utils.ChooseRandomly.choosePairRandomlyInBoard;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoardWithNextStones;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printStonePointPairs;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
@Slf4j
public abstract class AiBaseClass implements Ai, Runnable {
    private long startTime;
    private Ai.OnSolutionListener mListener;
    protected int[][] currentOptimal;

    protected int stoneType;
    protected int[][] board;
    protected Thread findSolThread;

    protected boolean terminate;
    protected int remainStones;

    protected void tic() {
        this.startTime = System.currentTimeMillis();
    }

    protected long toc() {
        long toc = System.currentTimeMillis() - this.startTime;
        log.debug("AiBaseClass/toc: [{}]",toc);
        return toc;
    }

    public void findSolution(int[][] board, int remainStones, Ai.OnSolutionListener listener) {
        this.terminate = false;
        this.board = board;
        tic();
        this.mListener = listener;
        this.remainStones = remainStones;
        this.findSolThread = new Thread(this);
        this.findSolThread.start();
        while(true) {
            if(this.terminate) {
                log.info("AiBaseClass/findSolution: terminatedByAi");
                break;
            }

            if(toc()> REAL_TIME_LIMITS) {
                log.info("AiBaseClass/findSolution: REAL_TIME_LIMITS");
                terminate();
                break;
            }
            try {
                Thread.sleep(TIMELIMIT_CHECK_PERIOD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        done();
    }

    protected void done() {
        mListener.onSolution(this.currentOptimal, this.remainStones);
        mListener = null;
    }

    protected void terminate() {
        this.terminate = true;
        this.findSolThread.interrupt();
    }

    abstract public void run();

    public void setStoneType(int stoneType) {
        this.stoneType = stoneType;
    }

    protected void setSolution(int[][] stonePointPair) {
        log.info("AiBaseClass/setSolution: ");
        printStonePointPairs(stonePointPair);
//        printBoardWithNextStones(board, stonePointPair, stoneType);
        this.currentOptimal = stonePointPair;
    }
}
