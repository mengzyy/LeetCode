package com.mzy.leetcode;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-10 22:35
 **/
public class ltoffer48 {
    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        int t = 0;
        int leftBoard = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            char temp = s.charAt(i);
            if (!hashMap.containsKey(temp) || hashMap.get(temp) < leftBoard) {
                hashMap.put(temp, i);
                t++;
            } else {
                int integer = hashMap.get(temp);
                hashMap.put(temp, i);
                max = Math.max(max, t);
                t = i - integer;
                leftBoard = integer + 1;
            }

        }
        max = Math.max(max, t);
        return max;

    }

    public static void main(String[] args) {
        int abba = lengthOfLongestSubstring("abba");
        System.out.println(abba);

    }
}
