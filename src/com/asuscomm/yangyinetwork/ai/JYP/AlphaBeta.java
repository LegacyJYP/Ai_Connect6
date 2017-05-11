package com.asuscomm.yangyinetwork.ai.JYP;

import com.asuscomm.yangyinetwork.utils.domain.Node;

import static com.asuscomm.yangyinetwork.consts.CONSTS.INF;
import static com.asuscomm.yangyinetwork.consts.GAME_EVAL.GAMEEND;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
public class AlphaBeta {
    public static Node alphabeta(Node node, int depth,
                                  double alpha, double beta, boolean maximizingPlayer, int maximumDepth) {
        double v = 0;
        Node bestNode = node;
        if(node.getEval() >= GAMEEND || node.getEval() <= (-GAMEEND) || node.getChildrenSize() == 0 || depth == maximumDepth) {
            return bestNode;
        }

        if (maximizingPlayer) {
            v = -INF;
            for (Node child:
                    node.getChildren()) {
                double w = alphabeta( child, depth + 1, alpha, beta, false, maximumDepth).getEval();
                if (v < w) {
                    bestNode = child;
                    v = w;
                }
                alpha = max(alpha, v);
                if(beta <= alpha) {
                    break;
                }
            }

            return bestNode;
        } else {
            v = INF;
            for (Node child:
                    node.getChildren()) {
                double w = -(alphabeta( child, depth + 1, alpha, beta, true, maximumDepth).getEval());
                if (v > w) {
                    bestNode = child;
                    v = w;
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

