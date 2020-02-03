package com.inter;

public class Test5 {

    public static void main(String[] args) {
        String s = "sunjob=saijie=saijiebo";
        String[] strings = s.split("=");
        System.out.println(strings[1]);

        String[] strings2 = s.split("=" , 2);
        System.out.println(strings2[1]);

    }
}
