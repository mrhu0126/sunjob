package com.service;

import com.dao.DepDAO;
import com.pojo.Dep;
import com.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class DepService implements IDepService {

    public void add(Dep dep){
        DepDAO depDAO = SqlSessionUtil.getMapper(DepDAO.class);
        depDAO.add(dep);
    }

}
