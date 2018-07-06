package com.playdata.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import java.awt.Font;

public class ScheduleTimeView extends JPanel {
	public JToggleButton tbt_time;
	JLabel la_seat;
	LineBorder bta;
	public ScheduleTimeView() {
		bta = new LineBorder(Color.white,2);//Å×µÎ¸® 
//new
		tbt_time = new JToggleButton("07:00~08:30");
		tbt_time.setForeground(Color.WHITE);
		tbt_time.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		tbt_time.setBorder(bta);	
		la_seat = new JLabel("0 / 20¼®");
		
		
		
//panel set
		setBackground(Color.GRAY);
		setLayout(null);
		tbt_time.setBounds(20, 20, 160, 80);
		tbt_time.setBackground(new Color(52,52,51));
		la_seat.setBounds(80, 110, 60, 30);
//add
		add(tbt_time);
		add(la_seat);
		setSize(200,160);
	}
}
