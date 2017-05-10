package com.asuscomm.yangyinetwork.utils;

/**
 * Created by jaeyoung on 2017. 5. 10..
 */
public class Clone2darray {
    public static int[][] clone2darray(int[][] arr) {
        int[][] result = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].clone();
        }
        return result;
    }
}
