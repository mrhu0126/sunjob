package com.inter;

import java.util.Vector;

public class Test7 {
    public static void main(String[] args) {

        Vector vector = new Vector();
        System.out.println(vector.capacity());

        for (int i =0 ; i<81 ; i++){
            vector.add(1);
        }

        System.out.println(vector.capacity());

    }
}
