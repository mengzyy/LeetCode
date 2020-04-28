package com.mzy.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-14 18:31
 **/
public class n22 {
    public static void f(String input1, String input2) {
        String helper1 = "0123456789abcdefABCDEF";
        String helper2 = "084C2A6E195D3B7F5D3B7F";
        String s = input1 + input2;
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (i % 2 == 0)
                list1.add(s.charAt(i));
            else
                list2.add(s.charAt(i));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        String res = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0, k = 0; i < len; ++i) {
            if (i % 2 == 0)
                res += list1.get(j++);
            else
                res += list2.get(k++);
        }
        for (int i = 0; i < len; ++i) {
            int n = helper1.indexOf(res.charAt(i));
            if (n != -1) {
                sb.append(helper2.charAt(n));
            } else {
                sb.append(res.charAt(i));
            }
        }
        System.out.println(sb.toString());


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String a = sc.next();
            String b = sc.next();
            f(a, b);
        }


    }
}
