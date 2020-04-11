package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-01 21:43
 **/

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class weight {
    public int JumpFloor(int target) {
        if (target == 0) return 0;

        if (target == 1) return 1;
        if (target == 2) return 2;
        int a = 1;
        int b = 2;
        for (int i = 0; i < target - 2; i++) {
            int temp = b;
            b = a + b;
            a = temp;

        }
        return b;


    }


}
