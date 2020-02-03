package com.view;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginView extends JFrame {
    private JLabel usernameLabel = new JLabel("用户名");
    private JTextField usernameField = new JTextField();

    private JLabel passwordLabel = new JLabel("密码");
    private JTextField passwordField = new JPasswordField();//父类的引用指向子类对象

    private JButton resetButton = new JButton("重置");
    private JButton loginButton = new JButton("登录");

    public LoginView() {//构造方法
        setTitle("欢迎使用强哥图书馆管理系统");//设置标题内容
        setSize(600, 500);//设置窗体大小
        setLocationRelativeTo(null);//设置窗体居中
        setResizable(false);//设置窗口不可以调整大小
        setLayout(null);//设置绝对布局方式
        //各控件在窗体中的相对位置
        usernameLabel.setBounds(100, 100, 100, 20);
        usernameField.setBounds(250, 100, 100, 20);

        passwordLabel.setBounds(100, 170, 100, 20);
        passwordField.setBounds(250, 170, 100, 20);

        resetButton.setBounds(150, 250, 60, 20);
        loginButton.setBounds(250, 250, 60, 20);

        //添加各个控件
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(resetButton);
        add(loginButton);

        //匿名内部类
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "确定退出吗？", "退出", JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    System.exit(0);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {//增加一个监听事件
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");//清空对应控件的文本内容
                passwordField.setText("");
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                Connection connection = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82", "root", "admin");
                    String sql = "select username,password from userinfo where username = ? and password = ?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setObject(1, username);
                    ps.setObject(2, password);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        LoginView.this.dispose();
                        new MainView();
                    } else {
                        JOptionPane.showMessageDialog(null, "用户名或密码错误");
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginView();
    }
}
