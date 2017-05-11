package com.asuscomm.yangyinetwork;

import com.asuscomm.yangyinetwork.ai.commons.Ai;
import com.asuscomm.yangyinetwork.ai.JYP.AiJYPImpl;
import lombok.extern.slf4j.Slf4j;

import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.BLACK_STONE;
import static com.asuscomm.yangyinetwork.test.AiTest.testJYPAiImpl;
import static com.asuscomm.yangyinetwork.test.Board2StringUtils.testWallToEnemy;
import static com.asuscomm.yangyinetwork.test.HeuristicProbMapFunc.testHeuristicFunc;
import static com.asuscomm.yangyinetwork.test.HeuristicProbMapFunc.testProbMap;
import static com.asuscomm.yangyinetwork.test.Samples.getSample;
import static com.asuscomm.yangyinetwork.test.alphabeta.TestCode.alphabetaTest;
import static com.asuscomm.yangyinetwork.utils.BoardUtils.putStonePoints;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoard;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoardWithNextStones;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printStonePoint;

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

        testJYPAiImpl();

//        printStonePoints(RuleChecker.isGameEnd(board, new int[]{3,3}));
    }




}
