package com.mzy.leetcode.compest503;

import org.omg.CORBA.MARSHAL;
import sun.nio.cs.ext.MacArabic;

import java.beans.Transient;
import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-03 10:43
 **/
public class Main3 {


    public int longestSubarray(int[] nums, int limit) {

        int max = nums[0];
        int min = nums[0];
        int ans = 0;
        SortedMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(nums[0], 0);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);

        int left = 0;
        int right = 0;
        for (right = 0; right < nums.length; right++) {
            //更新MAN MIN
            max = Math.max(max, nums[right]);
            min = Math.min(min, nums[right]);
            //加入treeMap
            treeMap.put(nums[right], right);


            if (Math.abs(max - min) > limit) {
                int t = treeMap.get(nums[left]);
                treeMap.remove(nums[left]);
                left = t + 1;
                treeMap.clear();
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for (int i = left; i <= right; i++) {
                    max = Math.max(max, nums[i]);
                    min = Math.min(min, nums[i]);
                    treeMap.put(nums[i], i);

                }
                ans = Math.max(ans, right - left + 1);
            } else {
                ans = Math.max(ans, right - left + 1);
            }
        }




        return ans;

    }


    public static void main(String[] args) {
        System.out.println(new Main3().longestSubarray(new int[]{4, 2, 2, 2, 4, 1, 2, 3, 4, 5, 23, 23, 4, 4, 2, 2}, 0));
    }
}