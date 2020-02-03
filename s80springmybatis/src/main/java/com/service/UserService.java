package com.service;


import com.mapper.UserMapper;
import com.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper  userMapper;

    public List findall(){
        return userMapper.findall();
    }

    public int deletebyusername(String username){
       int n =  userMapper.deletebyusername(username);
       return  n ;
    }

    public void test(){
        userMapper.deletebyusername("sunjob");

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("222");
        userInfo.setPassword("bb");
        userMapper.add(userInfo);


    }


}
