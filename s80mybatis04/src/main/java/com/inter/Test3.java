package com.inter;

import com.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test3 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp emp = sqlSession.selectOne("com.pojo.Emp.findbyid" , 9);
        if(emp==null){
            return ;
        }

        emp.setDid(1);
        int n = sqlSession.update("com.pojo.Emp.updateemp" , emp);
        sqlSession.commit();





    }
}
