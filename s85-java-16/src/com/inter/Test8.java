package com.inter;

import java.io.*;

public class Test8 {

    public static void main(String[] args) throws IOException {
        //字节输入流
        InputStream is = new FileInputStream(new File("C:/Users/Mr胡/Desktop\\spring.zip"));
        OutputStream os = new FileOutputStream("c:/users/Mr胡/aa.zip");

        byte[] b = new byte[1024];
        int size = is.read(b);// size   数组放了多少个    1024  可以放多少个

        while(size>0){
            System.out.println(size);
            os.write(b , 0 , size);
            size = is.read(b);
        }

        os.close();
        is.close();

    }
}
