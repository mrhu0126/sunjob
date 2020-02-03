package com.example.boot80.service;

import com.example.boot80.mapper.UserMapper;
import com.example.boot80.pojo.UserInfo;
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



}
