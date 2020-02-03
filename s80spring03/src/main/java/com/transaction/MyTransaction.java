package com.transaction;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyTransaction {

    public void transaction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("开启事务");
        proceedingJoinPoint.proceed();//调用被执行的方法
        System.out.println("提交事务");
    }




}
