package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-11 11:22
 **/
public class lt216 {
    static List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        dfs(1, k, n, new ArrayList<Integer>(), 0);
        return res;


    }

    private void dfs(int i, int k, int n, ArrayList<Integer> arrayList, int temp) {

        if (arrayList.size() == k && temp == n) {
            List<Integer> t = new ArrayList<>();
            for (Integer integer : arrayList) {
                t.add(integer);
            }
            res.add(t);
        } else {
            for (int j = i; j <= 9; j++) {

                if (temp + j <= n) {
                    arrayList.add(j);
                    dfs(j + 1, k, n, arrayList, temp + j);
                    arrayList.remove(arrayList.size() - 1);
                }

            }
        }


    }

}
