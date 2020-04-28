package com.mzy.leetcode.compest667;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-19 11:12
 **/


public class Main3 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs == null || croakOfFrogs.length() <= 4) return -1;
        HashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put('c', 0);
        hashMap.put('r', 1);
        hashMap.put('o', 2);
        hashMap.put('a', 3);
        hashMap.put('k', 4);

        int res = 0;
        int[] count = new int[5];

        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            int integer = hashMap.get(c);
            count[integer]++;
            res = Math.max(res, count[integer]);
            for (int j = 0; j < integer; j++) {
                if (count[integer] > count[j]) return -1;
            }

            //消除
            if (integer == 4) {
                for (int j = 0; j < 5; j++) {
                    count[j]--;
                }
            }

        }
        for (int i = 0; i < 5; i++) {
            if (count[i] != 0) return -1;
        }
        return res;


    }

    public static void main(String[] args) {

        int croakcroak = new Main3().minNumberOfFrogs("croakcroa");
        System.out.println(croakcroak);
    }
}
