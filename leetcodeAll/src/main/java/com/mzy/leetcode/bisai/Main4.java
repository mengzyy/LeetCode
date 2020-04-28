package com.mzy.leetcode.bisai;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 22:02
 **/
public class Main4 {


    public static List<int[]> f(int[] nums) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1 + i; j < nums.length; j++) {
                if (find(i, j, nums)) {
                    res.add(new int[]{nums[i], nums[j]});
                }

            }

        }
        return res;


    }

    private static boolean find(int i, int j, int[] nums) {

        int target = nums[i] + nums[j];

        int left = j + 1;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;


    }


    public static void main(String[] args) {


        f(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});


    }
}
