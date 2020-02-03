package com.inter;

import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test3 {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sessionFactory.openSession();
        Dep dep = new Dep();
        dep.setDepid(3);
        dep.setDepname("国防部");

        int n = sqlSession.insert("com.mapper.DepMapper.adddep" , dep);

        sqlSession.commit();// 增删改 需要提交事务
        System.out.println(n);

    }
}
