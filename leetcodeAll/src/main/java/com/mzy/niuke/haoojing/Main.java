package com.mzy.niuke.haoojing;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-06 15:27
 **/

class a implements Runnable{


    @Override
    public void run() {
        System.out.println("Sd");

    }
}
public class Main {
    public static int f(int n) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hashSet = new HashSet<>();
        String s = String.valueOf(n);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!hashSet.contains(s.charAt(i))) {
                sb.append(s.charAt(i));
                hashSet.add(s.charAt(i));
            }

        }
        return Integer.valueOf(sb.toString());

    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));

        Integer integer = Integer.valueOf("123");
        int i = integer.intValue();

        Thread t = new Thread(new a());
        t.start();


    }
}
