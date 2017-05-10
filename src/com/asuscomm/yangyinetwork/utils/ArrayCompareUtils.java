package com.asuscomm.yangyinetwork.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
@Slf4j
public class ArrayCompareUtils {
    public static int[][] before;
    public static void boardCompare(int[][] board) {
        int row=board.length, col=board[0].length;
        int[][] after = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                after[i][j] = board[i][j];
            }
        }


        if(before != null) {
            int count=0;
            for (int i = 0; i < row; i++) {
//                log.info("ArrayCompareUtils/compare: row=[{}] after =[{}]",i,Arrays.toString(after[i]));
//                log.info("ArrayCompareUtils/compare: row=[{}] before=[{}]",i,Arrays.toString(before[i]));
                for (int j = 0; j < col; j++) {
                    if(after[i][j] != before[i][j]) {
                        count++;
                    }
                    before[i][j] = after[i][j];
                }
            }
//            log.info("ArrayCompareUtils/compare: count=[{}]",count);
        } else {
            before = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    before[i][j] = after[i][j];
                }
            }
        }
    }
}
