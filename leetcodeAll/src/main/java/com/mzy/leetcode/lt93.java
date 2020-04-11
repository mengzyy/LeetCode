package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-11 19:32
 **/
public class lt93 {
    static List<String> res;

    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() <= 4) return null;
        res = new ArrayList<>();
        restoreIpAddresses(s, 0, "", 4);
        return res;


    }

    private static void restoreIpAddresses(String s, int i, String s1, int count) {
        if (count == 0) {
            if (i == s.length()) {
                res.add(s1.substring(0, s1.length() - 1));
            }
        } else {
            //跳跃一次
            if (i<= s.length() - 1 && count - 1 >= 0)
                restoreIpAddresses(s, i + 1, s1 + s.charAt(i) + ".", count - 1);
            //跳跃二次
            if (i + 1 <= s.length() - 1 && count - 1 >= 0&&s.charAt(i)!='0')
                restoreIpAddresses(s, i + 2, s1 + s.substring(i, i + 2) + ".", count - 1);
            //跳跃三次
            if (i + 2 <= s.length() - 1 && count - 1 >= 0 && Integer.parseInt(s.substring(i, i + 3)) <= 255&&s.charAt(i)!='0') {
                restoreIpAddresses(s, i + 3, s1 + s.substring(i, i + 3) + ".", count - 1);
            }

        }

    }


    public static void main(String[] args) {

        List<String> list = restoreIpAddresses("25525511135");
    }
}
