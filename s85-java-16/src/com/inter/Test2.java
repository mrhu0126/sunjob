package com.inter;

import java.io.*;

public class Test2 {

    public static void main(String[] args) throws IOException {
        //字符流
        InputStream is = new FileInputStream(new File("C:/Users/Mr胡/Desktop\\a.txt"));
        Reader reader = new InputStreamReader(is , "UTF-8");

        int ch = reader.read();
        while (ch!=-1){
            System.out.println((char) ch);
            ch = reader.read();
        }


    }
}
