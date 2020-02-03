package com.inter;

//单继承   一个子类只能有一个父类  一个父类可以有多个子类
public class Women extends Person {

    // 重写   两个继承关系的类中   方法名相同  参数也相同
    public void say(){
        System.out.println("good morning");
    }


}
