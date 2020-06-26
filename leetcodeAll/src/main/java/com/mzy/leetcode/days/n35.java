package com.mzy.leetcode.days;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-29 10:12
 **/
interface MountainArray {
    public int get(int index);

    public int length();
}

public class n35 {
    public int findInMountainArray(int target, List<Integer> mountainArr) {

        int topIndex = findTopIndex(mountainArr);

        int leftIndex = findupMountainTarget(mountainArr, target, topIndex);
        int rightIndex = finddowmMountainTarget(mountainArr, target, topIndex + 1);

        if (leftIndex == -1 && rightIndex == -1) return -1;
        if (leftIndex == -1) return rightIndex;
        if (rightIndex == -1) return leftIndex;

        return leftIndex;


    }

    private int finddowmMountainTarget(List<Integer> mountainArr, int target, int topIndex) {
        //递减序列
        int left = topIndex;
        int right = mountainArr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) return mid;
            else if (midValue < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findupMountainTarget(List<Integer> mountainArr, int target, int topIndex) {
        //递增序列
        int left = 0;
        int right = topIndex;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) return mid;
            else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findTopIndex(List<Integer> mountainArr) {

        int left = 0;
        int right = mountainArr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            int leftValue = mountainArr.get(mid - 1);
            int rightValue = mountainArr.get(mid + 1);
            if (midValue > leftValue && midValue > rightValue) {
                return mid;
            } else if (midValue > leftValue && mid < rightValue) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> mountainArr = new ArrayList<>();
        mountainArr.add(1);
        mountainArr.add(5);
        mountainArr.add(2);


        new n35().findInMountainArray(0, mountainArr);
    }
}
