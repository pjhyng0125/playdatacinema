package com.playdata.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.playdata.model.client.Server;
import com.playdata.model.vo.Member;

public class AdminView extends JFrame implements Runnable {
	JPanel p_member; // 회원정보 패널
	JPanel p_history; // 결제정보(수익정보, 결제내역) 패널

	public JComboBox<String> cb_menu = new JComboBox<>();;
	public JComboBox<String> cb_month;
	JTextField tf_totProfit;

	JTable t_memberInf;
	JTable t_profitInf;
	JTable t_payHistory;

	DefaultTableModel dtm_member;
	DefaultTableModel dtm_pro;
	DefaultTableModel dtm_pay;

	JLabel la_memberInf;
	JLabel la_profitInf;
	JLabel la_payHistory;
	JLabel la_totProfit;
	JLabel la_time;
	JLabel la_logo,la_cinema;

	public JButton bt_selectAll = new JButton("전체조회");
	public JButton bt_select = new JButton("선택조회");
	public JButton bt_delete = new JButton("삭제");
	public JButton bt_canclePay;
	public JButton bt_postManage;
	public JButton bt_cmtManage;

	JScrollPane sp_member;
	JScrollPane sp_pro;
	JScrollPane sp_pay;
	
	ImageIcon icon1;

	Calendar c;
	Server server;

	/*
	 * 작성자:박형진 수정일자:07/03/21:24 
	 */
	public AdminView() {
		setTitle("관리자창");
		memberInf(true); //회원정보 패널 메소드
		history(false); //결제정보 패널 메소드
		
		server = new Server();
		server.serverrun = true;

		la_time = new JLabel();
			la_time.setBounds(980, 30, 200, 30);

		getContentPane().setLayout(null);
			getContentPane().add(la_time);
			getContentPane().add(p_member);

			getContentPane().add(p_history);
			bt_cmtManage = new JButton("후기관리");
			bt_cmtManage.setBounds(1050, 563, 100, 30);
			bt_cmtManage.setBackground(Color.BLACK);
			bt_cmtManage.setForeground(Color.WHITE);
			getContentPane().add(bt_cmtManage);
			
			
			bt_postManage = new JButton("게시물관리");
			bt_postManage.setBounds(1050, 521, 100, 30);
			bt_postManage.setBackground(Color.black);
			bt_postManage.setForeground(Color.white);
			getContentPane().add(bt_postManage);
			cb_menu.setBounds(1050, 606, 100, 30);
			
			getContentPane().add(cb_menu);
			cb_menu.addItem("회원정보");
			cb_menu.addItem("결제정보");
		Thread t = new Thread(this);
		t.start();
		setBounds(500, 100, 1200, 800);
		setVisible(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				server.turnOff();
			}
		});
		
	}// 생성자

	public void memberInf(boolean flag) { //회원정보 패널
		p_member = new JPanel();
			p_member.setLayout(null);
			p_member.setBounds(0, 0, 1036, 753);
		la_memberInf = new JLabel("회원정보");
			la_memberInf.setBounds(150, 58, 100, 30);
			bt_selectAll.setBounds(689, 651, 100, 30);
			bt_selectAll.setBackground(Color.BLACK);
			bt_selectAll.setForeground(Color.WHITE);
			bt_select.setBounds(803, 651, 100, 30);
			bt_select.setBackground(Color.BLACK);
			bt_select.setForeground(Color.white);
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

		p_member.setVisible(flag);
	}
 
	public void history(boolean flag) {// 결제정보(수익정보, 결제내역) 패널
		p_history = new JPanel();
			p_history.setLayout(null);
			p_history.setBounds(0, 0, 1036, 800);
			p_history.setBackground(Color.pink);
			p_history.setPreferredSize(new Dimension(500,500));
		la_profitInf = new JLabel("영화정보");
		la_profitInf.setFont(new Font("맑은 고딕", Font.BOLD, 22));
			la_profitInf.setBounds(150, 82, 100, 30);
		la_payHistory = new JLabel("결제내역");
		la_payHistory.setFont(new Font("맑은 고딕", Font.BOLD, 22));
			la_payHistory.setBounds(550, 82, 100, 30);
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
		


		Object[] payCol = { "아이디", "영화제목", "런타임", "시작시간", "좌석번호", "스크린코드", "인원수" };
		Object[] proCol = { "아이디", "충전금액" };

		
		dtm_pay = new DefaultTableModel(proCol, 32);
		dtm_pro = new DefaultTableModel(payCol, 32);

		
		t_payHistory = new JTable(dtm_pay);
			t_payHistory.getTableHeader().setBackground(Color.LIGHT_GRAY);
		t_profitInf = new JTable(dtm_pro);
			t_profitInf.getTableHeader().setBackground(Color.LIGHT_GRAY);

		sp_pay = new JScrollPane(t_payHistory);
			sp_pay.setBounds(150, 124, 300, 537);
			sp_pay.setBorder(new BevelBorder(0, Color.BLACK, Color.BLACK));
		sp_pro = new JScrollPane(t_profitInf);
			sp_pro.setBounds(550, 124, 300, 537);
			sp_pro.setBorder(new BevelBorder(0, Color.BLACK, Color.BLACK));
		
		p_history.add(cb_month);
		p_history.add(la_payHistory);
		p_history.add(la_profitInf);
		p_history.add(la_totProfit);
		
		p_history.add(sp_pay);
		p_history.add(sp_pro);

		p_history.add(bt_canclePay);
		p_history.add(tf_totProfit);
		p_history.add(la_logo);
		p_history.add(la_cinema);
		p_history.setVisible(flag);
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
	
	
	
 	public void dispTable(ArrayList<Object[]> list,String table) { //table : "회원정보" "수익정보" "결제내역"
		if(table.equals("회원정보")) {
			dtm_member.setRowCount(0); // 출력될 포인트 행을 0으로 셋팅!!
			for(int i=0; i < list.size();i++) {
				Object [] rowData = list.get(i);
				dtm_member.addRow(rowData);
			}
		}else if(table.equals("수익정보")){
			dtm_pro.setRowCount(0);
			for(int i=0; i < list.size();i++) {
				Object [] rowData = list.get(i);
				dtm_pro.addRow(rowData);
			}
		}else if(table.equals("결제내역")) {
			dtm_pay.setRowCount(0);
			for(int i=0; i < list.size();i++) {
				Object [] rowData = list.get(i);
				dtm_pay.addRow(rowData);
			}			
		}
	}
 	
 	public void dispTable(ArrayList<Member> list) {
 		dtm_member.setRowCount(0);
 		String[] mem_grade = {"일반","VIP","VVIP"};
 		for(int i=0; i<list.size();i++) {
 			Object[] rowData = {list.get(i).getId(),
 							   list.get(i).getGender(),
 							   list.get(i).getName(),
 							   list.get(i).getBirth(),
 							  list.get(i).getPhone(),
 							  list.get(i).getAddr(),
 							  list.get(i).getEmail(),
 							  list.get(i).getPoint(),
 							  list.get(i).getCash(),
 							  mem_grade[list.get(i).getMem_grade()]};
 			dtm_member.addRow(rowData);
 		}
 	}
 	
 	public String showInputmsg(String msg) {
 		return JOptionPane.showInputDialog(msg);
 	}
 	public void showmsg(String msg) {
 		JOptionPane.showMessageDialog(this, msg);
 	}
 	public int showconfirmmsg(String msg) {
 		return JOptionPane.showConfirmDialog(this, msg);
 	}
}
