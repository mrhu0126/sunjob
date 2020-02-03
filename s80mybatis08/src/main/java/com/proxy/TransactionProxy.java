package com.proxy;

import com.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionProxy implements InvocationHandler {

    private Object object;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object , args);// 完成了被代理对象该做的事情
        //  扩充功能的代码  提交事务
        SqlSession sqlSession = SqlSessionUtil.getSession();
        sqlSession.commit();
        return null;
    }

    public TransactionProxy(Object object) {
        this.object = object;
    }

    //得到代理对象
    public Object getInstance(){
        //为什么参数需要接口? 因为代理对象也需要实现接口  产生的代理对象也会实现 object.getClass().getInterfaces() 接口
        return Proxy.newProxyInstance(object.getClass().getClassLoader() ,object.getClass().getInterfaces() , this );
    }


}
