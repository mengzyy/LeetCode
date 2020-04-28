package com.mzy.leetcode.compest667;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-19 10:35
 **/
public class Main1 {
    public String reformat(String s) {
        if (s.length() <=1) return s;
        List<Character> chara = new ArrayList<>();
        List<Character> num = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a >= 'a' && a <= 'z') {
                chara.add(a);
            } else {
                num.add(a);
            }
        }
        if (chara.size() == 0 || num.size() == 0) return "";
        int n = chara.size();
        int m = num.size();
        if (Math.abs(n - m) >= 2) return "";
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        if (n > m) {
            while (i < n || j < m) {

                if (i < n) sb.append(chara.get(i));
                if (j < m) sb.append(num.get(j));
                i++;
                j++;
            }

        } else {
            while (i < n || j < m) {
                if (j < m) sb.append(num.get(j));
                if (i < n) sb.append(chara.get(i));
                i++;
                j++;
            }

        }
        return sb.toString();


    }

    public static void main(String[] args) {

        new Main1().reformat("ab123");
    }
}
