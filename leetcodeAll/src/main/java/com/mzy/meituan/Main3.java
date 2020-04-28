package com.mzy.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-19 14:20
 **/
public class Main3 {

    public static int f(int n, int[] coins) {
        int[][] dp = new int[n][n];
        //i 到j的石头重量
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i][i] = coins[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + coins[j];
            }
        }

        int len = 1;

        //定不同的区间长度
        for (int i = len; i <= n - 1; i++) {
            for (int j = 0; j + i <= n - 1; j++) {
                int start = j;
                int end = j + i;
                int k = j;
                dp[start][end] = Integer.MAX_VALUE;
                while (k + 1 <= end) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k + 1][end] + sum[start][end]);
                    k++;
                }

            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(f(n, a));
        }


    }
}
