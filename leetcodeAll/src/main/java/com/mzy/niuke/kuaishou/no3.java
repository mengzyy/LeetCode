package com.mzy.niuke.kuaishou;

import java.io.CharArrayReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-31 14:32
 **/
public class no3 {

    public static boolean f(String x, String y) {

        Queue<Character> queueX = new LinkedList<>();
        Queue<Character> queueY = new LinkedList<>();
        for (char c : x.toCharArray()) {
            if (c != '.') {
                queueX.offer(c);
            }
        }
        for (char c : y.toCharArray()) {
            if (c != '.') {
                queueY.offer(c);
            }
        }
        boolean isBal = false;
        while (queueX.size() != 0 || queueY.size() != 0) {
            char charx = queueX.size() != 0 ? queueX.poll() : '0';
            char chary = queueY.size() != 0 ? queueY.poll() : '0';

            if (charx > chary) return false;
            if (charx == chary) isBal = true;
            if (charx < chary) return true;

        }
        return !isBal;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] a = new String[count];
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            a[i] = sc.nextLine();
        }

        for (int i = 0; i < a.length; i++) {
            String[] s = a[i].split(" ");
            System.out.println(f(s[0], s[1]));
        }


    }
}
