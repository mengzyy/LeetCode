package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-22 22:23
 **/
public class dfsda {
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int x = target % 3;
        int y = target / 3;
        if (x == 0) {
            return (int) Math.pow(3, y);
        } else if (x == 1) {
            return (int) (2 * 2 * Math.pow(3, y - 1));
        } else {
            return (int) (2 * Math.pow(3, y));
        }

    }
}
