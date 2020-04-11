package com.mzy.baidu;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static int f(int n, long[] a) {

        if (a == null || a.length == 0) return -1;
        int res = 0;

        Arrays.sort(a);


        while (a[n - 1] >= n) {
            res++;
            //最大的减小
            a[n - 1] -= n;
            //其他减一
            for (int i = 0; i < n - 1; i++) {
                a[i] += 1;

            }
            //排序
            Arrays.sort(a);

        }
        return res;


    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] a = new long[n];
        while (sc.hasNext()) {
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(sc.next());

            }

            System.out.println(f(n, a));

        }
    }


}