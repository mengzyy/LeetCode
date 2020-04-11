package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-06 14:02
 **/
public class lt1401 {
    public static boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {

        boolean isNineArea = false;
        double zfxx_center = ((double) (x1) + (double) (x2)) / 2;
        double zfxy_center = (((double) y1 + (double) y2)) / 2;
        if ((x_center >= x1 && x_center <= x2) || (y_center >= y1 && y_center <= y2)) {
            isNineArea = true;
        }
        boolean res = false;
        //区域内
        if (isNineArea) {
            if (x_center >= x1 && x_center <= x2) {
                res = (Math.abs(zfxy_center - y_center) <= (radius + Math.abs(zfxy_center - y1)));
            } else {
                res = (Math.abs(zfxx_center - x_center) <= (radius + Math.abs(zfxx_center - x1)));
            }
        } else {
            //区域外
            //左上
            if (x_center < x1 && y_center > y2) {
                res = ((x1 - x_center) * (x1 - x_center) + (y2 - y_center) * (y2 - y_center)) <= radius * radius;
            }
            //左下
            if (x_center < x1 && y_center < y1) {
                res = ((x1 - x_center) * (x1 - x_center) + (y1 - y_center) * (y1 - y_center)) <= radius * radius;
            }
            //右上
            if (x_center > x2 && y_center > y2) {
                res = ((x2 - x_center) * (x2 - x_center) + (y2 - y_center) * (y2 - y_center)) <= radius * radius;
            }
            //右下
            if (x_center > x2 && y_center < y1) {
                res = ((x2 - x_center) * (x2 - x_center) + (y1 - y_center) * (y1 - y_center)) <= radius * radius;
            }


        }
        return res;


    }

    public static void main(String[] args) {
        System.out.println(checkOverlap(2, 8, 6, 5, 1, 10, 4));

    }
}
