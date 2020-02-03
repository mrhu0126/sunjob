package com.test;

import com.service.DepService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app*.xml");
        DepService depService = (DepService) applicationContext.getBean("depService");
        depService.add();



    }


}
