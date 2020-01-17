package com.mzy.leetcode;

import java.util.Arrays;

public class lt16 {


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];

                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target) {
                    R--;
                } else if (sum < target) {
                    L++;
                } else {
                    return ans;
                }


            }

        }
        return ans;


    }


}
