package com.inter;

import com.mapper.DepMapper;
import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test3 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepMapper depMapper = sqlSession.getMapper(DepMapper.class);

        List<Dep> list = depMapper.find(1 , "国防部");

        for (Dep dep : list) {
            System.out.println(dep.getDepid()+"\t" + dep.getDepname());
        }




    }

}
