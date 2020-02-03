package com.service;

import com.mapper.DepMapper;
import com.pojo.Dep;
import com.util.SqlSessionUtil;

public class DepService implements IDepService{

    DepMapper depMapper = SqlSessionUtil.getMapper(DepMapper.class);

    public int add(Dep dep){
        int n =depMapper.add(dep);
        return n ;
    }



}
