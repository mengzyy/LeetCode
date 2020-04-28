package com.mzy.leetcode.compest184;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 13:13
 **/
public class n033 {
    public String entityParser(String text) {
        text=text.replaceAll("&quot;", "\"");
        text=text.replace("&apos;", "\'");
        text=text.replace("&amp;", "&");
        text=text.replace("&gt;", ">");
        text=text.replace("&lt;", "<");

        return text.replace("&frasl;", "/");

    }

    public static void main(String[] args) {
        new n033().entityParser("sd");
    }
}
