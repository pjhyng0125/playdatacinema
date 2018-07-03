package com.playdata.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScheduleTimeView extends JPanel {
	JButton bt_time;
	JLabel la_seat;
	public ScheduleTimeView() {
//new
		bt_time = new JButton("07:00~08:30");
		la_seat = new JLabel("0 / 20¼®");
//panel set
		setBackground(Color.GRAY);
		setLayout(null);
		bt_time.setBounds(20, 20, 160, 80);
		la_seat.setBounds(80, 110, 60, 30);
//add
		add(bt_time);
		add(la_seat);
		setSize(200,160);
	}
}
