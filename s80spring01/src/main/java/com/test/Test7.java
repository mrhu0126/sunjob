package com.test;

public class Test7 {

    public static void main(String[] args) {
        String sql = "select %d from student ";
       String s = String.format(sql, 1);
        System.out.println(s);
    }


}
