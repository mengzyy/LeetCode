package com.mzy.leetcode.days;

import java.lang.reflect.InvocationHandler;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-09 08:48
 **/
public class n46 {
    static int count;

    public int translateNum(int num) {
        count = 0;
        //转字符串
        String input = String.valueOf(num);
        int n = input.length();
        dfs(0, input, n);
        return count;

    }

    private void dfs(int i, String input, int n) {
        if (i >= n - 1) {
            count++;
            return;
        }
        for (int j = i; j < i + 2 && j < n; j++) {
            //每次递增增加一个长度
            int tempValue = Integer.valueOf(input.substring(i, j + 1));
            //两位数的情况
            if (j - i == 1 && tempValue < 10) continue;
            //其他情况
            if (tempValue <= 25) {
                //只有小于的情况才进行dfs
                dfs(j + 1, input, n);
            }


        }

    }

    public int translateNum2(int num) {
        count = 0;
        //转字符串
        String input = String.valueOf(num);
        int n = input.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //判断是否可以跳两个台阶
            int value = Integer.valueOf(input.substring(i - 2, i));
            if (value >= 10 && value <= 25) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[n];


    }

    public static void main(String[] args) {


        int i = new n46().translateNum2(25);
        System.out.println(i);
    }
}
