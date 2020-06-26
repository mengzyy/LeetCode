package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-17 21:35
 **/
public class lt118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        if (numRows == 0) return ans;
        List<Integer> start = new LinkedList<>();
        start.add(1);
        ans.add(start);
        if (numRows == 1) return ans;

        for (int i = 2; i <= numRows; i++) {
            if (i == 2) {
                List<Integer> t = new LinkedList<>();
                t.add(1);
                t.add(1);
                ans.add(t);
            } else {
                //获取前一行
                List<Integer> preLine = ans.get(i - 2);
                List<Integer> t = new LinkedList<>();
                t.add(1);
                for (int j = 0; j < preLine.size() - 1; j++) {
                    int left = preLine.get(j);
                    int right = preLine.get(j + 1);
                    t.add(left + right);
                }
                t.add(1);
                ans.add(t);
            }
        }
        return ans;


    }


}

