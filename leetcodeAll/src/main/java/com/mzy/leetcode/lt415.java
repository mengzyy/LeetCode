package com.mzy.leetcode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class lt415 {

    public String addStrings(String num1, String num2) {

        int c = 0;
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (len1 > -1 || len2 > -1) {
            char a = len1<=-1?'0':num1.charAt(len1);
            char b = len2<=-1?'0':num2.charAt(len2);
            int tempSum = (a - '0') + (b - '0') + c;
            if (tempSum >= 10) {
                sb.append((char) (tempSum % 10 + '0'));
                c = 1;
            } else {
                sb.append((char) (tempSum + '0'));
                c = 0;
            }
            len1--;
            len2--;
        }
        if (c == 1) sb.append('1');
        return sb.reverse().toString();


    }

    public static void main(String[] args) {

        String s = new lt415().addStrings("408", "5");

        System.out.println(s);


    }
}
