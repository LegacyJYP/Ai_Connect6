package com.asuscomm.yangyinetwork.utils;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
public class BoardUtils {
    public static int sum2dboard(int[][] board) {
        int sum = 0;
        for (int[] row:
                board) {
            for (int each:
                    row) {
                sum+=each;
            }
        }

        return sum;
    }
}
