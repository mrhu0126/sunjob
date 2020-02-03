package com.inter;

public class Test8 {

    public static void change(int a ){
        a = a + 10 ;
    }


    public static void main(String[] args) {
        int a = 10 ;
        change(a);
        System.out.println(a);
    }
}
