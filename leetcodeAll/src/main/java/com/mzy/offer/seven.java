package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-01 21:36
 **/
public class seven {


    public static int Fibonacci(int n) {
        if (n == 0) return 0;

        if (n <= 2) return 1;
        int a = 1;
        int b = 1;
        for (int i = 0; i < n - 2; i++) {
            int temp = b;
            b = a + b;
            a = temp;

        }
        return b;

    }

    public static void main(String[] args) {

        int fibonacci = Fibonacci(4);
        System.out.println(fibonacci);
    }


}
