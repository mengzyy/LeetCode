package com.mzy.huawei;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-15 16:43
 **/
public class n26 {

    public static void f(String input) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        System.out.println(sb.toString());

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            f(sc.nextLine());
        }


    }
}
