package com.asuscomm.yangyinetwork.utils.domain;

import com.asuscomm.yangyinetwork.game.StonePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.asuscomm.yangyinetwork.ai.JYP.Eval.eval;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.X;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.Y;
import static com.asuscomm.yangyinetwork.utils.Clone2darray.clone2darray;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
public class Node extends BaseTree {
    StonePoint[] stonePoints;
    Double eval;

    public Node(BaseTree mother, StonePoint[] stonePoints, int stoneType) {
        super(mother,stoneType);
        this.stonePoints = stonePoints;
    }

    public Node(int[][] board, int stoneType) {
        super(board,stoneType);
    }

    public StonePoint[] getStonePoints() {
        return stonePoints;
    }

    public int[][] getBoard() {
        if(this.isRoot) {
            return this.board;
        }
        else {
            return updateBoard(this.mother.getBoard(), this.stonePoints);
        }
    }

    private int[][] updateBoard(int[][] board, StonePoint[] stonePoints) {
        int[][] result = clone2darray(board);
        for (StonePoint stonePoint:
             stonePoints) {
            int[] point = stonePoint.getStonePoints();
            result[point[X]][point[Y]] = stonePoint.getStoneType();
        }
        return result;
    }

    public double getEval() {
        if (this.eval == null) {
            this.eval = eval(getBoard());
        }
        return this.eval;
    }
}