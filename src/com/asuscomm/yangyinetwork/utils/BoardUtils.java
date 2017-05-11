package com.asuscomm.yangyinetwork.utils;

import java.util.ArrayList;
import java.util.List;

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

    public static int[][] string2board(String[] boardString) {
        int row = boardString.length;
        int col = boardString[0].length();

        int[][] board = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = Character.getNumericValue(boardString[i].charAt(j));
            }
        }

        return board;
    }

    public static List<String> board2string(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        List<String> boardString = new ArrayList<String>();
        for (int i = 0; i < row; i++) {
            String eachLine = "";
            for (int j = 0; j < col; j++) {
                eachLine += board[i][j];
            }
            boardString.add(eachLine);
        }

        return boardString;
    }
}
