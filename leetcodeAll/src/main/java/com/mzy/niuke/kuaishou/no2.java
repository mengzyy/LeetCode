package com.mzy.niuke.kuaishou;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-31 14:14
 **/
public class no2 {

    public static boolean f(int n) {
        if (n == 1) return true;

        HashSet<Integer> hashSet = new HashSet<>();

        while (n!=1) {

            int nextn = 0;
            while (n != 0) {
                int temp = n % 10;
                n /= 10;
                nextn += temp * temp;
            }
            if (!hashSet.contains(nextn)) {
                if (nextn == 1) return true;
                hashSet.add(nextn);
                n = nextn;
            } else {
                return false;
            }

        }
        return false;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(f(a[i]));
        }


    }
}
