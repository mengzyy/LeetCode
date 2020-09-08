package com.mzy.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-04 15:32
 **/
public class lt56_2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        /*info add*/
        List<int[]> info = new ArrayList<>();
        for (int[] interval : intervals) {
            int[] t = {interval[0], interval[1]};
            info.add(t);
        }

        int start = info.get(0)[0];
        int end = info.get(0)[1];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < info.size(); i++) {
            int nextStart = info.get(i)[0];
            int nextEnd = info.get(i)[1];
            if (nextStart > end) {
                ans.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            } else {
                end = nextEnd > end ? nextEnd : end;
            }
        }
        ans.add(new int[]{start, end});
        int n = ans.size();
        int[][] res = new int[n][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;

    }
}
