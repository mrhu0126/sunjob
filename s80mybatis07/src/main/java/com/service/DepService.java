package com.service;

import com.mapper.DepMapper;
import com.pojo.Dep;
import com.util.SqlSessionUtil;

//业务层
public class DepService {

    private DepMapper depMapper;

    public void add(Dep dep){
        depMapper = SqlSessionUtil.getMapper(DepMapper.class);
        depMapper.add(dep);
        SqlSessionUtil.getSession().commit();
    }
}
