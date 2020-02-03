package com.test;

import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3,4);
        list.forEach(n->System.out.println(n));
        //代替lambada表达式
        list.forEach(System.out::println);
    }

}
