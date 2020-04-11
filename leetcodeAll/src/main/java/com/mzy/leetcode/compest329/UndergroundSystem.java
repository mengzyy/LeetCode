package com.mzy.leetcode.compest329;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-29 11:09
 **/

class underinfo {
    public underinfo(int count, double pjun) {
        this.count = count;
        this.pjun = pjun;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPjun() {
        return pjun;
    }

    public void setPjun(double pjun) {
        this.pjun = pjun;
    }

    private int count;
    private double pjun;

}

class userInfo {
    public String getUndername() {
        return undername;
    }

    public void setUndername(String undername) {
        this.undername = undername;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    private String undername;
    private double t;

    public userInfo(String undername, double t) {
        this.undername = undername;
        this.t = t;
    }
}


public class UndergroundSystem {
    //用户信息
    private HashMap<Integer, userInfo> userInfoMap;
    //地铁信息
    private HashMap<String, underinfo> underwayInfo;


    public UndergroundSystem() {
        this.userInfoMap = new HashMap<>();
        this.underwayInfo = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        //无需检查
        userInfo userInfo = new userInfo(stationName, t);
        userInfoMap.put(id, userInfo);
    }

    public void checkOut(int id, String stationName, int t) {
        //更新地铁信息,然后将之删除
        userInfo userInfo = userInfoMap.get(id);
        double delt = t - userInfo.getT();
        if (underwayInfo.containsKey(userInfo.getUndername() + stationName)) {
            underinfo underinfo = underwayInfo.get(userInfo.getUndername() + stationName);
            //更新t
            double newt = (underinfo.getCount() * underinfo.getPjun() + delt) / (underinfo.getCount() + 1);
            underwayInfo.put(userInfo.getUndername() + stationName, new underinfo(underinfo.getCount() + 1, newt));
        } else {
            underwayInfo.put(userInfo.getUndername() + stationName, new underinfo(1, delt));
        }

        //删除用户进站信息
        userInfoMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String str = startStation + endStation;
        if (underwayInfo.containsKey(str)) {
            underwayInfo.get(str);
            return underwayInfo.get(str).getPjun();
        } else {
            return -1;
        }

    }
}
