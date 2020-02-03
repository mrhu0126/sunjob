package com.test;

import com.pojo.Student;
import com.pojo.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Test {

    public static void main(String[] args) {
        //解析applicationContext.XML
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app*.xml");
        Student student = (Student) applicationContext.getBean("student");

        System.out.println(student.getStuid());
        System.out.println(student.getStuname());

        String[] strings = student.getLoves();
        for (String string : strings) {
            System.out.println(string);
        }

        Map map = student.getOther();
        System.out.println(map.get("age"));
        System.out.println(map.get("name"));

        Teacher teacher = student.getTeacher();
        System.out.println(teacher.getTname());

    }
}
