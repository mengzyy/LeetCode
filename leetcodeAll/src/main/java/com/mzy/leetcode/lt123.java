package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-09 16:43
 **/
public class lt123 {
    public int maxProfit(int[] prices) {


        int n = prices.length;

        //定义三个状态
        int[][] dp = new int[n][3];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = Integer.MIN_VALUE;
        dp[1][2] = -1 * (prices[0] + prices[1]);

        for (int i = 1; i < n; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            if (i - 2 >= 0) dp[i][1] = Math.max(dp[i][1], dp[i - 1][2] + prices[i]);

            if (i - 2 >= 0) {
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            }
        }
        return dp[n - 1][0];


    }
}
