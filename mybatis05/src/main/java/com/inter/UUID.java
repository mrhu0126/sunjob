package com.inter;

import com.mapper.UserInfoMapper;
import com.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class UUID {

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader , "mysql");
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("sunjobs");

        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        mapper.save(userInfo);

        sqlSession.commit();
        System.out.println(userInfo.getUsername());

    }
}
