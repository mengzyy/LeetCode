package com.mzy.leetcode.compest184;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 14:41
 **/
public class n05 {
    public int numOfWays(int n) {
        double s = 6;
        double f = 6;
        for (int i = 0; i < n - 1; i++) {
            s = s * 2 + 2*f;
            f = s *2+ f * 3;
        }
        return (int) ((s + f) % (Math.pow(10, 9) + 7));


    }
}
