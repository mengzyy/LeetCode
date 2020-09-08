package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-04 18:15
 **/
public class lt494 {

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int w = (sum + S) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        /*问题转化为和为w的最大数量*/
        for (int num : nums) {
            for (int i = num; i <= w; i--) {
                dp[i] += dp[i - num];

            }
        }
        return dp[w];
    }
}
