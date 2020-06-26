package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-19 11:58
 **/
public class lt5 {
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 1) return s;
        int n = s.length();
        String maxStr = s.substring(0, 1);
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1] && maxLen < 2) {
                maxLen = 2;
                maxStr = s.substring(i, i + 2);
            }
        }

        for (int j = 2; j < n; j++) {
            int newJ = j;
            int newI = 0;
            while (newI < n && newJ < n) {
                dp[newI][newJ] = dp[newI + 1][newJ - 1] && s.charAt(newI) == s.charAt(newJ);
                if (dp[newI][newJ] && maxLen < newJ - newI + 1) {
                    maxLen = newJ - newI + 1;
                    maxStr = s.substring(newI, newJ + 1);
                }
                newI++;
                newJ++;
            }
        }

        return maxStr;

    }
}
