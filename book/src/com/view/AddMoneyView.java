package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddMoneyView extends JDialog {

    private JLabel readeridLabel = new JLabel("读者编号");
    private JTextField readeridField = new JTextField();

    private JButton queryButton = new JButton("查找");

    private JLabel readernameLabel = new JLabel("读者姓名");
    private JTextField readernameField = new JTextField();

    private JLabel telLabel = new JLabel("联系电话");
    private JTextField telField = new JTextField();

    private JLabel moneyLabel = new JLabel("充值金额");
    private JTextField moneyField = new JTextField();

    private JLabel balanceLabel = new JLabel("余额");
    private JTextField balanceField = new JTextField();

    private JButton addButton = new JButton("充值");


    public AddMoneyView() {
        setTitle("充值");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        readeridLabel.setBounds(50, 100, 100, 20);
        readeridField.setBounds(160, 100, 100, 20);

        queryButton.setBounds(300, 100, 100, 20);

        readernameLabel.setBounds(50, 150, 100, 20);
        readernameField.setBounds(160, 150, 100, 20);

        telLabel.setBounds(50, 200, 100, 20);
        telField.setBounds(160, 200, 100, 20);

        balanceLabel.setBounds(50, 250, 100, 20);
        balanceField.setBounds(160, 250, 100, 20);

        moneyLabel.setBounds(50,300,100,20);
        moneyField.setBounds(160,300,100,20);

        addButton.setBounds(300, 300, 100, 20);

        add(readeridLabel);
        add(readeridField);
        add(queryButton);
        add(readernameLabel);
        add(readernameField);
        add(telLabel);
        add(telField);
        add(moneyLabel);
        add(moneyField);
        add(balanceLabel);
        add(balanceField);
        add(addButton);

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String readerid = readeridField.getText();

                Connection connection = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82", "root", "admin");
                    String sql = "select readername , tel , money from reader where readerid = ? ";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setObject(1, readerid);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        readernameField.setText(rs.getString(1));
                        telField.setText(rs.getString(2));
                        balanceField.setText(rs.getDouble(3)+"");
                    } else {
                        JOptionPane.showMessageDialog(null, "该用户不存在");
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String readerid = readeridField.getText();
                String money = moneyField.getText();

                Connection connection = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82", "root", "admin");
                    String sql = "update reader set money = money + ? where readerid = ? ";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setObject(1, money);
                    ps.setObject(2 , readerid);

                    int n = ps.executeUpdate();

                    if(n>0){
                        balanceField.setText((Double.parseDouble(balanceField.getText())+Double.parseDouble(moneyField.getText()))+"");
                        JOptionPane.showMessageDialog(null, "充值成功");
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
        new AddMoneyView();
    }
}


