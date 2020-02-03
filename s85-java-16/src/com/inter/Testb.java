package com.inter;

public class Testb {

    public static int sum(int n ){
        int s = 0 ;
        if(n==0){
            return s;
        }

        s = n+sum(n-1);
        return  s ;
    }


    public static void main(String[] args) {
        System.out.println(sum(100));
    }
}
