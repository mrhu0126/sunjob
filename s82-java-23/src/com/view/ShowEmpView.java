package com.view;

import com.pojo.Dep;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

public class ShowEmpView extends JDialog {

    private JTable table = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS , JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

    private JButton deleteButton = new JButton("删除");

    private JButton updateButton = new JButton("修改");

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

    public ShowEmpView(){
        setSize(800,600);
        setLocationRelativeTo(null);
        setTitle("查找员工");
        setLayout(null);

        pane.setBounds(40, 40,700,350);

        empidLabel.setBounds(40,410,60,20);
        empidField.setBounds(120,410,120,20);

        empnameLabel.setBounds(260,410,60,20);
        empnameField.setBounds(340,410,120,20);

        didLabel.setBounds(480,410,60,20);
        depBox.setBounds(560,410,120,20);

        //查找所有部门   加入下拉列表中
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
            String sql = "select depid , depname from dep";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
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





        birthdayLabel.setBounds(40,450,60,20);
        birthdayField.setBounds(120,450,120,20);

        phoneLabel.setBounds(260,450,60,20);
        phoneField.setBounds(340,450,120,20);

        idLabel.setBounds(480,450,60,20);
        idField.setBounds(560,450,120,20);

        genderLabel.setBounds(40,490,60,20);
        maleButton.setBounds(120,490,60,20);
        femaleButton.setBounds(200,490,60,20);

        deleteButton.setBounds(400, 490,60,20 );

        updateButton.setBounds(560,490,60,20);

        empidField.setEditable(false);

        add(empidLabel);
        add(empidField);

        add(empnameLabel);
        add(empnameField);

        add(didLabel);
        add(depBox);

        add(birthdayLabel);
        add(birthdayField);

        add(phoneLabel);
        add(phoneField);

        add(idLabel);
        add(idField);

        add(genderLabel);
        add(maleButton);
        add(femaleButton);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(maleButton);
        buttonGroup.add(femaleButton);

        Vector<String> thVector = new Vector<String>();
        thVector.add("员工编号");
        thVector.add("员工名称");
        thVector.add("所在部门");
        thVector.add("出生日期");
        thVector.add("电话号码");
        thVector.add("身份证");
        thVector.add("性别");

        Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

        Connection connection2 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
            String sql ="select empid , empname , depname , birthday , phone , id , gender from emp , dep where emp.did=dep.depid";
            PreparedStatement ps = connection2.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            System.out.println(2);
            while(rs.next()){
                System.out.println(1);
                Vector<String> vector = new Vector<String>();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                vector.add(rs.getString(6));
                vector.add(rs.getString(7).equals("1") ? "男" : "女");
                dataVector.add(vector);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //设置表头不可以重新排序
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();// 渲染
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class , cellRenderer);

        DefaultTableModel defaultTableModel = new DefaultTableModel(dataVector, thVector);

        table.setModel(defaultTableModel);

        //把表格加入到滚动面板中
        pane.getViewport().add(table);

        add(pane);

        add(deleteButton);

        add(updateButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(null , "请选中先!");
                    return ;
                }

                //根据编号删除
                String empid = (String) table.getValueAt(row , 0);

                //先从数据库删除
                int n = 0;
                Connection  connection=null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    String sql ="delete from emp where empid = ?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setObject(1 , empid);

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

                if(n>0){

                    DefaultTableModel  model = (DefaultTableModel) table.getModel();
                    model.removeRow(row);
                    model.fireTableDataChanged();//刷新表格

                    JOptionPane.showMessageDialog(null, "删除成功！");

                }else{
                    JOptionPane.showMessageDialog(null, "删除失败！");
                }




            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int count = e.getClickCount();
                if(count==2){
                    int row = table.getSelectedRow();
                    String empid = (String) table.getValueAt(row , 0);
                    String empname = (String) table.getValueAt(row , 1);
                    String depname = (String) table.getValueAt(row , 2);
                    String birthday = (String) table.getValueAt(row , 3);
                    String phone = (String) table.getValueAt(row , 4);
                    String id = (String) table.getValueAt(row , 5);
                    String gender = (String) table.getValueAt(row , 6);

                    empidField.setText(empid);
                    empnameField.setText(empname);
                    //didLabel.setText(depname);
                    //改部门
                    int c = depBox.getItemCount();
                    System.out.println(c);
                    for(int i = 0 ;i<c ;i++){
                        if(depname.equals(((Dep)depBox.getItemAt(i)).getDepname())){
                            depBox.setSelectedIndex(i);//设置为选中项
                            break;
                        }
                    }


                    birthdayField.setText(birthday);
                    phoneField.setText(phone);
                    idField.setText(id);
                   // genderLabel.setText(gender);
                    if(gender.equals("男")){
                        maleButton.setSelected(true);
                    }else{
                        femaleButton.setSelected(true);
                    }



                }

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empid = empidField.getText();
                String empname = empnameField.getText();
                String depname = didLabel.getText();
                String birthday = birthdayField.getText();
                String phone = phoneField.getText();
                String id = idField.getText();
                String gender = genderLabel.getText();

                int row = table.getSelectedRow();

                int n = 0 ;
                Connection connection1 = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    String sql = "update emp set empname = ?,depname = ?,birthday = ?,phone = ?,id = ?,gender = ? where empid = ?";
                    PreparedStatement ps = connection1.prepareStatement(sql);
                    ps.setObject(1,empname);
                    ps.setObject(2,depBox);
                    ps.setObject(3,birthday);
                    ps.setObject(4,phone);
                    ps.setObject(5,id);
                    ps.setObject(6,gender);
                    ps.setObject(7,empid);
                    n = ps.executeUpdate();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        connection1.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if(n==1){
                    table.setValueAt(empname , row , 1);
                    JOptionPane.showMessageDialog(null , "修改成功");
                }

            }
        });

        setVisible(true);


    }

    public static void main(String[] args) {
        new ShowEmpView();
    }


}
