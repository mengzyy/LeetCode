package com.mzy.alibaba;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-23 19:31
 **/
public class Main2 {

    static int all = -1;
    static int count = -1;
    static int min;

    public static int f(String[][] a, int n, int m) {

        all = 5;
        min = Integer.MAX_VALUE;
        int i = -1;
        int j = -1;
        for (int i1 = 0; i1 < a.length; i1++) {
            for (int j1 = 0; j1 < a[i1].length; j1++) {

                if (a[i1][j1].equals("S")) {
                    i = i1;
                    j = j1;

                }

            }

        }

        count = 0;
        dfs(a, n, m, i, j);
        int res =count;
        count=0;
        return res;


    }

    private static void dfs(String[][] a, int n, int m, int i, int j) {

        if (!(a[i][j].equals("#"))) {
            if (a[i][j].equals("E")) {
                min = min > count ? count : min;
            } else {
                //向上
                if (i - 1 >= 0) {
                    count++;
                    dfs(a, n, m, i - 1, j);
                    count--;
                }

                //向下
                if (i + 1 <= n) {
                    count++;
                    dfs(a, n, m, i + 1, j);
                    count--;
                }

                //向左
                if (j - 1 >= 0) {
                    count++;
                    dfs(a, n, m, i, j - 1);
                    count--;
                }
                //向右
                if (j + 1 <= m) {
                    count++;
                    dfs(a, n, m, i, j + 1);
                    count--;
                }

                //使用bug
                if (n - i - 1 >= 0 && n - i - 1 <= n && m - j - 1 >= 0 && m - j - 1 <= m && all > 0) {
                    count++;
                    all--;
                    dfs(a, n, m, n - i - 1, m - j - 1);
                    all++;
                    count--;
                }


            }
        }


    }


    public static void main(String[] args) {

        int n = -1;
        int m = -1;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        String[][] input = new String[n][m];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].toCharArray().length; j++) {
                input[i][j] = String.valueOf(s[i].toCharArray()[j]);

            }

        }

        int f = f(input, n, m);
        System.out.println(f);


    }


}
