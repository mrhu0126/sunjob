package com.inter;

import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);

        Dep dep = new Dep();
        dep.setDepid(14);
        dep.setDepname("国防部");

        Dep dep2 = new Dep();
        dep2.setDepid(15);
        dep2.setDepname("国防部");

        Dep dep3 = new Dep();
        dep3.setDepid(16);
        dep3.setDepname("国防部");

        sqlSession.insert("com.pojo.Dep.insert" , dep);
        sqlSession.insert("com.pojo.Dep.insert" ,dep2);
        sqlSession.insert("com.pojo.Dep.insert" , dep3);

       sqlSession.commit();


    }

}
