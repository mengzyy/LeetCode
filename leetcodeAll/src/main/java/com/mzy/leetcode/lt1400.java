package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-06 13:36
 **/
public class lt1400 {

    public boolean canConstruct(String s, int k) {
        int[] book = new int[26];
        for (int i = 0; i < s.length(); i++) {
            book[s.charAt(i) - 'a'] += 1;
        }
        int count = 0;
        for (int i : book) {
            count += i & 1;

        }

        return k<=s.length()&&count<=k;

    }
}
