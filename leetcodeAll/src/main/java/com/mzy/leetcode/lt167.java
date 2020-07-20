package com.mzy.leetcode;

public class lt167 {


    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;

        int sum =0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left, right};
            if(sum<target){
                left++;
            }else{
                right--;
            }
        }

        return new int[]{0,0};

    }
}
