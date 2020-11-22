package com.mzy.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-11 11:38
 **/
public class ltoffer45 {
    public static String minNumber(int[] nums) {

        List<String> input = new ArrayList<>();

        for (int num : nums) {
            input.add(String.valueOf(num));
        }

        Collections.sort(input, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int len1 = a.length();
                int len2 = b.length();
                if (len1 == len2) return a.compareTo(b);
                return (a+b).compareTo(b+a);


            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(s);
        }
        return sb.toString();

    }

    public static void main(String[] args) {

        int[] nums ={121,12};
        String s = minNumber(nums);
        System.out.println(s);
    }
}
