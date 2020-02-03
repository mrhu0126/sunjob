package com.inter;

public class Test6 {

    public static void main(String[] args) {
        String s = "www.baidu.com";
        s.replace("." , "");
        System.out.println(s.length());

        s.replaceAll("\\." , "");//  通配符  任何字符
        System.out.println(s.length());

        s=s.replaceAll("\\w" , "");//   \\w  单词字符
        System.out.println(s.length());




    }
}
