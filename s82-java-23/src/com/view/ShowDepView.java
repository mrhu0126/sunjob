package com.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

//对话框
public class ShowDepView extends JDialog {


    private JLabel depnameLabel = new JLabel("部门名称");
    private JTextField depnameField = new JTextField();

    private JLabel depidLabel = new JLabel("部门编号");
    private JTextField depidField = new JTextField();

    private JButton updateButton = new JButton("修改");

    private JTable table = new JTable(){

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS , JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

    //构造方法
    public ShowDepView(){
        setSize(800,600);
        setLocationRelativeTo(null);
        setTitle("查找部门");
        setLayout(null);

        pane.setBounds(40, 40,700 , 400);

        depidLabel.setBounds(40 , 500 , 60 , 20 );
        depidField.setBounds(120 , 500 , 100 , 20);

        depnameLabel.setBounds(230 , 500 , 60 , 20);
        depnameField.setBounds(300 , 500 , 100 , 20);

        updateButton.setBounds(420 , 500 , 60 ,20);

        depidField.setEditable(false);

        add(depidLabel);
        add(depidField);

        add(depnameLabel);
        add(depnameField);

        add(updateButton);

        Vector<String> thVector = new Vector<String>();
        thVector.add("部门编号");
        thVector.add("部门名称");


        /*
        Vector<String> vector = new Vector<String>();
        vector.add("1");
        vector.add("小卖部");

        Vector<String> vector2 = new Vector<String>();
        vector2.add("2");
        vector2.add("麻将部");

        Vector<String> vector3 = new Vector<String>();
        vector3.add("3");
        vector3.add("宣传部");
         */

        Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
        /*
        dataVector.add(vector);
        dataVector.add(vector2);
        dataVector.add(vector3);
         */
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
            String sql ="select depid , depname from dep";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Vector<String> vector = new Vector<String>();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                dataVector.add(vector);
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


        //得到表模型
        DefaultTableModel defaultTableModel = new DefaultTableModel(dataVector , thVector);
        //把表模型赋值给表格
        table.setModel(defaultTableModel);

        //把表格加入到滚动面板中
        pane.getViewport().add(table);

        add(pane);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int count = e.getClickCount();
                if(count==2){
                    int row = table.getSelectedRow();
                    String depid = (String) table.getValueAt(row , 0);
                    String depname = (String) table.getValueAt(row , 1);

                    depidField.setText(depid);
                    depnameField.setText(depname);
                }

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String depid = depidField.getText();
                String depname = depnameField.getText();

                int row = table.getSelectedRow();

                int n = 0;
                Connection connection = null ;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                     connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    String sql ="update dep set depname = ? where depid = ? ";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setObject(1 , depname);
                    ps.setObject(2, depid);

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

                if(n==1){
                    table.setValueAt(depname , row , 1);
                    JOptionPane.showMessageDialog(null , "修改成功");
                }
            }
        });



        setVisible(true);

    }

    public static void main(String[] args) {
        new ShowDepView();
    }

}
