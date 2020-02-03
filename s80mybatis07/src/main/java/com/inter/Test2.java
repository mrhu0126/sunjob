package com.inter;

import com.mapper.DepMapper;
import com.pojo.Dep;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        InputStream is = Test2.class.getResourceAsStream("/mybatis-config.xml");
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
        List list = new ArrayList();
        list.add(dep);
        list.add(dep2);
        list.add(dep3);

        DepMapper depMapper = sqlSession.getMapper(DepMapper.class);

        depMapper.add2(list);

        sqlSession.commit();





    }
}
