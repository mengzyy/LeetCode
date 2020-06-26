package com.mzy.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-15 13:55
 **/
public class lt187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() < 10) return res;
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();
        int n = s.length();
        for (int i = 9; i < n; i++) {
            String temp = s.substring(i - 9, i + 1);
            if (!hashMap.containsKey(temp)) {
                hashMap.put(temp, 1);
            } else {
                hashMap.put(temp, hashMap.get(temp) + 1);
            }
        }
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) > 1) {
                res.add(key);
            }
        }
        return res;


    }
}
