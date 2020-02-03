package com.inter;

import java.util.Set;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {

        Set set = new TreeSet();
        set.add(1);
        set.add(9);
        set.add(4);
        set.add(2);
        set.add(2);
      set.add("5");
        System.out.println(set.size());
        for (Object object : set) {
            System.out.println(object);
        }

    }

}
