package com.mzy.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-06 10:30
 **/
public class lt205 {
    public boolean isIsomorphic(String s, String t) {
        int[] maps = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (maps[a] != maps[b]) return false;
            if (maps[a] == 0) {
                maps[a]++;
                maps[b]++;
            }
        }
        return true;


    }
}
