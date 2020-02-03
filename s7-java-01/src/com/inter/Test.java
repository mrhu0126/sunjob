package com.inter;

public class Test {

    //传值   基本数据类型/String/包装类   传引用

    public static void change(String s ){
        s = s + "aa";
    }

    public static void main(String[] args) {
        String s = "abc";
        change(s);
        System.out.println(s);
    }



}
