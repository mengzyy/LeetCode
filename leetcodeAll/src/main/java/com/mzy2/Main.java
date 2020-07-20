package com.mzy2;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

class te{


    boolean isX;
    public boolean isX() {
        return isX;
    }

    public void setX(boolean x) {
        isX = x;
    }


}

public class Main {

    public static void main(String[] args) {

        List<String> integers = new ArrayList<>();
        integers.add("1");
        integers.add("2");
        integers.add("3");
        Iterator<String> iterator = integers.iterator();
        while (iterator.hasNext()){
            iterator.next();

            iterator.remove();
        }
        Map<String,String> map = new HashMap<>();
        map.put("1","2");
        map.put("2","3");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.printf(entry.getKey());
            System.out.printf(entry.getValue());
            System.out.println(" ");
        }
        System.out.printf("debug");


//        ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put(null,2);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.incrementAndGet();
        System.out.printf(String.valueOf(i));
        LongAdder  longAdder = new LongAdder();
        longAdder.add(0);
        longAdder.add(4);
        System.out.println(longAdder.intValue());
        double random = Math.random();
        int i1 = new Random().nextInt(10);
        System.out.println(i1);
    }


}
