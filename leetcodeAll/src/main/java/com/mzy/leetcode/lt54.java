package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
public class lt54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        while (matrix.length > 0) {
            int n = matrix.length;
            int m = matrix[0].length;

            //添加
            for (int i : matrix[0]) {
                res.add(i);
            }

            //删除一行
            if (matrix.length > 1) {
                int[][] matrixtemp = new int[n-1][m];
                for (int i = 1; i < n; i++) {
                    matrixtemp[i - 1] = matrix[i];
                }
                matrix = matrixtemp;

                //旋转（因为删除了一行所以n-1）
                int[][] arr = new int[m][n-1];
                for (int i = 0; i < n-1; i++) {
                    for (int j = 0; j < m; j++) {
                        arr[m - 1 - j][i] = matrix[i][j];
                    }
                }
                matrix=arr;

            } else {
                break;
            }


        }
        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));

    }
}
