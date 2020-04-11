package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-11 14:45
 **/
public class lt58 {
    public int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0) return 0;
        String trim = s.trim();
        int count = 0;
        for (int i = trim.length() - 1; i >= 0; i--) {
            if (trim.charAt(i) == ' ') break;
            else count++;
        }
        return count;


    }
}
