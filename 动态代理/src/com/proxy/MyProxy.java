package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {

    private Object object;

    public MyProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务");
        method.invoke(object , args);
        System.out.println("提交事务");
        return null;
    }

    //得到代理对象
    public Object getInstance(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces() , this);
    }

}
