package com.mzy.leetcode.days;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-29 16:43
 **/
public class n011 {
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};


        int res = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size != 0) {
                point = queue.poll();
                int x = point[0], y = point[1];
                // 取出队列的元素，将其四周的海洋入队。
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                        continue;
                    }
                    grid[newX][newY] =1; //表示访问过
                    hasOcean = true;
                    queue.offer(new int[]{newX, newY});
                }

                size--;

            }

        }

        // 没有陆地或者没有海洋，返回-1。
        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后一次遍历到的海洋的距离。
        return res;

    }

    public static void main(String[] args) {

        int[][] a = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int i = new n011().maxDistance(a);
        System.out.println(i);
    }
}
