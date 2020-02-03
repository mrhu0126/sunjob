package com.test;

import java.util.*;
import java.util.Arrays;

public class Test3 {

    public void test(Integer integer){
        System.out.println("来了");
    }


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.forEach(n->System.out.println(n));
        list.forEach(System.out::println);

         list.forEach(new Test3()::test);

         int a = 10;



    }


}
