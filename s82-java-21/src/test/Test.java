package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {
        //1.拷贝驱动

        Connection connection = null;
        try {
            //2.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //3.得到连接对象
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82", "root", "admin");

            //4.写sql
            String sql = "insert into userinfo(username, password) values('sunjob', 'sunjob')";

            //5.创建指令对象
            Statement statement = connection.createStatement();

            //6.执行操作   executeUpdate  增删改  executeQuery  查询
            int n = statement.executeUpdate(sql);//n 指的是影响的条数
            System.out.println(n);
        } catch (Exception e) {
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
