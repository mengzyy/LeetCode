package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-03 11:43
 **/
public class lt357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 9;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int min = Math.min(10, n);
        int ans = 10;
        for (int i = 2; i <=min; i++) {
            dp[i] = dp[i - 1] * (10 - i + 1);
            ans += dp[i];
        }
        return ans;
    }
}
