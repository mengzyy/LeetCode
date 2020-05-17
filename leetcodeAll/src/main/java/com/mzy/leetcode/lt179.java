package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-08 16:28
 **/
public class lt179 {

    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = String.valueOf(o1);
                String b = String.valueOf(o2);
                if (a.equals(b)) return 0;
                String c = a + b;
                String d = b + a;
                for (int i = 0; i < c.length(); i++) {
                    if (c.charAt(i) > d.charAt(i)) {
                        return -1;
                    }
                    if (c.charAt(i) < d.charAt(i)) {
                        return 1;
                    }

                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        String res = sb.toString();
        while (res.length() > 1 && res.charAt(0) == '0') res = res.substring(1, res.length());
        return res;


    }

    public static void main(String[] args) {

    }


}
