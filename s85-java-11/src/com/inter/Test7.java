package com.inter;


public class Test7 {


    public static void main(String[] args) {
        /*
        String s = "abcdefghijklmnopqrstuvwxyz0123456789";
        String code = "";
        for (int i =0 ;i<4 ;i++){
            int index = (int)(Math.random()*36);
            char ch = s.charAt(index);
            code = code + ch ;
        }

        System.out.println(code);

        */

        String s = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer sb = new StringBuffer("");
        for (int i =0 ;i<4 ;i++){
            int index = (int)(Math.random()*36);
            char ch = s.charAt(index);
            sb.append(ch);
        }

        String code = sb.toString();
        System.out.println(code);



    }

}
