package com.mzy.niuke.kuaishou;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-02 13:31
 **/
public class n06 {


    public static int getMinWeight(int n, int[] weights) {


        int sum = 0;
        for (int weight : weights) {
            sum += weight;

        }
        //转化为01背包问题
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < weights[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i-1]] + weights[i-1]);
                }

            }
        }

        return sum - 2 * dp[n][sum / 2];


    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        System.out.println(getMinWeight(n, weights));
    }
}
