package com.test;

import java.sql.*;
import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名");
        String username = scanner.nextLine();//得到用户名

        System.out.println("请输入密码:");
        String password = scanner.nextLine();//得到密码

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s85","root","admin");

            //select username , password from userinfo where username ='sunjob' and password = 'sunjob'
            String sql = "select username , password from userinfo where username ='"+username+"' and password = '"+password+"'";
            System.out.println(sql);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            if(rs.next()){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    }

}
