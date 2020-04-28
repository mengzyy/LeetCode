package com.mzy.leetcode.compest184;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 13:51
 **/
public class n06 {
    public static void main(String[] args) {
        String s ="abcabc";
        StringBuilder sb = new StringBuilder();
        sb.append("abcabc");
        String replace = s.replace("abc", "d");
        boolean x=s.contains("abc");
        String trim = s.trim();
        int a = s.indexOf("a");
        int a1 = s.compareTo("abc");
        boolean ab = s.endsWith("abcabc");
        int i = s.lastIndexOf("a");
        boolean b = s.contentEquals(sb);
        boolean equals = s.equals(sb);
        System.out.println(b);
        System.out.println(ab);
        boolean sd = s.matches("(ab)+");

        System.out.println(sd);
        System.out.println(s);

    }
}
