package test;

import com.pojo.UserInfo;

public class Test {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("sunjob");
        userInfo.setPassword("sunjob");

        StringBuffer sb = new StringBuffer();
        sb.append("{'username':'").append(userInfo.getUsername()).append("' , 'password':'").append(userInfo.getPassword()).append("'}");
        String s = sb.toString();
        System.out.println(s);





    }
}
