package com.inter;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {
        //字节输入流
        InputStream is = new FileInputStream(new File("C:/Users/Mr胡/Desktop\\a.txt"));
        int ch = is.read();
        while(ch!=-1){
            System.out.println((char)ch);
            System.out.println(ch*1);
            ch = is.read();
        }

    }
}
