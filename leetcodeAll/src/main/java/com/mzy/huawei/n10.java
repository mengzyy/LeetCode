package com.mzy.huawei;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 22:31
 **/
public class n10 {
    public static void f(int money, int[][] info) {

        int n = info.length;
        int m = money;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //如果钱不够买当前物品
                if (j < info[i - 1][0]) {
                    dp[i][j] = dp[i - 1][j];
                }else{

                }

            }

        }


    }
}
