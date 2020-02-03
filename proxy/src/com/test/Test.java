package com.test;

import com.impl.StuManagerIMPL;
import com.inter.StuManager;
import com.proxy.StuProxy;

public class Test {
    public static void main(String[] args) {
        StuManager stuManager = new StuManagerIMPL();
        StuProxy stuProxy = new StuProxy(stuManager);
        stuProxy.add();
    }
}
