package com.mzy.base;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-30 20:08
 **/
class student{
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

public class test {

    public static  student f(){
        student student = new student();
        student.setName("sdsd");


        try {

            return student;

        }catch (Exception e){
            System.out.println(e);
        }finally {
         student.setName("fffhjf");
        }

        return null;

    }


    public static void main(String[] args) {

        System.out.println(f().getName());


    }
}
