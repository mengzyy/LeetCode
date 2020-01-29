package com.mzy.leetcode;

public class lt28 {


    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;

        int pro = needle.length();


        for (int i = 0; i <= haystack.length() - needle.length(); i++) {


            if (haystack.substring(i, i+pro).equals(needle))

                return i;

        }


        return -1;


    }

    public static void main(String[] args) {


        System.out.println(strStr("hello","ll"));


    }
}
