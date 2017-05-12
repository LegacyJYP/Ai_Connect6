package main.java.com.asuscomm.yangyinetwork.test;

import lombok.extern.slf4j.Slf4j;
import main.java.com.asuscomm.yangyinetwork.ai.JYP.evaluation.Evaluation;
import main.java.com.asuscomm.yangyinetwork.utils.PrintUtils;

import java.util.List;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
@Slf4j
public class Board2StringUtils {
    public static void testEverySequence(int[][] board) {
        List<String> seqs = Evaluation.everySequence(board);
        List<String> enemySeqs = Evaluation.everyEnemySequence(board);

        log.info("Board2StringUtils/everySequenceTest: mine");
        PrintUtils.printStringList(seqs);
        log.info("Board2StringUtils/everySequenceTest: enemy's");
        PrintUtils.printStringList(enemySeqs);
    }

    public static void testWallToEnemy(int[][] board) { //     seqs = wallToEnemy(seqs); <- 주석화 해야함
        List<String> seqs = Evaluation.everySequence(board);
        List<String> enemySeqs = Evaluation.everyEnemySequence(board);
        log.info("Board2StringUtils/everySequenceTest: before");
        PrintUtils.printStringList(seqs);
        seqs = Evaluation.wallToEnemy(seqs);
        log.info("Board2StringUtils/everySequenceTest: after");
        PrintUtils.printStringList(seqs);

        log.info("Board2StringUtils/everySequenceTest: enemy's before");
        PrintUtils.printStringList(enemySeqs);
        enemySeqs = Evaluation.wallToEnemy(enemySeqs);
        log.info("Board2StringUtils/everySequenceTest: enemy's after");
        PrintUtils.printStringList(enemySeqs);
    }
}
