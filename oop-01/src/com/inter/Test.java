package com.inter;

public class Test {

    public static void main(String[] args) {
        // 如何获取对象
        Person person = new Person();
        person.age = 30;// . 的
        person.name = "张三" ;

        System.out.println(person.age);
        System.out.println(person.name);

        person.say();// 调用say() 方法
        int a = person.add(1,2);
        System.out.println(a);
    }
}