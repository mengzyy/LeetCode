package com.mzy.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-20 12:50
 **/
public class lt1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0] % 2 == 0 ? 0 : 1;
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 1) {
                dp[i] = dp[i - 1] + 1;
            }
            //遍历
            for (int j = 0; j <= i - 1; j++) {
                if (dp[i] - dp[j] == k) ans++;
            }
        }
        return ans;


    }
}
