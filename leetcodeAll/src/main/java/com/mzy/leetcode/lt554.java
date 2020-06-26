package com.mzy.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-25 11:12
 **/
public class lt554 {
    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        int n = wall.size();
        for (int i = 0; i < n; i++) {
            int temp = 0;
            int m = wall.get(i).size();
            for (int j = 0; j < m - 1; j++) {
                temp += wall.get(i).get(j);
                if (!hashMap.containsKey(temp)) {
                    hashMap.put(temp, 1);
                } else {
                    hashMap.put(temp, hashMap.get(temp) + 1);
                }
            }
        }
        int max = 0;
        for (Integer integer : hashMap.keySet()) {
            max = Math.max(hashMap.get(integer), max);
        }
        return n - max;

    }
}
