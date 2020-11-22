package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-23 15:50
 **/
public class lt870 {
    public int[] advantageCount(int[] A, int[] B) {

        /*sort*/
        Arrays.sort(A);
        List<Integer> temp = new ArrayList<>();
        for (int i : A) {
            temp.add(i);
        }
        for (int i = 0; i < B.length; i++) {
            A[i] = findMin(temp, B[i]);
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == -1) A[i] = temp.get(count++);
            count++;

        }
        return A;

    }

    private int findMin(List<Integer> temp, int target) {
        int left = 0;
        int right = temp.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (temp.get(mid)>target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        /*判断*/
        int ans = -1;
        if (temp.get(left) > target) {
            ans = temp.get(left);
            temp.remove(left);
        }
        return ans;
    }
}
