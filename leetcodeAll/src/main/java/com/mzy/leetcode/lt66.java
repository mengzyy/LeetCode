package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-21 16:23
 **/
public class lt66 {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        while (index >= 0) {
            int nowValue = digits[index];
            if (nowValue < 9) {
                digits[index]++;
                break;
            } else {
                digits[index--] = 0;
                if (index == -1) {
                    int[] ans = new int[digits.length + 1];
                    ans[0] = 1;
                    for (int i = 1; i <= digits.length; i++) {
                        ans[i] = digits[i - 1];
                    }
                    return ans;
                }
            }
        }
        return digits;

    }
}
