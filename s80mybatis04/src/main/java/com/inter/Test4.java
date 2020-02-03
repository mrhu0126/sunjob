package com.inter;

import com.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test4 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp emp = new Emp();
        emp.setEmpname("李");
        emp.setGender(1);

        List<Emp> list = sqlSession.selectList("com.pojo.Emp.query" , emp);
        for (Emp e : list) {
            System.out.println(e.getEmpid()+"\t" + e.getEmpname()+"\t" + e.getDid());
        }


    }
}
