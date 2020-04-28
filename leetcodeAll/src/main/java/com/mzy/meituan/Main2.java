package com.mzy.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-19 17:37
 **/


public class Main2 {

    public static void main(String[] args) {
        minPrefix();
    }

    private static void minPrefix() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
            maxLen = Math.max(maxLen, strs[i].length());
        }

        int[] minLen = new int[n]; // minLen[i]: strs[i]的最小前缀长度

        for (int i = 1; i <= maxLen; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (minLen[j] != 0)
                    continue;
                if (i == strs[j].length()) {
                    minLen[j] = i;
                }
                String str = strs[j].substring(0, i);
                if (!map.containsKey(str)) {
                    map.put(str, 1);
                } else {
                    map.put(str, map.get(str) + 1);
                }

            }

            for (int j = 0; j < n; j++) {
                if (minLen[j] != 0)
                    continue;

                String str = strs[j].substring(0, i);
                if (map.get(str) == 1)
                    minLen[j] = i;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(strs[i].substring(0, minLen[i]));
        }
    }
}
