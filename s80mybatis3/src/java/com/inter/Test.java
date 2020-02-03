package com.inter;

import com.pojo.Dep;
import com.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sessionFactory.openSession();

        Dep dep = sqlSession.selectOne("com.pojo.Dep.findbyid" ,1);
        System.out.println(dep.getDepid()+"\t" + dep.getDepname());
        Set<Emp> set = dep.getEmps();
        for (Emp emp : set) {
            System.out.println(emp.getEmpid()+"\t" + emp.getEmpname());
        }

    }
}
