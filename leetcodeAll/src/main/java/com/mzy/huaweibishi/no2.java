package com.mzy.huaweibishi;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-26 16:41
 **/
public class no2 {

    public static int f(String input, char a) {

        if (input == null || input.length() <= 0) return 0;
        int count = 0;


        for (int i = 0; i < input.toCharArray().length; i++) {

            if (input.charAt(i) > 'a' || input.charAt(i) < 'z' || input.charAt(i) > 'A' || input.charAt(i) < 'Z') {
                if (a==input.charAt(i)||Math.abs(a - input.charAt(i)) == 32) {
                    count++;
                }
            } else {
                if (a == input.charAt(i)) {
                    count++;
                }
            }


        }

        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String a = sc.next();
        char character = a.toCharArray()[0];
        int f = f(input, character);
        System.out.println(f);


    }
}
