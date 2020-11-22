package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-08 13:57
 **/
public class lt779 {
    public static int kthGrammar(int N, int K) {
        if (N == 0) return 0;
        if (K % 2 == 0) {
            return kthGrammar(N - 1, (K + 1) / 2);
        } else {
            return Math.abs(kthGrammar(N - 1, K / 2) - 1);
        }
    }


}
