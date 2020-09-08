package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-04 14:53
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lt15_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        /*sort*/
        Arrays.sort(nums);
        /*这题的候心在于去重*/
        for (int i = 0; i < nums.length; i++) {
            /*i去重*/
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int L = i;
            int R = i + 1;
            int RR = nums.length - 1;

            while (R < RR) {
                int sum = nums[L] + nums[R] + nums[RR];
                if (sum == 0) {
                    while (R < RR && nums[R] == nums[R + 1]) R++;
                    while (R < RR && nums[RR] == nums[RR - 1]) RR--;
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[L]);
                    t.add(nums[R]);
                    t.add(nums[RR]);
                    ans.add(t);
                    R++;
                    RR--;

                } else if (sum > 0) {
                    RR--;
                } else {
                    R++;
                }
            }


        }
        return ans;
    }
}
