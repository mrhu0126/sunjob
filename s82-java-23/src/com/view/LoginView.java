package com.view;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginView extends JFrame {

    private JLabel usernameLabel = new JLabel("用户名");
    private JTextField usernameField = new JTextField();

    private JLabel passwordLabel = new JLabel("密码");
    private JTextField passwordField = new JPasswordField();

    private JButton resetButton = new JButton("重置");
    private JButton loginButton = new JButton("登录");


    public LoginView(){
        setTitle("赛杰高级管理系统");
        setSize(400 , 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int n = JOptionPane.showConfirmDialog(null , "真的要退出吗?" ,"退出" , JOptionPane.YES_NO_OPTION);
                if(n==0){
                    System.exit(0);
                }
            }
        });

        usernameLabel.setBounds(40 , 50 ,60 , 20);
        usernameField.setBounds(140 , 50 , 100 , 20);

        passwordLabel.setBounds(40 , 100 , 60 , 20);
        passwordField.setBounds(140 , 100 , 100 , 20);

        resetButton.setBounds(80 , 200 , 60 ,20);
        loginButton.setBounds(200 , 200 , 60 , 20);

        add(usernameLabel);
        add(usernameField);

        add(passwordLabel);
        add(passwordField);

        add(resetButton);
        add(loginButton);

        resetButton.addActionListener((e)->{
            usernameField.setText("");
            passwordField.setText("");
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String password = passwordField.getText();
                Connection connection = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    String sql ="select username , password , role from userinfo where username = ? and password = ? ";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    System.out.println(ps.getClass());
                    ps.setObject(1 , username);
                    ps.setObject(2, password);

                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        LoginView.this.dispose();
                        int role = rs.getInt(3);
                        if(role==1){
                            new MainView(username);
                        }else{
                            System.out.println("这里是2号角色但是我不想写了");
                        }

                    }else{
                        JOptionPane.showMessageDialog(null , "用户名或密码错误");
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


        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int k = e.getKeyCode();
                if(k == e.VK_ENTER){

                    String username = usernameField.getText();
                    String password = passwordField.getText();
                    Connection connection = null;
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                        String sql ="select username , password , role from userinfo where username = ? and password = ? ";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        System.out.println(ps.getClass());
                        ps.setObject(1 , username);
                        ps.setObject(2, password);

                        ResultSet rs = ps.executeQuery();
                        if(rs.next()){
                            LoginView.this.dispose();
                            int role = rs.getInt(3);
                            if(role==1){
                                new MainView(username);
                            }else{
                                System.out.println("这里是2号角色但是我不想写了");
                            }

                        }else{
                            JOptionPane.showMessageDialog(null , "用户名或密码错误");
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
            }
        });


        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int k = e.getKeyCode();
                if(k == e.VK_ENTER){

                    String username = usernameField.getText();
                    String password = passwordField.getText();
                    Connection connection = null;
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                        String sql ="select username , password , role from userinfo where username = ? and password = ? ";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        System.out.println(ps.getClass());
                        ps.setObject(1 , username);
                        ps.setObject(2, password);

                        ResultSet rs = ps.executeQuery();
                        if(rs.next()){
                            LoginView.this.dispose();
                            int role = rs.getInt(3);
                            if(role==1){
                                new MainView(username);
                            }else{
                                System.out.println("这里是2号角色但是我不想写了");
                            }

                        }else{
                            JOptionPane.showMessageDialog(null , "用户名或密码错误");
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
            }
        });





        setVisible(true);

    }
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
    }
}
