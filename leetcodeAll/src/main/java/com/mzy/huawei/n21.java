package com.mzy.huawei;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-14 16:30
 **/
public class n21 {
    public static void Encrypt1(String auc) {
        char[] aucPassword = auc.toCharArray();
        char[] aucResult = new char[aucPassword.length];
        for (int i = 0; i < aucPassword.length; i++) {
            char temp = aucPassword[i];
            if (temp >= 'a' && temp <= 'z') {
                temp = Character.toUpperCase(temp);
                if (temp == 'Z') temp = 'A';
                else {
                    temp += 1;
                }
            } else if (temp >= 'A' && temp <= 'Z') {
                temp = Character.toLowerCase(temp);
                if (temp == 'z') temp = 'a';
                else {
                    temp += 1;
                }

            } else if (temp >= '0' && temp <= '9') {
                if (temp == '9') temp = '0';
                else {
                    temp += 1;
                }

            }
            aucResult[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aucResult);
        System.out.println(sb.toString());


    }


    public static void unEncrypt1(String pass) {
        char[] chars = pass.toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (temp >= 'a' && temp <= 'z') {
                temp = Character.toUpperCase(temp);
                if (temp == 'A') temp = 'Z';
                else {
                    temp -= 1;
                }

            } else if (temp >= 'A' && temp <= 'Z') {
                temp = Character.toLowerCase(temp);
                if (temp == 'a') temp = 'z';
                else {
                    temp -= 1;
                }

            } else if (temp >= '0' && temp <= '9') {
                if (temp == '0') temp = '9';
                else {
                    temp -= 1;
                }

            }
            result[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        System.out.println(sb.toString());


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            Encrypt1(a);
            unEncrypt1(b);

        }
        sc.close();


    }
}
