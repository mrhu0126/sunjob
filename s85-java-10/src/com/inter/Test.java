package com.inter;

public class Test implements Cloneable {


    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "aa";
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Test test = new Test();
        Test test1 = test;

        System.out.println(test);
        System.out.println(test1);
        System.out.println(test.equals(test1));

        Test test2 = (Test) test.clone();
        System.out.println(test2.toString());
        System.out.println(test.equals(test2));
        System.out.println(test2.hashCode());

    }


}
