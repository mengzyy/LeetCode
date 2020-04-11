package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-28 16:39
 **/
public class lt74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) return false;

        int n = matrix.length-1;
        int m = matrix[0].length-1;

        int i = n;
        int j = 0;

        //退出条件
        while (i >= 0 && j <= m) {


            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) {
                //向上搜索
                i--;
            } else {
                //向右搜索
                j++;
            }

        }
        return false;

    }
}
