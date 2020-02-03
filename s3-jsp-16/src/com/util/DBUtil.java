package com.util;

import com.pojo.UserInfo;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DBUtil {

    public static Vector<Connection> connectionPoll = new Vector<Connection>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < 10; i++) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s3", "root", "admin");
                connectionPoll.add(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        Connection connection = connectionPoll.get(0);
        connectionPoll.remove(0);
        return connection;
    }

    public static void releaseConnection(Connection connection) {
        connectionPoll.add(connection);
    }


    public static int zsg(String sql, Object... p) {
        Connection connection = getConnection();
        int n = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < p.length; i++) {
                ps.setObject(i + 1, p[i]);
            }
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseConnection(connection);
        }
        return n;
    }

    public static List query(Class c ,String sql, Object... p) {
        Connection connection = getConnection();
        List list = new ArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < p.length; i++) {
                ps.setObject(i + 1, p[i]);
            }
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();//得到总列数
            while (rs.next()) {
                Object object = c.newInstance();
                //一个字段对应一个属性
                for (int i= 1 ;i<=count ; i++){
                    String fieldname = rsmd.getColumnLabel(i);//得到列ming
                    Field field = c.getDeclaredField(fieldname);
                    field.setAccessible(true);
                    field.set(object , rs.getObject(i));
                }
                list.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseConnection(connection);
        }

        return list ;


    }

    public static void main(String[] args) {
        List<UserInfo> list = query(UserInfo.class, "select username , password from userinfo");
        for (UserInfo userInfo : list) {
            System.out.println(userInfo.getUsername()+"\t"+userInfo.getPassword());

        }
    }


}
