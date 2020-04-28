package com.mzy.huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 21:40
 **/
public class n07 {
    public static void f(String input) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            hashSet.add(input.charAt(i));

        }
        System.out.println(hashSet.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f(sc.next());

    }
}
