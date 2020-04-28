package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-15 10:30
 **/
public class lt542 {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;

        int n = matrix.length;
        int m = matrix[0].length;

        //dx dy
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    //add
                    queue.add(new int[]{i, j});
                }

            }
        }

        int t = 1;
        while (queue.size() != 0) {
            int queueLen = queue.size();
            while (queueLen != 0) {
                int[] poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = poll[0] + dx[i];
                    int newY = poll[1] + dy[i];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && matrix[newX][newY] == 1) {
                        matrix[newX][newY] += t;
                        queue.add(new int[]{newX, newY});
                    }
                }
                queueLen--;
            }
            t++;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j]--;
                }

            }
        }

        return matrix;


    }


}
