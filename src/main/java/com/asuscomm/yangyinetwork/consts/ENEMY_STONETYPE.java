package main.java.com.asuscomm.yangyinetwork.consts;

import static main.java.com.asuscomm.yangyinetwork.consts.GAME_BOARD.NONE_STONE;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
public class ENEMY_STONETYPE {
    public static int ENEMY_STONETYPE(int stoneType) {
        return (stoneType%2)+1;
    }

    public static int ENEMY_STONETYPE_INCLUDE_NONE(int stoneType) {
        if(stoneType != NONE_STONE) {
            return (stoneType%2)+1;
        } else {
            return NONE_STONE;
        }
    }
}
