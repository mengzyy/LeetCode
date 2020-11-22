package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-23 11:42
 **/
public class lt1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int[] dp = new int[sum / 2 + 1];
        int m = dp.length;
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            for (int j = m; j > stones[i]; j--) {
                dp[j] = Math.max(dp[j - stones[i]] + stones[i], dp[j]);
            }
        }
        return sum - dp[sum / 2];

    }


}
