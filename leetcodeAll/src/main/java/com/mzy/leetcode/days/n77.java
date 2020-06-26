package com.mzy.leetcode.days;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-01 10:50
 **/
public class n77 {
    public int[] masterMind(String solution, String guess) {
        HashMap<Character, Integer> hashMap1 = new LinkedHashMap<>();
        HashMap<Character, Integer> hashMap2 = new LinkedHashMap<>();
        int[] res = new int[2];
        int len = solution.length();
        for (int i = 0; i < len; i++) {
            if (solution.charAt(i) == guess.charAt(i)) res[0]++;
            else {
                if (!hashMap1.containsKey(solution.charAt(i))) {
                    hashMap1.put(solution.charAt(i), 1);
                } else {
                    hashMap1.put(solution.charAt(i), hashMap1.get(solution.charAt(i)) + 1);
                }
                if (!hashMap2.containsKey(guess.charAt(i))) {
                    hashMap2.put(guess.charAt(i), 1);
                } else {
                    hashMap2.put(guess.charAt(i), hashMap2.get(guess.charAt(i)) + 1);
                }

            }
        }

        for (Character character : hashMap2.keySet()) {
            if (hashMap1.containsKey(character)) {
                res[1] += Math.min(hashMap1.get(character), hashMap2.get(character));
            }

        }
        return res;


    }
}
