package com.inter;

import java.io.File;

public class Testa {

    //递归
    public static void show(File file){
       // System.out.println("aaa");
        if(file.isFile()){
            System.out.println(file.getName());
            return;
        }
        File[] files = file.listFiles();
        for (File f : files) {
            show(f);
        }
    }


    public static void main(String[] args) {
        File fie = new File("C:/Users/Mr胡/Desktop/a");
        show(fie);
    }




}
