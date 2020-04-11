package com.mzy.niuke.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-01 16:19
 **/
public class n05 {
    public static int f(int n, int m, String[] answer, int[] scores) {

        int res = 0;
        char[][] a = new char[n][m];
        int[][] book = new int[5][m];



        for (int i = 0; i < answer.length; i++) {
            String aAnswer = answer[i];
            for (int j = 0; j < aAnswer.length(); j++) {
                a[i][j] = aAnswer.charAt(j);

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                book[a[j][i] - 65][i] += 1;
            }

        }
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 5; j++) {
                max = max < book[j][i] ? book[j][i] : max;
            }
            res += scores[i] * max;
        }
        return res;


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] a = new String[n];
        int[] score = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
        }
        for (int i = 0; i < m; i++) {
            score[i] = sc.nextInt();

        }

        System.out.print(f(n, m, a, score));


    }
}
