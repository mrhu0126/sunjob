package com.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionProxy implements InvocationHandler {

    static Object target ;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        Object n =  method.invoke(target ,args);
        sqlSession.commit();
        return n;
    }

    //得到对象
    public Object getInstance(Object t){
        target = t ;
        return Proxy.newProxyInstance(target.getClass().getClassLoader() , target.getClass().getInterfaces() , this );
    }



}
