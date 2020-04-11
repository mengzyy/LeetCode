package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-02 12:44
 **/

/*

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class nine {
    public static int JumpFloorII(int target) {

        if (target == 1) return 1;

        int a = 1;
        int count = 0;
        for (int i = 0; i < target - 1; i++) {
            count=2*a;
            a=count;

        }
        return count;

    }

    public static void main(String[] args) {

        System.out.println(JumpFloorII(4));


    }


}
