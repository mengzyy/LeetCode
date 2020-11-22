package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-10 22:56
 **/
public class ltoffer63 {
    public int maxProfit(int[] prices) {

        int nowMin = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > nowMin) {
                max = Math.max(max, prices[i] - nowMin);
            } else {
                nowMin = Math.min(nowMin, prices[i]);
            }
        }
        return max;

    }
}
