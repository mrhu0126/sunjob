package com.mapper;

import com.pojo.UserInfo;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    //查找所有
    public List<UserInfo> findall(int page , int size){
        List<UserInfo> list = new ArrayList<UserInfo>();
        String sql = "select username, password from userinfo limit ? , ? " ;
        ResultSet rs = DBUtil.query(sql ,(page-1)*size , size);// sql有问号 就要赋值
        try {
            while(rs.next()){
                UserInfo userInfo = new UserInfo();
                userInfo.setUsername(rs.getString(1));
                userInfo.setPassword(rs.getString(2));
                list.add(userInfo);
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
        return list ;
    }

    //查总条数
    public int getCount(){
        String sql ="select count(*) from userinfo ";
        int n = DBUtil.uniqueQuery(sql);
        return n ;
    }


}
