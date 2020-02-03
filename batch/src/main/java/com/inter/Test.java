package com.inter;

import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Dep> list = new ArrayList<Dep>();

        Dep dep = new Dep();
        dep.setDepid("a");
        dep.setDepname("b");

        Dep dep2 = new Dep();
        dep2.setDepid("c");
        dep2.setDepname("d");

        Dep dep3 = new Dep();
        dep3.setDepid("e");
        dep3.setDepname("f");

        list.add(dep);
        list.add(dep2);
        list.add(dep3);

        int n = sqlSession.insert("com.pojo.Dep.batch" , list);
        sqlSession.commit();
        System.out.println(n);



    }
}
