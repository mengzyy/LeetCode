package com.mzy.leetcode.days;

import java.util.Map;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-29 15:31
 **/
/*
多源dfs保存每个源最近的 然后max
 */
public class n01 {
    private static int max;
    private static int len;
    private int[][] book;//禁止走重复的路

    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int n = grid.length;
        int m = grid[0].length;

        //初始化
        book = new int[n][m];
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                //为海洋时进行bfs搜索
                if (grid[i][j] == 0) {
                    max = -1;
                    len = 300;
                    book[i][j] = 1;
                    bfs(grid, i, j, i, j);
                    book[i][j] = 0;
                    res = res > max ? res : max;
                }

            }

        }
        return res;


    }


    private void bfs(int[][] grid, int i, int j, int i0, int j0) {


        if (grid[i][j] == 1) {
            int nowlen = Math.abs(i - i0) + Math.abs(j - j0);
            if (nowlen < len) {
                max = nowlen;
                len = nowlen;
            } else if (nowlen == len) {
                max = max > nowlen ? max : nowlen;
            }
        } else {

            //bfs搜索
            //向上
            if (i - 1 >= 0 && book[i - 1][j] == 0 && (Math.abs(i - 1 - i0) + Math.abs(j - j0)) <= len) {
                book[i - 1][j] = 1;
                bfs(grid, i - 1, j, i0, j0);
                book[i - 1][j] = 0;
            }
            //向下
            if (i + 1 < grid.length && book[i + 1][j] == 0 && (Math.abs(i + 1 - i0) + Math.abs(j - j0)) <= len) {
                book[i + 1][j] = 1;
                bfs(grid, i + 1, j, i0, j0);
                book[i + 1][j] = 0;
            }
            //向左
            if (j - 1 >= 0 && book[i][j - 1] == 0 && (Math.abs(i - i0) + Math.abs(j - 1 - j0)) <= len) {
                book[i][j - 1] = 1;
                bfs(grid, i, j - 1, i0, j0);
                book[i][j - 1] = 0;
            }
            //向右
            if (j + 1 < grid[0].length && book[i][j + 1] == 0 && (Math.abs(i - i0) + Math.abs(j + 1 - j0)) <= len) {
                book[i][j + 1] = 1;
                bfs(grid, i, j + 1, i0, j0);
                book[i][j + 1] = 0;
            }


        }


    }

    public static void main(String[] args) {

        int[][] a = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int i = new n01().maxDistance(a);
        System.out.println(i);
    }
}
