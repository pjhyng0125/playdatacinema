package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * 작성자: 박진형
 * 수정일자: 07/01 12:20
 * 클래스 기능: ReserView 안에 1행4열로 배치될 SubView
 */
public class ReserveSubView extends JPanel {
	JButton bt_reserve;
	JLabel la_image, la_title, la_percent, la_genre;
	JLabel []la_stars;
	JPanel p_ps, p_center, p_stars;
	
	public ReserveSubView() {
		bt_reserve = new JButton("지금 예매");
		la_image = new JLabel("la_image");
		la_image.setBackground(Color.yellow);
		la_title = new JLabel("앤트맨과 와스프");
		la_percent = new JLabel("예매율 35.5%");
		la_genre = new JLabel("코미디액션");
		la_stars = new JLabel[5];

//Label 정렬
		la_title.setHorizontalAlignment(JLabel.CENTER);
		la_percent.setHorizontalAlignment(JLabel.CENTER);
		la_genre.setHorizontalAlignment(JLabel.CENTER);
		
		p_ps = new JPanel();
		p_center = new JPanel();
		p_stars = new JPanel();
		
		for(int i=0; i<la_stars.length; i++) {
			la_stars[i] = new JLabel("*");
			la_stars[i].setBackground(Color.yellow);
		}
		
		setLayout(new BorderLayout());
//p_ps
		p_ps.setPreferredSize(new Dimension(0, 300));
		add(p_ps, BorderLayout.PAGE_START);
		p_ps.add(la_image);
//p_center
		add("Center",p_center);
		p_center.setLayout(new GridLayout(5, 1));
			p_center.add(la_title);
			p_center.add(la_percent);
			p_center.add(la_genre);
		p_center.add(p_stars);
//p_stars
		for(int i=0; i<la_stars.length; i++)
			p_stars.add(la_stars[i]);
		p_center.add(bt_reserve);
		
		
		setBackground(Color.BLUE);
		setSize(300, 740);
	}
}
