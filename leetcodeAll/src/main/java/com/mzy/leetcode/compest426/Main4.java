package com.mzy.leetcode.compest426;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-26 15:02
 **/
public class Main4 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> t = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (t.size() <= i + j) {
                    List<Integer> line = new ArrayList<>();
                    t.add(line);
                }
                t.get(i + j).add(list.get(j));
                count++;
            }
        }
        int[] ans = new int[count];
        int work = 0;
        for (List<Integer> list : t) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ans[work] = list.get(i);
                work++;
            }
        }
        return ans;


    }

}
