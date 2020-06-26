package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-14 12:03
 **/
public class lt125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) sb.append(c);
        }

        int len = sb.length();
        s = sb.toString();
        if (len % 2 == 0) {
            //even
            int left = len / 2 - 1;
            int right = len / 2;
            while (left >= 0 && s.charAt(left) == s.charAt(right++)) left--;
            return left == -1;
        } else {
            //odd
            int left = len / 2 - 1;
            int right = len / 2 + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(right++))left--;
            return left == -1;
        }


    }


    public static void main(String[] args) {

        new lt125().isPalindrome("A man, a plan, a canal: Panama");
    }
}
