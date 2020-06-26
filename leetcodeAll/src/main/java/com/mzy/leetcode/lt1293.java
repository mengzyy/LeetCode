package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-06 12:19
 **/
public class lt1293 {
    static int res;

    public int shortestPath(int[][] grid, int k) {

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};


        int n = grid.length;
        int m = grid[0].length;
        int[][][] book = new int[n][m][k];
        book[0][0][k] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k});
        int ans = 0;
        while (queue.size() != 0) {

            int len = queue.size();

            while (len != 0) {
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];
                int ak = poll[2];
                if (i == n - 1 && j == m - 1) return ans;

                for (int co = 0; co < 4; co++) {
                    int newI = i + dx[co];
                    int newJ = j + dy[co];
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {

                        if (grid[newI][newJ] == 0 && book[newI][newJ][ak] == 0) {
                            book[newI][newJ][ak] = 1;
                            queue.offer(new int[]{newI, newJ, ak});
                        }

                        if (grid[newI][newJ] == 1 && ak - 1 >= 0 && book[newI][newJ][ak - 1] == 0) {
                            book[newI][newJ][ak - 1] = 1;
                            queue.offer(new int[]{newI, newJ, ak - 1});
                        }
                    }
                }
                len--;
            }
            ans++;
        }
        return -1;

    }

//    private void Dfs(int i, int j, int[][] grid, int[][] book, int[] dx, int[] dy, int n, int m, int k, int count) {
//        if (i == n - 1 && j == m - 1) {
//            res = Math.min(res, count);
//        } else {
//
//            for (int co = 0; co < 4; co++) {
//                int newI = i + dx[co];
//                int newJ = j + dy[co];
//                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && book[newI][newJ] == 0) {
//                    if (grid[newI][newJ] == 0 && count + n - newI - 1 + m - newJ - 1 < res&&res>n+m-2) {
//                        book[newI][newJ] = 1;
//                        Dfs(newI, newJ, grid, book, dx, dy, n, m, k, count + 1);
//                        book[newI][newJ] = 0;
//                    } else if (grid[newI][newJ] == 1 && count + n - newI - 1 + m - newJ - 1 < res && k - 1 >= 0&&res>n+m-2) {
//                        book[newI][newJ] = 1;
//                        Dfs(newI, newJ, grid, book, dx, dy, n, m, k - 1, count + 1);
//                        book[newI][newJ] = 0;
//                    }
//                }
//            }
//        }
//
//
//    }


}
