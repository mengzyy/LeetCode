package com.mzy.huawei;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 21:17
 **/
public class n05 {

    public static void f(int[][] input) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = input.length;
        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(input[i][0])) {
                hashMap.put(input[i][0], input[i][1]);
            } else {
                int newValue = hashMap.get(input[i][0]) + input[i][1];
                hashMap.put(input[i][0], newValue);
            }
        }
        List<int[]> res = new ArrayList<>();
        for (Integer integer : hashMap.keySet()) {
            int[] temp = {integer, hashMap.get(integer)};
            res.add(temp);

        }
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[1]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);

        }


    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        f(a);
    }
}
