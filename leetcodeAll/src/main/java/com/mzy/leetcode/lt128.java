package com.mzy.leetcode;

import org.omg.CORBA.MARSHAL;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-06 09:58
 **/
/*
idea:以空间换取时间，使用hashset这个结构来存储数据，并且要保证内循环只进入一次


 */
public class lt128 {


    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            //确保只能进入一次
            if (!hashSet.contains(num - 1)) {
                int tempLen = 1;
                while (hashSet.contains(++num)) tempLen++;
                maxLen = Math.max(maxLen, tempLen);
            }
        }
        return maxLen;

    }


}
