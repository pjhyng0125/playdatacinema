package com.playdata.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ScheduleTimeView extends JPanel {
	public JToggleButton tbt_time;
	public JLabel la_seat;
	public ScheduleTimeView() {
//new
		tbt_time = new JToggleButton("07:00~08:30");
		la_seat = new JLabel("0 / 20¼®");
//panel set
		setBackground(Color.GRAY);
		setLayout(null);
		tbt_time.setBounds(20, 20, 160, 80);
		la_seat.setBounds(80, 110, 60, 30);
//add
		add(tbt_time);
		add(la_seat);
		setSize(200,160);
	}
}