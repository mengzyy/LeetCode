package com.mzy.leetcode.leetcodexx;

import com.mzy.offer.dfs;

import java.util.HashSet;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-23 09:58
 **/
public class Main5 {


    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[n] % 1000000007;

    }



    public static void main(String[] args) {
        new Main5().waysToChange(10);


    }
}
