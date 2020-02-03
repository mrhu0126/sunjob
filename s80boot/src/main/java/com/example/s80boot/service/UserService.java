package com.example.s80boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.s80boot.mapper.UserMapper;
import com.example.s80boot.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper ;

    public List<UserInfo> findall(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
        List<UserInfo> list = userMapper.selectList(queryWrapper);
        return list ;

    }

}
