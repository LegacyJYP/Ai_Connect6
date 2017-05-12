package com.asuscomm.yangyinetwork.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.*;
import static com.asuscomm.yangyinetwork.utils.BoardUtils.fillBoardAroundPoint;
import static com.asuscomm.yangyinetwork.utils.Clone2darray.clone2darray;
import static com.asuscomm.yangyinetwork.utils.Clone2darray.clone2dzeros;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoard;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
@Slf4j
public class PossibleNextStone {
    public static ArrayList<int[]> possibleNextStone(int[][] board) {
        ArrayList<int[]> possibleNextStones = new ArrayList<int[]>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == NONE_STONE) { // todo remove ==
                    possibleNextStones.add(new int[]{i, j});
                }
            }
        }

        return possibleNextStones;
    }

    public static ArrayList<int[][]> possibleNextStonePair(int[][] board) {
        ArrayList<int[]> possibleNextStones = possibleNextStone(board);
        ArrayList<int[][]> possibleNextStonePairs = new ArrayList<int[][]>();

        int length = possibleNextStones.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int[] firstStone = possibleNextStones.get(i);
                int[] secondStone = possibleNextStones.get(j);
//                log.info("PossibleNextStone/possibleNextStonePair: [{}], [{}]", Arrays.toString(firstStone), Arrays.toString(secondStone));
                possibleNextStonePairs.add(new int[][]{firstStone, secondStone});
            }
        }
        return possibleNextStonePairs;
    }

    public static ArrayList<int[][]> effectiveNextStonePair(int[][] board) {
        ArrayList<int[]> possibleNextStones = effectiveNextStone(board);
        ArrayList<int[][]> possibleNextStonePairs = new ArrayList<int[][]>();

        int length = possibleNextStones.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int[] firstStone = possibleNextStones.get(i);
                int[] secondStone = possibleNextStones.get(j);
//                log.info("PossibleNextStone/possibleNextStonePair: [{}], [{}]", Arrays.toString(firstStone), Arrays.toString(secondStone));
                possibleNextStonePairs.add(new int[][]{firstStone, secondStone});
            }
        }
        return possibleNextStonePairs;
    }

    public static ArrayList<int[]> effectiveNextStone(int[][] board) {
        ArrayList<int[]> effectiveNextStones = new ArrayList<int[]>();
        int[][] effectiveRange = clone2dzeros(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == BLACK_STONE || board[i][j] == WHITE_STONE) {
                    effectiveRange = fillBoardAroundPoint(effectiveRange, i,j);
                }
            }
        }

//        log.info("PossibleNextStone/effectiveNextStone: effectRange");
//        printBoard(effectiveRange);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == NONE_STONE && effectiveRange[i][j] == EFFECTIVE_POSITION) {
                    effectiveNextStones.add(new int[]{i, j});
                }
            }
        }

        return effectiveNextStones;
    }
}