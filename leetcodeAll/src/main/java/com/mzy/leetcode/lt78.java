package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-28 18:49
 **/
public class lt78 {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums==null||nums.length == 0) return null;

        res = new ArrayList<>();

        List<Integer> arrayList = new ArrayList<>();
        for (int m = 1; m <=nums.length; m++) {
            combine(nums, m, 0, arrayList);
        }
        res.add(new ArrayList<Integer>());



        return res;


    }

    private void combine(int[] nums, int k, int i, List<Integer> arrayList) {

        if (k == 0) {
            List<Integer> temp = new ArrayList<>();
            for (Integer integer : arrayList) {
                temp.add(integer);
            }
            res.add(temp);
        } else {
            for (int j = i; j <= nums.length-1; j++) {
                arrayList.add(nums[j]);
                combine(nums, k - 1, j + 1, arrayList);
                arrayList.remove(arrayList.size() - 1);


            }


        }

    }

    public static void main(String[] args) {



    }

}
