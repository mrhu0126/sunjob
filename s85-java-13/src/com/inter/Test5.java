package com.inter;

import java.util.Date;

public class Test5 {

    public static void main(String[] args) {
        Date date = new Date();//  获取系统的当前时间
        System.out.println(date);

        System.out.println(date.getYear());// 1900
        System.out.println(date.getMonth());//  10
        System.out.println(date.getDate());//  1-31
        System.out.println(date.getDay());

        date.setYear(1994);
        date.setMonth(0);
        date.setDate(26);

        System.out.println(date);


    }
}
