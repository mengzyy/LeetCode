package com.mzy.leetcode.compest502;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-02 23:00
 **/
public class Main3 {
    public boolean checkIfCanBreak(String s1, String s2) {

        char[] chars = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int n = chars.length;

        Arrays.sort(chars);
        Arrays.sort(chars2);

        boolean isStart = false;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != chars2[i]) {
                if (chars[i] > chars2[i] && !isStart) {
                    isStart = true;
                    k = 0;
                } else if (chars[i] < chars2[i] && !isStart) {
                    isStart = true;
                    k = 1;
                } else if (isStart) {
                    if (chars[i] > chars2[i] && k == 1 || chars[i] < chars2[i] && k == 0) {
                        return false;
                    }
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {

        System.out.println(new Main3().checkIfCanBreak("leetcodee", "interview"));
    }
}
