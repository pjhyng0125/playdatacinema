package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * 영화스케쥴뷰
 */
public class ScheduleView extends JFrame {
	public JPanel p_date, p_time, p_next;
	public JButton bt_next;
	public JLabel la_title, la_date;
	public ScheduleDateView v_sd[];
	public ScheduleTimeView v_st[];
	boolean flag;
	
	
	public ScheduleView() {
		setTitle("ScheduleView");
		p_date = new JPanel();
		p_time = new JPanel();
		p_next = new JPanel();
		bt_next = new JButton("좌석 선택");
		la_title = new JLabel("영화: 탐정");
		la_date = new JLabel("날짜: 18/07/03");
		
		v_sd = new ScheduleDateView[7];
		v_st = new ScheduleTimeView[8];
		
		
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
//add ScheduleTimeView
		for(int i=0; i<v_st.length; i++) {
			v_st[i] = new ScheduleTimeView();
			if(i>3)
				v_st[i].setBounds(300*(i-4)+40, 270, 200, 160);
			else
				v_st[i].setBounds(300*(i)+40, 50, 200, 160);
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
		la_title.setBounds(50, 150, 100, 30);
		la_date.setBounds(1050, 150, 100, 30);
//add panel to frame
		add(p_date, BorderLayout.PAGE_START);
		add(p_time, BorderLayout.CENTER);
		add(p_next, BorderLayout.PAGE_END);
		p_next.add(bt_next);
		p_date.add(la_date);
		p_date.add(la_title);
		
		setSize(1200, 800);
		setVisible(false);
	}//생성자
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/03 20:32
	 * 이벤트리스너 기능: ScheduleDateView num check
	 */
	public void canChecksDate() {	//한개면 그것 빼고 다 Enable(false) & 0개면 다 Enable(true) 
//		int checked = -1;
//		int count = 0;
//		for(int i=0; i<v_sd.length; i++)
//			if(v_sd[i].isSelected()) {
//				checked = i;
//				count++;
//			}
//		
//		for(int i=0; i<v_sd.length; i++) {
//			if(count == 1)
//				if(checked != i)
//					v_sd[i].setEnabled(false);
//			else if(count == 0)
//					v_sd[i].setEnabled(true);
//		}
	}
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/03 20:32
	 * 이벤트리스너 기능: ScheduleTimeView num check
	 */
	public boolean canChecksTime() {
		int n = 0;
		flag = true;
		for(int i=0; i<v_st.length; i++)
			if(v_st[i].tbt_time.isSelected())
				n++;
		if(n>1)
			flag = false;
		return flag;
	}

}
