package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-11 11:37
 **/
public class lt887 {
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];


        for (int i = 0; i <= K; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= K; i++) {
            dp[1][i] = 1;
        }

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                //在
                int left = 1;
                int right = i;
                while (left < right) {
                    int mid = left + (right - left) / 2;

                    int breakCount = dp[mid - 1][j - 1];
                    int noBreakCount = dp[i - mid][j];
                    if (breakCount > noBreakCount) {
                        //解在左边
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                //此时的left就是解
                dp[i][j] = Math.min(dp[left - 1][j - 1], dp[i - left][j]) + 1;

            }
        }
        return dp[N][K];


    }

    public static void main(String[] args) {

        System.out.println(superEggDrop(1,2));

    }
}
