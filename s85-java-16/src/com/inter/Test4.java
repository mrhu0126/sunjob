package com.inter;

import java.io.*;

public class Test4 {

    public static void main(String[] args) throws IOException {
        //字节输入流
        InputStream is = new FileInputStream(new File("C:/Users/Mr胡/Desktop\\a.txt"));
        //字节输出流
        OutputStream os = new FileOutputStream("c:/users/Mr胡/b.txt");
        int ch = is.read();
        while(ch!=-1){
            System.out.println((char)ch);
            os.write(ch);
            ch = is.read();
        }

    }
}
