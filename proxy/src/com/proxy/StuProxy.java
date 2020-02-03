package com.proxy;

import com.inter.StuManager;

public class StuProxy implements StuManager {

    private StuManager stuManager ;

    public StuProxy(StuManager stuManager) {
        this.stuManager = stuManager;
    }

    @Override
    public void add() {
        System.out.println("开启事务");
        stuManager.add();
        System.out.println("提交事务");
    }

}
