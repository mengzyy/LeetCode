package com.mzy2;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-15 19:58
 **/
class zdetailInfo {
    int len;
    List<Integer> list;

    public zdetailInfo(int len, List<Integer> list) {
        this.len = len;
        this.list = list;

    }
}

public class Main3 {

    static int max;
    static int[] book;
    static boolean isR;

    //多源dfs应该可以解决
    public static void f(String info, String[] zhanInfo) {

        boolean isVaild = check(info,zhanInfo);
        if (!isVaild) {
            System.out.println("NA");
            return;
        }
        max = Integer.MIN_VALUE;
        //spilt
        int zhanLen = -1;
        if (!info.contains(" ")) {
            zhanLen = Integer.parseInt(info);
        } else {
            String[] s = info.split(" ");
            zhanLen = Integer.parseInt(s[0]);
        }
        //book数组在调用中判断是否已经调用过
        book = new int[zhanLen + 1];
        HashMap<Integer, zdetailInfo> hashMap = new LinkedHashMap<>();
        //初始化栈信息
        for (String s1 : zhanInfo) {
            String[] s2 = s1.split(" ");
            int zhanname = Integer.parseInt(s2[0]);
            int zhanlen = Integer.parseInt(s2[1]);
            List<Integer> list = new ArrayList<>();
            for (int i = 2; i < s2.length; i++) {
                list.add(Integer.parseInt(s2[i]));
            }
            zdetailInfo zdetailInfo = new zdetailInfo(zhanlen, list);
            hashMap.put(zhanname, zdetailInfo);
        }
        isR = false;
        for (int i = 1; i <= zhanLen; i++) {
            book[i] = 1;
            dfs(i, hashMap, 0);
            book[i] = 0;

        }
        if (!isR) {
            System.out.println(max);
        } else {
            System.out.println("NA");
        }


    }

    private static boolean check(String info,String[] zhanInfo) {
        for (String s : zhanInfo) {
            if (s.length() <= 2) {
                return false;
            }
            if (!s.contains(" ")) {
                return false;
            }
            String[] s1 = s.split(" ");
            if (s1.length == 1) {
                return false;
            }
        }





        return true;


    }

    private static void dfs(int i, HashMap<Integer, zdetailInfo> hashMap, int i1) {
        //加入当前的栈深度
        i1 += hashMap.get(i).len;
        if (hashMap.get(i).list.size() == 0) {
            max = max < i1 ? i1 : max;
        } else {
            List<Integer> list = hashMap.get(i).list;
            if (list.size() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (book[list.get(i2)] == 0) {
                        book[list.get(i2)] = 1;
                        dfs(list.get(i2), hashMap, i1);
                        book[list.get(i2)] = 0;
                    } else {
                        isR = true;
                        return;
                    }

                }
            }

        }


    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String info = scanner.nextLine();
            int n = -1;
            if (!info.contains(" ")) {
                n = Integer.parseInt(info);
            } else {
                n = Integer.parseInt(info.split(" ")[0]);
            }
            String[] zhanInfo = new String[n];
            for (int i = 0; i < n; i++) {
                zhanInfo[i] = scanner.nextLine();

            }
            f(info, zhanInfo);

        }


    }
}
