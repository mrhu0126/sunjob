package com.view;

public class Test {
    public static void main(String[] args) {
        byte a = 10 ;
        byte b = 10 ;
        a+=b;
        System.out.println(a);

        String s =null;

        //不会空指针异常
        System.out.println(String.valueOf(s));
    }
}
