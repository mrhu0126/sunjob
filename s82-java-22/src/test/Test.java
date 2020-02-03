package test;

import java.sql.*;

public class Test {

    public static void main(String[] args) {

        //1.拷贝驱动
        Connection connection = null;

        try {
            //2.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //3.得到连接对象
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");

            //4.写sql
            String sql ="select username , password from userinfo ";

            //5.创建指令对象
            Statement statement = connection.createStatement();

            //6.执行操作
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString(1)+"\t" + rs.getString(2));
            }
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
