package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-30 12:33
 **/
public class lt994 {
    public static int count;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int n = grid.length;
        int m = grid[0].length;
        count = 0;
        int[][] book = new int[n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (book[i][j] == 0 && grid[i][j] == 2) {
                    book[i][j] = 1;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs(grid, queue, book, dx, dy);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return count;

    }

    private void bfs(int[][] grid, Queue<int[]> queue, int[][] book, int[] dx, int[] dy) {


        while (queue.size() != 0) {
            int len = queue.size();

            while (len != 0) {
                int[] poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newI = poll[0] + dx[i];
                    int newJ = poll[1] + dy[i];
                    if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && book[newI][newJ] == 0 && grid[newI][newJ] == 1) {
                        book[newI][newJ] = 1;
                        grid[newI][newJ] = 2;
                        queue.offer(new int[]{newI, newJ});
                    }
                }
                len--;
            }
            if (queue.size() != 0) {
                count++;
            }
        }
    }

    public static void main(String[] args) {

        int[][] a = {{1}, {2}, {2}};
        new lt994().orangesRotting(a);


    }
}
