package com.mzy.alibaba;

import java.util.Map;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-23 18:27
 **/
public class Main {
    public static int f(int n) {
        if(n==0)return 0;
        if(n==1)return 1;

        int res = 0;
        //先算一个n
        int allsum = 1;
        for (int i = 1; i <=n; i++) {
            allsum*=i;

        }
        for (int i = 1; i <= n; i++) {

            //挑选出一个
            int k = n - i;
            int sum1 = 1;
            int sum2 = 1;
            for (int j = 1; j <=i; j++) {
                sum1 *= j;

            }
            for (int m = 1; m <=k; m++) {
                sum2 *= m;

            }
            res+= (allsum/(sum1*sum2))*i;

        }
        return res%(int)(Math.pow(10,9)+7);


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = f(n);
        System.out.println(f);

    }


}
