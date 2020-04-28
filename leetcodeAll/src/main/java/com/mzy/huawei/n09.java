package com.mzy.huawei;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 21:59
 **/
public class n09 {
    public static void f(String[] input) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            list.add(input[i]);

        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.compareTo(o2) > 0) {
                    return 1;
                } else if (o1.compareTo(o2) == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for (String s : list) {
            System.out.println(s);

        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.next();
        }
        f(input);

    }
}
