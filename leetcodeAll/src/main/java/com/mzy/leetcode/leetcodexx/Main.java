package com.mzy.leetcode.leetcodexx;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-17 11:56
 **/
public class Main {
    public int[] createTargetArray(int[] nums, int[] index) {

        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] res = new int[n];
        //初始化
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int ind = index[i];
            insert(res, ind, num);

        }
        return res;


    }

    private void insert(int[] res, int ind, int num) {

        if (res[ind] == -1) {
            res[ind] = num;
        } else {
            //寻找插入位置
            int count = 0;
            for (int i = ind; i < res.length; i++) {
                if (res[i] != -1) {
                    count++;
                } else {
                    break;
                }
            }

            for (int i = ind + count; i >= ind + 1; i--) {
                res[i] = res[i - 1];
            }
            res[ind] = num;

        }


    }

    public static void main(String[] args) {

        new Main().createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
    }
}
