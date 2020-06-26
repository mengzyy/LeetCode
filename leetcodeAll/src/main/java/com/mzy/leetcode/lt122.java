package com.mzy.leetcode;

import com.mzy.offer.dfs;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-09 16:07
 **/
public class lt122 {


    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n][2];

        //定义初始状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];

    }


}
