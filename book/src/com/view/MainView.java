package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JMenuBar bar = new JMenuBar();
    private JMenu bookmenu = new JMenu("图书管理");
    private JMenuItem querybook = new JMenuItem("查找图书");
    private JMenuItem returnbook = new JMenuItem("归还图书");

    public MainView(){
        setTitle("欢迎使用赛杰高级管理系统");
        setSize(800 , 600);
        setLocationRelativeTo(null);
        setLayout(null);

        bar.setBounds(0,0,800,20);
        bar.add(bookmenu);
        bookmenu.add(querybook);

        add(bar);

        querybook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowBookView();
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }


}
