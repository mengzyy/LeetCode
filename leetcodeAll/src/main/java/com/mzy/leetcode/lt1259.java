package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-21 17:17
 **/
public class lt1259 {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) return "";
        int leftCount = 0;
        int rightCount = 0;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (temp != ')') {
                if (temp == '(') leftCount++;
                sb.append(temp);
            } else {
                if (leftCount >= rightCount + 1) {
                    sb.append(temp);
                    rightCount++;
                }
            }
        }
        if (leftCount == rightCount) return sb.toString();

        int del = leftCount - rightCount;
        String pre = sb.toString();
        StringBuilder ans = new StringBuilder();
        int c = 0;
        while (del != 0||c<pre.length()) {
            char temp = pre.charAt(c);
            if (del==0||temp != '(') {
                ans.append(temp);
            } else {
                del--;
            }
            c++;

        }
        return ans.toString();

    }

    public static void main(String[] args) {
        new lt1259().minRemoveToMakeValid("(a(b(c)d)");
    }

}
