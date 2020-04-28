package com.mzy3;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-26 20:57
 **/
public class Main2 {
    public static void findMin(int[][] nums1, int[][] nums2) {
        int[] a = nums1[1];
        int[] bMin = nums2[1];
        for (int[] ints : nums2) {
            if (Math.pow(Math.abs(ints[0] - a[0]) + Math.abs(ints[1] - a[1]), 2) < Math.pow(Math.abs(bMin[0] - a[0]) + Math.abs(bMin[1] - a[1]), 2)) {
                bMin = ints;
            }
        }
        int[] b = bMin;
        int[] aMin = nums1[1];
        for (int[] ints : nums1) {
            if (Math.pow(Math.abs(ints[0] - b[0]) + Math.abs(ints[1] - b[1]), 2) < Math.pow(Math.abs(aMin[0] - b[0]) + Math.abs(aMin[1] - b[1]), 2)) {
                aMin = ints;
            }
        }
        double res = Math.sqrt(Math.pow(Math.abs(aMin[0] - bMin[0]) + Math.abs(aMin[1] - bMin[1]), 2));
        DecimalFormat df = new DecimalFormat(".###");
        System.out.println(df.format(res));


    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int groupnums = scanner.nextInt();
            for (int i = 0; i < groupnums; i++) {
                int count = scanner.nextInt();
                int[][] nums1 = new int[count][2];
                int[][] nums2 = new int[count][2];
                for (int j = 0; j < count; j++) {
                    nums1[j][0] = scanner.nextInt();
                    nums1[j][1] = scanner.nextInt();
                }
                for (int j = 0; j < count; j++) {
                    nums2[j][0] = scanner.nextInt();
                    nums2[j][1] = scanner.nextInt();
                }
                findMin(nums1, nums2);
            }


        }


    }
}
