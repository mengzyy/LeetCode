package com.mzy.leetcode.days;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-25 10:52
 **/
public class n33 {
    public static List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0, new ArrayList<Integer>());
        return res;

    }
    private void dfs(int[] nums, int i, List<Integer> temp) {
        if (i == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int j = i; j < nums.length; j++) {
                //swap
                swap(nums, i, j);
                temp.add(nums[j]);
                dfs(nums, i + 1, temp);
                temp.remove(temp.size() - 1);
                swap(nums, i, j);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
