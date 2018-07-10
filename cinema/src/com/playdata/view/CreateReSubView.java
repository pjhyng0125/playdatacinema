package com.playdata.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class CreateReSubView extends JPanel {

	public JLabel lb_movie_name,lb_runtime,lb_seat,lb_date;
	public JButton bt_cancle;
	JPanel p_center,p_runtime,p_seat,p_movie,p_date,p_bt;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	LineBorder linea;
	
	public CreateReSubView() {
		setLayout(new BorderLayout(0, 0));
		
		p_center = new JPanel();
		p_center.setBackground(Color.WHITE);
		add(p_center, BorderLayout.CENTER);
		p_center.setLayout(new GridLayout(1,6));
		
		p_movie = new JPanel();
		p_movie.setBackground(Color.LIGHT_GRAY);
		p_movie.setBorder(new BevelBorder(0, Color.black,Color.black ));
		p_center.add(p_movie);
		
		p_date  = new JPanel();
		p_date.setBackground(Color.LIGHT_GRAY);
		p_date.setBorder(new BevelBorder(0, Color.black,Color.black ));
		p_center.add(p_date);
		
		p_runtime = new JPanel();
		p_runtime.setBackground(Color.LIGHT_GRAY);
		p_runtime.setBorder(new BevelBorder(0, Color.black,Color.black ));
		p_center.add(p_runtime);
		
		lb_date = new JLabel("상영 날짜");
		p_date.add(lb_date);
		
		p_seat = new JPanel();
		p_seat.setBackground(Color.LIGHT_GRAY);
		p_seat.setBorder(new BevelBorder(0, Color.black,Color.black ));
		p_center.add(p_seat);
		
		lb_movie_name = new JLabel("영화 이름");
		p_movie.add(lb_movie_name);
		
		
		lb_runtime = new JLabel("상영시간");
		p_runtime.add(lb_runtime);
		
		lb_seat = new JLabel("좌석번호");
		p_seat.add(lb_seat);
		
		p_bt = new JPanel();
		p_bt.setBackground(Color.LIGHT_GRAY);
		p_center.add(p_bt);
		p_bt.setLayout(null);
		
		bt_cancle = new JButton("취소");
		bt_cancle.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bt_cancle.setForeground(Color.WHITE);
		bt_cancle.setBackground(Color.BLACK);
		bt_cancle.setBounds(34, 29, 61, 27);
		p_bt.add(bt_cancle);
	
		
	   setSize(637,90);
	   setVisible(true);
	
	}
	
}
