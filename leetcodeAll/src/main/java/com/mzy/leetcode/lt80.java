package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-08 20:48
 **/
public class lt80 {
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 1;

        int count = 1;

        //覆盖指针
        int done = 1;
        for (int i = 0; i < nums.length; i++) {
            //与之前数相同
            if (nums[i] == nums[i - 1]) {
                count += 1;
                if (count <= 2) {
                    //需要覆盖
                    nums[done] = nums[i];
                    done++;
                }
            } else {
                //不相同,同样需要覆盖,此时指针可以移动
                count = 1;
                nums[done] = nums[i];
                done++;

            }


        }
        return --done;

    }
}
