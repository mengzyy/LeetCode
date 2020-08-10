package com.mzy.leetcode;

import java.util.Map;

/**
 * @description:
 * @author: Meng ZhongYi
 * @create: 2020-08-10 09:19
 **/
public class lt696 {

    public int countBinarySubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int pre = 0;
        /*之前数组长度*/
        int last = 0;
        while (pre < n) {
            char c = s.charAt(pre);
            int count = 0;
            while (pre < n && s.charAt(pre) == c) {
                pre++;
                count++;
            }
            ans += Math.min(last, count);
            last = count;

        }
        return ans;

    }
}
