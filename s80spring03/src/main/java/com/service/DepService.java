package com.service;

import com.inter.IDepService;
import org.aspectj.lang.ProceedingJoinPoint;

public class DepService implements IDepService {

    public void add() {
        System.out.println("添加了");
    }

}
