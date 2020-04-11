package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-28 16:48
 **/
/*
定义三个指针
左指针定为0 右指针定位2 工作指针
 */
public class lt75 {
    public static void sortColors(int[] nums) {

        if (!(nums == null || nums.length == 0)) {
            int n = nums.length - 1;
            int left = 0;
            int right = n;
            int work = left;
            while (work <= right) {
                int temp = nums[work];
                if (temp == 0) {
                    nums[work] = nums[left];
                    nums[left] = 0;
                    left++;
                    work++;
                } else if (temp == 2) {
                    nums[work] = nums[right];
                    nums[right] = 2;
                    right--;
                } else {
                    work++;
                }
            }
        }


    }

    public static void main(String[] args) {


        int[] a = {2, 0, 2, 1, 1, 0};
        sortColors(a);
    }
}
