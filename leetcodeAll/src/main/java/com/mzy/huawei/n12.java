package com.mzy.huawei;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-13 14:24
 **/
public class n12 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();

        while (sc.hasNext()) {
            String path = sc.next();
            int line = sc.nextInt();
            //分割
            String[] split = path.split("\\\\");
            String fileName = split[split.length - 1];
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16, fileName.length());
            }
            String key = fileName + " " + line;
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, 1);
            } else {
                hashMap.put(key, hashMap.get(key) + 1);
            }
        }
        int count = 0;
        for (String string : hashMap.keySet()) {
            count++;
            if (count > (hashMap.keySet().size() - 8)) //输出最后八个记录
                System.out.println(string + " " + hashMap.get(string));
        }

    }
}
