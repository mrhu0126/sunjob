package com.inter;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        List list2 = new ArrayList();
        list2.add("1");
        list2.add("2");

        list.add(list2);
        list.addAll(list2);
        System.out.println(list.size());

    }
}
