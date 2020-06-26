package com.mzy.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-07 15:23
 **/
public class lt76 {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> dictT = new LinkedHashMap<>();
        HashMap<Character, Integer> windowDict = new LinkedHashMap<>();
        int sLen = s.length();
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char a = t.charAt(i);
            if (!dictT.containsKey(a)) {
                dictT.put(a, 1);
            } else {
                dictT.put(a, dictT.get(a) + 1);
            }
        }

        int l = 0;
        int r = 0;
        int formed = 0;

        int[] ans = {-1, -1, 0};

        while (r < sLen) {

            char temp = s.charAt(r);

            if (!windowDict.containsKey(temp)) {
                windowDict.put(temp, 1);
            } else {
                windowDict.put(temp, windowDict.get(temp) + 1);
            }


            //判断
            if (dictT.containsKey(temp) && dictT.get(temp).equals(windowDict.get(temp))) {
                formed++;


                while (formed == dictT.size()) {
                    //更新ans
                    if (ans[0] == -1 || ans[2] > r - l + 1) {
                        ans[0] = l;
                        ans[1] = r;
                        ans[2] = r - l + 1;
                    }
                    //减去l
                    char tep = s.charAt(l);
                    windowDict.put(tep, windowDict.get(tep) - 1);
                    l++;
                    if (dictT.containsKey(tep) && windowDict.get(tep).intValue() < dictT.get(tep).intValue()) formed--;
                }


            }
            r++;


        }
        return ans[0] == -1 ? "" : s.substring(ans[0], ans[1] + 1);

    }

    public static void main(String[] args) {
        new lt76().minWindow("ab", "b");

    }
}
