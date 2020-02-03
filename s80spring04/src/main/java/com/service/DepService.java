package com.service;

import com.dao.DepDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepService {

    @Autowired
    private DepDAO depDAO;

    public void add(){
        depDAO.add();
    }

}
