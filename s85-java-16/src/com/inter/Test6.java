package com.inter;

import java.io.*;

public class Test6 {

    public static void main(String[] args) throws IOException {
        //字符流
        InputStream is = new FileInputStream(new File("C:/Users/Mr胡/Desktop\\a.txt"));
        Reader reader = new InputStreamReader(is , "GBK");
        //缓冲流
        BufferedReader br = new BufferedReader(reader);


        Writer writer = new FileWriter("C:/Users/Mr胡/Desktop/d.txt" );
        BufferedWriter bw = new BufferedWriter(writer);
        //一行一行的读

        String line = br.readLine();
        while(line!=null){
            System.out.println(line);
            bw.write(line+"\r\n");
            line= br.readLine();
        }

        bw.flush();

    }
}
