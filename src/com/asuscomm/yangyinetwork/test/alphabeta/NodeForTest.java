package com.asuscomm.yangyinetwork.test.alphabeta;

import com.asuscomm.yangyinetwork.ai.algorithms.domain.BaseTree;
import com.asuscomm.yangyinetwork.ai.algorithms.domain.TreeForAlphabeta;

import java.util.List;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
public class NodeForTest extends BaseTree<NodeForTest> implements TreeForAlphabeta{
    private double eval;


    public NodeForTest(double eval) {
        super();
        this.eval = eval;
    }

    public NodeForTest(NodeForTest mother,double eval) {
        super(mother);
        this.eval = eval;
    }

    public NodeForTest addChild(double eval) {
        NodeForTest child = new NodeForTest(this,eval);
        this.children.add(child);
        return child;
    }

    public double getEval() {
        return this.eval;
    }

    public int getChildrenSize() {
        return super.getChildrenSize();
    }

    public List<NodeForTest> getChildren() {
        return super.getChildren();
    }
}
