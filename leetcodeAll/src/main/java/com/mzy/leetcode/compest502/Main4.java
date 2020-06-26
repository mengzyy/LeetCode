package com.mzy.leetcode.compest502;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-02 23:18
 **/
public class Main4 {
    public static int count;

    public int numberWays(List<List<Integer>> hats) {

        int leftSize = hats.size();

        int[] hatsMatch = new int[40];
        count = 0;
        for (int i = 0; i < leftSize; i++) {
            int[] used = new int[40];
            if (i == leftSize - 1) {
                find2(i, hats.get(i), used, hatsMatch, hats);
            } else {
                boolean b = find(i, hats.get(i), used, hatsMatch, hats);
                if (!b) return 0;
            }
        }
        return count;
    }

    private void find2(int x, List<Integer> xMatch, int[] used, int[] hatsMatch, List<List<Integer>> hats) {

        for (int j = 0; j < xMatch.size(); j++) {
            if (used[xMatch.get(j)] == 0) {
                used[xMatch.get(j)] = 1;
                //两种选择
                if (hatsMatch[xMatch.get(j)] == 0) {
                    hatsMatch[xMatch.get(j)] = x;
                    count = (count + 1) % 1000000007;
                } else {
                    find(hatsMatch[xMatch.get(j)], hats.get(hatsMatch[xMatch.get(j)]), used, hatsMatch, hats);
                }
            }
        }


    }

    public static boolean find(int x, List<Integer> xMatch, int[] used, int[] hatsMatch, List<List<Integer>> hats) {
        for (int j = 0; j < xMatch.size(); j++) {
            if (used[xMatch.get(j)] == 0) {
                used[xMatch.get(j)] = 1;
                if (hatsMatch[xMatch.get(j)] == 0 || find(hatsMatch[xMatch.get(j)], hats.get(hatsMatch[xMatch.get(j)]), used, hatsMatch, hats)) {
                    hatsMatch[xMatch.get(j)] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
