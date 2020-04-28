package com.mzy.leetcode.leetcodexx;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-17 12:26
 **/
public class Main2 {
    public int sumFourDivisors(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += countFourNum(nums[i]);
        }
        return res;

    }

    private int countFourNum(int num) {
        int res = 0;
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res += i;
                count++;
                int other = num / i;
                if (other != i) {
                    res += other;
                    count++;
                }
            }

        }
        return count == 4 ? res : 0;

    }
}
