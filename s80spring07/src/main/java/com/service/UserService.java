package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper ;

    //分頁
    public IPage fenye(int p , int size){
        Page page = new Page(p,size);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage ipage = userMapper.selectPage(page , queryWrapper);//分頁
        return page ;
    }

    //根据主键删除
    public int deletebyusername(String username){
        int n = userMapper.deleteById(username);
        return n ;
    }


}
