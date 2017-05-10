package com.asuscomm.yangyinetwork.ai.JYP;


import com.asuscomm.yangyinetwork.game.StonePoint;
import com.asuscomm.yangyinetwork.utils.domain.BaseClass;
import com.asuscomm.yangyinetwork.utils.domain.Node;
import lombok.extern.slf4j.Slf4j;


import static com.asuscomm.yangyinetwork.ai.JYP.AlphaBeta.alphabeta;
import static com.asuscomm.yangyinetwork.consts.CONSTS.INF;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.BLACK_STONE;
import static com.asuscomm.yangyinetwork.utils.ChooseRandomly.chooseRandomlyInBoard;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
@Slf4j
public class AiJYPImpl extends BaseClass{
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
                    rootTree.extend(presentDepth);
                    log.info("AiJYPImpl/iterativeDeepeningSearch: [{}]", presentDepth);
                    Node bestNode = alphabeta(rootTree,0,-INF, INF, true, presentDepth);
                    StonePoint[] stonePointPair = bestNode.getStonePoints();
                    setSolution(stonePointPair);
                }
            }
        }
    }
}
