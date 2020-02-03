package com.inter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(4);

        Collections.sort(list);

        for (Object object : list) {
            System.out.println(object);
        }

    }

}
