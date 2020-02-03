package com.inter;

import com.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {

        //1.读取总的配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //2.创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader ,"MYSQL");
        //  connection 封装   3.得到session
        SqlSession sqlSession = factory.openSession();

        List<UserInfo> list = sqlSession.selectList("com.findall");
        for (UserInfo userInfo : list) {
            System.out.println(userInfo.getUsername()+"\t" + userInfo.getPassword());
        }
        
        

    }
}
