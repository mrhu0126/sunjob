package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {


    public static void main(String[] args) {

        //1.拷贝驱动
        Connection connection = null;

        try {
            //2.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.得到连接对象
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s85","root","admin");

            //4.写sql
            String sql = "update dep set depname ='宣传部' where depid = 1" ;

            //5.创建指令对象
            Statement statement = connection.createStatement();

            //6.执行操作
            int n = statement.executeUpdate(sql);

            System.out.println(n);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.关闭连接
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }







    }


}
