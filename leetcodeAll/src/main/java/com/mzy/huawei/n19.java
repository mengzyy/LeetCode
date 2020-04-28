package com.mzy.huawei;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-14 10:35
 **/
public class n19 {

    public static void f(String[] input, String targetStr, int num) {

        //先排序为字典序
        Arrays.sort(input);
        int count = 0;
        String res = "";
        for (String s : input) {
            char[] chars = s.toCharArray();
            char[] target = targetStr.toCharArray();
            if (!s.equals(targetStr)&&isBrother(chars, target)) count++;
            if (count == num&&res.equals("")) {
                res = s;
            }
        }
        System.out.println(count);
        if(!res.equals("")) System.out.println(res);
    }

    private static boolean isBrother(char[] chars, char[] target) {
        if (chars.length == target.length) {
            Arrays.sort(chars);
            Arrays.sort(target);
            if (Arrays.equals(chars, target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.next();
            }
            String target = sc.next();
            int k = sc.nextInt();
            f(input, target, k);


        }


    }
}
