package com.mzy.huawei;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-15 15:59
 **/
public class n25 {

    public static void f(String ip, String numsStr) {

        String[] split = ip.split("\\.");
        StringBuilder res1 = new StringBuilder();
        for (String s : split) {
            long temp = Long.parseLong(s);
            int len = 8;
            StringBuilder sbTemp = new StringBuilder();
            while (len != 0) {
                long i = temp & 1;
                temp = temp >> 1;
                sbTemp.append(i);
                len--;
            }
            res1.append(sbTemp.reverse().toString());
        }
        System.out.println(twoToten(res1.toString()));


        //numstr
        long temp2 = Long.parseLong(numsStr);
        int len2 = 32;
        StringBuilder res2 = new StringBuilder();
        while (len2 != 0) {
            long i = temp2 & 1;
            res2.append(i);
            temp2 = temp2 >> 1;
            len2--;

        }
        String res = twoToten2(res2.reverse().toString());
        System.out.println(res.toString());


    }

    private static String twoToten2(String toString) {
        StringBuilder res = new StringBuilder();
        long numres = 0;
        for (int i = 0; i < toString.length(); i++) {
            numres = numres * 2 + Long.parseLong(String.valueOf(toString.charAt(i)));
            if ((i + 1) % 8 == 0) {
                res.append(numres + ".");
                numres = 0;
            }

        }
        return res.substring(0, res.length() - 1);


    }

    private static long twoToten(String toString) {
        long res = 0;
        for (int i = 0; i < toString.length(); i++) {
            res = res * 2 + Long.parseLong(String.valueOf(toString.charAt(i)));
        }
        return res;


    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a= sc.nextLine();
            String b = sc.nextLine();
            f(a,b);
        }
    }


}
