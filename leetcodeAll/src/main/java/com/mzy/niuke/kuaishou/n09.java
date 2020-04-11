package com.mzy.niuke.kuaishou;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-07 18:24
 **/
public class n09 {
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();


        if (n * m == 0)
            return n + m;


        int[][] D = new int[n + 1][m + 1];


        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                D[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return D[n][m];
    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
////        String a = sc.next();
////        String b = sc.next();
////        System.out.println(minDistance(a,b));


    }
}
