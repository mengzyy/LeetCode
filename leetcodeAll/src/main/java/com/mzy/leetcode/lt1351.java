package com.mzy.leetcode;


import java.util.logging.XMLFormatter;

/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
 * <p>
 * 请你统计并返回 grid 中 负数 的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * [4,3,2,-1],
 * [3,2,1,-1],
 * [1,1,-1,-2],
 * [-1,-1,-2,-3]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 */
public class lt1351 {

    public int countNegatives(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int lineLeft = 0;

        int res = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= lineLeft; j--) {
                if (grid[i][j] < 0) res++;
                if (grid[i][j] >= 0) {
                    lineLeft = j;
                    break;
                }
            }
        }
        return res;

    }

}
