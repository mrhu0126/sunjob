package com.test;

import com.pojo.UserInfo;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app*.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        List<UserInfo> list =  userService.findall();

        for (UserInfo userInfo : list) {
            System.out.println(userInfo.getUsername()+"\t" + userInfo.getPassword());
        }


    }

}
