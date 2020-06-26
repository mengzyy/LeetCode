package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-17 10:04
 **/
public class lt1014 {

    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int leftMax = A[0] + 0;

        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, leftMax + A[i] - i);
            leftMax = Math.max(leftMax, A[i] + i);
        }
        return res;
    }

    public static void main(String[] args) {

        new lt1014().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6});
    }
}
