package com.asuscomm.yangyinetwork.utils.domain;

import com.asuscomm.yangyinetwork.game.StonePoint;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.asuscomm.yangyinetwork.consts.ENEMY_STONETYPE.ENEMY_STONETYPE;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.X;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.Y;
import static com.asuscomm.yangyinetwork.utils.ArrayCompareUtils.boardCompare;
import static com.asuscomm.yangyinetwork.utils.PossibleNextStone.possibleNextStone;
import static com.asuscomm.yangyinetwork.utils.PossibleNextStone.possibleNextStonePair;
import static com.asuscomm.yangyinetwork.utils.PrintUtils.printBoard;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
@Slf4j
public abstract class BaseTree {
    protected List<Node> children;
    protected int[][] board;
    protected BaseTree mother;
    protected boolean isRoot;
    protected int stoneType;
    protected boolean extended;

    public BaseTree(int[][] board, int stoneType) {
        this.board = board;
        this.isRoot = true;
        this.stoneType = stoneType;
        this.children = new ArrayList<Node>();
        this.extended = false;
    }

    public BaseTree(BaseTree mother, int stoneType) {
        this.isRoot = false;
        this.mother = mother;
        this.stoneType = stoneType;
        this.children = new ArrayList<Node>();
        this.extended = false;
    }

    protected BaseTree getRoot() {
        BaseTree root = this;
        while(true) {
            if (!root.isRoot) {
                root = root.mother;
            } else {
                return root;
            }
        }
    }

    abstract public int[][] getBoard();

    public void extend() {
        if(!this.extended) {
            for (int[][] stonePointPair :
                    possibleNextStonePair(this.getBoard())) {
                StonePoint[] stonePoints = {new StonePoint(stonePointPair[0], this.stoneType), new StonePoint(stonePointPair[1], this.stoneType)};
                this.children.add(new Node(this, stonePoints, this.nextTurn()));
            }
            this.extended = true;
        }
    }

    public boolean isExtended() {
        return extended;
    }

    protected int nextTurn() {
        return ENEMY_STONETYPE(this.stoneType);
    }


    public void extend(int targetDepth) {
//        log.info("BaseTree/extend: targetDepth=[{}]",targetDepth);
//        log.info("BaseTree/extend: before");
//        boardCompare(getBoard());
        extend();
//        log.info("BaseTree/extend: after");
//        boardCompare(getBoard());
        if(targetDepth != 1) {
            for (Node node :
                    this.children) {
                node.extend(targetDepth-1);
            }
        }
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public int getChildrenSize() {
        return this.children.size();
    }

    @Override
    public String toString() {
        return "BaseTree{" +
                "children=" + children.toString() +
                ", stoneType=" + stoneType +
                ", extended=" + extended +
                '}';
    }

    public int getStoneType() {
        return stoneType;
    }
}
