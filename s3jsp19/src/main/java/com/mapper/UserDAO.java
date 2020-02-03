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
        String sql = "select username , password from userinfo";
        ResultSet rs = DBUtil.query(sql);
        List<UserInfo> list = new ArrayList<UserInfo>();
        try {
            while(rs.next()){
                UserInfo userinfo = new UserInfo();
                userinfo.setUsername(rs.getString(1));
                userinfo.setPassword(rs.getString(2));
                list.add(userinfo);
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


}
