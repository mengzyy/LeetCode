package com.mzy.leetcode.compest329;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-04 22:30
 **/
public class n04 {
    public  int countLargestGroup(int n) {

        if (n == 1) return 1;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num != 0) {
                int m = num % 10;
                sum+= m;
                num /= 10;
            }
            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, 1);

            } else {
                hashMap.put(sum, hashMap.get(sum) + 1);
            }

        }

        int max = Integer.MIN_VALUE;
        for (Integer integer : hashMap.keySet()) {
            max = max < hashMap.get(integer) ? hashMap.get(integer) : max;

        }
        int res = 0;
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) == max) res++;

        }
        return res;


    }

    public static void main(String[] args) {
    }
}
