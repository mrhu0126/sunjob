package com.inter;

public class Test2 {

    public static void main(String[] args) {
        Integer integer =100;
        Integer integer1 = 100;
        System.out.println(integer+integer1);

        System.out.println(integer==integer1);

        Integer integer2 =200;
        Integer integer3 = 200;
        System.out.println(integer2==integer3);


        Integer integer4 = new Integer(100);
        Integer integer5 = new Integer(100);
        System.out.println(integer4==integer5);
        System.out.println(integer4.equals(integer5));

        System.out.println(integer.toString());
        System.out.println(integer.hashCode());

        System.out.println(Integer.max(2,3));


    }
}
