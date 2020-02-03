package test;

import com.pojo.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("sunjob");
        userInfo.setPassword("sunjob");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUsername("saijiebo");
        userInfo2.setPassword("saijiebo");


        List<UserInfo> list = new ArrayList<UserInfo>();
        list.add(userInfo);
        list.add(userInfo2);

        StringBuffer sb = new StringBuffer("[");

        for (UserInfo info : list) {
            sb.append("{'username':'").append(info.getUsername()).append("','password':'").append(info.getPassword()).append("'},");
        }
        
        System.out.println(sb);
        sb.replace(sb.length()-1 , sb.length() ,"]");
        System.out.println(sb);

    }
}
