package com.service;

import com.mapper.UserMapper;
import com.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper ;

    public List<UserInfo> findall(){
        List<UserInfo> list = userMapper.findall();
        return list ;
    }

    public int add(UserInfo userInfo){
        int n = userMapper.add(userInfo);
        return n ;
    }

    public void test(UserInfo userInfo){
        userMapper.add(userInfo);
        userMapper.deletebyid("11111");
    }


}
