package com.inter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DepMapper;
import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test4 {
    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //分页插件
        DepMapper depMapper = sqlSession.getMapper(DepMapper.class);

        PageHelper.startPage(1,2,true);
        List<Dep> list = depMapper.fenye();
        PageInfo<Dep> pageInfo = new PageInfo<Dep>(list);
        System.out.println(pageInfo.getPages());


    }
}
