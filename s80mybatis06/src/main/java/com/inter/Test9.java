package com.inter;

import com.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Test9 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", null);

        empMapper.testadd(map);
        sqlSession.commit();
        System.out.println(map.get("c"));


    }
}
