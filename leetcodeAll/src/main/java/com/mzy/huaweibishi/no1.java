package com.mzy.huaweibishi;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-26 16:30
 **/
public class no1 {

    public static int f(String input) {
        if(input==null ||input.length()<=0)return 0;

        String[] s = input.split(" ");


        for (int i = s.length-1; i >=0; i--) {
            if(!s[i].equals(" ")){
                return s[i].length();
            }

        }

        return 0;




    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int f = f(input);
        System.out.println(f);

    }
}
