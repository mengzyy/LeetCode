package com.mzy.leetcode.compest426;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-26 10:14
 **/
public class Main {
    public int maxScore(String s) {
        int len = s.length() - 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            String left = s.substring(0, i + 1);
            String right = s.substring(i + 1, len + 1);
            res = Math.max(count(left, right), res);

        }
        return res;

    }

    private int count(String left, String right) {
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) == '0') leftCount++;

        }
        for (int i = 0; i < right.length(); i++) {
            if (right.charAt(i) == '1') rightCount++;
        }
        return leftCount + rightCount;


    }


}
