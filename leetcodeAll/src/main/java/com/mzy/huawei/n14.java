package com.mzy.huawei;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-13 19:48
 **/
public class n14 {

    public static void f(String input) {
        HashMap<Character, Character> hashMap = new LinkedHashMap<>();
        hashMap.put('p', '7');
        hashMap.put('q', '7');
        hashMap.put('r', '7');
        hashMap.put('s', '7');
        hashMap.put('t', '8');
        hashMap.put('u', '8');
        hashMap.put('v', '8');
        hashMap.put('w', '9');
        hashMap.put('x', '9');
        hashMap.put('y', '9');
        hashMap.put('z', '9');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            int resTemp = Integer.MAX_VALUE;
            if (temp >= 'A' && temp <= 'Z') {
                resTemp = temp == 'Z' ? 'a' : temp + 33;
            } else if (temp >= 'a' && temp <= 'o') {
                resTemp = (((temp - 97) / 3) + 2) + 48;
            } else if (temp >= 'p' && temp <= 'z') {
                resTemp = hashMap.get(temp);
            } else {
                resTemp = temp;
            }
            sb.append((char) (resTemp));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            f(sc.next());
        }

    }
}
