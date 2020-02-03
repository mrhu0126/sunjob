package com.example.s80boot2.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.s80boot2.mapper.UserMapper;
import com.example.s80boot2.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper ;


    public List<UserInfo> findall(){
        QueryWrapper queryWrapper =  new QueryWrapper();
        List<UserInfo> list = userMapper.selectList(queryWrapper);
        return list ;
    }

    public int delbyid(String username) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
        int n = userMapper.deleteById(username);
        System.out.println(1/0);
        return n ;
    }
}
