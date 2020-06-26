package com.mzy.leetcode;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-07 09:29
 **/
public class lt126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new LinkedList<>();
        if (beginWord.length() != endWord.length()) return res;
        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        if (!wordList.contains(endWord)) return res;

        HashMap<String, Integer> wordListind = new LinkedHashMap<>();
        for (String s : wordList) {
            wordListind.put(s, wordList.indexOf(s));
        }

        int n = wordList.size();
        //visit数组
        boolean[] book = new boolean[n];
        //path路径
        int[] path = new int[n];

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> wordListHash = new HashSet<>();
        for (String s : wordList) {
            wordListHash.add(s);
        }
        book[wordListind.get(beginWord)] = true;
        path[wordList.indexOf(beginWord)] = -1;
        boolean hasFind = false;
        while (queue.size() != 0 && !hasFind) {

            int len = queue.size();
            while (len != 0) {
                String poll = queue.poll();
                //change
                char[] chars = poll.toCharArray();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < 26; j++) {
                        chars[i] = (char) ('a' + j);
                        String s = chars.toString();
                        if (wordListHash.contains(s)) {
                            //如果等于endword
                            if (s.equals(endWord)) {
                                hasFind = true;
                                Stack<String> stack = new Stack<>();
                                stack.push(endWord);
                                int k = wordListind.get(poll);
                                stack.push(poll);
                                while (path[k] != -1) {
                                    stack.push(wordList.get(path[k]));
                                    k = path[k];
                                }
                                stack.push(beginWord);
                                List<String> list = new LinkedList<>();
                                while (!stack.isEmpty()) list.add(stack.pop());
                                res.add(list);
                            } else {
                                int ind = wordListind.get(s);
                                if (!book[ind]) {
                                    book[ind] = true;
                                    path[ind] = wordListind.get(poll);
                                }
                            }
                        }
                    }

                }
                len--;
            }


        }
        return res;


    }

    public static void main(String[] args) {
        List<String> wordList = new LinkedList<>();
        wordList.add("sss");
        new lt126().findLadders("sss", "aaa", wordList);

    }
}
