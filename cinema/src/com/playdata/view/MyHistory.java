package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;


public class MyHistory extends JFrame{
	// 유저 마이페이지 view - 관람내역 버튼 클릭 시 유저의 영화관람 목록 확인 창.
	// 초기 담당자 : 이성훈 
	
   
	JLabel la_myhis;	
	public JTable table;
	String datasort[] = {"no","영화제목 ", "관람일자 ", "인원수"};
	Object [][]his;
	public DefaultTableModel dtm;
	JTextArea ta_his;
	JScrollPane sb_ta;
	public JButton bt_review;	//후기 버튼
	JPanel p_north, p_south;
	private JLabel la_name;//고객 이름
	
	public MyHistory() {
		setTitle("관람내역창");
		
		
		//center 구성
		his = new Object[0][4];
		dtm = new DefaultTableModel(his, datasort);
		table = new JTable(dtm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sb_ta = new JScrollPane(table);
		
		//north 구성
		la_myhis = new JLabel("님 관람내역");
		la_myhis.setForeground(Color.WHITE);
		la_myhis.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_myhis.setBounds(279, 24, 89, 36);
		p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(Color.BLACK);
		p_north.setPreferredSize(new Dimension(0, 60));
		p_north.add(la_myhis);
		
		//south 구성
		bt_review = new JButton("후기 작성하러 가기");
		bt_review.setBounds(95, 10, 219, 70);
		p_south = new JPanel();
		p_south.setBackground(Color.WHITE);
		p_south.setLayout(null);
		p_south.setPreferredSize(new Dimension(0, 100));
		p_south.add(bt_review);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("Center",sb_ta);
		getContentPane().add("North",p_north);
		
		//고객 이름
		la_name = new JLabel("gildong");
		la_name.setForeground(Color.WHITE);
		la_name.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		la_name.setBounds(129, 12, 140, 48);
		p_north.add(la_name);
		getContentPane().add("South",p_south);
		
		
		
		setSize(400, 650);
		setVisible(true);
		
	}
	// ************   삭제하지마세요  *******************
//	public void displayTable(ArrayList<History> list) {
//		   dtm.setRowCount(0);//출력될 시작행의 위치 0 ---> 첫번째행
//		   
//		   for(int i=0; i<list.size(); i++) {
//			   History h = list.get(i);
//			   					// no,  영화제목		관람일자		인원수
//			   Object rowData[]= {(i+1),h.getName(),h.getAge(),h.getJob()};
//			   dtm.addRow(rowData);
//		   }
//	   }//displayTable
//	
	
	public static void main(String[] args) {
		new MyHistory();
	}
}
