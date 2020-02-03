package com.test;

import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa" , "bb" , "cc");
        list.forEach(new Demo()::println);
        list.forEach(System.out::println);
    }

    public void println(String string){
        System.out.println(string);
    }


}
