package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-11 14:49
 **/
public class lt91 {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        //无法解码
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            int leftOne = 0;
            int leftTwo = 0;
            if (s.charAt(i - 1) != '0') {
                leftOne = dp[i - 1];
            }
            if (i - 2 >= 0) {
                if (s.charAt(i - 1) == '0') {
                    if (s.charAt(i - 2) == '1' | s.charAt(i - 2) == '2') {
                        leftTwo = dp[i - 2];
                    }
                } else {
                    int temp = Integer.parseInt(s.substring(i - 2, i));
                    if (s.charAt(i - 2) != '0' && temp >= 1 && temp <= 26) {
                        leftTwo = dp[i - 2];
                    }
                }
            }
            dp[i] = leftOne + leftTwo;
        }
        return dp[s.length()];

    }
}
