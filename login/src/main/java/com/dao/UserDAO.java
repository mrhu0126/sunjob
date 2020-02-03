package com.dao;

import com.pojo.UserInfo;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    //登录
    public UserInfo login(String username , String password){

        String sql = "select username , password from userinfo where username = ? and password = ? ";
        ResultSet rs = DBUtil.query(sql ,username , password);
        UserInfo userInfo = null ;

        try {
            if(rs.next()){//判断数据库中是否找到了数据
                userInfo = new UserInfo();
                userInfo.setUsername(rs.getString(1));
                userInfo.setPassword(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.releaseConnection(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  userInfo ;

    }

    //注册
    public int regist(String username , String password){

        String sql = "insert into userinfo(username , password ) values(?,?)";
        int n = DBUtil.zsg(sql , username , password);
        return n ;
    }
}
