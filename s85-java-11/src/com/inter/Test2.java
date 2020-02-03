package com.inter;

public class Test2 {

    public static void main(String[] args) {

        String s = "abc";
        String s2 = "abc";
        System.out.println(s.equals(s2));
        System.out.println(s==s2);//比较内容  不用==
        System.out.println(s.equalsIgnoreCase(s2));
        System.out.println(s.length());



    }
}
