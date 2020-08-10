package com.mzy.leetcode;

import com.alibaba.fastjson.JSON;
import sun.awt.image.ImageAccessException;

public class lt409 {
    /*error*/
    public int longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 1;
        for (int i = 1; i < len - 1; i++) {
            /*中间点为奇数*/
            int leftOdd = i - 1;
            int rightOdd = i + 1;
            while (leftOdd >= 0 && rightOdd <= len - 1 && s.charAt(leftOdd) == s.charAt(rightOdd)) {
                leftOdd--;
                rightOdd++;
            }
            /*update*/
            maxLen = Math.max(maxLen, (i - leftOdd) * 2 - 1);

            /*中间点为偶数*/
            int leftEven = i;
            int rightEven = i + 1;
            while (leftEven >= 0 && rightEven <= len - 1 && s.charAt(leftEven) == s.charAt(rightEven)) {
                leftEven--;
                rightEven++;
            }
            /*update*/
            maxLen = Math.max(maxLen, (i - leftEven) * 2);
        }
        return maxLen;


    }

    public int longestPalindrome2(String s) {
        int[] t = new int[58];
        for (char c : s.toCharArray()) {
            t[c] += 1;
        }
        int ans = 0;
        for (int i : t) {
            ans += i - (i & 1);
        }
        return ans < s.length() ? ++ans : ans;


    }

}
