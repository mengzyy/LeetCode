package com.mzy2;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-20 16:23
 **/
public class Main5 {

    public static int f(int n, int m, int a, int b) {
        if (a > n) a = n;
        if(b > m) b = m;

        //初始化目标矩阵
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = ((i + 1) * (j + 1)) % 10;
            }
        }
        int ans = 0;
        //初始化结果矩阵
        for (int i = 0; i < n - (a - 1); i++) {
            for (int j = 0; j < m - (b - 1); j++) {
                int max = Integer.MIN_VALUE;
                int startI = i;
                int startJ = j;
                for (int k = startI; k < startI + a; k++) {
                    for (int h = startJ; h < startJ + b; h++) {
                        max = Math.max(max, matrix[k][h]);
                    }
                }
                ans += max;


            }
        }
        return ans;


    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(f(n, m, a, b));

        }


    }
}
