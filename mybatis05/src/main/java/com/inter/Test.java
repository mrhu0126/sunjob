package com.inter;

import com.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"mysql");
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map map = new HashMap();
        map.put("empid" , 1);
        map.put("empname" , "%三%");

        List<Emp> list = sqlSession.selectList("com.pojo.Emp.find" , map);
        //sqlSession.commit();    不提交   耳机缓存没作用

        for (Emp emp : list) {
            System.out.println(emp.getEmpid()+"\t" + emp.getEmpname());
        }





    }
}
