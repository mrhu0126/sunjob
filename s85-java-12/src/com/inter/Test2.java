package com.inter;

public class Test2 {

    public static void main(String[] args) {
        String s = "ab"+"cd";//  String s = "abcd";
        String s1 = "ab";
        String s2 = "cd" ;

        String s3 = s1+s2 ;// 运行时才确定   放堆中
        String s4 = "abcd";

        System.out.println(s==s3);
        System.out.println(s==s4);




    }
}
