package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-07 13:44
 **/
public class n08 {
    public void rotate(int[][] matrix) {

        //思路：现已对角线反转，在以中心进行反转
        int n = matrix.length;
        int m = matrix[0].length;

        //对角线
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        //中心反转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = temp;
            }

        }


    }

    public static void main(String[] args) {


    }
}
