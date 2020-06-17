package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/3sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class lt15 {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> listres = new ArrayList<>();
        //排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //大于0直接退出
            if (nums[i] > 0) break;

            //本身进行去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int L = i + 1;
            int R = nums.length - 1;


            while (L < R) {
                //先去重


                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    listres.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }


            }


        }

        return listres;


    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,-1,2}));

    }
}
