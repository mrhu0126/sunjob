package com.inter;

import com.pojo.Dep;
import com.service.DepService;
import com.service.IDepService;
import com.util.TransactionProxy;

public class Test3 {

    public static void main(String[] args) {

        DepService depService = new DepService();
        TransactionProxy transactionProxy = new TransactionProxy();
        IDepService service = (IDepService) transactionProxy.getInstance(depService);
        Dep dep = new Dep();
        dep.setDepid(99);
        dep.setDepname("测试部门");
        service.add(dep);




    }

}
