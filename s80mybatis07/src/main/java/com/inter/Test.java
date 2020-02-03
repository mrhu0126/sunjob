package com.inter;

import com.mapper.DepMapper;
import com.pojo.Dep;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        InputStream is = Test.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);

        Dep dep = new Dep();
        dep.setDepid(1);
        dep.setDepname("小卖部");

        Dep dep2 = new Dep();
        dep2.setDepid(2);
        dep2.setDepname("国防部");

        Dep dep3 = new Dep();
        dep3.setDepid(3);
        dep3.setDepname("中奖部");

        DepMapper depMapper = sqlSession.getMapper(DepMapper.class);

        depMapper.add(dep);
        depMapper.add(dep2);
        depMapper.add(dep3);

        sqlSession.commit();





    }
}
