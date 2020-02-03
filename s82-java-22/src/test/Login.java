package test;

import java.sql.*;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        Connection connection = null;

        try {
            //2.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //3.得到连接对象
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");

            //4.写sql
            String sql ="select username , password from userinfo where username = '"  + username +"' and password ='" + password + "'" ;
            // select username , password from userinfo where username = 'sunjob' and password = 'sunjob'

            //5.创建指令对象
            Statement statement = connection.createStatement();

            //6.执行操作
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next()){
               System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
        } catch (Exception e) {
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
