package com.inter;

public class Test {

    public static void main(String[] args) {
        String s = "cacbcc";
        char ch = s.charAt(2);
        System.out.println(ch);

        int index = s.indexOf('s');
        int i = s.lastIndexOf('c');
        System.out.println(index);

        String s2 = "http://www.baidu.com";
        System.out.println(s2.startsWith("http://"));
        System.out.println(s2.endsWith(".con"));


    }

}
