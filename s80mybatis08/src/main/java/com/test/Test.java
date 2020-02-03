package com.test;

import com.pojo.Dep;
import com.proxy.TransactionProxy;
import com.service.DepService;
import com.service.IDepService;

public class Test {

    public static void main(String[] args) {
        Dep dep = new Dep();
        dep.setDepid(80);
        dep.setDepname("80班");
        DepService depService = new DepService();
        TransactionProxy transactionProxy = new TransactionProxy(depService);
        //返回的一定是代理对象
        // List list = new ArrayList();
        //产生的对象并不是DepService   而是一个实现了IDepService接口的类
        IDepService depService1 =  (IDepService) transactionProxy.getInstance();
        System.out.println(depService1.getClass().getInterfaces()[0]);
        depService1.add(dep);

    }
}
