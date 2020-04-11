package com.mzy.leetcode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-26 11:42
 **/
public class lt71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;

        //判断之前是否为斜杠
        boolean isSlash = false;
        //判断之前是否为点
        boolean isSpot = false;
        //三点情况
        boolean threeSpot = false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < path.toCharArray().length; i++) {
            char currenttemp = path.charAt(i);

            if (currenttemp == '/') {
                if (!threeSpot&&isSpot) {
                    stack.pop();
                    isSpot = false;
                } else if (!isSlash) {
                    stack.push(currenttemp);
                    isSlash = true;
                }
            } else if (currenttemp == '.') {
                if (isSpot) {
                    if (threeSpot || i + 1 <= path.toCharArray().length - 1 && path.charAt(i + 1) == '.') {
                        stack.push('.');
                        threeSpot = true;
                    } else {
                        //栈弹出至之前的斜杠
                        int count = 0;
                        while (stack.size() != 0) {
                            Character peek = stack.peek();
                            if (peek == '/') {
                                if (count != 1) {
                                    stack.pop();
                                    count++;
                                } else {
                                    break;
                                }
                            } else {
                                stack.pop();
                            }
                        }
                        if (stack.size() == 0) {
                            stack.push('/');
                            isSlash = true;
                        }
                    }

                    isSpot = false;
                } else {
                    stack.push(currenttemp);
                    isSpot = true;
                }
            } else {
                stack.push(currenttemp);
                isSlash = false;
                isSpot = false;
            }


        }
        if (isSpot || isSlash) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.append(stack.pop());
        }
        StringBuilder res = new StringBuilder();
        for (int i = sb.toString().toCharArray().length - 1; i >= 0; i--) {
//            if (!(i == 0 && sb.toString().charAt(i) == '/'&&res.length()!=0)) {
            res.append(sb.toString().charAt(i));
//            }
        }
        return res.toString();


    }

    public static void main(String[] args) {


        String s = new lt71().simplifyPath("/home//foo/");
        System.out.println(s);
    }
}
