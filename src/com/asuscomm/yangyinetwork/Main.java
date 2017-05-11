package com.asuscomm.yangyinetwork;

import com.asuscomm.yangyinetwork.ai.Ai;
import com.asuscomm.yangyinetwork.ai.JYP.AiJYPImpl;
import lombok.extern.slf4j.Slf4j;

import static com.asuscomm.yangyinetwork.test.HeuristicProbMapFunc.testProbMap;
import static com.asuscomm.yangyinetwork.test.Samples.getSample;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printStonePoint;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
//        testEverySequence(getSample(2));
//        testHeuristicFunc(getSample(3));
//        testHeuristicFunc(getSample(4));
//        testWallToEnemy(getSample(4));
        testProbMap(getSample(4));

//        System.out.println();
//        Ai ai = new AiRandomImpl();
        Ai ai = new AiJYPImpl();
        ai.findSolution(getSample(4), 2, new Ai.OnSolutionListener() {
            public void onSolution(int[][] stonePointPair) {
                printStonePoint(stonePointPair[0]);
                printStonePoint(stonePointPair[1]);
            }
        });
//        printStonePoints(RuleChecker.isGameEnd(board, new int[]{3,3}));
    }




}
