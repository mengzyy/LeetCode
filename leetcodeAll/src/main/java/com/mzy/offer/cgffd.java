package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-21 10:03
 **/
public class cgffd {

    public static int StrToInt(String str) {
        if (str.length() == 0) return 0;
        if (str.substring(0, 1).equals("+") || str.substring(0, 1).equals("-")) {
            if (str.length() == 1) return 0;
        }
        //符号位
        boolean flag = true;
        if (str.substring(0, 1).equals("-")) flag = false;

        //变成工作字符串
        if (str.substring(0, 1).equals("-") || str.substring(0, 1).equals("+")) str = str.substring(1, str.length());

        int res = 0;
        for (int i =0; i<str.length(); i++) {
            if (!(str.toCharArray()[i] < '9' && str.toCharArray()[i] > '0')) return 0;
            int temp = str.toCharArray()[i] & 0xf;
            res = (res << 3) + (res << 1) + temp;
        }

        if(res<0&&flag)return 0;
        return flag ? res : -1 * res;


    }

    public static void main(String[] args) {

        System.out.println(StrToInt("123"));
//        System.out.println('9' & 0xf);

    }
}
