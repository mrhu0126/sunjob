package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.UserMapper;
import com.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> findall(){
        List<UserInfo> list = userMapper.findall();
        return  list ;
    }


    public void deleteByUsername(String username) {
        userMapper.deleteByUserName(username);
    }

    public IPage fenye() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
        queryWrapper.like("username" , "gg");
        Page page = new Page(1,2);
        IPage iPage = userMapper.selectPage(page , queryWrapper);
        return iPage ;
    }
}
