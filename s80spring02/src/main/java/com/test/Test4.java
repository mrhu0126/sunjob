package com.test;

import com.aop.DB;
import com.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        //解析applicationContext.XML
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app*.xml");
        DB db = (DB) applicationContext.getBean("db");
        db.add();


    }
}
