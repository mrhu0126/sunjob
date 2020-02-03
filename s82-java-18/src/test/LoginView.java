package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginView extends JFrame {

    private JLabel usernameLabel = new JLabel("用户名");
    private JLabel passwordLabel = new JLabel("密码");

    private JTextField usernameField = new JTextField();
    private JTextField passwordField = new JPasswordField();//父类的引用指向子类对象

    private JButton resetButton = new JButton("重置");
    private JButton loginButton = new JButton("登录");

    public LoginView(){
        setTitle("欢迎使用赛杰博高级管理系统");
        setSize(500,400);
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int n = JOptionPane.showConfirmDialog(null,"真的要退出吗?" ,"退出",JOptionPane.YES_NO_OPTION);
                if(n==0){
                    System.exit(0);
                }
            }
        });

        //设置布局方式
        setLayout(null);   // 绝对布局
        usernameLabel.setBounds(40 , 50 ,60 , 20);
        usernameField.setBounds(120 , 50 , 100 , 20);

        passwordLabel.setBounds(40 , 170 ,60 , 20);
        passwordField.setBounds(120 , 170 , 100 , 20);

        resetButton.setBounds(40 , 290 , 60 , 20);
        loginButton.setBounds(160 , 290 , 60 , 20);

        add(usernameLabel);
        add(passwordLabel);

        add(usernameField);
        add(passwordField);

        add(resetButton);
        add(loginButton);


        resetButton.addActionListener((e)-> usernameField.setText(""));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //得到用户填写的数据
                String username = usernameField.getText();
                String password = passwordField.getText();

                if("sunjob".equals(username) && "sunjob".equals(password)){
                    JOptionPane.showMessageDialog(null , "登录成功");
                    LoginView.this.dispose();//  关闭登录界面
                }else{
                    JOptionPane.showMessageDialog(null , "登录失败");
                }
            }
        });


        setVisible(true);
    }


    public static void main(String[] args) {
        LoginView loginView = new LoginView();
    }

}
