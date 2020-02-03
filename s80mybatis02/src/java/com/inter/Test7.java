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

public class Test7 {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sessionFactory.openSession();

        Map map = new HashMap();
        map.put("offset"  ,2);
        map.put("limit" , 2);

        List<Dep> list = sqlSession.selectList("com.mapper.DepMapper.fenye" ,map);

        for (Dep dep : list) {
            System.out.println(dep.getDepid()+"\t" + dep.getDepname());
        }
    }
}
