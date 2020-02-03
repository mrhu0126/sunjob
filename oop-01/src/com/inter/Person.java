package com.inter;

//   文件名和类名一致
public class Person {
    //  访问修饰符   类型   属性名
    public String name = "a";
    //public String name ="b";
    public int age;

    //做什么     定义方法
    //  访问修饰符    返回类型   方法名称   （参数）  {方法体}    void
    public void say() {
        System.out.println("嗨~~~");
    }

    public int add(int a, int b) {
        int c = a + b;
        return c;// 返回
    }
    // 重载   同一个类中   方法名相同   参数不同的方法  称之为方法的重载
    // 看方法定义  根据方法名和参数能找到唯一与之对应的  就ok
    public int add(int a, int b, int c) {
        int d = a + b + c;
        return d;
    }

}

