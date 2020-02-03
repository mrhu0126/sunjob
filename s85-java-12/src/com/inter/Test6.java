package com.inter;

public class Test6 implements  Cloneable {

    public static void test() throws CloneNotSupportedException {
        Test6 test6 = new Test6();
        Test6 test61 = (Test6) test6.clone();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        test();
    }

}
