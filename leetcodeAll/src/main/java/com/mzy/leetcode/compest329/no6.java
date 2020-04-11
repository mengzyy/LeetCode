package com.mzy.leetcode.compest329;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-04 23:07
 **/
public class no6 {

    public static int maxSatisfaction(int[] a) {

        int n = a.length;

        Arrays.sort(a);
        int ans = 0, sum = 0, cur = 0;
        for (int i = n - 1; i >= 0; --i) {
            cur += sum + a[i];
            ans = Math.max(ans, cur);
            sum += a[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] a = {-1, -8, 0, 5, -7};
        System.out.println(maxSatisfaction(a));

    }


}
