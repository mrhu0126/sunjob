package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {

    @Autowired
    private UserMapper userMapper ;

    public List<UserInfo> findall(){
        List<UserInfo> list = userMapper.findall();
        return list ;
    }

}
