package com.asuscomm.yangyinetwork.test;


import com.asuscomm.yangyinetwork.ai.JYP.AiJYPImpl;
import com.asuscomm.yangyinetwork.ai.commons.Ai;
import com.asuscomm.yangyinetwork.utils.PossibleNextStone;

import java.util.Arrays;
import java.util.List;

import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.BLACK_STONE;
import static com.asuscomm.yangyinetwork.test.Samples.getSample;
import static com.asuscomm.yangyinetwork.utils.ChooseRandomly.chooseRandomlyInStonePoints;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoardWithNextStones;
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


    public static void testJYPAiImpl() {
        final int[][] board = getSample(4);
        final int stoneType = BLACK_STONE;

        Ai ai = new AiJYPImpl();
        ai.setStoneType(stoneType);
        ai.findSolution(board, 2, new Ai.OnSolutionListener() {
            public void onSolution(int[][] stonePointPair) {
                printStonePoint(stonePointPair[0]);
                printStonePoint(stonePointPair[1]);
                printBoardWithNextStones(board, stonePointPair, stoneType);
            }
        });
    }

    public static void testPossibleNextStone(int[][] board) {
        printStonePoints(PossibleNextStone.possibleNextStone(board));
    }

    public static void testRandomNextStone(int[][] board) {
        List<int[]> possibleNextStone = PossibleNextStone.possibleNextStone(board);
        printStonePoint(chooseRandomlyInStonePoints(possibleNextStone));
    }
}
