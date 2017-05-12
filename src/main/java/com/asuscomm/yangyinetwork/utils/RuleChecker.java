package com.asuscomm.yangyinetwork.utils;

import com.asuscomm.yangyinetwork.consts.GAME_BOARD;

import java.util.ArrayList;
import java.util.List;

import static com.asuscomm.yangyinetwork.utils.RuleChecker.UPANDDOWN.DOWN;
import static com.asuscomm.yangyinetwork.utils.RuleChecker.UPANDDOWN.END;
import static com.asuscomm.yangyinetwork.utils.RuleChecker.UPANDDOWN.UP;

/**
 * Created by jaeyoung on 2017. 5. 9..
 */
public class RuleChecker {
    interface UPANDDOWN {
        int UP = 0;
        int DOWN = 1;
        int END = 2;
    }
    public static List<int[]> isGameEnd(int[][] board, int[] stonePoint) {
        int[][] DIRS = {
                {1, +1},

                {1, 0},

                {0, +1},

                {1, -1},
        };

        int stoneType = board[stonePoint[GAME_BOARD.X]][stonePoint[GAME_BOARD.Y]];
        List<int[]> trace = new ArrayList<int[]>();

        for (int[] DIR :
                DIRS) {
            int count = 0;
            trace.clear();
            for (int upanddownFlag = UP; upanddownFlag != END; upanddownFlag++) {
                int[] SDIR = DIR.clone();
                int[] i = stonePoint.clone();

                if (upanddownFlag == DOWN) {
                    SDIR[GAME_BOARD.X] = -SDIR[GAME_BOARD.X];
                    SDIR[GAME_BOARD.Y] = -SDIR[GAME_BOARD.Y];
//                    System.out.println("DOWN "+SDIR[X]+", "+SDIR[Y]);
                } else {
//                    System.out.println("UP "+SDIR[X]+", "+SDIR[Y]);
                }

                int iter = 0;
                while (true) {
                    i[GAME_BOARD.X] += SDIR[GAME_BOARD.X];
                    i[GAME_BOARD.Y] += SDIR[GAME_BOARD.Y];
                    iter++;
                    if (!(i[GAME_BOARD.X] >= 0 && i[GAME_BOARD.X] < GAME_BOARD.DEFAULT_BOARD_SIZE
                            && i[GAME_BOARD.Y] >= 0 && i[GAME_BOARD.Y] < GAME_BOARD.DEFAULT_BOARD_SIZE)) {
                        break;
                    }
                    if (stoneType == board[i[GAME_BOARD.X]][i[GAME_BOARD.Y]]) {
                        trace.add(i.clone());
                        count++;
//                        System.out.println("count="+count);
                    } else {
                        break;
                    }

                    if (count >= (GAME_BOARD.NUM_CONNECT - 1)) {
                        trace.add(stonePoint.clone());
                        return trace;
                    }
                    if (iter > GAME_BOARD.NUM_CONNECT) {
                        break;
                    }
                }
            }
        }
        return null;
    }
}
