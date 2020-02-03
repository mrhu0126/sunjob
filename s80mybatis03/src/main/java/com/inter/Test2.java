package com.inter;

import com.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sessionFactory.openSession();

        List<Emp> list = sqlSession.selectList("com.pojo.Emp.findbyid" , 1);
        for (Emp emp : list) {
            System.out.println(emp.getEmpid()+"\t" + emp.getEmpname() + emp.getDep().getDepname());
        }

    }
}
