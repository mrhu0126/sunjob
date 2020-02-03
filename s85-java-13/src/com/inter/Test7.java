package com.inter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);// 扫描对象
        System.out.println("请输入借书时间:");
        String s = scanner.nextLine();//扫描
        System.out.println("请输入还书时间:");
        String s2 = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date date = sdf.parse(s);
        Date date2 = sdf.parse(s2);

        if(date.getTime()>date2.getTime()){
            System.out.println("no");
        }else{
            System.out.println("yes");
        }

        System.out.println(date.compareTo(date2));



    }
}
