package com.asuscomm.yangyinetwork.test;


import com.asuscomm.yangyinetwork.utils.PossibleNextStone;

import java.util.Arrays;
import java.util.List;

import static com.asuscomm.yangyinetwork.utils.ChooseRandomly.chooseRandomlyInStonePoints;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printStonePoint;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printStonePoints;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
public class AiTest {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {1,0,0,0,0,1,2,0,0,0},
                {1,0,0,0,0,1,2,0,0,0},
                {0,0,0,0,1,1,2,0,0,0},
                {0,0,0,1,0,1,2,0,0,0},
                {0,0,1,0,0,1,2,0,0,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };

//        testPossibleNextStone(board);
        testRandomNextStone(board);
    }



    public static void testPossibleNextStone(int[][] board) {
        printStonePoints(PossibleNextStone.possibleNextStone(board));
    }

    public static void testRandomNextStone(int[][] board) {
        List<int[]> possibleNextStone = PossibleNextStone.possibleNextStone(board);
        printStonePoint(chooseRandomlyInStonePoints(possibleNextStone));
    }
}
