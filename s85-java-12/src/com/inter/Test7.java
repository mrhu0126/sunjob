package com.inter;

public class Test7 {

    public static void test(){
        try {//  可能出现异常的代码
            System.out.println("11");
            Class.forName("com.inter.Tes");
            System.out.println("22");
        } catch (ClassNotFoundException e) {
            System.out.println("33");
            //出现异常执行的代码
            e.printStackTrace();// 打印异常
        }finally {// 不管有没有异常  都要执行的代码
            System.out.println("44");
        }

    }

    public static void main(String[] args) {
        test();
    }


}
