package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ReturnBookView extends JDialog {

    private JLabel bookidLabel = new JLabel("图书编号");
    private JTextField bookidField = new JTextField();

    private JButton queryButton = new JButton("查找");


    private JLabel booknameLabel = new JLabel("图书名称");
    private JTextField booknameField = new JTextField();

    private JLabel bookcbsLabel = new JLabel("出版社");
    private JTextField bookcbsField = new JTextField();

    private JLabel bdateLabel = new JLabel("借书日期");
    private JTextField bdateField = new JTextField();

    private JLabel readeridLabel = new JLabel("读者编号");
    private JTextField readeridField = new JTextField();

    private JLabel readernameLabel = new JLabel("读者姓名");
    private JTextField readernameField = new JTextField();

    private JButton returnButton = new JButton("归还");

    //还书
    public ReturnBookView(){
        setTitle("查找图书");
        setSize(600 , 500);
        setLocationRelativeTo(null);
        setLayout(null);

        bookidLabel.setBounds(100 , 40 , 60 , 20);
        bookidField.setBounds(160 , 40 , 100 , 20);

        queryButton.setBounds(310 , 40 , 60 , 20);


        booknameLabel.setBounds(100,160,60,20);
        booknameField.setBounds(160,160,100,20);

        bookcbsLabel.setBounds(100,200,60,20);
        bookcbsField.setBounds(160,200,100,20);

        bdateLabel.setBounds(100,240,60,20);
        bdateField.setBounds(160,240,100,20);

        readeridLabel.setBounds(100,280,60,20);
        readeridField.setBounds(160,280,100,20);

        readernameLabel.setBounds(100,320,60,20);
        readernameField.setBounds(160,320,100,20);

        returnButton.setBounds(310,320,60,20);

        add(bookidLabel);
        add(bookidField);

        add(queryButton);


        add(booknameLabel);
        add(booknameField);

        add(bookcbsLabel);
        add(bookcbsField);

        add(bdateLabel);
        add(bdateField);

        add(readeridLabel);
        add(readeridField);

        add(readernameLabel);
        add(readernameField);

        add(returnButton);

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection connection = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    String sql = "select bk.`bookid` , bookname , bookcbs , bdate , r.readerid , readername from reader r , book bk, borrow bw where bk.bookid = ? and r.`readerid` = bw.`readerid` and bk.`bookid` = bw.`bookid` and bw.status=1";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setObject(1 , bookidField.getText());
                    ResultSet rs = ps.executeQuery();

                    if(rs.next()){
                        booknameField.setText(rs.getString(2));
                        bookcbsField.setText(rs.getString(3));
                        bdateField.setText(rs.getString(4));
                        readeridField.setText(rs.getString(5));
                        readernameField.setText(rs.getString(6));
                    }else{
                        JOptionPane.showMessageDialog(null , "未找到借阅信息！");
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

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String readerid = readeridField.getText();
                //  修改读者表
                Connection connection = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    String sql = "update reader set bookcount = bookcount -1 where readerid = ?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setObject(1 , readerid);
                    int n = ps.executeUpdate();
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

                String bookid = bookidField.getText();
                Connection connection2 = null;
                try {
                    //修改图书表
                    Class.forName("com.mysql.jdbc.Driver");
                    connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    String sql = "update  book set status = 1 where bookid = ? ";
                    PreparedStatement ps = connection2.prepareStatement(sql);
                    ps.setObject(1 , bookidField.getText());
                    int n = ps.executeUpdate();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        connection2.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                //修改借阅表
                Connection connection3 = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection3 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    String sql = "update borrow set status=0 and rdate = current_timestamp() where readerid = ? and bookid = ? and ISNULL(rdate) ";
                    PreparedStatement ps = connection3.prepareStatement(sql);
                    ps.setObject(1 , readerid);
                    ps.setObject(2, bookid);
                    int n = ps.executeUpdate();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        connection3.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }








            }
        });





        setVisible(true);

    }

    public static void main(String[] args) {
        new ReturnBookView();
    }



}
