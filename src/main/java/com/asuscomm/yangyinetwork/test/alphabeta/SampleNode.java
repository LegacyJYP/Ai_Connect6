package com.asuscomm.yangyinetwork.test.alphabeta;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
public class SampleNode {
    public static NodeForTest sample;
    public static NodeForTest getSample() {
        if(sample == null) {
            initSample();
        }

        return sample;
    }

    public static void initSample() {
        sample = new NodeForTest(1);
        NodeForTest a = sample.addChild(100);
        NodeForTest b = sample.addChild(200);
        NodeForTest c = sample.addChild(300);

        NodeForTest aa = a.addChild(10);
        NodeForTest ab = a.addChild(20);

        NodeForTest ba = b.addChild(30);
        NodeForTest bb = b.addChild(40);

        NodeForTest ca = c.addChild(50);
        NodeForTest cb = c.addChild(60);

        NodeForTest aaa = aa.addChild(4);
        NodeForTest aab = aa.addChild(6);
        NodeForTest aba = ab.addChild(7);
        NodeForTest abb = ab.addChild(9);

        NodeForTest baa = ba.addChild(1);
        NodeForTest bab = ba.addChild(2);
        NodeForTest bba = bb.addChild(0);
        NodeForTest bbb = bb.addChild(1);

        NodeForTest caa = ca.addChild(8);
        NodeForTest cab = ca.addChild(1);
        NodeForTest cba = cb.addChild(9);
        NodeForTest cbb = cb.addChild(2);
    }
}

