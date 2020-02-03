package com.inter;

import java.io.File;

public class Test9 {
    public static void main(String[] args) {
        File file = new File("C:/Users/Mr胡/Desktop/a.txt");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file);
    }
}
