package main.java.com.asuscomm.yangyinetwork.test;

import lombok.extern.slf4j.Slf4j;
import main.java.com.asuscomm.yangyinetwork.ai.JYP.evaluation.Evaluation;
import main.java.com.asuscomm.yangyinetwork.consts.GAME_BOARD;
import main.java.com.asuscomm.yangyinetwork.utils.PrintUtils;

import java.util.List;

import static main.java.com.asuscomm.yangyinetwork.ai.JYP.policy.Policy.makeProbmapWithStonePairs;
import static main.java.com.asuscomm.yangyinetwork.ai.JYP.policy.Policy.nextStonePairsByPolicy;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
@Slf4j
public class HeuristicProbMapFunc {
    public static void testHeuristicFunc(int[][] board) {
        PrintUtils.printBoard(board);
        log.info("HeuristicProbMapFunc/testHeuristicFunc: BLACK=[{}]", Evaluation.evaluation(board, GAME_BOARD.BLACK_STONE));
        log.info("HeuristicProbMapFunc/testHeuristicFunc: WHITE=[{}]", Evaluation.evaluation(board, GAME_BOARD.WHITE_STONE));
    }

    public static void testProbMap(int[][] board) {
        List<int[][]> nextStonePairs = nextStonePairsByPolicy(board, GAME_BOARD.BLACK_STONE);
        double[][] probmap = makeProbmapWithStonePairs(board, nextStonePairs);
        log.info("Policy/policy: printProbmap");
        PrintUtils.printProbmap(probmap);
//        printBoard(board);
    }
}
