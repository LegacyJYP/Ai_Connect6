package com.asuscomm.yangyinetwork.ai.JYP;


import com.asuscomm.yangyinetwork.game.StonePoint;
import com.asuscomm.yangyinetwork.utils.domain.BaseClass;
import com.asuscomm.yangyinetwork.utils.domain.Node;
import lombok.extern.slf4j.Slf4j;


import static com.asuscomm.yangyinetwork.ai.JYP.AlphaBeta.alphabeta;
import static com.asuscomm.yangyinetwork.ai.JYP.AlphaBetaForLoop.alphabetaforloop;
import static com.asuscomm.yangyinetwork.consts.CONSTS.INF;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.BLACK_STONE;
import static com.asuscomm.yangyinetwork.utils.ChooseRandomly.chooseRandomlyInBoard;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
@Slf4j
public class AiJYPImpl extends BaseClass{
    private boolean terminate;
    final int MAXIMUM_DEPTH = 100;
    final double EXTEND_TRHESH_EVAL = 0.1;

    @Override
    public void run() {
        {
            log.info("AiJYPImpl/run: ");

            int stoneType = BLACK_STONE;
            int remainStones = 2;
            if (remainStones == 1) {
                setSolution(new int[][]{chooseRandomlyInBoard(board)});
            } else {
                Node rootTree = new Node(board, stoneType);

//                iterativeDeepeningSearch(rootTree);
                int presentDepth = 0;
                while(true) {
                    presentDepth = presentDepth + 1;
                    rootTree.extendByEval(presentDepth, EXTEND_TRHESH_EVAL);
                    log.info("AiJYPImpl/iterativeDeepeningSearch: [{}]", presentDepth);
                    Node bestNode = alphabeta(rootTree,0,-INF, INF, true, presentDepth);
                    if(this.terminate) {
                        break;
                    }
//                    log.info("AiJYPImpl/run: [{}]",this.terminate);
//                    if(this.terminate) {
//                        break;
//                    }
                    StonePoint[] stonePointPair = bestNode.getStonePoints();
                    setSolution(stonePointPair);

                    if(presentDepth >= MAXIMUM_DEPTH) {
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void terminate() {
        log.info("AiJYPImpl/terminate: terminate");
        super.terminate();
        this.terminate = true;
        AlphaBetaForLoop.setTerminate(true);
    }
}
