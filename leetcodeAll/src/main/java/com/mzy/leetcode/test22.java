package com.mzy.leetcode;

import javax.swing.plaf.basic.BasicTextAreaUI;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-08 00:05
 **/
public class test22 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) return n * m;

        //dp数组 ,其中+1都是为空的情况
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= m; j++) {
            dp[0][m] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int del = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(left, Math.min(down, del));

            }

        }

        return dp[n][m];

    }

    public static void main(String[] args) {


        float a = 2;
        long x = 4;
        byte aa = 2;
        float k = 1.1;

        Integer t = 1;//Integer.valueOf(1);
        int t2 = 1;
        Float xxx = Float.valueOf(2);
        Character c = Character.valueOf('1');

    }

}
