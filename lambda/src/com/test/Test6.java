package com.test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Test6 {

    @FunctionalInterface
    interface  A{
        public void print();
    }


    public void test() {
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
        A a = new Test6()::print;
        System.out.println(a);
        a.print();

    }

    private void print() {
        System.out.println("aaa");
    }




    public static void main(String[] args) {
        new Test6().test();



    }




}
