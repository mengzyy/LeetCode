package com.mzy.huawei;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 19:50
 **/
public class n01 {
    public static void f(String[] input) {
        for (String s : input) {
            if (s.length() == 8) {
                System.out.println(s);
            } else if (s.length() < 8) {
                int addCount = 8 - s.length();
                for (int i = 0; i < addCount; i++) {
                    s = s + "0";

                }
                System.out.println(s);
            } else {
                while (true) {
                    String temp = s.substring(0, 8);
                    s = s.substring(8, s.length());
                    System.out.println(temp);
                    if (s.length() <= 8) {
                        break;
                    }
                }
                //重新计算长度
                int addCount = 8 - s.length();
                for (int i = 0; i < addCount; i++) {
                    s = s + "0";
                }
                System.out.println(s);
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = new String[2];
        a[0] = sc.next();
        a[1] = sc.next();
        f(a);

    }
}
