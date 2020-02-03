package test;

import com.mapper.UserDAO;
import com.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        UserDAO userDAO = session.getMapper(UserDAO.class);

        Map map = new HashMap();
        map.put("begin" , 1);
        map.put("offset" , 3);

        List<UserInfo> list = userDAO.fenye(map);

        for (UserInfo userInfo : list) {
            System.out.println(userInfo.getPassword() + "\t" + userInfo.getUsername());
        }
    }
}
