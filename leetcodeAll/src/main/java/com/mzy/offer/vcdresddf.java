package com.mzy.offer;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 17:01
 **/
public class vcdresddf {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 1) return false;

        //排序
        Arrays.sort(numbers);
        int zeroscount = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                zeroscount++;
            } else {
                int del = numbers[i + 1] - numbers[i];
                if (del < 1) {
                    return false;
                } else if (del > 1) {
                    if (zeroscount >= del - 1) {
                        zeroscount -= del - 1;
                    } else {
                        return false;
                    }
                }


            }


        }
        return true;

    }

    //第二种
    public boolean isContinuous2(int[] numbers) {
        if (numbers.length <= 4) return false;
        int max = -1;
        int min = 14;
        int[] book = new int[14];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 13 || numbers[i] < 0) return false;


            //对应的桶加一
            book[numbers[i]]++;
            if (numbers[i] != 0) {
                if (book[numbers[i]] > 1) return false;
                if (max < numbers[i]) max = numbers[i];
                if (min > numbers[i]) min = numbers[i];

            }
        }
        return max - min < 5;


    }

    public static void main(String[] args) {

//        int[] a = {0, 3, 2, 6, 4};
//
//        boolean continuous2 = isContinuous2(a);
//        System.out.println(continuous2);

    }
}
