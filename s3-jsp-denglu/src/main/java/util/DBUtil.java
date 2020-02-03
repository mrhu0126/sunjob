package util;

import java.sql.*;
import java.util.Vector;

public class DBUtil {
    public static Vector<Connection> connectionpool =new Vector<>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i=0;i<10;i++){
                Connection connection= DriverManager.getConnection("jdbc:mysql:127.0.0.1:3306://mysql","root","123456");
                connectionpool.add(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection=connectionpool.get(0);
        connectionpool.remove(0);
        return connection;
    }
    public static void releaseConnection(Connection connection){
        connectionpool.add(connection);
    }
    public static int zsg(String sql,Object...p){
        Connection connection=getConnection();
        int n=0;
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            for (int i=0;i<p.length;i++){
                ps.setObject(i+1,p[i]);
            }
            n=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
    public static ResultSet chaxun(String sql,Object...p){
        Connection connection=getConnection();
        ResultSet rs=null;

        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            for (int i=0;i<p.length;i++){
                ps.setObject(i+1,p[i]);
            }
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static int jhcx(String sql ,Object...p){
        Connection connection=getConnection();
        ResultSet rs=null;
        int n=0;

        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            for (int i=0;i<p.length;i++){
                ps.setObject(i+1,p[i]);
            }
            rs=ps.executeQuery();
            rs.next();
            n=rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                releaseConnection(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n;
    }
}
