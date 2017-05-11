package com.asuscomm.yangyinetwork.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.asuscomm.yangyinetwork.utils.BoardUtils.board2string;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
@Slf4j
public class PrintUtils {
    public static void printStonePoints(List<int[]> stonePoints) {
        for (int i = 0; i < stonePoints.size(); i++) {
            System.out.println(Arrays.toString(stonePoints.get(i)));
        }
    }

    public static void printStonePoint(int[] stonePoint) {
        System.out.println(Arrays.toString(stonePoint));
    }

    public static void printBoard(int[][] board) {

        List<String> boardString = board2string(board);

        for (int i = 0; i < boardString.size(); i++) {
            log.info("PrintUtils/printBoard: [{}]",boardString.get(i));
        }

//        for (int[] row:
//             board) {
//            log.info("PrintUtils/printBoard: [{}]",Arrays.toString(row));
//        }
    }
}
