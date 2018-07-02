package com.playdata.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * 관리자뷰
 */
public class AdminView extends JFrame {
	
	JTable t_customerInf;
	JTable t_profitInf;
	JTable t_payHistory;
	
	DefaultTableModel dtm_cus;
	DefaultTableModel dtm_pro;
	DefaultTableModel dtm_pay;
	
	JLabel la_customerInf;
	JLabel la_profitInf;
	JLabel la_payHistory;
	
	JLabel la_time;
	JButton bt_selectAll;
	JButton bt_select;
	JButton bt_delete;
	
	JScrollPane sp_cus;
	JScrollPane sp_pro;
	JScrollPane sp_pay;
	
	public AdminView() {
		setTitle("AdminView");
		la_time = new JLabel("현재시간");
		la_customerInf = new JLabel("회원정보");
			la_customerInf.setBounds(50, 100, 100, 30);
		la_payHistory = new JLabel("사용내역");
			la_payHistory.setBounds(50,400,100,30);
		la_profitInf = new JLabel("수익정보");
			la_profitInf.setBounds(450,400,100,30);
			
		
		bt_selectAll = new JButton("전체조회");
			bt_selectAll.setBounds(600, 350, 100, 30);
		bt_select = new JButton("선택조회");
			bt_select.setBounds(720, 350, 100, 30);
		bt_delete = new JButton("삭제");
			bt_delete.setBounds(840, 350, 80, 30);
		
		Object[] cusCol = {"아이디","성별","이름","생년월일","연락처"
							,"주소","이메일","포인트","캐쉬","회원등급"};
		Object[] payCol = {"아이디","결제일","티켓코드"};
		Object[] proCol = {"아이디","충전금액"};
		
		dtm_cus = new DefaultTableModel(cusCol,10);
		dtm_pay = new DefaultTableModel(proCol,10);
		dtm_pro = new DefaultTableModel(payCol,10);
		
		t_customerInf = new JTable(dtm_cus);
		t_payHistory = new JTable(dtm_pay);
		t_profitInf = new JTable(dtm_pro);

		sp_cus = new JScrollPane(t_customerInf);
			sp_cus.setBounds(50, 150, 900, 185);
		sp_pay = new JScrollPane(t_payHistory);
			sp_pay.setBounds(50,450,300,185);
		sp_pro = new JScrollPane(t_profitInf);
			sp_pro.setBounds(450, 450, 300, 185);
		setLayout(null);
		add(la_time);
		add(la_customerInf);
		add(la_payHistory);
		add(la_profitInf);
		add(sp_cus);
		add(sp_pay);
		add(sp_pro);
		add(bt_selectAll);
		add(bt_select);
		add(bt_delete);
		
		
		setBounds(300, 400, 1200, 800);
		
		
//		setSize(1200, 800);
		setVisible(true);
	}//생성자
	
	public static void main(String[] args) {
		new AdminView();
	}
}

