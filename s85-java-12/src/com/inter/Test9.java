package com.inter;

public class Test9 implements Cloneable {

    public static void test(){
        try {
            System.out.println(1);
            Class.forName("com.inter.Test");
            System.out.println(2);
            Test9 test9 = new Test9();
            Test9 test91 = (Test9) test9.clone();
            System.out.println(3);
        } catch (CloneNotSupportedException e) {
            System.out.println(4);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(5);
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        test();
    }

}
