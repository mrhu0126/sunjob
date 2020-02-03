package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundTest {

    public void aorund( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before");
        proceedingJoinPoint.proceed();
        System.out.println("around after");
    }
}
