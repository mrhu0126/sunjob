package com.test;

import java.io.*;

public class Test5 {

    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Mr胡/Desktop/a");
        File[] files = file.listFiles();

        int a = 0 ;
        for (File f : files) {
            if("a.txt".equals(f.getName())){
                OutputStream os = new FileOutputStream("C:/Users/Mr胡/Desktop/a/a.txt" , true);
                os.write('a');
            }else{
                System.out.println("aa");
                OutputStream os = new FileOutputStream("C:/Users/Mr胡/Desktop/a/a.txt");
                os.write('a');
                a = 1 ;
                return ;
            }
        }

        if(a==0){
            OutputStream os = new FileOutputStream("C:/Users/Mr胡/Desktop/a/a.txt");
            os.write('a');
        }


    }

}
