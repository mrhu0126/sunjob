package com.inter;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        //接口的引用指向了实现类对象
        List list = new ArrayList();
        list.add("aa");// 0
        list.add("bb");
        list.add("cc");

        System.out.println(list.get(0));
        System.out.println(list.get(2));
        list.add(1,"dd");
        System.out.println(list.get(2));
        list.add("aa");
        list.remove("aa");
        System.out.println(list.size());

        list.remove(0);
        System.out.println(list.get(0));

        //   bb cc aa



    }
}
