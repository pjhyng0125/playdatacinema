package com.playdata.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindPwView extends JFrame{
   public JTextField tf_id,tf_hint;
   public JButton bt_find,bt_reset;
   JLabel la_title,la_id,la_hint;
   public JComboBox<String> cb_hint;
   JPanel panel;
   
   
   public FindPwView() {
      
      setTitle("FindPwView");
      
      String hintT[]= {"�ʵ��б� �̸���?", "�����ϴ�å��?", "�¾����?", "��� ������?", "�����ϴ� ������?"};
      
      tf_id = new JTextField();
      tf_hint = new JTextField();
      
      bt_find = new JButton("ã ��");
      bt_reset = new JButton("�� ��");
      
      la_title = new JLabel("PWã��");
      la_id = new JLabel("*I D:");
      la_hint = new JLabel("*�����Ʈ:");
      

      
      cb_hint = new JComboBox<String>(hintT);
      
      
      tf_id.setBounds(120,130,100,25);
      tf_hint.setBounds(120,200,100,25);
      
      panel = new JPanel();
      panel.setLayout(null);
      panel.setBounds(0,0,340,70);
      panel.setBackground(Color.BLACK);
      
      la_title.setBounds(110,20,150,30);
      la_title.setFont(new Font("����", Font.PLAIN, 30));
      la_title.setForeground(Color.WHITE);
      la_id.setBounds(10,130,100,25);
      la_id.setFont(new Font("����", Font.BOLD, 18));
      la_hint.setBounds(10,170,100,25);
      la_hint.setFont(new Font("����", Font.BOLD, 18));
      
      bt_find.setBounds(50,250,90,25);
      bt_find.setBackground(Color.BLACK);
      bt_find.setForeground(Color.WHITE);
      bt_reset.setBounds(180,250,90,25);
      bt_reset.setBackground(Color.BLACK);
      bt_reset.setForeground(Color.WHITE);
      
      cb_hint.setBounds(120,170,100,25);
      
      setLayout(null);
      add(tf_id);
      add(tf_hint);
      add(bt_find);
      add(bt_reset);
      add(la_title);
      add(la_id);
      add(la_hint);
      add(cb_hint);
      add(panel);
      
      
      setBounds(400,300,340,350);
      setVisible(true);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
   }
   public static void main(String[] args) {
      new FindPwView();
   }
}



