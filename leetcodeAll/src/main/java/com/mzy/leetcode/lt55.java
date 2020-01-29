package com.mzy.leetcode;

public class lt55 {

    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
            if(k>=nums.length-1)break;
        }
        return true;
    }


    public static void main(String[] args) {
        lt55 l = new lt55();
        System.out.println(l.canJump(new int[]{2,3,1,1,4}));



    }
}
