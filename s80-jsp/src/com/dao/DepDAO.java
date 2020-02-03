package com.dao;

import com.pojo.Dep;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepDAO {

    public List<Dep> findall(){
        String sql ="select depid ,depname from dep";
        ResultSet rs = DBUtil.query(sql);
        List<Dep> list = new ArrayList<Dep>();

        try {
            while(rs.next()){
                Dep dep = new Dep();
                dep.setDepid(rs.getInt(1));
                dep.setDepname(rs.getString(2));
                list.add(dep);
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
