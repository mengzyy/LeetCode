package com.mzy.leetcode;

import java.util.*;

/**
 * @description:
 * @author: Meng ZhongYi
 * @create: 2020-08-06 09:15
 **/
public class lt336 {
    public List<List<Integer>> palindromePairs(String[] words) {

        /*存放翻转字符串*/
        Map<String, Integer> map = new HashMap<>();
        /*存放结果*/
        List<List<Integer>> ans = new ArrayList<>();

        int n = words.length;

        /*init*/
        for (int i = 0; i < n; i++) {
            String s = new StringBuilder(words[i]).reverse().toString();
            map.put(s, i);
        }

        for (int i = 0; i < n; i++) {
            String nowStr = words[i];
            int m = nowStr.length();
            /*前缀回文判断 后面部分翻转判断*/
            for (int j = 0; j <= m; j++) {
                if (isPrimStr(nowStr, 0, j)) {
                    if (map.containsKey(nowStr.substring(j))) {
                        List<Integer> t = new ArrayList<>();
                        t.add(map.get(nowStr.substring(j)));
                        t.add(i);
                        if (!t.get(0).equals(t.get(1))) {
                            ans.add(t);
                        }
                    }
                }
            }
            /*后缀回文判断 前面部分翻转判断 注意去掉j=0 否则会有重复*/
            for (int j = m; j >= 0; j--) {
                if (isPrimStr(nowStr, j, m)) {
                    if (map.containsKey(nowStr.substring(0, j))) {
                        List<Integer> t = new ArrayList<>();
                        t.add(i);
                        t.add(map.get(nowStr.substring(0, j)));
                        if (!t.get(0).equals(t.get(1))) {
                            ans.add(t);
                        }
                    }
                }

            }
        }

        return ans;


    }

    private boolean isPrimStr(String nowStr, int start, int end) {
        /*空字符的情况 返回true*/
        if (start == end && (start == 0 || start == nowStr.length())) return true;
        end--;
        while (start < end) {
            if (nowStr.charAt(start) != nowStr.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        String[] a = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> lists = new lt336().palindromePairs(a);
        System.out.println(lists);
    }
}
