package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-13 18:05
 **/
public class n13 {


    public static String f(String input) {
        int hasNum = 0;
        int hasUpCase = 0;
        int hasLowCase = 0;
        int hasOther = 0;
        boolean hasNoRepeat = false;
        if (input.length() > 8) {
            if (!input.matches("(.{3,}).*\1")) hasNoRepeat = true;
            if (input.matches(".*[0-9].*")) hasNum = 1;
            if (input.matches(".*[A-Z].*")) hasUpCase = 1;
            if (input.matches(".*[a-z].*")) hasLowCase = 1;
            if (input.matches(".*[^0-9A-Za-z].*")) hasOther = 1;
            int count = hasNum + hasLowCase + hasUpCase + hasOther;
            if (count >= 3 && hasNoRepeat) return "OK";
            return "NG";

        } else {
            return "NG";
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(f(sc.next()));
        }


    }
}
