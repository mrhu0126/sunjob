package com.util;

import java.sql.*;
import java.util.Vector;

public class DBUtil {

    public static Vector<Connection> connectionPoll = new Vector<Connection>();

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for(int i=0;i<10;i++){
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s3","root","admin");
                connectionPoll.add(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        Connection connection = connectionPoll.get(0);
        connectionPoll.remove(0);
        return connection;
    }

    public static void releaseConnection(Connection connection){
        connectionPoll.add(connection);
    }


    public static int zsg(String sql,Object... p){
        Connection connection = getConnection();
        int n = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for(int i=0;i<p.length;i++){
                ps.setObject(i+1,p[1]);
            }
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConnection(connection);
        }
        return n;
    }

    public static ResultSet query(String sql,Object... p){
        Connection connection =  getConnection();
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for(int i=0;i<p.length;i++){
                ps.setObject(i+1,p[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


}
