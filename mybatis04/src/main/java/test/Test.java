package test;

import com.pojo.Dep;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Dep> list = sqlSession.selectList("com.pojo.Dep.findbyid" , 1);
        System.out.println(list.size());
        for (Dep dep : list) {
            System.out.println(dep.getDepid()+"\t" + dep.getDepname()+"\t" + dep.getEmps().size());
        }







    }
}
