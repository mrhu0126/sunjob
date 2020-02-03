package com.inter;

public class Test8 {

    public static int test(){
        try {
            Class.forName("com.inter.Test");
            return 3 ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            return 4 ;
        }
    }

    public static void main(String[] args) {
        int n = test();
        System.out.println(n);

    }

}
