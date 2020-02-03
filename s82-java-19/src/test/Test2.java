package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString  = sdf.format(date);//把日期型转换为字符串
        System.out.println(dateString);
        // 字符串转日期
        String s = "1979-03-03 08:08:08" ;
        Date date1 = sdf.parse(s);//   字符串变成日期
        System.out.println(date1);
    }
}
