package com.asuscomm.yangyinetwork.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

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
        for (int[] row:
             board) {
            log.info("PrintUtils/printBoard: [{}]",Arrays.toString(row));
        }
    }
}
