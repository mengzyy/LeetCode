package com.mzy.leetcode;

import com.mzy.offer.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-28 20:09
 **/
public class test {

    public static List<String> res;

    public static List<String> f(String s) {

        res = new ArrayList<>();
        dfs(0, "", s);
        return res;


    }

    private static void dfs(int i, String strTemp, String s) {

        if (i == s.length()) {

            res.add(strTemp);

        } else {
            for (int j = i; j < s.length(); j++) {
                int temp = s.charAt(j);
                dfs(j+ 1, strTemp + s.charAt(j), s);
            }
        }

    }


    public static void main(String[] args) {
        List<String> abc = f("abc");
        System.out.println(abc);

    }
}
