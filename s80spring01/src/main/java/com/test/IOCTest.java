package com.test;

import com.ioc.ApplicatonContext;
import com.pojo.Student;

public class IOCTest {

    public static void main(String[] args) {
        Student student = (Student) ApplicatonContext.getBean("student");
        student.setStuid(1);
        System.out.println(student.getStuid());
    }

}
