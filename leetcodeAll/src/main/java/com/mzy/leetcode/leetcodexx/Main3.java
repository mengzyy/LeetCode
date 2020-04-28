package com.mzy.leetcode.leetcodexx;

import com.mzy.offer.dfs;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-17 12:32
 **/
public class Main3 {
    public static boolean hasPath;
    public static int[][] book;

    public boolean hasValidPath(int[][] grid) {
        if (grid == null || grid.length == 0) return false;

        int n = grid.length;
        int m = grid[0].length;
        hasPath = false;
        book = new int[n][m];
        book[0][0] = 1;
        Dfs(grid, 0, 0, n, m);

        return hasPath;


    }

    private void Dfs(int[][] grid, int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            hasPath = true;
        } else {
            int value = grid[i][j];
            if (value == 1) {
                //left
                if (!hasPath && j - 1 >= 0 && book[i][j - 1] == 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
                    book[i][j - 1] = 1;
                    Dfs(grid, i, j - 1, n, m);
                    book[i][j - 1] = 0;
                }
                //right
                if (!hasPath && j + 1 <= m - 1 && book[i][j + 1] == 0 && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
                    book[i][j + 1] = 1;
                    Dfs(grid, i, j + 1, n, m);
                    book[i][j + 1] = 0;
                }

            } else if (value == 2) {

                //up
                if (!hasPath && i - 1 >= 0 && book[i - 1][j] == 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
                    book[i - 1][j] = 1;
                    Dfs(grid, i - 1, j, n, m);
                    book[i - 1][j] = 0;
                }
                //down
                if (!hasPath && i + 1 <= n - 1 && book[i + 1][j] == 0 && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
                    book[i + 1][j] = 1;
                    Dfs(grid, i + 1, j, n, m);
                    book[i + 1][j] = 0;
                }
            } else if (value == 3) {
                //left
                if (!hasPath && j - 1 >= 0 && book[i][j - 1] == 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
                    book[i][j - 1] = 1;
                    Dfs(grid, i, j - 1, n, m);
                    book[i][j - 1] = 0;
                }

                //down
                if (!hasPath && i + 1 <= n - 1 && book[i + 1][j] == 0 && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
                    book[i + 1][j] = 1;
                    Dfs(grid, i + 1, j, n, m);
                    book[i + 1][j] = 0;
                }

            } else if (value == 4) {

                //right
                if (!hasPath && j + 1 <= m - 1 && book[i][j + 1] == 0 && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
                    book[i][j + 1] = 1;
                    Dfs(grid, i, j + 1, n, m);
                    book[i][j + 1] = 0;
                }

                //down
                if (!hasPath && i + 1 <= n - 1 && book[i + 1][j] == 0 && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
                    book[i + 1][j] = 1;
                    Dfs(grid, i + 1, j, n, m);
                    book[i + 1][j] = 0;
                }


            } else if (value == 5) {
                //left
                if (!hasPath && j - 1 >= 0 && book[i][j - 1] == 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
                    book[i][j - 1] = 1;
                    Dfs(grid, i, j - 1, n, m);
                    book[i][j - 1] = 0;
                }

                //up
                if (!hasPath && i - 1 >= 0 && book[i - 1][j] == 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
                    book[i - 1][j] = 1;
                    Dfs(grid, i - 1, j, n, m);
                    book[i - 1][j] = 0;
                }


            } else if (value == 6) {
                //right
                if (!hasPath && j + 1 <= m - 1 && book[i][j + 1] == 0 && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
                    book[i][j + 1] = 1;
                    Dfs(grid, i, j + 1, n, m);
                    book[i][j + 1] = 0;
                }

                //up
                if (!hasPath && i - 1 >= 0 && book[i - 1][j] == 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
                    book[i - 1][j] = 1;
                    Dfs(grid, i - 1, j, n, m);
                    book[i - 1][j] = 0;
                }

            }

        }

    }
}
