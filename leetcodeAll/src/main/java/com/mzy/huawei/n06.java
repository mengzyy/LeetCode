package com.mzy.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 21:29
 **/
public class n06 {

    public static void f(String input) {
        List<Character> list = new ArrayList<>();
        for (int i = input.length() - 1; i >= 0; i--) {
            if (!list.contains(input.charAt(i))) {
                list.add(input.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);

        }
        System.out.println(sb.toString());


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        f(sc.next());
    }
}
