package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-09 11:26
 **/

/*

输入一个整数数组，
判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class uiyt {

    public static  boolean VerifySquenceOfBST(int[] sequence) {


        if(sequence.length == 0) return false;
        for(int i = 0; i < sequence.length; i++){
            boolean sign = false;
            for(int j = 0; j < i; j++){
                if(sequence[j] > sequence[i]){
                    sign = true;
                }
                else if(sign) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {


        int[] a ={4,9,3,2,5};
        boolean b = VerifySquenceOfBST(a);
        System.out.println(b);
    }


}
