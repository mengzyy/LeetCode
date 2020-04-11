package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-09 23:33
 **/
public class lt137 {
    public int singleNumber(int[] nums) {
        int seen_once = 0;
        int seen_twice = 0;
        for (int num : nums) {
            seen_once = ~seen_twice & (seen_once ^ num);
            seen_twice = ~seen_once & (seen_twice ^ num);


        }
        return seen_once;

    }

}
