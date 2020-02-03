package test;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz" ;
        //StringBuffer sb = new StringBuffer("");   //线程安全
        StringBuilder sb = new StringBuilder("");
        Random random = new Random();
        for (int i = 0 ; i<4 ;i++){
            /*
            int index = (int)Math.floor(Math.random()*26);
            char ch = s.charAt(index);
             */
            int index = random.nextInt(26);// [0-25]
            char ch = s.charAt(index);
            sb.append(ch);//追加
        }

        String code = sb.toString() ;
        System.out.println(code);

    }


}
