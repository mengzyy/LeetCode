package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-13 22:15
 **/
public class n17 {

    public static void f(int[] input) {
        int n = input.length;
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];

        //左至右遍历
        for (int i = 0; i < n; i++) {
            //初始化
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    max = max < leftDp[j] + 1 ? leftDp[j] + 1 : max;
                }
            }
            leftDp[i] = max;
        }
        //从右向左遍历
        for (int i = n - 1; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < n; j++) {
                if (input[i] > input[j]) {
                    max = max < rightDp[j] + 1 ? rightDp[j] + 1 : max;
                }
            }
            rightDp[i] = max;

        }
        //相加
        int queueLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            queueLen = queueLen < leftDp[i] + rightDp[i] ? leftDp[i] + rightDp[i] : queueLen;

        }
        System.out.println(n - queueLen+1);


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextInt();

            }
            f(input);


        }


    }
}
