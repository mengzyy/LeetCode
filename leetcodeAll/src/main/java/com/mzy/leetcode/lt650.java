package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-03 14:07
 **/
public class lt650 {
    public  int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE-1;
            }
        }
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            /*记录最小值*/
            int tMin = dp[i][0];
            for (int j = 1; j <= i; j++) {
                if (i - j > 0) {
                    dp[i][j] = Math.min(dp[i - j][j] + 1, dp[i][j]);
                    tMin = Integer.min(tMin, dp[i][j]);
                }
                if (i == j) {
                    /*复制自己即可*/
                    dp[i][j] = tMin + 1;
                }
            }
        }
        return dp[n][n] - 1;
    }

}
