package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
 * 마이페이지뷰
 */
public class MyPageView extends JFrame {
	// 초기 작성자 : 이성훈
	// 마이페이지 뷰 
	
		//버튼 되돌아가기 , 예매확인,   관람내역,    회원정보수정,  캐쉬충전,   회원탈퇴,   로그아웃
	public JButton bt_back, bt_check, bt_revise, bt_cash, bt_drop, bt_logout;	
	JPanel p_north, p_center;
	//	      마이페이지라벨, 환영라벨,   등급라벨,   캐쉬라벨,   포인트라벨
	public JLabel la_mypage, la_greet, la_grade, la_cash, la_point;
	public JLabel la_grade2, la_cash2, la_point2;	// 값 표시 위한 라벨
	public ImageIcon i_grade, i_cash, i_point, i_back;
	public JCheckBox cb_grade, cb_cash, cb_point;
	public JLabel la_logo, la_cinema;
	ImageIcon icon1;
	
	public MyPageView() {
		setTitle("마이페이지창");
		
		
		// 라벨 
		
		icon1 = new ImageIcon("image/logo.png");
		la_logo = new JLabel(icon1);
		la_logo.setBounds(320, 615, 50, 50);
		la_cinema = new JLabel("Cinema");
		la_cinema.setBounds(250,615,100, 50);
		la_cinema.setFont(new Font("도움", Font.HANGING_BASELINE, 20));
		
		
		la_mypage = new JLabel("마이페이지");
		la_mypage.setForeground(Color.WHITE);
		la_mypage.setBounds(100, 16, 268, 68);
		la_mypage.setFont(new Font("맑은 고딕", Font.BOLD, 41));
		la_greet = new JLabel("님 환영합니다!");
		la_greet.setBounds(150, 17, 212, 30);
		la_greet.setFont(new Font("맑은고딕", 0, 30));
		la_grade = new JLabel("등급 : ");
		la_grade.setBounds(20, 70, 100, 30);
		la_grade.setFont(new Font("맑은고딕", 0, 30));
		la_grade2 = new JLabel("VIP");
		la_grade2.setBounds(180, 70, 113, 30);
		la_grade2.setFont(new Font("맑은고딕", 0, 30));
		la_cash = new JLabel("캐쉬 : ");
		la_cash.setBounds(20, 130, 100, 30);
		la_cash.setFont(new Font("맑은고딕", 0, 30));
		la_cash2 = new JLabel("20000원");
		la_cash2.setBounds(150, 130, 138, 30);
		la_cash2.setFont(new Font("맑은고딕", 0, 30));
		la_point = new JLabel("포인트 : ");
		la_point.setBounds(20, 193, 120, 30);
		la_point.setFont(new Font("맑은고딕", 0, 30));
		la_point2 = new JLabel("3000P");
		la_point2.setBounds(180, 193, 113, 30);
		la_point2.setFont(new Font("맑은고딕", 0, 30));
		
		
		// 이미지
		i_grade = new ImageIcon("image/crown.png");			// 이미지 구해서 경로 설정해야함.
		i_cash = new ImageIcon("image/cash.png");
		i_point = new ImageIcon("image/point.png");
		i_back = new ImageIcon("image/back.png");
		
		
		// 버튼
		bt_back = new JButton(i_back);
		bt_back.setBounds(20, 16, 65, 65);
		bt_back.setBackground(Color.orange);
		bt_check = new JButton("예매 확인/취소");
		bt_check.setBackground(Color.BLACK);
		bt_check.setForeground(Color.WHITE);
		bt_check.setFont(new Font("Dialog", Font.BOLD, 30));
		bt_check.setBounds(41, 281, 300, 50 );
		bt_revise = new JButton("회원수정");
		bt_revise.setBackground(Color.BLACK);
		bt_revise.setForeground(Color.WHITE);
		bt_revise.setFont(new Font("Dialog", Font.BOLD, 30));
		bt_revise.setBounds(41, 351, 300, 50);
		bt_cash = new JButton("캐쉬충전");
		bt_cash.setBackground(Color.BLACK);
		bt_cash.setForeground(Color.WHITE);
		bt_cash.setFont(new Font("Dialog", Font.BOLD, 30));
		bt_cash.setBounds(41, 421, 300, 50);
		bt_drop = new JButton("회원탈퇴");
		bt_drop.setBackground(Color.BLACK);
		bt_drop.setForeground(Color.WHITE);
		bt_drop.setFont(new Font("Dialog", Font.BOLD, 30));
		bt_drop.setBounds(41, 491, 300, 50);
		bt_logout = new JButton("로그아웃");
		bt_logout.setBackground(Color.BLACK);
		bt_logout.setForeground(Color.WHITE);
		bt_logout.setFont(new Font("Dialog", Font.BOLD, 30));
		bt_logout.setBounds(41, 561, 300, 50);
		
		//체크박스
		cb_grade = new JCheckBox(i_grade);
		cb_grade.setBounds(330, 55, 50, 50);
		cb_cash = new JCheckBox(i_cash);
		cb_cash.setBounds(330, 110, 50, 50);
		cb_point = new JCheckBox(i_point);
		cb_point.setBounds(330, 155, 50, 50);
		
		// 패널
		p_north = new JPanel();
		p_center = new JPanel();
		
		p_north.setLayout(null);
		p_north.setBackground(Color.BLACK);
		p_north.setPreferredSize(new Dimension(400, 100));
		p_north.add(bt_back);
		p_north.add(la_mypage);
		
		p_center.setLayout(null);
		p_center.setPreferredSize(new Dimension(400, 1000));
		p_center.add(cb_grade);
		p_center.add(cb_cash);
		p_center.add(cb_point);
		p_center.add(la_greet);
		p_center.add(la_grade);
		p_center.add(la_grade2);
		//p_center.add(i_grade);									// 이미지는 add할 컴포넌트가 아니다!
		p_center.add(la_cash);
		p_center.add(la_cash2);
		//p_center.add(i_cash);
		p_center.add(la_point);
		p_center.add(la_point2);
		
		p_center.add(bt_check);
		p_center.add(bt_revise);
		p_center.add(bt_cash);
		p_center.add(bt_drop);
		p_center.add(bt_logout);
		
		p_center.add(la_logo);
		p_center.add(la_cinema);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("North",p_north);
		getContentPane().add("Center",p_center);
		
		
		setSize(400, 814);
		setVisible(false);
	}//생성자
	
	public void showMsg(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	public boolean showYesNOmsg(String msg) {
		int t = JOptionPane.showConfirmDialog(this, msg,"회원 탈퇴 및 로그아웃",JOptionPane.YES_NO_OPTION);
		System.out.println(t);
		if(t==0)return true;
		
		return false;
	}
}
