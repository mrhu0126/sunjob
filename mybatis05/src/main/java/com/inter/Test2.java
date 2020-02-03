package com.inter;

import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"mysql");
        SqlSession sqlSession = sqlSessionFactory.openSession();

       Dep dep = new Dep();
       dep.setDepname("国防部");

       int n = sqlSession.insert("com.pojo.Dep.insert" , dep);
       sqlSession.commit();
        System.out.println(dep.getDepid());

    }
}
