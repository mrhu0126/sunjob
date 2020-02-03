package com.inter;

import java.util.HashSet;
import java.util.Set;

public class Test5 {
    public static void main(String[] args) {

        Set set = new HashSet();
        set.add("aa");
        set.add("bb");
        set.add("aa");
        set.add("cc");
        System.out.println(set.size());

        for (Object object : set) {
            System.out.println(object);
        }

    }
}
