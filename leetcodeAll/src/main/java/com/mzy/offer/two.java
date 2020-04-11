package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-02-29 22:06
 **/


/*

题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class two {

    public static String replaceSpace(StringBuffer str) {
        int oldlen = str.length();
        if (oldlen == 0) return str.toString();

        int count = 0;
        char[] chars = str.toString().toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                count++;
            }

        }
        if (count == 0) return str.toString();

        //扩展
        for (int i = 0; i < count * 2; i++) {
            str.append(' ');
        }

        //移动并插入
        char[] newchars = str.toString().toCharArray();
        for (int i = oldlen-1; i >= 0 && count != 0; i--) {

            if (newchars[i] != ' ') {
                newchars[i + count * 2] = newchars[i];
            } else {
                newchars[i + count * 2] = '0';
                newchars[i + count * 2 - 1] = '2';
                newchars[i + count * 2 - 2] = '%';
                count--;

            }


        }


        return String.valueOf(newchars);

    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("hello world");
        System.out.println(replaceSpace(str));


    }


}
