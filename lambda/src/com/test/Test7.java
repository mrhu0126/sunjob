package com.test;

import com.inter.AddInter;

import java.util.Arrays;
import java.util.List;
import java.util.ListResourceBundle;

public class Test7{


    public static void main(String[] args) {

        //实现了接口中的方法
        AddInter addInter = (int a,int b)->{return a+b ; };
        int s = addInter.add(5,2);
        System.out.println(s);

        List list = Arrays.asList("1" , "3" , "5");
        list.forEach(System.out::println);//lambada

        String a = "abcdf";



    }


}
