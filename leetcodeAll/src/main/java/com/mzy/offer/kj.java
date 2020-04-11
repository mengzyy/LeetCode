package com.mzy.offer;

import java.util.ArrayList;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-04 10:45
 **/

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵：
 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */


/*
思路：x，y为当前坐标，xbrand，ybrand为边界
 */
public class kj {


    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0) return null;

        ArrayList<Integer> arrayList = new ArrayList<>();
        //无法适应为一行的情况，所以该特殊情况特殊处理
        if (matrix.length == 1 || matrix[0].length == 1) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    arrayList.add(anInt);
                }
            }
        } else {


            int x = 0;
            int y = 0;


            int xBrandMin = 0;
            int xBrandMax = matrix.length - 1;

            int yBrandMin = 0;
            int yBrandMax = matrix[0].length - 1;

            //初始化
            arrayList.add(matrix[0][0]);

            while (true) {

                //向右
                y++;
                if (y > yBrandMax) break;
                while (y <= yBrandMax) {
                    arrayList.add(matrix[x][y]);
                    y++;
                }
                //因为多加了一次
                y--;


                //向下
                x++;
                if (x > xBrandMax) break;
                while (x <= xBrandMax) {
                    arrayList.add(matrix[x][y]);
                    x++;
                }
                x--;

                //向左
                y--;
                if (y < yBrandMin) break;
                while (y >= yBrandMin) {
                    arrayList.add(matrix[x][y]);
                    y--;
                }
                y++;

                //向上
                x--;
                //更新边界
                xBrandMin++;
                xBrandMax--;
                yBrandMin++;
                yBrandMax--;

                if (x < xBrandMin) break;
                while (x >= xBrandMin) {
                    arrayList.add(matrix[x][y]);
                    x--;
                }
                x++;


            }
        }


        return arrayList;


    }


    public static void main(String[] args) {

        int[][] ma = {{1, 2, 3,4,5,6}};
        printMatrix(ma);


    }
}
