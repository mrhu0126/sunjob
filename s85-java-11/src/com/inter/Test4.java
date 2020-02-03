package com.inter;

public class Test4 {

    public static void main(String[] args) {
        String s = "   abcd  sdd   ";
        s= s.trim();//   去除首尾空格
        System.out.println(s.length());

        String s2 = "abcdefghijklmn";
        String s3 = s2.substring(4);
        String s4 = s2.substring(3,5);//[3,5)
        System.out.println(s3);
        System.out.println(s4);


    }
}
