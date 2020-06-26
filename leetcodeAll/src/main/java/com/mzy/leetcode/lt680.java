package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-19 11:12
 **/
public class lt680 {
    public boolean validPalindrome(String s) {
        if (s == null) return false;
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return validPalindrome(s, left, right-1) || validPalindrome(s, left+1, right);
            }
        }
        return true;


    }

    private boolean validPalindrome(String s, int left, int right) {
        while (left <= right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left > right;
    }

    public static void main(String[] args) {

        new lt680().validPalindrome("abc");
    }
}