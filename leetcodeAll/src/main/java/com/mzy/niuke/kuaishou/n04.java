package com.mzy.niuke.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-01 16:06
 **/
public class n04 {

    public static int f(String s, int k) {
        //用list来存放下标
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '1') list.add(i);
        }
        int n = list.size();
        if (n < k) return 0;
        int res = 0;
        if (k == 0) {
            boolean proIsZero = false;
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    if (!proIsZero) {
                        count = 1;
                        proIsZero = true;
                    } else {
                        count++;
                    }
                } else {
                    if (proIsZero) {
                        res += ((1 + count) * count) / 2;
                        count = 0;
                        proIsZero = false;

                    }
                }
            }
            //加上尾部
            res += ((1 + count) * count) / 2;

        } else {
            for (int i = k - 1; i < n; i++) {
                int start = list.get(i - k + 1);
                int end = list.get(i);
                //求出start和end两边的0
                start--;
                end++;
                int leftZeroCount = 0;
                int rightZeroCount = 0;
                while (start >= 0) {
                    if (s.charAt(start) == '0') {
                        leftZeroCount++;
                        start--;
                    } else {
                        break;
                    }
                }
                while (end <= s.length() - 1) {
                    if (s.charAt(end) == '0') {
                        rightZeroCount++;
                        end++;
                    } else {
                        break;
                    }

                }
                leftZeroCount++;
                rightZeroCount++;
                res += leftZeroCount * rightZeroCount;


            }

        }
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        String s = sc.next();
        System.out.println(f(s, k));


    }
}
