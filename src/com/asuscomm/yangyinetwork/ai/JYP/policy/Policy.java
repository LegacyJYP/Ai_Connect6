package com.asuscomm.yangyinetwork.ai.JYP.policy;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.asuscomm.yangyinetwork.ai.JYP.config.Policy.NEXT_STONE_PAIRS_THERSH_PERSENTAGE;
import static com.asuscomm.yangyinetwork.ai.JYP.evaluation.Eval.eval;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.BLACK_STONE;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.X;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.Y;
import static com.asuscomm.yangyinetwork.utils.BoardUtils.putStonePoints;
import static com.asuscomm.yangyinetwork.utils.Clone2darray.clone2darrayToDouble;
import static com.asuscomm.yangyinetwork.utils.PossibleNextStone.possibleNextStonePair;
import static com.asuscomm.yangyinetwork.utils.Sort.sortedIndex;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
@Slf4j
public class Policy {
    public static List<int[][]> nextStonePairsByPolicy(int[][] board, int stoneType) {
        List<int[][]> possibleNextStonePairs = possibleNextStonePair(board);
        List<int[][]> filteredNextStonePairs = new ArrayList<int[][]>();
        List<Double> evals = new ArrayList<Double>();

        for (int i = 0; i < possibleNextStonePairs.size(); i++) {
            int[][] stonePointPair = possibleNextStonePairs.get(i);
            int[][] afterBoard = putStonePoints(board, stonePointPair, stoneType);
//            log.info("Policy/policy: before");
//            printBoard(board);
//            printBoard(afterBoard);
            double ev= eval(afterBoard, stoneType);
            evals.add(ev);
            if(ev > 100) {
//                log.info("Policy/policy: after putStonePoints [{}], [{}], eval=[{}]",
//                        Arrays.toString(stonePointPair[0]), Arrays.toString(stonePointPair[1]), evals.get(i));
            }
        }
        List<Integer> sorted = null;
        sorted = sortedIndex(evals);

        for (int i = 0; i < possibleNextStonePairs.size() * NEXT_STONE_PAIRS_THERSH_PERSENTAGE; i++) {
            int idx = sorted.get(i);
            filteredNextStonePairs.add(possibleNextStonePairs.get(idx));
//            log.info("Policy/policy: possibleNextStonePairs=[{}], [{}] evals=[{}]",
//                    possibleNextStonePairs.get(idx)[0], possibleNextStonePairs.get(idx)[1], evals.get(idx));
        } // 1. 디버깅 2. CPP 3. 씨코드 참고 4. 정책망 가치망 고치기 5. 몬테카를로

        return filteredNextStonePairs;
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
