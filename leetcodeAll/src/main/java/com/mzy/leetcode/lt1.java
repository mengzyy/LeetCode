package com.mzy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class lt1 {


    public static int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        int[] res = new int[2];
        if (len < 1) {
            return res;
        } else {
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] + nums[j] == target) {
                        res[0] = i;
                        res[1] = j;
                        break;
                    }
                }
            }

        }

        return res;


    }

    //使用hashmap解法
    public static int[] twoSumHashMap(int[] nums, int target) {
        if (nums.length < 2) return new int[]{0, 0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            //直接在循环里进行判断
            //为了保正存在重复元素
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};

            }
            map.put(nums[i], i);


        }
        return new int[]{0, 0};
    }


    public static void main(String[] args) {


        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSumHashMap(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }


    }
}
