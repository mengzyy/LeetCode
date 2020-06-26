package com.mzy.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-16 12:55
 **/
public class lt217 {

    public boolean containsDuplicate(int[] nums) {


        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) >=2) return true;

        }
        return false;

    }
}
