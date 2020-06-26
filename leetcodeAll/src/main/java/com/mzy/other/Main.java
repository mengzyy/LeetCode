package com.mzy.other;


import java.util.*;

class a {


}

public class Main {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int ori=x;
        int sum = 0;
        while(x>sum){
            try{
                sum=sum*10+x%10;
                x/=10;}
            catch(Exception e ){
                return false;
            }


        }
        return sum==ori||sum/10==ori;

    }

    public static void main(String[] args) {
        new Main().isPalindrome(10);
    }

}
