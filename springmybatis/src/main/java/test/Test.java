package test;

import com.pojo.UserInfo;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app*.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        UserInfo info = new UserInfo();
        info.setUsername("55");
        info.setPassword("");
        userService.test(info);


    }

}
