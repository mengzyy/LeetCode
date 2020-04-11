package com.mzy.niuke.haoojing;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-06 15:38
 **/
public class Main2 {


    public static int f(int n, int[] studentAbility, int k, int d) {

        //0 1背包问题
        //n个学生 ，k个位置
        int[][] dp = new int[n + 1][k + 1];
        //标记数组为了阻止距离大于d
        int[][] book = new int[n + 1][k + 1];

        //c初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= k; i++) {
            dp[0][i] = 1;
        }

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int notAdd = dp[i - 1][j];
                int add = dp[i - 1][j - 1] * studentAbility[i - 1];
                //第一行默认
                if (i == 1) {
                    dp[i][j] = add;
                    book[i][j] = j;
                } else if (notAdd > add) {
                    dp[i][j] = notAdd;
                } else if (j - book[i - 1][j - 1] <= d) {
                    dp[i][j] = add;
                    book[i][j] = j;
                } else {
                    dp[i][j] = notAdd;
                }
            }
        }

        return dp[n][k];


    }

    //3
//        7 4 7
//        2 50
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ability = new int[num];
        for (int i = 0; i < num; i++) {
            ability[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(f(num, ability, k, d));


    }
}
