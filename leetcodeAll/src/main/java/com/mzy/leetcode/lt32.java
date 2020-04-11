package com.mzy.leetcode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-10 15:49
 **/
public class lt32 {
    public  int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int leftCount = 0;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == ')') {
                if (leftCount == 0) {
                    dp[i] = 0;
                } else {
                    leftCount--;
                    dp[i] = 2 + dp[i - 1];
                    //在i-dp[i]前的长度也要加上来
                    if (i - dp[i] >= 0) {
                        dp[i] += dp[i - dp[i]];

                    }
                }

            } else {
                leftCount++;
                dp[i] = 0;

            }
            max = Math.max(max, dp[i]);
        }
        return max;


    }

    public static void main(String[] args) {
//        longestValidParentheses("(()()");
    }
}
