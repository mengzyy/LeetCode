package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-13 20:33
 **/
public class n15 {

    public static void f(int input) {

        int res = 0;
        while (input / 3 != 0) {
            int he = input / 3;
            res += he;
            input = he + input % 3;

        }
        if (input == 2) res++;
        System.out.println(res);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("0")) {
            f(sc.nextInt());
        }

    }
}
