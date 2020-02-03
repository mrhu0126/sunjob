package com.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ShowBookView extends JDialog {

    private JTable jTable = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return  false ;
        }
    };

    private JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JLabel idLabel = new JLabel("图书编号");
    private JTextField idField = new JTextField();

    private JLabel nameLabel = new JLabel("书名");
    private JTextField nameField = new JTextField();

    private JButton selectButton = new JButton("查找");

    private JLabel readeridLabel = new JLabel("读者编号");
    private JTextField readeridField = new JTextField();

    private JButton borrowButton = new JButton("借阅");

    public ShowBookView(){
        setTitle("查找图书");
        setSize(600 , 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setModal(true);

        idLabel.setBounds(30,50,60,20);
        idField.setBounds(100,50,120,20);

        nameLabel.setBounds(250,50,60,20);
        nameField.setBounds(290,50,120,20);

        selectButton.setBounds(490,50,60,20);

        readeridLabel.setBounds(50,410,60,20);
        readeridField.setBounds(120,410,120,20);

        borrowButton.setBounds(450,410,60,20);

        add(idLabel);
        add(idField);

        add(nameLabel);
        add(nameField);

        add(selectButton);

        add(readeridLabel);
        add(readeridField);

        add(borrowButton);

        //处理表模型
        Vector<String> thVector = new Vector<String>();
        thVector.add("图书编号");
        thVector.add("图书名称");
        thVector.add("价格");
        thVector.add("出版社");
        thVector.add("状态");

        //表数据
        Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

        Connection connection = null ;
        try {
            //JDBC
            Class.forName("com.mysql.jdbc.Driver");
            connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
            String sql = "select bookid , bookname , price , bookcbs , status from book";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){//   循环一次表示有一条记录   有一条记录就要有个小集合
                Vector<String> vector = new Vector<String>();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getFloat(3)+"" );
                vector.add(rs.getString(4));
                vector.add(rs.getInt(5)==1?"在馆":"不在馆");
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

        DefaultTableModel defaultTableModel = new DefaultTableModel(dataVector , thVector);
        jTable.setModel(defaultTableModel);//  把表模型给表格

        pane.setBounds(20 , 100 , 550 , 280);
        pane.getViewport().add(jTable);
        add(pane);

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int row = jTable.getSelectedRow();

                if(e.getClickCount()==2){
                    //借阅
                    String bookid = (String) jTable.getValueAt(row , 0);
                    String bookname = (String) jTable.getValueAt(row , 1);
                    String bookprice = (String) jTable.getValueAt(row , 2);
                    String bookcbs = (String) jTable.getValueAt(row , 3);


                    idField.setText(bookid);
                    nameField.setText(bookname);
                    //priceField.setText(bookprice);
                    //cbsField.setText(bookcbs);
                }
            }
        });

//        borrowButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                String bookid = idField.getText();
//                String readerid = readeridField.getText();
//
//                //借书时间
//                Date date =new Date();
//                Connection connection1 = null;
//                try {
//                    //状态  默认
//                    Class.forName("com.mysql.jdbc.Driver");
//                    connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
//                    String sql = "insert into borrow(readerid , bookid , bdate , status) values(? , ? , ? , 1)";
//
//                    PreparedStatement ps = connection1.prepareStatement(sql);
//                    ps.setObject(1 , readerid);
//                    ps.setObject(2 , bookid);
//                    ps.setObject(3 , date);
//
//                    int n = ps.executeUpdate();
//
//                    if(n>0){
//                        JOptionPane.showMessageDialog(null , "借阅成功");
//
//                        Class.forName("com.mysql.jdbc.Driver");
//                        Connection connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
//                        String sql2 = "update book set status = 0 where bookid = ?";
//
//                        PreparedStatement ps2 = connection2.prepareStatement(sql2);
//                        ps2.setObject(1 , bookid);
//
//                        int m = ps2.executeUpdate();
//
//                        //刷新界面
//                        if(m>0){
//                            int row = jTable.getSelectedRow();
//                            jTable.setValueAt("不在馆" , row , 4);
//                        }
//
//
//
//
//                    }
//                } catch (ClassNotFoundException ex) {
//                    ex.printStackTrace();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                } finally {
//                    try {
//                        connection1.close();
//                    } catch (SQLException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//
//
//
//
//
//            }
//        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String bookid = idField.getText();
                String bookname = nameField.getText();
                Connection connection = null ;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection  =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s82","root","admin");
                    StringBuffer sb = new StringBuffer("select bookid , bookname , price , bookcbs , status from book where 1=1 ");

                    List list = new ArrayList();

                    if(bookid!=null && bookid.trim().length()>0){
                        sb.append(" and bookid = ? ");
                        list.add(bookid);
                    }

                    if(bookname!=null && bookname.trim().length()>0){
                        sb.append(" and bookname like ? ");
                        list.add("%"+bookname+"%");
                    }

                    PreparedStatement ps = connection.prepareStatement(sb.toString());

                    for(int i = 0 ; i < list.size() ; i++){
                        ps.setObject(i+1 , list.get(i));
                    }

                    ResultSet rs = ps.executeQuery();

                    //表格种原有的数据清除
                    defaultTableModel.getDataVector().clear();

                    //把查询的结果加入表格
                    while(rs.next()){
                        Vector<String> vector = new Vector<String>();
                        vector.add(rs.getString(1));
                        vector.add(rs.getString(2));
                        vector.add(rs.getFloat(3)+"" );
                        vector.add(rs.getString(4));
                        vector.add(rs.getInt(5)==1?"在馆":"不在馆");
                        defaultTableModel.addRow(vector);
                    }

                    defaultTableModel.fireTableDataChanged();
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
        ShowBookView showBookView = new ShowBookView();
    }
}
