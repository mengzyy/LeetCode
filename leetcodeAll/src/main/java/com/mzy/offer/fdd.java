package com.mzy.offer;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-23 14:19
 **/
public class fdd {


    public static int f(int n, int len, List<int[]> list) {
        int res = 0;

        //将list根据第一个坐标排序
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0]) {
                    return 0;
                }
                return -1;
            }
        });


        int arrindex = 0;
        for (int i = 0; i < list.size(); i++) {

            if (i == 0) {
                //如果第一个不是0直接error
                if (list.get(0)[0] != 0) return -1;
                //寻找最远的
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j)[0] != 0) {
                        break;
                    } else {
                        arrindex = list.get(j)[1] > arrindex ? list.get(j)[1] : arrindex;
                    }

                }
                res++;
            } else if (arrindex >= len) {
                return res;
            } else {
                //其他情况
                if (list.get(i)[0] <= arrindex) {
                    //寻找最远的
                    int max = arrindex;
                    //下次要跳的地方
                    int nextidnex = -1;
                    for (int k = i; k < list.size(); k++) {
                        if (list.get(k)[0] <= arrindex) {
                            if (list.get(k)[1] > max) {
                                max = list.get(k)[1];
                                nextidnex = k;
                                //下次要跳的地方
                                i = nextidnex;
                            }
                        } else {
                            break;
                        }


                    }
                    arrindex = max;
                    res++;

                }

            }

        }
        if (arrindex < len) return -1;
        return res;


    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int len = sc.nextInt();
//        List<int[]> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            int[] temp = new int[2];
//            temp[0] = sc.nextInt();
//            temp[1] = sc.nextInt();
//            list.add(temp);
//        }
//
//        int f = f(n, len, list);
//        System.out.println(f);
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(sc.next());

        }
        System.out.println(list.size());


    }

}