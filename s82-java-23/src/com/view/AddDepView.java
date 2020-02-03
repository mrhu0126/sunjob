package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddDepView extends JDialog {
    private JLabel depnameLabel = new JLabel("部门名称");
    private JTextField depnameField = new JTextField();

    private JLabel depidLabel = new JLabel("部门编号");
    private JTextField depidField = new JTextField();

    private JButton depButton = new JButton("添加");


    public AddDepView(){
        setTitle("新增部门");
        setSize(600,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setModal(true);//模式对话框

        depnameLabel.setBounds(80,60,80,20);
        depnameField.setBounds(200,60,120,20);

        depidLabel.setBounds(80,120,80,20);
        depidField.setBounds(200,120,120,20);

        depButton.setBounds(210,250,80,20);

        add(depnameLabel);
        add(depnameField);

        add(depidLabel);
        add(depidField);

        add(depButton);
        depButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String depid = depidField.getText();
                String depname = depnameField.getText();

                Connection connection = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    String sql ="insert into dep(depid , depname ) values(?,?) ";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setObject(1 , depid);
                    ps.setObject(2, depname);

                    int n = ps.executeUpdate();

                    if(n>0){
                        JOptionPane.showMessageDialog(null , "新增成功");
                    }else{
                        JOptionPane.showMessageDialog(null , "新增失败");
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
}
