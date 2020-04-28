package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-14 20:02
 **/
public class n23 {

    public static void f(String input) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= 'a' && input.charAt(i) <= 'z' || input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
                s.append(" ");
            } else {
                s.append(input.charAt(i));
            }

        }


        String[] split = s.toString().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 1; i--) {
            sb.append(split[i]);
            sb.append(" ");

        }
        sb.append(split[0]);
        System.out.println(sb.toString().trim());


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            f(sc.nextLine());
        }


    }
}
