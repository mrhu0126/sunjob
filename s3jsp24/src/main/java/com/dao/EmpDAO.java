package com.dao;

import com.pojo.Emp;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

    //根据部门编号找员工
    public List<Emp> findEmpBydid(String depid){
        String sql = "select empid , empname from emp where did = ? " ;
        ResultSet rs = DBUtil.query(sql , depid);
        List<Emp> list = new ArrayList<Emp>();

        try {
            while(rs.next()){
                Emp emp = new Emp();
                emp.setEmpid(rs.getInt(1));
                emp.setEmpname(rs.getString(2));
                list.add(emp);
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
