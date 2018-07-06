package com.playdata.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindIdView extends JFrame{
	public JTextField tf_name,tf_email1,tf_email2;
	public JButton bt_find,bt_reset;
	JLabel la_title,la_name,la_email;
	JLabel at[];
	JPanel panel;
	public JComboBox<String> cb_email;
	
	
	public FindIdView() {
		
		setTitle("FindPwView");	
		
		at = new JLabel[1];
		for(int i=0; i<at.length; i++)
		{
			at[i]=new JLabel("@");
		}
		
		String emailT[]= {"naver.com", "gmail.com", "yahoo.com", "daum.net"};
		
		tf_name = new JTextField();
		tf_email1 = new JTextField();
		tf_email2 = new JTextField();
		
		
		bt_find = new JButton("찾기");
		bt_reset = new JButton("취소");
		
		la_title = new JLabel("ID찾기");
		la_name = new JLabel("이 름:");
		la_email = new JLabel("이메일:");
		
		cb_email = new JComboBox<String>(emailT);
	    
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,380,70);
		panel.setBackground(Color.BLACK);

		tf_name.setBounds(80,130,80,25);
	    tf_email1.setBounds(80,180,80,25);
	    at[0].setBounds(163,180,25,25);
	    tf_email2.setBounds(180,180,70,25);
	    
	    
	    la_title.setBounds(140,20,150,30);
        la_title.setFont(new Font("돋움", Font.PLAIN, 30));
	    la_title.setForeground(Color.WHITE);
        la_name.setBounds(20,130,100,25);
	    la_email.setBounds(20,180,100,25);
	       
	    bt_find.setBounds(70,250,90,25);
	    bt_find.setBackground(Color.BLACK);
	    bt_find.setForeground(Color.WHITE);
        bt_reset.setBounds(200,250,90,25);
	    bt_reset.setBackground(Color.BLACK);
        bt_reset.setForeground(Color.WHITE);
        
        cb_email.setBounds(260,180,100,25);
        
        
        setLayout(null);
        add(tf_name);
        add(tf_email1);
        add(tf_email2);
        add(bt_find);
        add(bt_reset);
        add(la_title);
        add(la_name);
        add(la_email);
        add(panel);
        add(cb_email);
        
        for(int i=0; i<at.length; i++)
		{
			add(at[i]);
		}
		
		setBounds(400,300,380,350);
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FindIdView();
	}

}

