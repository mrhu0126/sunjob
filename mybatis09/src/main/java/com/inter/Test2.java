package com.inter;

import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);

        Dep dep = new Dep();
        dep.setDepid(18);
        dep.setDepname("国防部");

        Dep dep2 = new Dep();
        dep2.setDepid(19);
        dep2.setDepname("国防部");

        Dep dep3 = new Dep();
        dep3.setDepid(20);
        dep3.setDepname("国防部");

        List list = new ArrayList();
        list.add(dep);
        list.add(dep2);
        list.add(dep3);

        int n = sqlSession.insert("com.pojo.Dep.batch" , list );

       sqlSession.commit();


    }

}
