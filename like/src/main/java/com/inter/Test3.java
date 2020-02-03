package com.inter;

import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"mysql");
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map map = new HashMap();
        map.put("x" , 3);
        map.put("y" , 9);

        List<Dep> list = sqlSession.selectList("com.pojo.Dep.qj2" , map);

        for (Dep d : list) {
            System.out.println(d.getDepid()+"\t" + d.getDepname());
        }

    }
}
