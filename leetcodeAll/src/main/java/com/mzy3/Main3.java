package com.mzy3;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-28 11:25
 **/
public class Main3 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        int count = 1;
        while ((res & count) == 0) {
            count = count << 1;
        }
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((count & nums[i]) != 0) ans[0] ^= nums[i];
            else ans[1] ^= nums[i];
        }
        return ans;


    }

    public static void main(String[] args) {

        new Main3().singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3});
    }
}
