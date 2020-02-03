package com.view;

import test.AddDepView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainView extends JFrame {

    private JMenuBar menuBar = new JMenuBar();

    private JMenu depMenu = new JMenu("部门管理");
    private JMenuItem addDepItem = new JMenuItem("新增部门");
    private JMenuItem deleteDepItem = new JMenuItem("删除部门");
    private JMenuItem updateDepItem = new JMenuItem("修改部门");
    private JMenuItem queryDepItem = new JMenuItem("查询部门");

    private JMenu empMenu = new JMenu("员工管理");
    private JMenuItem addEmpItem = new JMenuItem("新增员工");
    private JMenuItem deleteEmpItem = new JMenuItem("删除员工");
    private JMenuItem updateEmpItem = new JMenuItem("修改员工");
    private JMenuItem queryEmpItem = new JMenuItem("查询员工");

    public MainView(String username){
        setTitle("欢迎使用赛杰高级管理系统"+username);
        setSize(1000,600);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        menuBar.setBounds(0,0,1000,20);

        menuBar.add(depMenu);
        depMenu.add(addDepItem);
        depMenu.add(deleteDepItem);
        depMenu.add(updateDepItem);
        depMenu.add(queryDepItem);


        menuBar.add(empMenu);
        empMenu.add(addEmpItem);
        empMenu.add(deleteEmpItem);
        empMenu.add(updateEmpItem);
        empMenu.add(queryEmpItem);

        add(menuBar);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int n = JOptionPane.showConfirmDialog(null , "真的要退出","退出" , JOptionPane.YES_NO_OPTION);
                if(n==0){
                    System.exit(0);
                }
            }
        });

        addDepItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDepView();
            }
        });

        addEmpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmpView();
            }
        });

        queryDepItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDepView();
            }
        });
        setVisible(true);
    }
}
