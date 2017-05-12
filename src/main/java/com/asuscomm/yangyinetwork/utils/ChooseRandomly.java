package com.asuscomm.yangyinetwork.utils;

import java.util.List;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
public class ChooseRandomly {
    public static int[] chooseRandomlyInStonePoints(List<int[]> stonePoints) {
        int siz = stonePoints.size();
        double rnd = Math.random()*siz;
        int idx = (int)(rnd % siz);
        return stonePoints.get(idx);
    }

    public static int[][] choosePairRandomlyInStonePoints(List<int[][]> stonePoints) {
        int siz = stonePoints.size();
        double rnd = Math.random()*siz;
        int idx = (int)(rnd % siz);
        return stonePoints.get(idx);
    }

    public static int[][] choosePairRandomlyInBoard(int[][] board) {
        List<int[][]> stonePointPairs = PossibleNextStone.possibleNextStonePair(board);
        return choosePairRandomlyInStonePoints(stonePointPairs);
    }

    public static int[] chooseRandomlyInBoard(int[][] board) {
        List<int[]> stonePoints = PossibleNextStone.possibleNextStone(board);
        return chooseRandomlyInStonePoints(stonePoints);
    }
}
