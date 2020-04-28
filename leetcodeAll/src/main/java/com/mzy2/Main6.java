package com.mzy2;

import com.mzy.offer.dfs;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-20 16:53
 **/
public class Main6 {

    public static int res;
    public static int[] book;

    public static int f(int[] city, int N, int A, int B, int C) {
        res = Integer.MAX_VALUE;
        book = new int[city.length];
        dfs(city, A, B, C, N, 1, 0);
        return res;

    }

    private static void dfs(int[] city, int A, int B, int C, int N, int nowIndex, int count) {
        if (nowIndex == N) {
            res = Math.min(count, res);
        } else {
            //三种选择
            if (count + A < res && book[nowIndex] == 0) {
                book[nowIndex] = 1;
                dfs(city, A, B, C, N, city[nowIndex], count + A);
                book[nowIndex] = 0;
            }

            if (count + B < res && city[nowIndex] > 1) {
                city[nowIndex]--;
                boolean isonef = false;
                if (book[nowIndex] == 1) {
                    isonef = true;
                    book[nowIndex] = 0;
                }
                dfs(city, A, B, C, N, nowIndex, count + B);
                city[nowIndex]++;
                if (isonef) book[nowIndex] = 1;
            }

            if (count + C < res && city[nowIndex] < N) {
                city[nowIndex]++;
                boolean istwof = false;
                if (book[nowIndex] == 1) {
                    istwof = true;
                    book[nowIndex] = 0;
                }
                dfs(city, A, B, C, N, nowIndex, count + C);
                city[nowIndex]--;
                if (istwof) book[nowIndex] = 1;
            }
        }


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int cityLen = scanner.nextInt();
            int[] city = new int[cityLen + 1];
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();

            for (int i = 1; i <= cityLen; i++) {
                city[i] = scanner.nextInt();

            }
            System.out.println(f(city, cityLen, A, B, C));


        }


    }
}
