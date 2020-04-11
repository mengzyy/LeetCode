package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-03 13:48
 **/
public class n06 {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;


        int start = 0;
        boolean isPostiveNum = true;
        for (start = 0; start < str.toCharArray().length; start++) {
            if (str.charAt(start) != ' ') {
                if (str.charAt(start) == '-') {
                    isPostiveNum = false;
                    start++;
                    break;
                }
                if (str.charAt(start) == '+') {
                    isPostiveNum = true;
                    start++;
                    break;
                }
                if (str.charAt(start) <= '9' && str.charAt(start) >= '0') break;
                return 0;
            }

        }
        if (start >= str.length()) return 0;
        StringBuilder sb = new StringBuilder();

        int numLen = 0;//记录需要转化的数的长度 最终为0的话直接return0
        for (; start < str.toCharArray().length; start++) {
            if (str.charAt(start) <= '9' && str.charAt(start) >= '0') {
                sb.append(str.charAt(start));
                numLen++;
            } else {
                break;
            }
        }

        if (numLen == 0) return 0;
        try {
            int res = Integer.valueOf(sb.toString());
            return isPostiveNum ? res : -1 * res;

        } catch (Exception e) {
            return isPostiveNum ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        }

    }

    public static void main(String[] args) {

        System.out.println(myAtoi("          -42"));


    }

}
