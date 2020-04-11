package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-01 12:32
 **/
public class n04 {

    public int[] maxDepthAfterSplit(String seq) {

        int n = seq.toCharArray().length;
        int[] res = new int[n];

        boolean isProisA = false;
        boolean isNextB = false;

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                if (!isProisA) {
                    res[i] = 0;
                    isProisA = true;
                } else {
                    res[i] = 1;
                    isProisA = false;
                }
            } else {
                if (!isNextB) {
                    res[i] = 0;
                    isNextB = true;
                } else {
                    res[i] = 1;
                    isNextB = false;
                }


            }
        }
        return res;


    }

    public static void main(String[] args) {


    }


}
