package test;

import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        Date date = new Date();//得到系统的当前时间
        System.out.println(date);
        System.out.println(date.getYear());//1900
        System.out.println(date.getMonth());
        date.setYear(1994);
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        calendar.set(Calendar.YEAR, 1994);
        calendar.set(Calendar.MONTH , 13);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar);

        Date date1 = calendar.getTime();
        System.out.println(date1);
    }
}
