package com.mzy.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-18 13:05
 **/
/*

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ghgh {
    public String PrintMinNumber(int[] numbers) {
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int number : numbers) {
            list.add(number);
        }
        Collections.sort(list, new Comparator<Integer>() {

            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        for (int j : list) {
            s.append(j);
        }
        return s.toString();

    }
}
