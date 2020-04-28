package com.mzy.meituan;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-19 14:07
 **/
public class Main {
    public static void f(String a, String b) {
        a = a.substring(1, a.length() - 1);
        b = b.substring(1, b.length() - 1);
        BigInteger biga = new BigInteger(a);
        BigInteger bigb = new BigInteger(b);
        BigInteger add = biga.add(bigb);
        System.out.println("\"" + add.toString() + "\"");

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            f(a, b);
        }


    }
}
