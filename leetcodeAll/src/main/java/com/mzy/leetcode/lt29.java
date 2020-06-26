package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-05 09:02
 **/
public class lt29 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int i = 0;

        int x = 0;
        int y = 0;

        int count = n * m - 1;

        visit[x][y] = true;
        res.add(matrix[0][0]);
        while (count != 0) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX > n - 1 || newY < 0 || newY > m - 1 || visit[newX][newY]) {
                i = (i + 1) % 4;
            } else {
                visit[newX][newY] = true;
                count--;
                res.add(matrix[newX][newY]);
                x = newX;
                y = newY;
            }
        }
        return res;
    }
}
