package com.mzy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-25 11:30
 **/
public class lt621 {
    public int leastInterval(char[] tasks, int n) {
        int[] input = new int[26];
        int count = tasks.length;
        for (char task : tasks) {
            input[task - 'A']++;
        }
        int time = 0;
        Arrays.sort(input);
        while (input[25] != 0) {
            int i = 0;

            while (i <= n) {
                if (input[25] == 0) break;
                if (i < 26 && input[25 - i] > 0) {
                    input[25 - i]--;
                }
                i++;
                time++;
            }
            Arrays.sort(input);

        }
        return time;


    }

    public static void main(String[] args) {


        new lt621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }
}
