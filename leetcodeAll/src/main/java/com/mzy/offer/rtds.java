package com.mzy.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-23 13:45
 **/
public class rtds {

    static int res = Integer.MAX_VALUE;

    public static int f(int days, int[] arr1, int[] arr2) {

        if (!(days == 0 || arr1.length != arr2.length || arr1.length != days)) {

            int flag = -1;//-1代表休息 ，1代表前天工作，2代表锻炼

            dfs(days, arr1, arr2, -1, 0);


        }
        int r = res;
        //重置
        res = 0;
        return r;

    }

    static void dfs(int days, int[] arr1, int[] arr2, int state, int count) {
        if (days == 0) {
            res = count < res ? count : res;
        } else {
            int nowday = arr1.length - days;
            if (state == -1) {
                //第一天 可以休息，工作锻炼
                //休息
                if (res > count + 1) {
                    dfs(days - 1, arr1, arr2, -1, count + 1);
                }
                //s是否可以工作
                if (arr1[nowday] == 1) {
                    dfs(days - 1, arr1, arr2, 1, count);
                }
                //是否可以锻炼
                if (arr2[nowday] == 1) {
                    dfs(days - 1, arr1, arr2, 2, count);
                }

            } else if (state == 1) {
                //前天工作了
                //休息
                if (res > count + 1) {
                    dfs(days - 1, arr1, arr2, -1, count + 1);
                }
                //是否可以锻炼
                if (arr2[nowday] == 1) {
                    dfs(days - 1, arr1, arr2, 2, count);
                }

            } else {
                //前天锻炼了
                if (res > count + 1) {
                    dfs(days - 1, arr1, arr2, -1, count + 1);
                }
                //是否可以工作
                if (arr1[nowday] == 1) {
                    dfs(days - 1, arr1, arr2, 1, count);
                }

            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();
        int[] arr1 = new int[days];
        int[] arr2 = new int[days];
        for (int i = 0; i < days; i++) {
            arr1[i] = sc.nextInt();

        }
        for (int i = 0; i < days; i++) {
            arr2[i] = sc.nextInt();

        }

        int f = f(days, arr1, arr2);
        System.out.println(f);


    }
}
