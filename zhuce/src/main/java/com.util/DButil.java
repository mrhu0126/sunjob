package com.util;

import java.sql.*;
import java.util.Objects;
import java.util.Vector;

public class DButil {
    public  static Vector<Connection> connectionPool = new Vector<Connection>();

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0;i<10;i++){
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tangxuan","root","2001");
                connectionPool.add(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static Connection getConnection(){
        Connection connection = connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }

    public  static  void  relese(Connection connection){
        connectionPool.add(connection);

    }
    public  static  int zsg(String sql,Object...p){
        Connection connection = getConnection();
        int n = 0;


        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0;i<p.length;i++){
                ps.setObject(i+1,p[i]);
            }
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            relese(connection);
        }
        return n;
    }

    public static  ResultSet chaxun(String sql, Object...p){
        Connection connection =getConnection();
        ResultSet rs = null;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0;i<p.length;i++){
                ps.setObject(i+1,p[i]);
            }
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }



    public  static int jhcx(String sql,Object...p){
        Connection connection = getConnection();
        ResultSet rs = null;
        int n=0;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i =0;i<p.length;i++){
                ps.setObject(i+1,p[i]);
            }
            rs=ps.executeQuery();
            rs.next();
            n=rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DButil.relese(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  n;
    }

}
