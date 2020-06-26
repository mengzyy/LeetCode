package com.mzy.leetcode;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-20 10:03
 **/
public class lt1371 {
    public int findTheLongestSubstring(String s) {
        int[] dp = new int[1 << 5];
        Arrays.fill(dp, -1);
        int n = s.length();
        int state = 0;
        int ans = 0;
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int tep = s.charAt(i);
            if (tep == 'a') {
                state ^= 1 << 0;
            } else if (tep == 'e') {
                state ^= 1 << 1;
            } else if (tep == 'i') {
                state ^= 1 << 2;
            } else if (tep == 'o') {
                state ^= 1 << 3;
            } else if (tep == 'u') {
                state ^= 1 << 4;
            }
            if (dp[state] >= 0) {
                ans = Math.max(ans, i + 1 - dp[state]);
            } else {
                dp[state] = i + 1;
            }
        }
        return ans;

    }
}
