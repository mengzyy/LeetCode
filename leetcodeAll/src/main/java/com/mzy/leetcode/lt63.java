package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-26 10:34
 **/
public class lt63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length <= 0) return -1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //初始化0行0列
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }


        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 1) {
                dp[0][j] = 1;
            } else {
                break;
            }

        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    int up =  dp[i - 1][j];
                    int left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }

        }

        return dp[m - 1][n - 1];


    }

    public static void main(String[] args) {

        int[][] input = {{1, 0}};

        uniquePathsWithObstacles(input);

    }
}
