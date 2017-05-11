package com.asuscomm.yangyinetwork.test;

import lombok.extern.slf4j.Slf4j;

import static com.asuscomm.yangyinetwork.ai.JYP.evaluation.Eval.eval;
import static com.asuscomm.yangyinetwork.ai.JYP.policy.Policy.policy;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.BLACK_STONE;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.WHITE_STONE;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoard;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
@Slf4j
public class HeuristicProbMapFunc {
    public static void testHeuristicFunc(int[][] board) {
        printBoard(board);
        log.info("HeuristicProbMapFunc/testHeuristicFunc: BLACK=[{}]",eval(board, BLACK_STONE));
        log.info("HeuristicProbMapFunc/testHeuristicFunc: WHITE=[{}]",eval(board, WHITE_STONE));
    }

    public static void testProbMap(int[][] board) {
        policy(board, BLACK_STONE);
//        printBoard(board);
    }
}
