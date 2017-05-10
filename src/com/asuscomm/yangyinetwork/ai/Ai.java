package com.asuscomm.yangyinetwork.ai;

/**
 * Created by jaeyoung on 2017. 5. 7..
 */
public interface Ai {
    interface OnSolutionListener {
        void onSolution(int[][] stonePoint);
    }
    void findSolution(int[][] board, OnSolutionListener listener);
}
