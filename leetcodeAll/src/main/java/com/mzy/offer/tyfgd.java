package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 16:35
 **/
/*
汇编语言中有一种移位指令叫做循环左移（ROL），
现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class tyfgd {
    public   String LeftRotateString(String str, int n) {
        if (str.length()==0||n == 0) return str;
        int k = n % str.length();
        String left = str.substring(0, k);
        String right = str.substring(k, str.length());
        return right + left;

    }

    public static void main(String[] args) {
//        System.out.println(LeftRotateString("abcdefg",1));


    }



}
