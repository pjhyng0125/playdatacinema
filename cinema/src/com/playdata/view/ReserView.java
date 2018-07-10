package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.playdata.model.client.Client;

import java.awt.Font;
/*
 * 예매뷰
 */
public class ReserView extends JFrame{
	public JPanel p_ps, p_center;
	public JButton bt_mypage, bt_logout;
	public ReserveSubView subv_reserve[];
	
	public ReserView() {
		setTitle("ReserView");
		p_ps = new JPanel();
		p_center = new JPanel();
		bt_mypage = new JButton("마이 페이지");
		bt_mypage.setForeground(Color.WHITE);
		bt_mypage.setBackground(Color.BLACK);
		bt_mypage.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt_logout = new JButton("로그아웃");
		bt_logout.setForeground(Color.WHITE);
		bt_logout.setBackground(Color.BLACK);
		bt_logout.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		subv_reserve = new ReserveSubView[4];
		
		getContentPane().setLayout(new BorderLayout());
//p_ps
		p_ps.setPreferredSize(new Dimension(0, 60));
		getContentPane().add(p_ps, BorderLayout.PAGE_START);
		p_ps.setLayout(null);
		p_ps.setBackground(Color.WHITE);
		p_ps.setBackground(new Color(247, 246, 239));
		bt_mypage.setBounds(1000, 10, 120, 40);
		bt_logout.setBounds(60, 10, 120, 40);
		p_ps.add(bt_mypage);
		p_ps.add(bt_logout);	
		
		getContentPane().add(p_center, BorderLayout.CENTER);
//p_center
		p_center.setLayout(new GridLayout(1, 4));
		p_center.setBackground(new Color(247, 246, 239));
		for(int i=0; i<subv_reserve.length; i++) {
			subv_reserve[i] = new ReserveSubView();
			p_center.add(subv_reserve[i]);
		}
		
		setSize(1200, 800);
		setVisible(true);
	}//생성자
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/01 12:34
	 * 이벤트리스너 기능: ReserveSubView에서 토글버튼 상태변경 & 이미지변경
	 */
	public void setstarSelected(int checked_i, int checked_j) {
		for(int k=0; k<subv_reserve[checked_i].tbt_stars.length; k++) {
			if(k<checked_j) {
				subv_reserve[checked_i].tbt_stars[k].setSelected(true);
				subv_reserve[checked_i].tbt_stars[k].setIcon(new ImageIcon("image/star_yellow.png"));
			}
			else {
				subv_reserve[checked_i].tbt_stars[k].setSelected(false);
				subv_reserve[checked_i].tbt_stars[k].setIcon(new ImageIcon("image/star_blank.png"));
			}
		}
	}//setstarSelected
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/05 24:11
	 * 이벤트리스너 기능: ReserveSubView에서 새로운 영화로 변경되었을 때는 반드시 평균평점이 0일 것 => 모든 별을 blank로 만들어주는 함수
	 */
	public void setAllStarBlank(int checked_i) {
		for(int k=0; k<subv_reserve[checked_i].tbt_stars.length; k++) {
			subv_reserve[checked_i].tbt_stars[k].setSelected(false);
			subv_reserve[checked_i].tbt_stars[k].setIcon(new ImageIcon("image/star_blank.png"));
		}
	}

	
	public int sendConfirmedMsg(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}
	
	public void sendshowMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	public static void main(String[] args) {
		new ReserView();
	}
}
