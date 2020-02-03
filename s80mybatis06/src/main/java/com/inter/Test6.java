package com.inter;

import com.mapper.EmpMapper;
import com.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test6 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Emp emp = new Emp();
        emp.setEmpid(1);
        emp.setEmpname("菜菜");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        int n = empMapper.update(emp);
        sqlSession.commit();


    }
}
