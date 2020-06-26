package com.mzy.leetcode.days;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-02 11:47
 **/
public class day888 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int maxLen = 0;
        HashMap<Character, Integer> hashMap = new LinkedHashMap<>();

        int len = s.length();
        int t = 0;
        for (int i = 0; i < len; i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), i);
                t++;
            } else {
                int index = hashMap.get(s.charAt(i));
                hashMap.clear();
                maxLen = Math.max(maxLen, t);
                i = index;
                t = 0;
            }
        }
        maxLen = Math.max(maxLen, t);
        return maxLen;


    }

    public static void main(String[] args) {
        new day888().lengthOfLongestSubstring(" ");


    }
}
