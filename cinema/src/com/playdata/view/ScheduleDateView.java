package com.playdata.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScheduleDateView extends JPanel {
	JLabel la_week, la_date ;
	public ScheduleDateView() {
		la_week = new JLabel("����");
		la_date = new JLabel("7 / 3");
		
		setLayout(null);
//setLocation
		la_week.setBounds(20,20, 50, 30);
		la_week.setBounds(20,60, 80, 30);
		
		setBackground(Color.GRAY);
		setSize(100, 80);
	}//������
	
	public String getDate(String month, String day) {
		return month + " / " + day;
	}
}
