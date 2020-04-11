package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-09 21:39
 **/
public class lt90 {
    public static HashSet<String> hashSet;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        hashSet = new HashSet<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, "");
        List<List<Integer>> res = new ArrayList<>();
        for (String s : hashSet) {
            List<Integer> list = new ArrayList<>();
            if (s.length() != 0) {
                String[] split = s.split(",");
                for (String s1 : split) {
                    list.add(Integer.parseInt(s1));
                }
                res.add(list);
            }
        }
        res.add(new ArrayList<Integer>());
        return res;


    }

    private void subsetsWithDup(int[] nums, int i, String s) {
        hashSet.add(s);
        for (int j = i; j < nums.length; j++) {
            if (j == i || nums[j] != nums[j - 1]) {
                subsetsWithDup(nums, j + 1, s + nums[j] + ',');
            }
        }

    }

    public static void main(String[] args) {

        List<List<Integer>> lists = new lt90().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }


}
