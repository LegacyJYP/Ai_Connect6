package main.java.com.asuscomm.yangyinetwork.test;


import main.java.com.asuscomm.yangyinetwork.ai.JYP.AiJYPImpl;
import main.java.com.asuscomm.yangyinetwork.ai.commons.Ai;
import main.java.com.asuscomm.yangyinetwork.utils.PossibleNextStone;

import java.util.List;

import static main.java.com.asuscomm.yangyinetwork.consts.GAME_BOARD.BLACK_STONE;
import static main.java.com.asuscomm.yangyinetwork.utils.ChooseRandomly.chooseRandomlyInStonePoints;
import static main.java.com.asuscomm.yangyinetwork.utils.PrintUtils.printBoardWithNextStones;
import static main.java.com.asuscomm.yangyinetwork.utils.PrintUtils.printStonePoint;
import static main.java.com.asuscomm.yangyinetwork.utils.PrintUtils.printStonePoints;

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
        final int[][] board = Samples.getSample(0);
        final int stoneType = BLACK_STONE;
        final int remainStones = 2;

        Ai ai = new AiJYPImpl();
        ai.setStoneType(stoneType);
        ai.findSolution(board, remainStones, new Ai.OnSolutionListener() {
            public void onSolution(int[][] stonePointPair, int remainStones) {
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
