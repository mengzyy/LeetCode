package com.mzy.leetcode;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-18 11:04
 **/
public class lt268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n + 1);
        copy[n] = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            if (copy[i] != Integer.MAX_VALUE && copy[i] != i) {
                int t = copy[i];
                copy[i] = copy[t];
                copy[t] = t;
                i--;
            }
        }

        //遍历
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == Integer.MAX_VALUE) return i;
        }
        return -1;

    }



}
