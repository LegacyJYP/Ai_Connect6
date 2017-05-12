package com.asuscomm.yangyinetwork.utils;

import lombok.extern.slf4j.Slf4j;
import com.asuscomm.yangyinetwork.consts.CONSTS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
@Slf4j
public class Sort {
    public static List<Integer> sortedIndex(List<Double> before) {
        List<Integer> sorted = new ArrayList<Integer>();
        List<Double> beforeClone = new ArrayList<Double>();
        beforeClone.addAll(before);


        for (int i = 0; i < beforeClone.size(); i++) {
            double maximum = -CONSTS.INF;
            int maximum_idx = i;
            for (int j = i; j < beforeClone.size(); j++) {
                double temp = beforeClone.get(j);
                if (temp > maximum) {
                    maximum = temp;
                    maximum_idx = j;
                }
            }
            beforeClone.set(maximum_idx,-CONSTS.INF);
//            log.info("Sort/sortedIndex: [{}]",maximum_idx);
            sorted.add(maximum_idx);
        }

        return sorted;
    }
//
//    public static List<Integer> sortedIndex(List<Double> before) {
//        List<Integer> sorted = new ArrayList<Integer>();
//        List<Double> beforeClone = new ArrayList<Double>();
//        beforeClone.addAll(before);
//
//
//        for (int i = 0; i < beforeClone.size(); i++) {
//            double maximum = -INF;
//            int maximum_idx = i;
//            for (int j = i; j < beforeClone.size(); j++) {
//                double temp = beforeClone.get(j);
//                if (temp > maximum) {
//                    beforeClone.set(j,beforeClone.get(i));
//                    beforeClone.set(i,temp);
//                    maximum = temp;
//                    maximum_idx = j;
//                }
//            }
//            log.info("Sort/sortedIndex: [{}]",maximum_idx);
//            sorted.add(maximum_idx);
//        }-> 인덱스로할때 바꾸면안됨
//
//        return sorted;
//    }
}
