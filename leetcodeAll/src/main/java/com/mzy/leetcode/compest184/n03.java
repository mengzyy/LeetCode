package com.mzy.leetcode.compest184;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 11:19
 **/
public class n03 {
    public String entityParser(String text) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("&quot;", "\"");
        hashMap.put("&apos;", "\'");
        hashMap.put("&amp;", "&");
        hashMap.put("&gt;", ">");
        hashMap.put("&lt;", "<");
        hashMap.put("&frasl;", "\\/");
        StringBuilder sb = new StringBuilder();
        boolean isStart = false;
        String temp = "";
        for (char c : text.toCharArray()) {
            if (!isStart && c != '&') {
                sb.append(c);
            } else if (c == '&') {
                isStart = true;
                temp = temp + c;
            } else if (c == ';') {
                isStart = false;
                temp = temp + c;
                String s = hashMap.get(temp);
                if (s == null) {
                    sb.append(temp);
                } else {
                    sb.append(s);
                }
                temp = "";

            } else if (isStart) {
                temp = temp + c;

            }

        }
        String[] split = sb.toString().split("\\s+");
        StringBuilder res2 = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            res2.append(split[i] + " ");

        }
        res2.append(split[split.length - 1]);

        return res2.toString().trim();


    }

    public static void main(String[] args) {
        String s = new n03().entityParser("&amp; is an HTML entity but &ambassador; is not.");
        System.out.println(s);


    }
}