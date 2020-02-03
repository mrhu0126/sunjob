package com.inter;

import com.mapper.EmpMapper;
import com.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test7 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> list = empMapper.findall();
        for (Emp emp : list) {
            System.out.println(emp.getEmpid()+"\t" + emp.getEmpname());
        }


    }
}
