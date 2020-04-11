package com.mzy.niuke.kuaishou;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-08 10:57
 **/
/*
给定两个-100到100的整数x和y,对x只能进行加1，减1，乘2操作，问最少对x进行几次操作能得到y？
例如：
a=3,b=11: 可以通过3*2*2-1，3次操作得到11；
a=5,b=8：可以通过(5-1)*2，2次操作得到8；
 */
public class n10 {

    public static int f(int x, int y) {


        int n = 100 + x;
        int m = 100 + y;

        int[][] dp = new int[n + 1][m + 1];

        //初始化
        for (int i = 1; i <= n; i++) {
            //整体需要减去100
            if ((i - 100) % 2 == 0) {
                dp[i][0] = Math.min(dp[i - 1][0] + 1, dp[i / 2][0] + 1);
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for (int i = 1; i <= m; i++) {
            if ((i - 100) % 2 == 0) {
                dp[0][i] = Math.min(dp[0][i - 1] + 1, dp[0][i / 2] + 1);
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i - 1][j] + 1;
                int up = dp[i][j - 1] + 1;
                if ((i - 100) % 2 == 0) {
                    dp[i][j] = Math.min(left, Math.min(up, dp[i / 2][j]) + 1);
                } else {
                    dp[i][j] = Math.min(left, up);
                }
            }
        }
        return dp[n][m];


    }

    public static void main(String[] args) {

        System.out.println(f(5,8));
    }
}
