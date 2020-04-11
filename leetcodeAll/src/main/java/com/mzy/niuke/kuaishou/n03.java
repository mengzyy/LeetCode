package com.mzy.niuke.kuaishou;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-31 15:22
 **/
public class n03 {

    public static String f(char[] a, char[] b) {

        int count = 0;
        int bindex = 0;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            res.append(a[i]);
            count++;
            if (count == 4) {
                if (bindex <= b.length - 1) {
                    res.append(b[bindex]);
                    bindex++;
                }
                count = 0;
            }
        }

        if (bindex <= b.length - 1) {
            //将b的尾部加入
            for (int i = bindex; i < b.length; i++) {
                res.append(b[i]);

            }
        }

        return res.toString();


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(" ");
        String[] b = sc.nextLine().split(" ");
        char[] chara = new char[a.length];
        char[] charb = new char[b.length];
        for (int i = 0; i < a.length; i++) {
            chara[i] = a[i].charAt(0);
        }
        for (int i = 0; i < b.length; i++) {
            charb[i] = b[i].charAt(0);
        }

        String f = f(chara, charb);
        for (int i = 0; i < f.toCharArray().length - 1; i++) {
            System.out.print(f.charAt(i) + " ");
        }
        System.out.print(f.charAt(f.length() - 1));


    }
}
