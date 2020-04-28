package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 20:22
 **/
public class n03 {
    public static void f(long a) {
        while (true) {
            long mid = a / 2;
            boolean hasZnum = false;
            for (long i = 2; i <= mid; i++) {
                if (a % i == 0) {
                    a /= i;
                    hasZnum = true;
                    System.out.print(i + " ");
                    break;
                }

            }
            if (!hasZnum) {
                System.out.println(a + " ");
                break;
            }
        }


    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        f(l);
    }
}
