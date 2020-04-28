package com.mzy.huawei;

import sun.awt.datatransfer.DataTransferer;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-14 10:01
 **/
public class n18 {


    public static void f(String input) {
        List<Character> list = new ArrayList<>();
        //如果对应的input为非字母，则设为1
        int[] book = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                list.add(input.charAt(i));
            } else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                list.add(input.charAt(i));
            } else {
                book[i] = 1;
            }

        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        int j = 0;
        //add
        for (int i = 0; i < input.length(); i++) {
            if (book[i] == 1) {
                sb.append(input.charAt(i));
            } else {
                sb.append(list.get(j));
                j++;
            }

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
