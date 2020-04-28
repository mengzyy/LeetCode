package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 20:38
 **/
public class n04 {
    public static void f(String a) {
        //首先判断是否含有.
        if (!a.contains(".")) {
            System.out.println(a);
        } else {
            String[] split = a.split("\\.");
            int left = Integer.parseInt(split[0]);
            if (split[1].charAt(0) >= '5') {
                System.out.println(left + 1);
            } else {
                System.out.println(left);
            }

        }


    }

    public static void main(String[] args) {


        Scanner sc  =new Scanner(System.in);
        f(sc.next());

    }
}
