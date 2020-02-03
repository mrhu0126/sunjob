package com.mapper;

import com.pojo.UserInfo;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    //查找所有
    public List<UserInfo> findall() {
        List<UserInfo> list = new ArrayList<UserInfo>();
        String sql = "select username , password from userinfo ";
        ResultSet rs = DBUtil.query(sql);
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
            try {//释放连接
                DBUtil.releaseConnection(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  list ;

    }


}
