package com.mzy.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-02 12:06
 **/
public class lt407 {
    public int trapRainWater(int[][] heightMap) {

        if (heightMap == null || heightMap.length == 0) return 0;
        int ans = 0;

        int n = heightMap.length;
        int m = heightMap[0].length;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        PriorityQueue<int[]> queue = new PriorityQueue<>(n+n+m-1+m-1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int[][] book = new int[n][m];

        //先加入外围
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    queue.offer(new int[]{i, j, heightMap[i][j]});
                    book[i][j] = 1;
                }
            }
        }
        while (queue.size() != 0) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newI = poll[0] + dx[i];
                int newJ = poll[1] + dy[i];
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && book[newI][newJ] == 0) {
                    book[newI][newJ] = 1;

                    if (poll[2] > heightMap[newI][newJ]) {
                        ans += poll[2] - heightMap[newI][newJ];
                    }

                    queue.offer(new int[]{newI, newJ, Math.max(poll[2], heightMap[newI][newJ])});
                }
            }

        }
        return ans;

    }
}
