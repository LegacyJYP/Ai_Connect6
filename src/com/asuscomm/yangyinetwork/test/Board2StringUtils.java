package com.asuscomm.yangyinetwork.test;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.asuscomm.yangyinetwork.ai.JYP.evaluation.Evaluation.everyEnemySequence;
import static com.asuscomm.yangyinetwork.ai.JYP.evaluation.Evaluation.everySequence;
import static com.asuscomm.yangyinetwork.ai.JYP.evaluation.Evaluation.wallToEnemy;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printStringList;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
@Slf4j
public class Board2StringUtils {
    public static void testEverySequence(int[][] board) {
        List<String> seqs = everySequence(board);
        List<String> enemySeqs = everyEnemySequence(board);

        log.info("Board2StringUtils/everySequenceTest: mine");
        printStringList(seqs);
        log.info("Board2StringUtils/everySequenceTest: enemy's");
        printStringList(enemySeqs);
    }

    public static void testWallToEnemy(int[][] board) { //     seqs = wallToEnemy(seqs); <- 주석화 해야함
        List<String> seqs = everySequence(board);
        List<String> enemySeqs = everyEnemySequence(board);
        log.info("Board2StringUtils/everySequenceTest: before");
        printStringList(seqs);
        seqs = wallToEnemy(seqs);
        log.info("Board2StringUtils/everySequenceTest: after");
        printStringList(seqs);

        log.info("Board2StringUtils/everySequenceTest: enemy's before");
        printStringList(enemySeqs);
        enemySeqs = wallToEnemy(enemySeqs);
        log.info("Board2StringUtils/everySequenceTest: enemy's after");
        printStringList(enemySeqs);
    }
}
