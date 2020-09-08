package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-08 13:40
 **/
public class lt754 {
    public int reachNumber(int target) {

        int k = 0;
        int sum = 0;
        while (sum < target) {
            k++;
            sum += k;
        }
        int delt = sum - target;
        return delt==0?k:k+1+k%2;

    }

}
