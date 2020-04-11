package com.mzy.huaweibishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-26 17:10
 **/
public class no3 {

    public static int[] f(int[] input) {

        int[] book = new int[1001];

        for (int i = 0; i < input.length; i++) {
            book[input[i]] += 1;
        }

        return book;


    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.nextInt();

            }
            int[] f = f(input);
            for (int i = 0; i < f.length; i++) {
                if (f[i] != 0) {
                    System.out.println(i);
                }

            }
        }




    }
}
