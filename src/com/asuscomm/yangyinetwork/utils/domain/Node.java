package com.asuscomm.yangyinetwork.utils.domain;

import com.asuscomm.yangyinetwork.game.StonePoint;
import com.asuscomm.yangyinetwork.utils.PrintUtils;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.INV_FLAG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.asuscomm.yangyinetwork.ai.JYP.Eval.eval;
import static com.asuscomm.yangyinetwork.consts.CONSTS.INF;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.X;
import static com.asuscomm.yangyinetwork.consts.GAME_BOARD.Y;
import static com.asuscomm.yangyinetwork.utils.Clone2darray.clone2darray;
import static com.asuscomm.yangyinetwork.utils.PossibleNextStone.possibleNextStonePair;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
@Slf4j
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
            this.eval = eval(getBoard(), getRoot().getStoneType());
//            PrintUtils.printBoard(getBoard());
//            log.info("Node/getEval: eval=[{}]",this.eval);
        }
        return this.eval;
    }

    public void extendByEval(double threshPercentage) {
        if(!this.extended) {
            List<Node> potentialChildren = new ArrayList<Node>();
            for (int[][] stonePointPair :
                    possibleNextStonePair(this.getBoard())) {
                StonePoint[] stonePoints = {new StonePoint(stonePointPair[0], this.stoneType), new StonePoint(stonePointPair[1], this.stoneType)};
                Node node = new Node(this, stonePoints, this.nextTurn());
                potentialChildren.add(node);
                double temp = node.getEval();
            }
            List<Node> sortedChildren = sortByEval(potentialChildren);
            for (int i = 0; i < sortedChildren.size()*threshPercentage; i++) {
                this.children.add(sortedChildren.get(i));
            }
//            log.info("Node/extendByEval: maximumEval=[{}], wholechildren=[{}], numofchildren=[{}]",this.children.get(getChildrenSize()-1).getEval(), sortedChildren.size(), getChildrenSize());
            this.extended = true;
        }
    }

    private List<Node> sortByEval(List<Node> nodes){
        List<Node> sorted = new ArrayList<Node>();

        for (int i = 0; i < nodes.size(); i++) {
            double maximum = -INF;
            int maximum_idx=i;
            for (int j = i; j < nodes.size(); j++) {
                double temp = nodes.get(j).getEval();
                if(temp> maximum) {
                    maximum = temp;
                    maximum_idx = j;
                }
            }
            sorted.add(nodes.get(maximum_idx));
        }

        return sorted;
    }

    public void extendByEval(int targetDepth, double threshPercentage) {
//        log.info("BaseTree/extend: targetDepth=[{}]",targetDepth);
//        log.info("BaseTree/extend: before");
//        boardCompare(getBoard());
        extendByEval(threshPercentage);
//        log.info("BaseTree/extend: after");
//        boardCompare(getBoard());
        if(targetDepth != 1) {
            for (Node node :
                    this.children) {
                node.extendByEval(targetDepth-1, threshPercentage);
            }
        }
    }
}