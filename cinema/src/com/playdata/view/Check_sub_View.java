package com.playdata.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Check_sub_View extends JPanel {
	// 초기 작성자 : 이성훈 
	// check view 구성 뷰
	
	//	    번호       영화제목  관람일자   장소
 	JLabel la_num, la_name, la_date, la_screen;
 	public JButton bt_cancel;
	
	public Check_sub_View() {
		
		la_num = new JLabel("1");
		la_num.setBounds(5, 10, 20, 40);
		la_name = new JLabel("영화이름");
		la_name.setBounds(30, 10, 200, 40);
		la_date = new JLabel("2018/06/18");
		la_date.setBounds(130, 10, 200, 40);
		la_screen = new JLabel("a상영관 b열 3석");
		la_screen.setBounds(250, 10, 200, 40);
		bt_cancel = new JButton("취소");
		bt_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bt_cancel.setForeground(Color.WHITE);
		bt_cancel.setBackground(Color.BLACK);
		bt_cancel.setBounds(370, 10, 60, 40);
		
		setLayout(null);
		add(la_num);
		add(la_name);
		add(la_date);
		add(la_screen);
		add(bt_cancel);
		
		setSize(450, 60);
		setVisible(false);
	}
	

}
