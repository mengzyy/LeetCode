package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-08 13:11
 **/
public class lt200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int n = grid.length;
        int m = grid[0].length;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[][] book = new int[n][m];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1'&&book[i][j]==0) {
                    book[i][j] = 1;
                    queue.offer(new int[]{i, j});
                    bfs(grid, i, j, queue, book, dx, dy, n, m);
                    res++;
                }
            }
        }
        return res;


    }

    private void bfs(char[][] grid, int i, int j, Queue<int[]> queue, int[][] book, int[] dx, int[] dy, int n, int m) {
        while (queue.size() != 0) {
            int[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newI = poll[0] + dx[k];
                int newJ = poll[1] + dy[k];
                if (newI >= 0 && newI <= n - 1 && newJ >= 0 && newJ <= m - 1 && grid[newI][newJ] == '1' && book[newI][newJ] == 0) {
                    book[newI][newJ] = 1;
                    queue.offer(new int[]{newI, newJ});
                }

            }

        }
    }

}
