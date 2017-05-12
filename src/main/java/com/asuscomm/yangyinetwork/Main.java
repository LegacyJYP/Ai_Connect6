package main.java.com.asuscomm.yangyinetwork;

import lombok.extern.slf4j.Slf4j;
import main.java.com.asuscomm.yangyinetwork.test.AiTest;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
//        testEverySequence(getSample(2));

//        testHeuristicFunc(getSample(4));
//        testHeuristicFunc(getSample(5));
//        testHeuristicFunc(getSample(6));

//        testWallToEnemy(getSample(4));
//        testProbMap(getSample(4));

//        System.out.println();
//        Ai ai = new AiRandomImpl();

//        https://www.youtube.com/watch?v=xBXHtz4Gbdo&t=158s
//        alphabetaTest();

        AiTest.testJYPAiImpl();

//        printStonePoints(RuleChecker.isGameEnd(board, new int[]{3,3}));
    }




}
