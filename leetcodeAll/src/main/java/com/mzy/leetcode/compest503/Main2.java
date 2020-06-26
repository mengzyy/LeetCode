package com.mzy.leetcode.compest503;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-03 10:37
 **/
public class Main2 {
    public boolean kLengthApart(int[] nums, int k) {

        boolean isStart = false;
        int start = -1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                if (!isStart) {
                    start = i;
                    isStart = true;
                } else {
                    if (i - start - 1 < k) {
                        return false;
                    } else {
                        start = i;
                    }
                }
            }

        }
        return true;

    }

    public static void main(String[] args) {

        System.out.println(new Main2().kLengthApart(new int[]{1, 0, 0, 1, 0,0, 1}, 2));

    }
}
