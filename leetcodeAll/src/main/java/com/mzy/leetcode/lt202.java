package com.mzy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-30 11:20
 **/
public class lt202 {
    public boolean isHappy(int n) {

        HashSet<Integer> hashSet = new LinkedHashSet<>();

        while (true) {
            int t = 0;
            while (n != 0) {
                t += (n % 10) * (n % 10);
                n /= 10;
            }
            if (t == 1) return true;
            if (!hashSet.contains(t)) {
                hashSet.add(t);
            } else {
                return false;
            }
            n = t;
        }

    }

    //快慢指针
    public boolean isHappy2(int n) {
        int i = n;
        int j = getNext(n);
        if (j == 1) return true;
        while (i != j) {
            i = getNext(i);
            j = getNext(getNext(j));
            if (i == 1 || j == 1) return true;

        }
        return false;


    }

    private int getNext(int n) {
        int t = 0;
        while (n != 0) {
            t += (n % 10) * (n % 10);
            n /= 10;
        }
        return t;
    }
}
