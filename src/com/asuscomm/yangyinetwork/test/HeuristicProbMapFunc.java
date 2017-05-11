package com.asuscomm.yangyinetwork.test;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.asuscomm.yangyinetwork.ai.JYP.evaluation.Evaluation.evaluation;
import static com.asuscomm.yangyinetwork.ai.JYP.policy.Policy.makeProbmapWithStonePairs;
import static com.asuscomm.yangyinetwork.ai.JYP.policy.Policy.nextStonePairsByPolicy;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.BLACK_STONE;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.WHITE_STONE;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoard;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printProbmap;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
@Slf4j
public class HeuristicProbMapFunc {
    public static void testHeuristicFunc(int[][] board) {
        printBoard(board);
        log.info("HeuristicProbMapFunc/testHeuristicFunc: BLACK=[{}]",evaluation(board, BLACK_STONE));
        log.info("HeuristicProbMapFunc/testHeuristicFunc: WHITE=[{}]",evaluation(board, WHITE_STONE));
    }

    public static void testProbMap(int[][] board) {
        List<int[][]> nextStonePairs = nextStonePairsByPolicy(board, BLACK_STONE);
        double[][] probmap = makeProbmapWithStonePairs(board, nextStonePairs);
        log.info("Policy/policy: printProbmap");
        printProbmap(probmap);
//        printBoard(board);
    }
}
