package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 19:58
 **/
public class n02 {
    public static void f(String input) {
        input = input.substring(2, input.length());
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            if (a >= 'A' && a < 'F') {
                sum = sum * 16 + (a - 55);
            } else {
                sum = sum * 16 + (a - 48);
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            f(input);
        }

    }
}
