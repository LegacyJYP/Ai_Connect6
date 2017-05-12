package com.asuscomm.yangyinetwork.test.alphabeta;

import lombok.extern.slf4j.Slf4j;

import static com.asuscomm.yangyinetwork.ai.algorithms.AlphaBeta.alphabeta;
import static com.asuscomm.yangyinetwork.consts.CONSTS.INF;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
@Slf4j
public class TestCode {
    public static void alphabetaTest() {
        NodeForTest sample = SampleNode.getSample();

        NodeForTest bestNode = (NodeForTest)alphabeta(sample,0, -INF, INF, true, 3);

        log.info("TestCode/alphabetaTest: [{}]",bestNode.getEval());
    }
}
