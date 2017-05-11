package com.asuscomm.yangyinetwork.ai.JYP.policy;

import com.asuscomm.yangyinetwork.game.StonePoint;
import com.asuscomm.yangyinetwork.utils.domain.Node;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.asuscomm.yangyinetwork.ai.JYP.evaluation.Eval.eval;
import static com.asuscomm.yangyinetwork.consts.CONSTS.INF;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.X;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.Y;
import static com.asuscomm.yangyinetwork.utils.BoardUtils.putStonePoints;
import static com.asuscomm.yangyinetwork.utils.Clone2darray.clone2darray;
import static com.asuscomm.yangyinetwork.utils.Clone2darray.clone2darrayToDouble;
import static com.asuscomm.yangyinetwork.utils.PossibleNextStone.possibleNextStonePair;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoard;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printProbmap;
import static com.asuscomm.yangyinetwork.utils.Sort.sortedIndex;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
@Slf4j
public class Policy {
    private  static double THERSH_PERSENTAGE = 0.1;

    public static double policy(int[][] board, int stoneType) {
        List<int[][]> possibleNextStonePairs = possibleNextStonePair(board);
        List<int[][]> filteredNextStonePairs = new ArrayList<int[][]>();
        List<Double> evals = new ArrayList<Double>();

        for (int i = 0; i < possibleNextStonePairs.size(); i++) {
            int[][] stonePointPair = possibleNextStonePairs.get(i);
            int[][] afterBoard = putStonePoints(board, stonePointPair, stoneType);
//            log.info("Policy/policy: before");
//            printBoard(board);
//            log.info("Policy/policy: after putStonePoints [{}], [{}]", Arrays.toString(stonePointPair[0]), Arrays.toString(stonePointPair[1]));
//            printBoard(afterBoard);
            evals.add(eval(afterBoard, stoneType));
        }

        List<Integer> sorted = sortedIndex(evals);

        for (int i = 0; i < possibleNextStonePairs.size() * THERSH_PERSENTAGE; i++) {
            int idx = sorted.get(i);
            filteredNextStonePairs.add(possibleNextStonePairs.get(idx));
//            log.info("Policy/policy: [{}]",evals.get(idx));
        }

        double[][] probmap = makeProbmapWithStonePairs(board, filteredNextStonePairs);

        log.info("Policy/policy: printProbmap");
        printProbmap(probmap);

        return 0;
    }

    public static double[][] makeProbmapWithStonePairs(int[][] board, List<int[][]> stonePairs) {
        double[][] result = clone2darrayToDouble(board);
        double prob = 1/((double)stonePairs.size())/2;
//        int count=0;
        for (int[][] stonePair:
                stonePairs) {
            for (int i = 0; i < stonePair.length; i++) {
                int x = stonePair[i][X];
                int y = stonePair[i][Y];
                result[x][y] += prob;
//                count++;
            }
        }

//        log.info("Policy/makeProbmapWithStonePairs: count=[{}], stonePairs.size=[{}]",count,stonePairs.size());

        return result;
    }
}
