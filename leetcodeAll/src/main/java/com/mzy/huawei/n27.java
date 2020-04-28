package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-15 17:07
 **/
public class n27 {

    public static void f(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int t = 0;
        while (t != n) {
            int i = t;
            int j = 0;
            while (j <= t) {
                matrix[i][j] = num;
                num++;
                j++;
                i--;
            }
            t++;
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    sb.append(matrix[i][j] + " ");
                }

            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));

        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            f(scanner.nextInt());
        }


    }
}
