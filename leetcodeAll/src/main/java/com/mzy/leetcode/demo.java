package com.mzy.leetcode;


import java.io.*;


class C {

    public void say() {

//        Reader reader = null;
//        try {
//            reader = new FileReader("a.txt");
//            char[] a = new char[2];
//            int read = reader.read(a);
//            System.out.println(read);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        FileWriter writer = null;
        try {
            writer = new FileWriter("b.txt");
            writer.write("abc");
//            writer.flush();
//            writer.close();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

public class demo {


    public static void main(String[] args) {
//
        C c = new C();
        c.say();

    }
}

