package com.playdata.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class ScheduleDateView extends JToggleButton {
	JLabel la_week, la_date ;
	public ScheduleDateView() {
//		la_week = new JLabel("요일");
//		la_date = new JLabel("7 / 3");
		setLayout(null);
//setLocation
//		la_week.setBounds(35,10, 50, 30);
//		la_date.setBounds(38, 48, 80, 30);
		
//		add(la_week);
//		add(la_date);
		
		setBackground(Color.GRAY);
		setSize(100, 80);
	}//생성자
	
	public String getDate(String month, String day) {
		return month + " / " + day;
	}
}
