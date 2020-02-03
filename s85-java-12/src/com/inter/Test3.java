package com.inter;

public class Test3 {

    public static void change(String s ){
        s = s + "aa";
    }

    public static void main(String[] args) {
        String s = new String("abcd");
        change(s);
        System.out.println(s);
    }

}
