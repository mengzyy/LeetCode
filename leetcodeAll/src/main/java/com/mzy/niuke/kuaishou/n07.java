package com.mzy.niuke.kuaishou;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-02 14:29
 **/
class nodeInfo {
    //节点值
    private int val;


    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }

    //该节点是否有水
    private boolean isWater;
    //父亲节点
    private List<Integer> parents;
    //孩子节点
    private List<Integer> childrens;

    public nodeInfo(int val) {
        this.val = val;
        //初始化
        this.isWater = false;
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    public int getVal() {
        return val;
    }


    public void setVal(int val) {
        this.val = val;
    }

    public List<Integer> getParents() {
        return parents;
    }

    public void setParents(List<Integer> parents) {
        this.parents = parents;
    }

    public List<Integer> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Integer> childrens) {
        this.childrens = childrens;
    }
}

public class n07 {

    public static HashMap<Integer, nodeInfo> hashMap;

    //加水操作
    public static void addWater(int node) {

        //自己设置有水
        nodeInfo curnode = hashMap.get(node);
        curnode.setWater(true);
        //孩子设置有水
        List<Integer> childrens = curnode.getChildrens();
        for (Integer children : childrens) {
            nodeInfo chilnode = hashMap.get(children);
            chilnode.setWater(true);
        }

    }

    //放水操作
    public static void relaxWater(int node) {
        //自己设置没水
        nodeInfo curnode = hashMap.get(node);
        curnode.setWater(false);
        //父亲设置没水
        List<Integer> parents = curnode.getParents();
        for (Integer parent : parents) {
            nodeInfo parentnode = hashMap.get(parent);
            parentnode.setWater(false);
        }


    }

    //询问操作
    public static void hasWater(int node) {
        System.out.println(hashMap.get(node).isWater() ? 1 : 0);

    }

    public static void main(String[] args) {

        hashMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        int nodeCount = scanner.nextInt();
        for (int i = 0; i < nodeCount - 1; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            if (!hashMap.containsKey(parent)) {
                nodeInfo nodeParentInfo = new nodeInfo(parent);
                nodeParentInfo.getChildrens().add(child);
                hashMap.put(parent, nodeParentInfo);
            } else {
                nodeInfo nodeParentInfo = hashMap.get(parent);
                nodeParentInfo.getChildrens().add(child);
            }

            if (!hashMap.containsKey(child)) {
                nodeInfo nodeChildInfo = new nodeInfo(child);
                nodeChildInfo.getParents().add(parent);
                hashMap.put(child, nodeChildInfo);
            } else {
                nodeInfo nodeChildInfo = hashMap.get(child);
                nodeChildInfo.getParents().add(parent);
            }

        }

        int opertionsCount = scanner.nextInt();
        for (int i = 0; i < opertionsCount; i++) {
            int type = scanner.nextInt();
            int node = scanner.nextInt();
            if (type == 1) {
                //加水
                addWater(node);
            } else if (type == 2) {
                //防水
                relaxWater(node);
            } else {
                hasWater(node);
            }


        }


    }
}
