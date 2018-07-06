package com.playdata.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame
{
    public JTextField tf_id;
    public JPasswordField tf_pass;
    public JButton bt_login,bt_join,bt_find;
	JLabel la_id, la_pass, la_title;
	JPanel panel;
	
  public LoginView()
	{		
		setTitle("LoginView");
		
		tf_id = new JTextField();			  
		tf_pass = new JPasswordField();
		
		bt_login = new JButton("로그인");
		bt_join = new JButton("회원가입");
		bt_find = new JButton("ID/PW찾기");
	
	    la_id = new JLabel("I  D");
		la_pass = new JLabel("P W");
		la_title = new JLabel("로그인");
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,300,50);
		panel.setBackground(Color.BLACK);
		
		tf_id.setBounds(70,120,100,45);
		tf_pass.setBounds(70,180,100,45);
		bt_login.setBounds(180,140,100,60);
		bt_login.setBackground(Color.BLACK);
		bt_login.setForeground(Color.WHITE);
		bt_join.setBounds(160,270,100,60);
		bt_join.setBackground(Color.BLACK);
		bt_join.setForeground(Color.WHITE);
		bt_find.setBounds(40,270,100,60);
		bt_find.setBackground(Color.BLACK);
		bt_find.setForeground(Color.WHITE);
		la_id.setBounds(20,130,90,25);
		la_id.setFont(new Font("Serif", Font.BOLD, 18));
		la_pass.setBounds(20,190,90,25);
		la_pass.setFont(new Font("Serif", Font.BOLD, 18));
		la_title.setBounds(105,10,130,30);
		la_title.setFont(new Font("돋움", Font.PLAIN, 30));
		la_title.setForeground(Color.WHITE);
		
		setLayout(null);
		add(tf_id);
		add(tf_pass);
		add(bt_login);
		add(bt_join);
		add(bt_find);
		add(la_id);
		add(la_pass);
		add(panel);
		panel.add(la_title);
		
		setBounds(400,300,300,400);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//생성자
  
  	public void showMsg(String msg) {
  		JOptionPane.showMessageDialog(this, msg);
  	}
  	
  	public int showConfirm(String msg) {
  		int num = JOptionPane.showConfirmDialog(this, msg);
  		return num; //0->예, 1->아니오, 2->취소
  	}
  	public void setEmpty() {
  		tf_id.setText("");
  		tf_pass.setText("");
  	}
      
}//LoginForm
