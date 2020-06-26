package com.mzy.leetcode.days;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-20 13:50
 **/
public class n0555 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put(0, 1);
        int ans=0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                dp[i] = (i - 1 >= 0 ? dp[i - 1] : 0) + 1;
            } else {
                dp[i] = i - 1 >= 0 ? dp[i - 1] : 0;
            }
            if (!hashMap.containsKey(dp[i])) {
                hashMap.put(dp[i], 1);
            } else {
                hashMap.put(dp[i], hashMap.get(dp[i]) + 1);
            }
            if (hashMap.containsKey(dp[i] - k)) {
                ans += hashMap.get(dp[i] - k);
                ;
            }
        }
        return ans;
    }

    public static void main(String[] args) {


        int i = new n0555().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
    }
}
