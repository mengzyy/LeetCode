package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-21 11:19
 **/
/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
/*
使用动态规划

 */
public class jhtrt {
    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0) return null;

        int[] res = new int[A.length];

        //初始化
        res[0] = 1;
        //计算下三角
        for (int i = 1; i < A.length; i++) {
            res[i] = res[i - 1] * A[i-1];
        }

        int temp = 1;
        //计算上三角 从下忘上
        for (int j = A.length - 2; j >= 0; j--) {
            temp *= A[j+1];
            res[j] *= temp;


        }
        return res;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,4,5};
        multiply(a);


    }


}
