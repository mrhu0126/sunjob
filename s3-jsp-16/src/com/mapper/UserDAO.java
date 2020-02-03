package com.mapper;

import com.pojo.UserInfo;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    //查找所有用户
    public List<UserInfo> findall(){

        return null ;
    }

    //根据用户名删除
    public int deletebyusername(String username){
        String sql = "delete from userinfo where username = ? ";
        int n = DBUtil.zsg(sql , username);
        return n ;
    }

}
