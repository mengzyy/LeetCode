package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-10 14:05
 **/
public class lt47 {
    static List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, 0, new ArrayList<Integer>());
        return res;

    }

    private void permute(int[] nums, int i, ArrayList<Integer> arrayList) {
        if (i == nums.length) {
            res.add(new ArrayList<Integer>(arrayList));
        } else {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!hashSet.contains(nums[j])) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    arrayList.add(nums[i]);
                    permute(nums, i + 1, arrayList);
                    arrayList.remove(arrayList.size() - 1);
                    int temp2 = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp2;
                    hashSet.add(nums[j]);
                }
            }
        }
    }
}
