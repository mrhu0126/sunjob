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
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        System.out.println(sqlSession);
        List<Dep> list = new ArrayList<Dep>();

        Dep dep = new Dep();
        dep.setDepid("f");
        dep.setDepname("b");

        Dep dep2 = new Dep();
        dep2.setDepid("g");
        dep2.setDepname("d");

        Dep dep3 = new Dep();
        dep3.setDepid("d");
        dep3.setDepname("f");

        list.add(dep);
        list.add(dep2);
        list.add(dep3);

        for (Dep d : list) {
            int n = sqlSession.insert("com.pojo.Dep.batch2" , d);
        }






    }
}
