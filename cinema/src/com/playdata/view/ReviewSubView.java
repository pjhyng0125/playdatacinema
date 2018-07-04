package com.playdata.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ReviewSubView extends JPanel {
	public JLabel la_id, la_content;
	public JToggleButton []tbt_stars;
	String id, content;
	int star;
	
	public ReviewSubView(String id, String content, int star) {
		this.id = id;
		this.content = content;
		this.star = star;
		
		la_id = new JLabel(id);
		la_content = new JLabel(content);
		tbt_stars = new JToggleButton[5];
		setLayout(null);
		
//tbt_starts 배열 이미지 삽입 & 버튼 투명 적용
	for(int i=0; i<tbt_stars.length; i++) {
		tbt_stars[i] = new JToggleButton(new ImageIcon("image/star_blank.png"));
		tbt_stars[i].setBorderPainted(false);	//tbt Border 없애주기
		tbt_stars[i].setContentAreaFilled(false);	//tbt 내용영역 채우지 않음
		tbt_stars[i].setFocusPainted(false);	//tbt 선택 테두리 사용 안함
		}
//p_stars
		la_id.setBounds(50, 30, 80, 20);
		la_id.setBackground(Color.CYAN);
		la_content.setBounds(50, 70, 400, 20);
		la_content.setBackground(Color.gray);
		add(la_id);
		add(la_content);
		
		for(int i=0; i<tbt_stars.length; i++) {
			tbt_stars[i].setBounds(50*(i)+500, 30, 50, 50);
			add(tbt_stars[i]);
		}
		
		setBackground(Color.PINK);
		setSize(1000,100);
	}
	
	public void setstarSelected(int checked) {
		for(int k=0; k<tbt_stars.length; k++) {
			if(k<=checked) {
				tbt_stars[k].setSelected(true);
				tbt_stars[k].setIcon(new ImageIcon("image/star_yellow.png"));
			}
			else {
				tbt_stars[k].setSelected(false);
				tbt_stars[k].setIcon(new ImageIcon("image/star_blank.png"));
			}
		}
	}//setstarSelected
}
