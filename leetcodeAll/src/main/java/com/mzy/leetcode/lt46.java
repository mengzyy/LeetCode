package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-09 22:44
 **/
public class lt46 {
    static List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        permute(nums, 0, new ArrayList<Integer>());
        return res;

    }

    private void permute(int[] nums, int i, ArrayList<Integer> arrayList) {
        if (i == nums.length) {
            res.add(new ArrayList<Integer>(arrayList));
        } else {
            for (int j = i; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                arrayList.add(nums[j]);
                permute(nums, i + 1, arrayList);
                arrayList.remove(arrayList.size() - 1);
                int temp2 = nums[j];
                nums[j] = nums[i];
                nums[i] = temp2;
            }
        }
    }
}
