package com.inter;

import java.io.*;

public class Test3 {

    public static void main(String[] args) throws IOException {
        //字符流
        InputStream is = new FileInputStream(new File("C:/Users/Mr胡/Desktop\\a.txt"));
        Reader reader = new InputStreamReader(is , "UTF-8");

        //缓冲流
        BufferedReader br = new BufferedReader(reader);
        //一行一行的读

        String line = br.readLine();
        while(line!=null){
            System.out.println(line);
            line= br.readLine();
        }

    }
}
