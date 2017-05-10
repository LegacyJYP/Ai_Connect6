package com.asuscomm.yangyinetwork;

import com.asuscomm.yangyinetwork.ai.Ai;
import com.asuscomm.yangyinetwork.ai.JYP.AiJYPImpl;

import static com.asuscomm.yangyinetwork.utils.PrintUtils.printStonePoint;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
public class Main {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {2,0,0,0,0,1,2,0,0,0},
                {1,2,0,0,0,1,2,0,0,0},
                {1,0,2,0,1,1,2,0,0,0},
                {1,0,0,0,0,1,2,0,0,0},
                {1,0,1,0,2,1,2,0,0,0},
                {2,1,0,0,0,2,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };

//        System.out.println();
//        Ai ai = new AiRandomImpl();
        Ai ai = new AiJYPImpl();
        ai.findSolution(board, new Ai.OnSolutionListener() {
            public void onSolution(int[][] stonePointPair) {
                printStonePoint(stonePointPair[0]);
                printStonePoint(stonePointPair[1]);
            }
        });
//        printStonePoints(RuleChecker.isGameEnd(board, new int[]{3,3}));
    }
}
