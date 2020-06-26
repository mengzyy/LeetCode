package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-17 21:48
 **/
public class lt119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new LinkedList<>();
        List<Integer> pre = new LinkedList<>();
        pre.add(1);
        if (rowIndex == 0) return pre;
        for (int i = 1; i <= rowIndex; i++) {
            ans.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                int start = pre.get(j);
                int end = pre.get(j + 1);
                ans.add(start + end);
            }
            ans.add(1);
            pre = ans;
            ans = new LinkedList<>();
        }
        return pre;
    }


}
