package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import java.awt.Font;
/*
 * øµ»≠Ω∫ƒ…¡Ï∫‰
 */
public class ScheduleView extends JFrame {
	public JPanel p_date, p_time, p_next;
	public JButton bt_next, bt_back;
	public JLabel la_title, la_date;
	public ScheduleDateView v_sd[];
	public ScheduleTimeView v_st[];
	boolean flag;
	LineBorder bta;
	String start="900";
	
	
	public ScheduleView() {
		setTitle("øµ»≠ Ω√∞£ º±≈√√¢");
		bta = new LineBorder(Color.WHITE,2);
		p_date = new JPanel();
		p_time = new JPanel();
		p_next = new JPanel();
		bt_next = new JButton("¡¬ºÆ º±≈√");
		bt_next.setFont(new Font("±º∏≤", Font.BOLD, 15));
		bt_next.setForeground(Color.WHITE);
		bt_next.setBackground(new Color(52,52,51));
		bt_next.setBorder(bta);
		bt_back = new JButton("øµ»≠ º±≈√");
		bt_back.setFont(new Font("±º∏≤", Font.BOLD, 15));
		bt_back.setForeground(Color.WHITE);
		bt_back.setBackground(new Color(52,52,51));
		bt_back.setBorder(bta);
		la_title = new JLabel("øµ»≠: ≈Ω¡§");
		la_title.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 18));
		la_date = new JLabel("≥Ø¬•: 18/07/03");
		la_date.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 18));
		
		v_sd = new ScheduleDateView[4];
		v_st = new ScheduleTimeView[4];
		
		
//set layout null
		p_date.setLayout(null);
		p_time.setLayout(null);
		p_next.setLayout(null);
//add ScheduleDateView
		for(int i=0; i<v_sd.length; i++) {
			v_sd[i] = new ScheduleDateView();
			v_sd[i].setBounds(250*(i)+180, 20, 100, 80);
			p_date.add(v_sd[i]);
		}
//add ScheduleTimeView
		for(int i=0; i<v_st.length; i++) {
			v_st[i] = new ScheduleTimeView(plusTime(start, i));
			v_st[i].setBounds(300*(i)+40, 140, 200, 160);
			p_time.add(v_st[i]);
		}
//set Background
		p_date.setBackground(Color.orange);
		p_time.setBackground(new Color(242,240,229));
		p_next.setBackground(new Color(29,29,28));
//set Size
		p_date.setPreferredSize(new Dimension(0, 200));
		p_next.setPreferredSize(new Dimension(0, 80));
		bt_next.setBounds(1050, 20, 105, 43);
		bt_back.setBounds(49, 20, 105, 43);
		la_title.setBounds(30, 150, 100, 30);
		la_date.setBounds(1014, 150, 136, 30);
//add panel to frame
		getContentPane().add(p_date, BorderLayout.PAGE_START);
		getContentPane().add(p_time, BorderLayout.CENTER);
		getContentPane().add(p_next, BorderLayout.PAGE_END);
		p_next.add(bt_next);
		p_next.add(bt_back);
		p_date.add(la_date);
		p_date.add(la_title);
		
		setSize(1200, 800);
		setVisible(false);
	}//ª˝º∫¿⁄
	public String plusTime(String time, int i) {
		return Integer.parseInt(time)+i*300+"";
	}
}
