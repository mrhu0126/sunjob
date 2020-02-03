package com.view;

import com.pojo.Dep;
import com.util.Chooser;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEmpView extends JFrame {

    private JLabel empidLabel = new JLabel("员工编号");
    private JTextField empidField = new JTextField();

    private JLabel empnameLabel = new JLabel("员工姓名");
    private JTextField empnameField = new JTextField();

    private JLabel didLabel = new JLabel("所在部门");
    private JComboBox<Dep> depBox = new JComboBox<Dep>();

    private JLabel birthdayLabel = new JLabel("出生日期");
    private JTextField birthdayField = new JTextField();

    private JLabel phoneLabel = new JLabel("电话号码");
    private JTextField phoneField = new JTextField();
    private JLabel checkphoneLabel = new JLabel();

    private JLabel idLabel = new JLabel("身份证号");
    private JTextField idField = new JTextField();

    private JLabel genderLabel = new JLabel("性别");
    private JRadioButton maleButton = new JRadioButton("男");
    private JRadioButton femaleButton = new JRadioButton("女");

    private JButton addButton = new JButton("添加");


    public AddEmpView() {
        setTitle("添加员工");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        empidLabel.setBounds(40, 20, 60, 20);
        empidField.setBounds(160, 20, 100, 20);

        empnameLabel.setBounds(40, 60, 60, 20);
        empnameField.setBounds(160, 60, 100, 20);

        didLabel.setBounds(40, 100, 60, 20);
        depBox.setBounds(160, 100, 100, 20);

        birthdayLabel.setBounds(40, 140, 60, 20);
        birthdayField.setBounds(160, 140, 100, 20);
        Chooser chooser = Chooser.getInstance();
        chooser.register(birthdayField);// 先注册   再添加

        phoneLabel.setBounds(40, 180, 60, 20);
        phoneField.setBounds(160, 180, 100, 20);
        checkphoneLabel.setBounds(280, 180, 30, 20);

        idLabel.setBounds(40, 220, 60, 20);
        idField.setBounds(160, 220, 100, 20);

        genderLabel.setBounds(40, 260, 60, 20);
        maleButton.setBounds(160, 260, 60, 20);
        femaleButton.setBounds(230, 260, 60, 20);

        addButton.setBounds(200, 320, 60, 20);

        add(empidLabel);
        add(empidField);

        add(empnameLabel);
        add(empnameField);

        add(birthdayLabel);
        add(birthdayField);

        add(didLabel);
        add(depBox);

        add(phoneField);
        add(phoneLabel);
        add(checkphoneLabel);

        add(idField);
        add(idLabel);

        add(genderLabel);
        add(maleButton);
        maleButton.setSelected(true);
        add(femaleButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(maleButton);
        buttonGroup.add(femaleButton);

        phoneField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String phone = phoneField.getText();
                String regex = "^1[3456789]\\d{9}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(phone);

                if (matcher.find()) {
                    checkphoneLabel.setText("√");
                } else {
                    checkphoneLabel.setText("×");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                String phone = phoneField.getText();
                String regex = "^1[3456789]\\d{9}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(phone);

                if (matcher.find()) {
                    checkphoneLabel.setText("√");
                } else {
                    checkphoneLabel.setText("×");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82", "root", "admin");
            String sql = "select depid , depname from dep";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dep dep = new Dep();
                dep.setDepid(rs.getInt(1));
                dep.setDepname(rs.getString(2));
                depBox.addItem(dep);
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


        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String empid = empidField.getText();
                String empname = empnameField.getText();
                //String did = didField.getText();
                int did = ((Dep) (depBox.getSelectedItem())).getDepid();
                String birthday = birthdayField.getText();

                //如何得到用户选择的性别
                int gender = 1;
                if (femaleButton.isSelected()) {
                    gender = 2;
                }

                Connection connection = null;
                int n = 0;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82", "root", "admin");
                    String sql = "insert into emp(empid , empname , did , birthday , gender ) values(?,?,? , ? , ?) ";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setObject(1, empid);
                    ps.setObject(2, empname);
                    ps.setObject(3, did);
                    ps.setObject(4, birthday);
                    ps.setObject(5, gender);

                    n = ps.executeUpdate();
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

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "新增成功");
                } else {
                    JOptionPane.showMessageDialog(null, "新增失败");
                }


            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        AddEmpView addEmpView = new AddEmpView();
    }
}
