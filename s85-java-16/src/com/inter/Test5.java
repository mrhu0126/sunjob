package com.inter;

import java.io.*;

public class Test5 {

    public static void main(String[] args) throws IOException {
        //字符流
        InputStream is = new FileInputStream(new File("C:/Users/Mr胡/Desktop\\a.txt"));
        Reader reader = new InputStreamReader(is , "UTF-8");
        Writer writer = new FileWriter("C:/Users/Mr胡/Desktop/c.txt");

        int ch = reader.read();
        while (ch!=-1){
            System.out.println((char) ch);
            writer.write(ch);
            ch = reader.read();
        }

        writer.close();//  会调用flush
        reader.close();
        //is.close();

    }
}
