package com.asuscomm.yangyinetwork.ai;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
public interface Ai {
    interface OnSolutionListener {
        void onSolution(int[][] stonePoint);
    }
    void findSolution(int[][] board, int remainStones, OnSolutionListener listener);
    void setStoneType(int stoneType);
}
