package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * øµ»≠Ω∫ƒ…¡Ï∫‰
 */
public class ScheduleView extends JFrame {
	JPanel p_date, p_time, p_next;
	ScheduleDateView v_sd[];
	
	public ScheduleView() {
		setTitle("ScheduleView");
		p_date = new JPanel();
		p_time = new JPanel();
		p_next = new JPanel();
		v_sd = new ScheduleDateView[7];
		
//set layout null
		p_date.setLayout(null);
		p_time.setLayout(null);
		p_next.setLayout(null);
//add ScheduleDateView
		for(int i=0; i<v_sd.length; i++) {
			v_sd[i] = new ScheduleDateView();
			v_sd[i].setBounds(170*(i)+30, 20, 100, 80);
			p_date.add(v_sd[i]);
		}
//set Background
		p_date.setBackground(Color.orange);
		p_time.setBackground(Color.GREEN);
		p_next.setBackground(Color.CYAN);
//set Size
		p_date.setPreferredSize(new Dimension(0, 200));
		p_next.setPreferredSize(new Dimension(0, 80));
//add panel to frame
		add(p_date, BorderLayout.PAGE_START);
		add(p_time, BorderLayout.CENTER);
		add(p_next, BorderLayout.PAGE_END);
		
		setSize(1200, 800);
		setVisible(true);
	}//ª˝º∫¿⁄
	public static void main(String[] args) {
		new ScheduleView();
	}
}
