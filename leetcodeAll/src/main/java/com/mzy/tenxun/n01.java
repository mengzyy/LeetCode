package com.mzy.tenxun;

import javax.print.DocFlavor;
import java.util.Scanner;
import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-07 14:03
 **/
public class n01 {

    public static String f(String s) {
        if (s == null || s.length() == 0) return null;
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ']') {
                StringBuilder sTemp = new StringBuilder();
                while (stack.peek() != '[') {
                    sTemp.append(stack.pop());
                }
                //出掉左括号
                stack.pop();
                StringBuilder reverse = sTemp.reverse();
                String[] split = reverse.toString().split("\\|");
                int repLen = Integer.valueOf(split[0].substring(0, split[0].length()));
                String repS = split[1];
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < repLen; j++) {
                    sb2.append(repS);
                }
                for (int j = 0; j < sb2.toString().toCharArray().length; j++) {
                    stack.push(sb2.toString().charAt(j));

                }

            } else {
                //入栈
                stack.push(s.charAt(i));
            }

        }
        //出栈
        StringBuilder res = new StringBuilder();
        while (stack.size() != 0) {
            res.append(stack.pop());
        }

        return res.reverse().toString();


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(f(s));
    }


}
