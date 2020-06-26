package com.mzy.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-15 10:20
 **/
public class lt560 {
    public int subarraySum(int[] nums, int k) {


        int count = 0;
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        int sum = 0;
        hashMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (hashMap.containsKey(sum - k)) {
                count += hashMap.get(sum - k);
            }
            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, 1);
            } else {
                hashMap.put(sum, hashMap.get(sum + 1) + 1);
            }
        }
        return count;

    }
}
