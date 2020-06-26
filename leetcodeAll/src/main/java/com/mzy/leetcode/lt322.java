package com.mzy.leetcode;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-17 22:03
 **/
public class lt322 {
    public int coinChange(int[] coins, int amount) {
        //sort
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            //直接从coins开始
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        new lt322().coinChange(new int[]{186, 419, 83, 408}, 6349);
    }
}
