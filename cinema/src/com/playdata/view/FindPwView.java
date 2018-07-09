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
      bt_find.setFont(new Font("���� ���", Font.BOLD, 15));
      bt_reset = new JButton("�� ��");
      bt_reset.setFont(new Font("���� ���", Font.BOLD, 15));
      
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
      
      getContentPane().setLayout(null);
      getContentPane().add(tf_id);
      getContentPane().add(tf_hint);
      getContentPane().add(bt_find);
      getContentPane().add(bt_reset);
      getContentPane().add(la_title);
      getContentPane().add(la_id);
      getContentPane().add(la_hint);
      getContentPane().add(cb_hint);
      getContentPane().add(panel);
      
      
      setBounds(400,300,340,350);
      setVisible(false);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
   }

}



