package com.playdata.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class Admin_movie_view extends JFrame implements Runnable {
	JPanel p_member; // 회원정보 패널
	JPanel p_history; // 결제정보(수익정보, 결제내역) 패널
	JComboBox<String> cb_month;

	JTable t_memberInf;
	JTable t_payHistory;

	DefaultTableModel dtm_member;
	DefaultTableModel dtm_pro;
	DefaultTableModel dtm_pay;

	JLabel la_memberInf;
	JLabel la_profitInf;
	JLabel la_time;
	JLabel la_logo;
	JLabel la_cinema;

	JButton bt_selectAll;
	JButton bt_select;
	JButton bt_delete;
	JButton bt_postManage;
	JButton bt_cmtManage;

	JScrollPane sp_member;
	JScrollPane sp_pay;

	Calendar c;
	
	ImageIcon icon1;

	/*
	 * 작성자:박형진 수정일자:07/03/21:24 
	 */
	public Admin_movie_view() {
		setTitle("관리자창");
//		memberInf(); //회원정보 패널 메소드
		history(); //결제정보 패널 메소드

		getContentPane().setLayout(null);
//			getContentPane().add(p_member);

			getContentPane().add(p_history);
			
			bt_postManage = new JButton("변경");
			bt_postManage.setBounds(923, 86, 100, 30);
			p_history.add(bt_postManage);
			bt_postManage.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			bt_postManage.setBackground(Color.black);
			bt_postManage.setForeground(Color.white);
			bt_cmtManage = new JButton("취소");
			bt_cmtManage.setBounds(1037, 86, 100, 30);
			p_history.add(bt_cmtManage);
			bt_cmtManage.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			bt_cmtManage.setBackground(Color.BLACK);
			bt_cmtManage.setForeground(Color.WHITE);
			

			la_time = new JLabel();
			la_time.setBounds(1021, 12, 200, 30);
			p_history.add(la_time);
		Thread t = new Thread(this);
		t.start();
		setBounds(500, 100, 1253, 800);
		setVisible(false);
	}// 생성자

	public void memberInf() { //회원정보 패널
		p_member = new JPanel();
			p_member.setLayout(null);
			p_member.setBounds(0, 0, 1036, 753);
		la_memberInf = new JLabel("회원정보");
			la_memberInf.setBounds(150, 58, 100, 30);
		bt_selectAll = new JButton("전체조회");
			bt_selectAll.setBounds(689, 651, 100, 30);
			bt_selectAll.setBackground(Color.BLACK);
			bt_selectAll.setForeground(Color.WHITE);
		bt_select = new JButton("선택조회");
			bt_select.setBounds(803, 651, 100, 30);
			bt_select.setBackground(Color.BLACK);
			bt_select.setForeground(Color.white);
		bt_delete = new JButton("삭제");
			bt_delete.setBounds(917, 651, 80, 30);
			bt_delete.setBackground(Color.BLACK);
			bt_delete.setForeground(Color.WHITE);
		Object[] memberCol = { "아이디", "성별", "이름", "생년월일", "연락처", "주소", "이메일", "포인트", "캐쉬", "회원등급" };
		dtm_member = new DefaultTableModel(memberCol, 32);
		t_memberInf = new JTable(dtm_member);
			t_memberInf.getTableHeader().setBackground(Color.LIGHT_GRAY); // 테이블 헤더 배경색 지정
			t_memberInf.getTableHeader().setReorderingAllowed(false); //테이블 순서변경 방지
			t_memberInf.getTableHeader().setResizingAllowed(false);  //테이블 사이즈 변경 방지
			t_memberInf.getColumnModel().getColumn(0).setPreferredWidth(50); // 해당컬럼 너비 지정			
			t_memberInf.getColumnModel().getColumn(1).setPreferredWidth(1); 	
			t_memberInf.getColumnModel().getColumn(2).setPreferredWidth(30);
			t_memberInf.getColumnModel().getColumn(3).setPreferredWidth(30);
			t_memberInf.getColumnModel().getColumn(4).setPreferredWidth(40);
			t_memberInf.getColumnModel().getColumn(7).setPreferredWidth(40);
			t_memberInf.getColumnModel().getColumn(8).setPreferredWidth(40);
			t_memberInf.getColumnModel().getColumn(9).setPreferredWidth(40);
		sp_member = new JScrollPane(t_memberInf);
			sp_member.setBounds(150, 100, 861, 537);
		p_member.add(la_memberInf);
		p_member.add(sp_member);
		p_member.add(bt_selectAll);
		p_member.add(bt_select);
		p_member.add(bt_delete);

		p_member.setVisible(true);
	}
 
	public void history() {// 결제정보(수익정보, 결제내역) 패널
		p_history = new JPanel();
			p_history.setLayout(null);
			p_history.setBounds(0, 0, 1235, 800);
			p_history.setBackground(Color.pink);
			p_history.setPreferredSize(new Dimension(500,500));
		la_profitInf = new JLabel("영화정보");
		la_profitInf.setFont(new Font("맑은 고딕", Font.BOLD, 22));
			la_profitInf.setBounds(28, 82, 100, 30);
		cb_month = new JComboBox<>();
			cb_month.setBounds(1151, 86, 70, 30);
		for(int i=1;i<13;i++) {
				cb_month.addItem(i+"월");			
			}
		
		icon1 = new ImageIcon("image/logo.png");
		la_logo = new JLabel(icon1);
		la_logo.setBounds(1150, 700, 50, 50);
		la_cinema = new JLabel("Cinema");
		la_cinema.setBounds(1040, 700, 150, 50);
		la_cinema.setFont(new Font("도움", Font.HANGING_BASELINE, 30));
		



		
		t_payHistory = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"영화이름","감독명","주연배우","줄거리","장르","예매율","평점","제한나이","가격","이미지경로","개봉일자","상영 일자","런타임","상영유무"}
		));
			t_payHistory.getTableHeader().setBackground(Color.LIGHT_GRAY);

		sp_pay = new JScrollPane(t_payHistory);
			sp_pay.setBounds(28, 124, 1193, 545);
			sp_pay.setBorder(new BevelBorder(0, Color.BLACK, Color.BLACK));
		
		p_history.add(cb_month);
		p_history.add(la_profitInf);
		
		p_history.add(sp_pay);
		p_history.add(la_logo);
		p_history.add(la_cinema);	
		p_history.setVisible(false);
	}

	@Override
	public void run() {
		try {
			while (true) {
				c = Calendar.getInstance();

				String timeStr = c.get(Calendar.YEAR) + "년 " + (c.get(Calendar.MONTH) + 1) + "월 " + c.get(Calendar.DATE)
						+ "일 " + c.get(Calendar.HOUR_OF_DAY) + "시 " + c.get(Calendar.MINUTE) + "분 "
						+ c.get(Calendar.SECOND) + "초";
				la_time.setText(timeStr);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	



}
