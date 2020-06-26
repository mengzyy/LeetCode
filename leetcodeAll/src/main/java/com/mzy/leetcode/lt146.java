package com.mzy.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-21 13:36
 **/
public class lt146 {
    HashMap<Integer, Integer> hashMap;
    int maxLen;

    public lt146(int capacity) {
        hashMap = new LinkedHashMap<>();
        maxLen = capacity;
    }

    public int get(int key) {
        if (this.hashMap.containsKey(key)) {
            int ans = hashMap.get(key);
            hashMap.remove(key);
            hashMap.put(key, ans);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (hashMap.containsKey(key)) {
            hashMap.remove(key);
            hashMap.put(key, value);
        } else {
            if (hashMap.size() < maxLen) {
                hashMap.put(key, value);
            } else {
                hashMap.remove(hashMap.entrySet().iterator().next().getKey());
                hashMap.put(key, value);
            }
        }
    }

}
