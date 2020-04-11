package com.mzy.offer;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-21 20:36
 **/
public class fddds {

    public static int[] f(int len, int[] a) {
        if (a.length == 0) return null;
        //使用单调栈
        Stack<Integer> stackUp = new Stack<>();
        Stack<Integer> stackDowm = new Stack<>();

        int[] bookUp = new int[len];
        int[] bookDown = new int[len];

        for (int i = 0; i < a.length; i++) {
            //维护单调减
            if (stackDowm.isEmpty() || stackDowm.peek() > a[i]) {
                stackDowm.push(a[i]);
            } else {
                while (!stackDowm.isEmpty() && stackDowm.peek() <=a[i]) {
                    stackDowm.pop();
                }
                stackDowm.push(a[i]);
            }
            bookDown[i] = stackDowm.size();
        }


        for (int i = a.length - 1; i >= 0; i--) {
            //维护单调增
            if (stackUp.isEmpty() || stackUp.peek() > a[i]) {
                stackUp.push(a[i]);
            } else {
                while (!stackUp.isEmpty() && stackUp.peek() <=a[i]) {
                    stackUp.pop();
                }
                stackUp.push(a[i]);
            }
            bookUp[i] = stackUp.size();
        }

        for (int i = bookDown.length - 1; i >= 1; i--) {
            bookDown[i] = bookDown[i - 1];
        }
        bookDown[0] = 0;
        for (int i = 0; i <= bookUp.length - 2; i++) {
            bookUp[i] = bookUp[i + 1];
        }
        bookUp[bookUp.length - 1] = 0;

        //增和：因为自己的视角多加了一次 减去1
        for (int j = bookUp.length - 1; j >= 0; j--) {
            bookUp[j] += bookDown[j] + 1;

        }
        return bookUp;


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int[] res = f(len, a);

        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.print(res[len - 1]);


    }
}
