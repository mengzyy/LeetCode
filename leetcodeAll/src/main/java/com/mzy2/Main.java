package com.mzy2;

import java.util.*;

public class Main {
    public static void f(String input) {
        boolean isVaild = check(input);
        if (!isVaild) {
            System.out.println("error.0001");
            return;
        }

        //分割
        String[] split = input.split(",");
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();
        //存储最大值
        int maxLen = Integer.MIN_VALUE;
        for (String s : split) {
            if (!hashMap.containsKey(s)) {
                hashMap.put(s, 1);
            } else {
                hashMap.put(s, hashMap.get(s) + 1);
            }
            maxLen = maxLen < hashMap.get(s) ? hashMap.get(s) : maxLen;

        }
        List<String> list = new ArrayList<>();
        for (String s : hashMap.keySet()) {
            if (hashMap.get(s) == maxLen) {
                list.add(s);
            }

        }
        //list排序
        Collections.sort(list);
        System.out.println(list.get(0));


    }

    private static boolean check(String input) {

        for (int i = 0; i < input.length(); i++) {

            if (!(input.charAt(i) >= 'a' && input.charAt(i) <= 'z' || input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' || input.charAt(i) == ',')) {
                return false;
            }

        }

        String[] split = input.split(",");
        for (String s : split) {
            if (!(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
                return false;
            }
            if (s.length() > 1) {
                String sub = s.substring(1);
                for (int i = 0; i < sub.length(); i++) {
                    if (!(sub.charAt(i) >= 'a' && sub.charAt(i) <= 'z')) {
                        return false;
                    }

                }
            }
        }


        return true;


    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            f(scanner.nextLine());


        }


    }
}
