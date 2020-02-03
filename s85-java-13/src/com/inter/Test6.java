package com.inter;

import java.util.Calendar;
import java.util.Date;

public class Test6 {

    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());
        calendar.setTime(date);
        calendar.set(Calendar.YEAR , 1994);
        calendar.set(Calendar.MONTH , 0);
        calendar.set(Calendar.DAY_OF_MONTH,26);
        System.out.println(calendar);
        date =  calendar.getTime();
        System.out.println(date.getTime());

    }
}
