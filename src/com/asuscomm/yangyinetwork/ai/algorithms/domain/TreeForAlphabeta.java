package com.asuscomm.yangyinetwork.ai.algorithms.domain;

import java.util.List;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
public interface TreeForAlphabeta {
    double getEval();
    int getChildrenSize();
    List<?> getChildren();
}
