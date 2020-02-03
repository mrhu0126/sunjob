package com.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtil {

    static InputStream is = SqlSessionUtil.class.getResourceAsStream("/mybatis-config.xml");
    static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    public static SqlSession getSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession==null){
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }else{
            try {
                sqlSession.getConnection();
            }catch (Exception e){
                sqlSession = sqlSessionFactory.openSession();
                threadLocal.set(sqlSession);
            }
        }

        return sqlSession;
    }

    //获取dao
    public static <T> T getMapper(Class c){
        return (T) getSession().getMapper(c);
    }

}
