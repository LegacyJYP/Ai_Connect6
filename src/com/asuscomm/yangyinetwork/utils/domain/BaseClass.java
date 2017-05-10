package com.asuscomm.yangyinetwork.utils.domain;

import com.asuscomm.yangyinetwork.ai.Ai;
import com.asuscomm.yangyinetwork.game.StonePoint;
import lombok.extern.slf4j.Slf4j;


import static com.asuscomm.yangyinetwork.consts.GAME_RULE.REAL_TIME_LIMITS;
import static com.asuscomm.yangyinetwork.consts.GAME_RULE.TIMELIMIT_CHECK_PERIOD;
import static com.asuscomm.yangyinetwork.utils.ChooseRandomly.choosePairRandomlyInBoard;
import static com.asuscomm.yangyinetwork.utils.ChooseRandomly.chooseRandomlyInBoard;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
@Slf4j
public abstract class BaseClass implements Ai, Runnable {
    private long startTime;
    private int[][] currentOptimal;
    protected int[][] board;

    protected void tic() {
        this.startTime = System.currentTimeMillis();
    }

    protected long toc() {
        long toc = System.currentTimeMillis() - this.startTime;
        log.debug("BaseClass/toc: [{}]",toc);
        return toc;
    }

    public void findSolution(int[][] board, Ai.OnSolutionListener listener) {
        this.board = board;
        Thread findSolThread = new Thread(this);
        setSolution(choosePairRandomlyInBoard(board));
        tic();
        findSolThread.start();
        while(true) {
            if(toc()> REAL_TIME_LIMITS) {
                log.info("BaseClass/findSolution: REAL_TIME_LIMITS");
                findSolThread.interrupt();
                break;
            }
            try {
                Thread.sleep(TIMELIMIT_CHECK_PERIOD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        listener.onSolution(this.currentOptimal);
    }


    abstract public void run();

    protected void setSolution(int[][] stonePointPair) {
        this.currentOptimal = stonePointPair;
    }

    protected void setSolution(StonePoint[] stonePointPair) {
        this.setSolution(new int[][] { stonePointPair[0].getStonePoints(),
                stonePointPair[1].getStonePoints() } );
    }
}
