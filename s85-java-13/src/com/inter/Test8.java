package com.inter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test8 {

    public static void main(String[] args) throws ParseException {
        String s = "1994-01-01 08:08:08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(s);//  字符串转日期    parse 转换  String --> Date
        System.out.println(date);
        String s2 = sdf.format(date);//  日期转字符串     Date--> String
        System.out.println(s2);



    }

}
