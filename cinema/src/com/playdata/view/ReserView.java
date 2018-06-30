package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 예매뷰
 */
public class ReserView extends JFrame{
	JPanel p_ps, p_center;
	JButton bt_mypage;
	
	public ReserView() {
		setTitle("ReserView");
		p_ps = new JPanel();
		p_center = new JPanel();
		bt_mypage = new JButton("마이 페이지");
		
		setLayout(new BorderLayout());
//p_ps
		p_ps.setPreferredSize(new Dimension(0, 60));
		add(p_ps, BorderLayout.PAGE_START);
		p_ps.setLayout(null);
		p_ps.setBackground(Color.CYAN);
		bt_mypage.setBounds(1000, 10, 120, 40);
		p_ps.add(bt_mypage);
		
		add(p_center, BorderLayout.CENTER);
//p_center
		p_center.setLayout(new GridLayout(1, 4));
		p_center.add(new ReserveSubView());
		p_center.add(new ReserveSubView());
		p_center.add(new ReserveSubView());
		p_center.add(new ReserveSubView());
		
		setSize(1200, 800);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ReserView();
	}
}
