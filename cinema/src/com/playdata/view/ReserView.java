package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 예매뷰
 */
public class ReserView extends JFrame{
	public JPanel p_ps, p_center;
	public JButton bt_mypage;
	public ReserveSubView subv_reserve[];
	
	public ReserView() {
		setTitle("ReserView");
		p_ps = new JPanel();
		p_center = new JPanel();
		bt_mypage = new JButton("마이 페이지");
		subv_reserve = new ReserveSubView[4];
		
		
		
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
//		p_center.add(new ReserveSubView());
//		p_center.add(new ReserveSubView());
//		p_center.add(new ReserveSubView());
//		p_center.add(new ReserveSubView());
		for(int i=0; i<subv_reserve.length; i++) {
			subv_reserve[i] = new ReserveSubView();
			p_center.add(subv_reserve[i]);
		}
		
		setSize(1200, 800);
		setVisible(false);
	}//생성자
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/01 12:34
	 * 이벤트리스너 기능: ReserveSubView에서 토글버튼 상태변경 & 이미지변경
	 */
	public void setstarSelected(int checked_i, int checked_j) {
		for(int k=0; k<subv_reserve[checked_i].tbt_stars.length; k++) {
			if(k<=checked_j) {
				subv_reserve[checked_i].tbt_stars[k].setSelected(true);
				subv_reserve[checked_i].tbt_stars[k].setIcon(new ImageIcon("image/star_yellow.png"));
			}
			else {
				subv_reserve[checked_i].tbt_stars[k].setSelected(false);
				subv_reserve[checked_i].tbt_stars[k].setIcon(new ImageIcon("image/star_blank.png"));
			}
		}
	}//setstarSelected
}
