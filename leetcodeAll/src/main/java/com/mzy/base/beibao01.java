package com.mzy.base;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-02 12:53
 **/
public class beibao01 {

    public static void f() {

        int[] w = {0, 2, 3, 4, 5};            //商品的体积2、3、4、5
        int[] v = {0, 3, 4, 5, 6};            //商品的价值3、4、5、6
        int bagV = 8;                            //背包大小

        int n = 5;
        int m = 9;
        int dp[][] = new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                //当前背包最大容量，当前要放入的商品
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }


            }
        }

        System.out.println(dp[n - 1][m - 1]);


    }

    public static void main(String[] args) {

        f();


    }
}
