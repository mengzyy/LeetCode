package com.mzy.leetcode.days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-16 10:19
 **/
public class n12 {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return new int[0][0];
        List<int[]> res = new ArrayList<>();

        List<int[]> contain = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            contain.add(new int[]{intervals[i][0], intervals[i][1]});
        }

        //排序
        Collections.sort(contain, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0]) {
                    return 1;
                } else if (a[0] < b[0]) {
                    return -1;
                }
                return 0;
            }
        });

        int start = contain.get(0)[0];
        int end = contain.get(0)[1];

        for (int i = 1; i < n; i++) {
            int nextStart = contain.get(i)[0];
            int nextEnd = contain.get(i)[1];
            if (nextStart < end) {
                end = nextEnd > end ? nextEnd : end;
            } else {
                //add
                res.add(new int[]{start, end});
                //update
                start = nextStart;
                end = nextEnd;
            }
        }
        //add
        res.add(new int[]{start, end});

        int len = res.size();

        int[][] res2 = new int[len][2];
        for (int i = 0; i < len; i++) {
            res2[i] = new int[]{res.get(i)[0], res.get(i)[1]};
        }
        return res2;

    }

    public static void main(String[] args) {

        new n12().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

    }
}
