package jm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Text extends JFrame {
    private JButton button=new JButton("按钮一");
    private JButton button2=new JButton("按钮二");
    private JLabel label=new JLabel("你好");
    private JTextField a=new JTextField();
    private JScrollPane pane=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private JTable table=new JTable();
    public Text() {
        setTitle("ahh");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        button.setBounds(100, 50, 100, 40);
        button2.setBounds(100, 90, 100, 40);
        pane.setBounds(205, 50, 400, 300);
        a.setBounds(700,50,100,40);
        label.setBounds(700,100,100,40);

        add(button);
        add(button2);

button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        pane.getViewport().add(table);
        add(pane);
    }
});
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        add(a);
        add(label);
    }
});
        setVisible(true);
    }
    public static void main(String[] args) {
        Text t=new Text();
    }
}
