package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-14 11:31
 **/
public class lt136 {
    public int singleNumber(int[] nums) {

        int ans=0;
        for(int i:nums){

            ans^=i;
        }
        return ans;

    }

    public static void main(String[] args) {


        int i = new lt136().singleNumber(new int[]{2,2,1});
        System.out.println(i);
    }
}
