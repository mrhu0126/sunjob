package com.test;

import com.impl.StuManagerIMPL;
import com.inter.StuManager;
import com.proxy.MyProxy;

public class Test {

    public static void main(String[] args) {
        StuManager stuManager = new StuManagerIMPL();
        MyProxy myProxy = new MyProxy(stuManager);
        StuManager stu = (StuManager) myProxy.getInstance();
        stu.add();
    }

}
