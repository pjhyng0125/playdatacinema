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
/*
 * ��ȭ�������
 */
public class ScheduleView extends JFrame {
	public JPanel p_date, p_time, p_next;
	public JButton bt_next, bt_back;
	public JLabel la_title, la_date;
	public ScheduleDateView v_sd[];
	public ScheduleTimeView v_st[];
	boolean flag;
	
	
	public ScheduleView() {
		setTitle("ScheduleView");
		p_date = new JPanel();
		p_time = new JPanel();
		p_next = new JPanel();
		bt_next = new JButton("�¼� ����");
		bt_back = new JButton("��ȭ ����");
		la_title = new JLabel("��ȭ: Ž��");
		la_date = new JLabel("��¥: 18/07/03");
		
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
			v_st[i] = new ScheduleTimeView();
			v_st[i].setBounds(300*(i)+40, 140, 200, 160);
			p_time.add(v_st[i]);
		}
//set Background
		p_date.setBackground(Color.orange);
		p_time.setBackground(Color.GREEN);
		p_next.setBackground(Color.CYAN);
//set Size
		p_date.setPreferredSize(new Dimension(0, 200));
		p_next.setPreferredSize(new Dimension(0, 80));
		bt_next.setBounds(1050, 25, 100, 30);
		bt_back.setBounds(50, 25, 100, 30);
		la_title.setBounds(30, 150, 100, 30);
		la_date.setBounds(1050, 150, 100, 30);
//add panel to frame
		add(p_date, BorderLayout.PAGE_START);
		add(p_time, BorderLayout.CENTER);
		add(p_next, BorderLayout.PAGE_END);
		p_next.add(bt_next);
		p_next.add(bt_back);
		p_date.add(la_date);
		p_date.add(la_title);
		
		setSize(1200, 800);
		setVisible(false);
	}//������
}
