package com.mzy.huawei;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-13 21:06
 **/
public class n16 {
    public static void f(String input) {
        int[] book = new int[200];
        for (int i = 0; i < input.length(); i++) {
            book[input.charAt(i)] += 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i : book) {
            if (i != 0) {
                min = min > i ? i : min;
            }
        }
        //存放最小的ascill值
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < book.length; i++) {
            if (book[i] == min) {
                list.add((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!list.contains(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
        }
        System.out.println(sb.toString());

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            f(sc.next());


        }


    }
}
