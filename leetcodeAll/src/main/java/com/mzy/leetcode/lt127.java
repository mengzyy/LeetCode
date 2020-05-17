package com.mzy.leetcode;

import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-11 20:25
 **/
public class lt127 {
    public static int res;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //dfs深搜
        res = Integer.MAX_VALUE;
        int n = wordList.size();
        int[] book = new int[n];
        dfs(beginWord, endWord, wordList, book, 0);
        if (res == Integer.MAX_VALUE) return 0;
        return res + 1;


    }

    private void dfs(String beginWord, String endWord, List<String> wordList, int[] book, int path) {

        if (beginWord.equals(endWord)) res = Math.min(res, path);
        else {
            int len = wordList.size();
            for (int i = 0; i < len; i++) {
                if (oneDiffStr(beginWord, wordList.get(i)) && book[i] == 0) {
                    book[i] = 1;
                    if (path + 1 < res) dfs(wordList.get(i), endWord, wordList, book, path + 1);
                    book[i] = 0;
                }

            }
        }

    }

    private boolean oneDiffStr(String beginWord, String endWord) {
        int count = 0;
        int n = beginWord.length();
        for (int i = 0; i < n; i++) {
            if (beginWord.charAt(i) != endWord.charAt(i)) count++;
            if (count > 1) return false;
        }
        return true;


    }

}
