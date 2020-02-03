package com.test;

import com.mapper.DepMapper;
import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws IOException, NoSuchMethodException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dep dep = sqlSession.selectOne("com.mapper.DepMapper.findbyid" ,1);
        System.out.println(dep.getDname());
        sqlSession.commit();

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        System.out.println(sqlSession==sqlSession1);


        Dep dep2 = sqlSession1.selectOne("com.mapper.DepMapper.findbyid" ,1);
        System.out.println(dep2.getDname());

    }
}
