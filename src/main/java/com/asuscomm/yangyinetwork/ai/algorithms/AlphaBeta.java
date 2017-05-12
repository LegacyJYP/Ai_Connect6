package main.java.com.asuscomm.yangyinetwork.ai.algorithms;

import main.java.com.asuscomm.yangyinetwork.ai.algorithms.domain.TreeForAlphabeta;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static main.java.com.asuscomm.yangyinetwork.consts.CONSTS.INF;
import static main.java.com.asuscomm.yangyinetwork.consts.GAME_EVAL.GAMEEND;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
@Slf4j
public class AlphaBeta {
    public static TreeForAlphabeta alphabeta(TreeForAlphabeta node, int depth,
                                             double alpha, double beta, boolean maximizingPlayer, int maximumDepth) {
        double v = 0;
        TreeForAlphabeta bestNode = node;
        if(node.getEval() >= GAMEEND || node.getEval() <= (-GAMEEND) || node.getChildrenSize() == 0 || depth == maximumDepth) {
//            log.info("AlphaBeta/alphabeta: GAMEEND OR MAXIMUMDEPTH [{}]",bestNode.getEval());
            return bestNode;
        }

        if (maximizingPlayer) {
            v = -INF;
            List<?> children = node.getChildren();
            for (int i = 0; i < children.size(); i++) {
                TreeForAlphabeta child = (TreeForAlphabeta) children.get(i);
                double w = alphabeta( child, depth + 1, alpha, beta, false, maximumDepth).getEval();

                if (v < w) {
                    bestNode = child;
                    v = w;
//                    log.info("AlphaBeta/alphabeta: updateBestNode=[{}]",depth);printBoard(((Node)bestNode).getBoard());
                }
                alpha = max(alpha, v);
                if(beta <= alpha) {
                    break;
                }
            }

            return bestNode;
        } else {
            v = INF;
            List<?> children = node.getChildren();
            for (int i = 0; i < children.size(); i++) {
                TreeForAlphabeta child = (TreeForAlphabeta) children.get(i);
                double w = -(alphabeta( child, depth + 1, alpha, beta, true, maximumDepth).getEval());
                if (v > w) {
                    bestNode = child;
                    v = w;
//                    log.info("AlphaBeta/alphabeta: updateBestNode=[{}]",depth);printBoard(((Node)bestNode).getBoard());
                }
                beta = -max(-beta, -v);
                if(beta <= alpha) {
                    break;
                }
            }
            return bestNode;
        }
    }



    private static double max(double prevone, double newone) {
        if(prevone > newone) {
            return prevone;
        } else {
            return newone;
        }
    }
}

