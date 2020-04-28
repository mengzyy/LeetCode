package com.mzy.huawei;

import com.mzy.offer.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-14 15:21
 **/
public class n20 {

    public static void f(int[] input) {
        //将输入分为两组
        int res = 0;
        List<Integer> oddG = new ArrayList<>();
        List<Integer> evenG = new ArrayList<>();
        for (int i : input) {
            if (i %2 != 0) oddG.add(i);
            else evenG.add(i);
        }
        int[] eventMatch = new int[evenG.size()];
        for (int i = 0; i < evenG.size(); i++) {
            eventMatch[i] = -1;
        }
        for (int i = 0; i < oddG.size(); i++) {
            int[] used = new int[evenG.size()];
            if (find(i, oddG, evenG, eventMatch, used)) {
                res++;
            }
        }
        System.out.println(res);


    }

    private static boolean find(int i, List<Integer> oddG, List<Integer> evenG, int[] eventMatch, int[] used) {

        for (int j = 0; j < evenG.size(); j++) {
            if (isCp(oddG.get(i) + evenG.get(j)) && used[j] == 0) {
                used[j] = 1;
                if (eventMatch[j] == -1 || find(eventMatch[j], oddG, evenG, eventMatch, used)) {
                    eventMatch[j] = i;
                    return true;
                }

            }
        }
        return false;

    }


    private static boolean isCp(int i) {
        if (i == 1) return false;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < input.length; i++) {
                input[i] = sc.nextInt();
            }
            f(input);

        }
        sc.close();
    }
}
