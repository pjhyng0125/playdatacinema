package com.playdata.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

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

import com.playdata.model.vo.Member;
import com.playdata.model.vo.Movie;
import com.playdata.model.vo.Reserve;

public class HistoryAdminView extends JFrame {
	JPanel p_member; // 회원정보 패널
	JPanel p_history; // 결제정보(수익정보, 결제내역) 패널

	public JComboBox<String> cb_menu;
	public JComboBox<String> cb_month;
	JTextField tf_totProfit;
	public JButton bt_movie, bt_reserve;
	

	JTable t_profitInf;
	JTable t_payHistory;

	DefaultTableModel dtm_pro;
	DefaultTableModel dtm_pay;

	JLabel la_profitInf;
	JLabel la_payHistory;
	JLabel la_totProfit;
	JLabel la_time;
	JLabel la_logo,la_cinema;

	public JButton bt_selectAll;
	public JButton bt_select;
	public JButton bt_delete;
	public JButton bt_canclePay;
	public JButton bt_postManage;
	public JButton bt_cmtManage;

	JScrollPane sp_pro;
	JScrollPane sp_pay;
	
	ImageIcon icon1;
	
	public HistoryAdminView() {
		p_history = new JPanel();
		bt_movie = new JButton("영화 조회");
		bt_movie.setBounds(100, 675, 100, 30);
		bt_reserve = new JButton("결제 조회");
		bt_reserve.setBounds(640, 675, 100, 30);
		p_history.add(bt_movie);
		p_history.add(bt_reserve);
		setTitle("HistoryView");
		p_history.setLayout(null);
		p_history.setBounds(0, 0, 1036, 800);
		p_history.setBackground(Color.pink);
		p_history.setPreferredSize(new Dimension(500,500));
	la_profitInf = new JLabel("영화 상영 정보");
	la_profitInf.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		la_profitInf.setBounds(100, 82, 200, 30);
	la_payHistory = new JLabel("결제내역");
	la_payHistory.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		la_payHistory.setBounds(640, 82, 100, 30);
	la_totProfit = new JLabel("총수익:");
	la_totProfit.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		la_totProfit.setBounds(240, 675, 70, 30);
		
		icon1 = new ImageIcon("image/logo.png");
		la_logo = new JLabel(icon1);
		la_logo.setBounds(80, 700, 50, 50);
		la_cinema = new JLabel("Cinema");
		la_cinema.setBounds(10, 700, 100, 50);
		la_cinema.setFont(new Font("도움", Font.HANGING_BASELINE, 20));
	
		bt_canclePay = new JButton("결제취소");
		bt_canclePay.setBounds(750, 675, 100, 30);
		bt_canclePay.setBackground(Color.black);
		bt_canclePay.setForeground(Color.white);			
	cb_month = new JComboBox<>();
		cb_month.setBounds(864, 126, 70, 30);
	for(int i=1;i<13;i++) {
			cb_month.addItem(i+"월");			
		}
	//<<------------------------------------------------------table	
	tf_totProfit = new JTextField("0000000원");
		tf_totProfit.setEditable(false);
		tf_totProfit.setBounds(300, 675, 150, 30);
		tf_totProfit.setBorder(new BevelBorder(0, Color.BLACK, Color.BLACK));
	tf_totProfit.setHorizontalAlignment(JTextField.RIGHT);
	


	Object[] payCol = { "아이디", "영화제목","상영날짜","상영시간","좌석번호","스크린번호","인원수" };
	Object[] proCol = { "영화제목", "장르", "상영중여부" };

	
	dtm_pay = new DefaultTableModel(proCol, 32);
	dtm_pro = new DefaultTableModel(payCol, 32);

	
	t_payHistory = new JTable(dtm_pay);
		t_payHistory.getTableHeader().setBackground(Color.LIGHT_GRAY);
	t_profitInf = new JTable(dtm_pro);
		t_profitInf.getTableHeader().setBackground(Color.LIGHT_GRAY);

	sp_pay = new JScrollPane(t_payHistory);
		sp_pay.setBounds(100, 124, 450, 537);
		sp_pay.setBorder(new BevelBorder(0, Color.BLACK, Color.BLACK));
	sp_pro = new JScrollPane(t_profitInf);
		sp_pro.setBounds(640, 124, 450, 537);
		sp_pro.setBorder(new BevelBorder(0, Color.BLACK, Color.BLACK));
	
//	p_history.add(cb_month);
	p_history.add(la_payHistory);
	p_history.add(la_profitInf);
	p_history.add(la_totProfit);
	
	p_history.add(sp_pay);
	p_history.add(sp_pro);

	p_history.add(bt_canclePay);
//	p_history.add(tf_totProfit);
	p_history.add(la_logo);
	p_history.add(la_cinema);
	add(p_history);
	setBounds(500, 100, 1200, 800);
	setVisible(false);
	}
	
	public void displayTable(ArrayList<Movie> list) {
 		dtm_pay.setRowCount(0);
 		for(int i=0; i<list.size();i++) {
 			Object[] rowData = {
 							   list.get(i).getMovie_name(),
 							   list.get(i).getGenre(),
 							   list.get(i).getOnshow()
 							   };
 			dtm_pay.addRow(rowData);
 		}
 	}
	public void displayTable_reserve(ArrayList<Reserve> list) {
 		dtm_pro.setRowCount(0);
 		for(int i=0; i<list.size();i++) {
 			Object[] rowData = {
 							   list.get(i).getId(),
 							   list.get(i).getMovie_name(),
 							   list.get(i).getRun_date(),
 							   list.get(i).getStart_time(),
 							   list.get(i).getSeatnum(),
 							   list.get(i).getScreen_code(),
 							   list.get(i).getPerson_cnt()
 							   };
 			dtm_pro.addRow(rowData);
 		}
 	}
}
