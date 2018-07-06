package com.playdata.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Font;

public class ScheduleDateView extends JToggleButton {
	JLabel la_week, la_date ;
	public ScheduleDateView() {
		la_week = new JLabel("¿äÀÏ");
		la_week.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		la_week.setForeground(Color.WHITE);
		la_date = new JLabel("7 / 3");
		la_date.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		la_date.setForeground(Color.WHITE);
		setLayout(null);
//setLocation
		la_week.setBounds(35,10, 50, 30);
		la_date.setBounds(38, 48, 80, 30);
		
		add(la_week);
		add(la_date);
		
		setBackground(new Color(52,52,51));
		setSize(100, 80);
	}//»ý¼ºÀÚ
	
	public String getDate(String month, String day) {
		return month + " / " + day;
	}
}
