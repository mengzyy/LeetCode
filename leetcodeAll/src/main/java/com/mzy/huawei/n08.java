package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 21:42
 **/
public class n08 {

    public static void f(int input) {
        int res = 0;
        while (input != 0) {
            res += input & 1;
            input = input >> 1;
        }
        System.out.println(res);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f(sc.nextInt());

    }
}
