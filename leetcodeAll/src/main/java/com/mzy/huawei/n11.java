package com.mzy.huawei;

import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-13 13:07
 **/
public class n11 {

    public static void f(String input) {
        String[] split = input.split("(;)+");
        String temp = "ASWD";
        int[] a = new int[2];
        for (String s : split) {
            if (s.length() == 2) {
                if (temp.contains(String.valueOf(s.charAt(0))) && s.charAt(1) >= '0' && s.charAt(1) <= '9') {
                    move(s.charAt(0), String.valueOf(s.charAt(1)), a);
                }
            } else if (s.length() == 3) {
                if (temp.contains(String.valueOf(s.charAt(0))) && s.charAt(1) >= '0' && s.charAt(1) <= '9' && s.charAt(2) >= '0' && s.charAt(2) <= '9') {
                    move(s.charAt(0), s.substring(1, 3), a);
                }
            }


        }
        System.out.println(a[0] + "," + a[1]);


    }

    private static void move(char charAt, String charAt1, int[] a) {
        if (charAt == 'A') {
            a[0] -= Integer.parseInt(charAt1);
        } else if (charAt == 'W') {
            a[1] += Integer.parseInt(charAt1);
        } else if (charAt == 'S') {
            a[1] -= Integer.parseInt(charAt1);
        } else {
            a[0] += Integer.parseInt(charAt1);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        f(n);


    }
}
