package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.UserMapper;
import com.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper ;

    public IPage<UserInfo> fenye(){
        Page page = new Page(1,2);
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
        IPage ipage = userMapper.selectPage(page , queryWrapper);
        return ipage ;
    }

}
