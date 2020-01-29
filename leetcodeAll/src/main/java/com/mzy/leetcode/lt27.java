package com.mzy.leetcode;

public class lt27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == val ? 0 : 1;

        //定双指针
        int pre = 0;
        int pro = nums.length - 1;


        while (pre < pro) {
            while (pre < pro && nums[pre] != val) pre++;
            while (pre < pro && nums[pro] == val) pro--;
            if (pre < pro) {
                //交换
                int temp = nums[pre];
                nums[pre] = nums[pro];
                nums[pro] = temp;
            }

        }
        return nums[pre] == val ? pre : pre + 1;


    }
}

