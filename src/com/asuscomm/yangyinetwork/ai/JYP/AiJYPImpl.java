package com.asuscomm.yangyinetwork.ai.JYP;


import com.asuscomm.yangyinetwork.ai.algorithms.AlphaBetaForLoop;
import com.asuscomm.yangyinetwork.ai.commons.AiBaseClass;
import com.asuscomm.yangyinetwork.ai.algorithms.domain.Node;
import lombok.extern.slf4j.Slf4j;


import static com.asuscomm.yangyinetwork.ai.algorithms.AlphaBeta.alphabeta;
import static com.asuscomm.yangyinetwork.ai.JYP.config.IterativeDeepening.MAXIMUM_DEPTH;
import static com.asuscomm.yangyinetwork.ai.JYP.config.IterativeDeepening.START_DEPTH;
import static com.asuscomm.yangyinetwork.consts.CONSTS.INF;
import static com.asuscomm.yangyinetwork.utils.ChooseRandomly.chooseRandomlyInBoard;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoard;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
@Slf4j
public class AiJYPImpl extends AiBaseClass {

    public AiJYPImpl() {
    }

    @Override
    public void run() {
        {
            log.info("AiJYPImpl/run: ");

            if (this.remainStones == 1) {
                setSolution(new int[][]{chooseRandomlyInBoard(board)});
            } else {
                Node rootNode = new Node(board, stoneType);

//                iterativeDeepeningSearch(rootNode);
                int presentDepth = START_DEPTH;
                while(true) {
                    rootNode.extendByEval(presentDepth);
                    log.info("AiJYPImpl/iterativeDeepeningSearch: [{}]", presentDepth);
                    Node bestNode = (Node)alphabeta(rootNode,0, -INF, INF, true, presentDepth);
                    log.info("AiJYPImpl/run: bestNode");
                    printBoard(bestNode.getBoard());
                    if(this.terminate) {
                        break;
                    }
                    int[][] stonePointPair = bestNode.getMothersChild().getStonePoints();
                    setSolution(stonePointPair);

                    if(presentDepth >= MAXIMUM_DEPTH) {
                        break;
                    }
                    presentDepth = presentDepth + 1;
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
