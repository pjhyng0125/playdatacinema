package com.playdata.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FindIdPwView extends JFrame{
	public JButton bt_id, bt_pw, bt_cancel;
	JLabel la_logo;
	JPanel panel;
	ImageIcon icon1;
	

	public FindIdPwView() {
		setTitle("FindIdPwView");
		
		icon1 = new ImageIcon("image/logo.png");
		la_logo = new JLabel(icon1);
		la_logo.setBounds(230, 210, 50, 50);
		
		bt_id = new JButton("ID찾기");
		bt_pw = new JButton("PW찾기");
		bt_cancel = new JButton("취소");
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 300, 300);
		panel.setBackground(Color.LIGHT_GRAY);
		
		bt_id.setBounds(100,20,90,60);
		bt_id.setBackground(Color.black);
		bt_id.setForeground(Color.white);
		bt_pw.setBounds(100,100,90,60);
		bt_pw.setBackground(Color.black);
		bt_pw.setForeground(Color.white);
		bt_cancel.setBounds(100,180,90,60);
		bt_cancel.setBackground(Color.BLACK);
		bt_cancel.setForeground(Color.white);
		
		
		setLayout(null);
		add(bt_id);
		add(bt_pw);
		add(bt_cancel);
		add(la_logo);
		add(panel);
		
		setBounds(400,300,300,300);
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}