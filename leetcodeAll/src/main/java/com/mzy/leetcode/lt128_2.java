package com.mzy.leetcode;

import java.util.HashSet;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-08 17:05
 **/
public class lt128_2 {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (Integer integer : hashSet) {
            if (hashSet.contains(integer - 1)) {
                continue;
            }
            int nowNum = integer;
            int localLen = 0;
            while (hashSet.contains(nowNum)) {
                localLen++;
                nowNum++;
            }
            maxLen = Math.max(maxLen, localLen);
        }
        return maxLen;

    }
}
