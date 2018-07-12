package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import java.awt.Font;
/*
 * ¿µÈ­½ºÄÉÁìºä
 */
public class ScheduleView extends JFrame {
	public JPanel p_date, p_time, p_next;
	public JButton bt_next, bt_back;
	public JLabel la_title, la_date;
	public JLabel la_logo, la_cinema,la_screenCode;
	public ScheduleDateView v_sd[];
	public ScheduleTimeView v_st[];
	boolean flag;
	LineBorder bta;
	String start="900";
	ImageIcon icon1;
	
	
	public ScheduleView() {
		setTitle("¿µÈ­ ½Ã°£ ¼±ÅÃÃ¢");
		bta = new LineBorder(Color.WHITE,2);
		p_date = new JPanel();
		p_time = new JPanel();
		p_next = new JPanel();
		bt_next = new JButton("ÁÂ¼® ¼±ÅÃ");
		bt_next.setFont(new Font("±¼¸²", Font.BOLD, 15));
		bt_next.setForeground(Color.WHITE);
		bt_next.setBackground(new Color(52,52,51));
		bt_next.setBorder(bta);
		bt_back = new JButton("¿µÈ­ ¼±ÅÃ");
		bt_back.setFont(new Font("±¼¸²", Font.BOLD, 15));
		bt_back.setForeground(Color.WHITE);
		bt_back.setBackground(new Color(52,52,51));
		bt_back.setBorder(bta);
		la_title = new JLabel("¿µÈ­: Å½Á¤");
		la_title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		la_date = new JLabel("³¯Â¥: 18/07/03");
		la_date.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		la_screenCode = new JLabel("1»ó¿µ°ü/");
		la_screenCode.setBounds(30, 150, 80, 30);
		la_screenCode.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		
		v_sd = new ScheduleDateView[4];
		v_st = new ScheduleTimeView[4];
		
		icon1 = new ImageIcon("image/logo.png");
		la_logo = new JLabel(icon1);
		la_logo.setBounds(1100, 620, 50, 50);
		la_cinema = new JLabel("Cinema");
		la_cinema.setBounds(1025, 620, 100, 50);
		la_cinema.setFont(new Font("µµ¿ò", Font.HANGING_BASELINE, 20));
		
		
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
			
			add(la_logo);
			add(la_cinema);
			
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
		p_date.add(la_screenCode);
		
		bt_next.setEnabled(false);
		
		
		setSize(1200, 800);
		setVisible(false);
	}//»ý¼ºÀÚ
	public String plusTime(String time, int i) {
		return Integer.parseInt(time)+i*300+"";
	}
	
	public void setDefaulttbt() {
		for(int i=0; i<v_sd.length; i++) {
			v_sd[i].setSelected(false);
			v_st[i].tbt_time.setSelected(false);
		}
	}
	
	public String timeCount(String screen_time,int run_time) {
		String[] screen_timeArray = screen_time.split(":");
		int hour = Integer.parseInt(screen_timeArray[0]);
		int minute = Integer.parseInt(screen_timeArray[1]);
		
		int plusHour = run_time/60;
		int plusMinute = run_time%60;
		
		hour += plusHour;
		minute += plusMinute;
		
		String returnTime="";
		if(hour<10) {
			returnTime += ("0"+hour);
		}else {
			returnTime += hour;
		}
		if(minute<10) {
			returnTime += (":0"+minute);
		}else {
			returnTime += ":"+minute;
		}
		System.out.println("½ÃÀÛ½Ã°£: "+screen_time+" \n³¡½Ã°£: "+returnTime);
		return screen_time+"~"+returnTime;
	}
}
