package com.mzy.leetcode.compest184;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 10:55
 **/
public class n02 {
    public int[] processQueries(int[] queries, int m) {

        int[] res = new int[queries.length];
        int[] p = new int[m + 1];
        for (int i = 1; i < p.length; i++) {
            p[i] = i;
        }

        for (int i = 0; i < queries.length; i++) {
            int index = Queryy(queries[i], p);
            res[i] = index - 1;
        }
        return res;


    }

    private int Queryy(int query, int[] p) {
        //查找
        int weizhi = -1;
        for (int i = 1; i < p.length; i++) {
            if (query == p[i]) {
                weizhi = i;
            }

        }
        int temp = p[weizhi];
        for (int i = weizhi; i >= 2; i--) {
            p[i] = p[i - 1];
        }
        p[1] = temp;

        return weizhi;

    }

    public static void main(String[] args) {
        int[] q = {3, 1, 2, 1};
        new n02().processQueries(q, 5);

    }
}
