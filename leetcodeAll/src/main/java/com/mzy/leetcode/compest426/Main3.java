package com.mzy.leetcode.compest426;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-26 10:59
 **/
public class Main3 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) return new int[0];
        int maxLen = 0;
        int count = 0;
        for (List<Integer> num : nums) {
            count += num.size();
            maxLen = Math.max(num.size(), maxLen);
        }
        int[] ans = new int[count];
        int t = 0;
        for (int i = 0; i < nums.size() + maxLen - 1; i++) {
            int ai = 0;
            int aj = 0;
            if (i < nums.size()) {
                ai = i;
            } else {
                ai = nums.size() - 1;
                aj = i - nums.size() + 1;
            }
            int newI = ai;
            int newJ = aj;
            while (newI <= nums.size() - 1 && newI >= 0 && newJ <= maxLen - 1 && newJ >= 0) {
                if (newJ < nums.get(newI).size()) {
                    ans[t] = nums.get(newI).get(newJ);
                    t++;
                }
                newI--;
                newJ++;
            }
        }
        return ans;


    }

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
//        List<Integer> b = new ArrayList<>();
//        b.add(6);
//        b.add(7);
//        List<Integer> c = new ArrayList<>();
//        c.add(8);
//        List<Integer> e = new ArrayList<>();
//        e.add(9);
//        e.add(10);
//        e.add(11);
//        List<Integer> f = new ArrayList<>();
//        f.add(12);
//        f.add(13);
//        f.add(14);
//        f.add(15);
//        f.add(16);

        List<List<Integer>> d = new ArrayList<>();
        d.add(a);
//        d.add(b);
//        d.add(c);
//        d.add(e);
//        d.add(f);
        new Main3().findDiagonalOrder(d);
    }
}
