package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-31 10:23
 **/
public class n03 {
    public int[] sortArray(int[] nums) {

        //使用二分
        quickSort2(nums, 0, nums.length - 1);
        return nums;


    }

    private void quickSort2(int[] nums, int left, int right) {
        if (left >= right) return;
        int lo = left + 1;               // 小于分界点元素的最右侧的指针
        int hi = right;                // 大于分界点元素的最左侧的指针
        while (lo <= hi) {
            if (nums[lo] > nums[left]) { // 交换元素确保左侧指针指向元素小于分界点元素
                swap(nums, lo, hi);
                hi--;
            } else {
                lo++;
            }
        }
        lo--;                          // 回到小于分界点元素数组的最右侧
        swap(nums, left, lo);          // 将分界点元素移到左侧数组最右侧
        quickSort2(nums, left, lo - 1);
        quickSort2(nums, lo + 1, right);


    }

    private void swap(int[] nums, int lo, int hi) {

        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

    public static void main(String[] args) {

        int[] ints = new n03().sortArray(new int[]{3,8});
        System.out.println(ints);


    }
}
