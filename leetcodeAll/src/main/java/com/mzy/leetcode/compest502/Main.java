package com.mzy.leetcode.compest502;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-02 22:09
 **/
public class Main {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);

        }
        int n = candies.length;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;

    }
}


