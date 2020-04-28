package com.mzy2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-15 19:20
 **/
public class Main2 {
    public static void f(String input) {
        String[] s = input.split(" ");
        String target = s[0];
        String info = s[1];
        //以],分割
        String[] split = info.split("],");
        split[split.length - 1] = split[split.length - 1].substring(0, split[split.length - 1].length() - 1);
        //如果符合则book为1
        int[] book = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            String ainfo = split[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < ainfo.length(); j++) {
                if (ainfo.charAt(j) != '[') {
                    sb.append(ainfo.charAt(j));
                } else {
                    break;
                }

            }
            if (sb.toString().equals(target)) {
                book[i] = 1;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < book.length; i++) {
            if (book[i] == 1) {
                String temp = split[i].substring(target.length() + 1);
                //分割
                String[] split1 = temp.split(",");
                StringBuilder resTemp = new StringBuilder();
                for (String s1 : split1) {
                    String[] split2 = s1.split("=");
                    String info16 = split2[1];
                    boolean isValid = check(info16);
                    if (isValid) {
                        resTemp.append(info16 + " ");
                    } else {
                        break;
                    }

                }
                if (resTemp.length() > 0) {
                    res.add(resTemp.toString().substring(0, resTemp.length() - 1));


                }
            }


        }
        if (res.size() == 0) {
            System.out.println("FAIL");
        } else {
            //输出
            for (String re : res) {
                System.out.println(re);

            }
        }

    }

    private static boolean check(String info16) {
        if (info16.length() <= 2) {
            return false;
        }
        String check1 = info16.substring(0, 2);
        if (!(check1.equals("0x")) && !check1.equals("0X")) {
            return false;
        }
        String num = info16.substring(2);
        for (int i = 0; i < num.length(); i++) {
            char a = num.charAt(i);
            if (!(a >= '0' && a <= '9' || a >= 'a' && a <= 'f' || a >= 'A' && a <= 'F')) {
                return false;
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
