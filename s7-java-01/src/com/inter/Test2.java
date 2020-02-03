package com.inter;

import com.pojo.UserInfo;

public class Test2 {

    public static void change(UserInfo userInfo) {
        userInfo.setUsername("aaa");
    }

    public static void main(String[] args) {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("aa");
        userInfo.setPassword("bb");

        change(userInfo);//  传引用
        System.out.println(userInfo.getUsername());
    }
}
