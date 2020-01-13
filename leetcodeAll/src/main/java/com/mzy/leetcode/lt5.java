package com.mzy.leetcode;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
public class lt5 {

    //使用动态规划的方法
    //根据前一个状态来推断下一个状态
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s.substring(0, s.length());
        }
        //dp状态栏
        boolean[][] dp = new boolean[s.length()][s.length()];
        //存放最大的回文数
        String maxLenStr = s.substring(0, 1);

        //初始化长度为1和2的
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i] = true;
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        dp[s.length() - 1][s.length() - 1] = true;


        //完成dp中的其他部分
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() - 2; j++) {
                if (i + j < s.length() ) {
                    char a = s.charAt(j);
                    char b = s.charAt(i + j);
                    dp[j][i + j] = dp[j + 1][i + j - 1] && (a == b);


                }
            }
        }

        //返回最大串
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (dp[i][j]) {
                    maxLenStr = s.substring(i, j + 1).length() > maxLenStr.length() ? s.substring(i, j + 1) : maxLenStr;
                }
            }
        }


        return maxLenStr;


    }

    public static void main(String[] args) {


        System.out.println(longestPalindrome("ccc"));

    }
}
