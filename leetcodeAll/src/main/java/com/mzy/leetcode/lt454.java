package com.mzy.leetcode;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-04 14:37
 **/
public class lt454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                /*A+B*/
                int t = A[i] + B[j];
                if (!hashMap.containsKey(t)) hashMap.put(t, 1);
                else {
                    hashMap.put(t, hashMap.get(t) + 1);
                }
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int t = C[i] + D[j];
                if (hashMap.containsKey(-t)) {
                    ans += hashMap.get(-t);
                }
            }
        }
        return ans;

    }
}
