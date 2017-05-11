package com.asuscomm.yangyinetwork.ai.commons;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
public interface Ai {
    interface OnSolutionListener {
        void onSolution(int[][] stonePoint, int remainStones);
    }
    void findSolution(int[][] board, int remainStones, OnSolutionListener listener);
    void setStoneType(int stoneType);
}
