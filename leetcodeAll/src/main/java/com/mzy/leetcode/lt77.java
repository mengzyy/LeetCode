package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-28 18:01
 **/
public class lt77 {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || n < k) return null;

        res = new ArrayList<>();

        List<Integer> arrayList = new ArrayList<>();
        combine(n, k, 1, arrayList);


        return res;


    }

    private void combine(int n, int k, int i, List<Integer> arrayList) {

        if (k == 0) {
            List<Integer> temp = new ArrayList<>();
            for (Integer integer : arrayList) {
                temp.add(integer);
            }
            res.add(temp);
        } else {
            if (n - i + 1 < k) return;
            for (int j = i; j <= n; j++) {
                arrayList.add(j);
                combine(n, k - 1, j + 1, arrayList);
                arrayList.remove(arrayList.size() - 1);


            }


        }

    }


    public static void main(String[] args) {
        List<List<Integer>> combine = new lt77().combine(4, 2);
        System.out.println(combine);


    }


}
