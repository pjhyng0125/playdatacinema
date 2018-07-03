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
		la_myhis.setBounds(10, 10, 150, 50);
		p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(Color.blue);
		p_north.setPreferredSize(new Dimension(0, 60));
		p_north.add(la_myhis);
		
		//south 구성
		bt_review = new JButton("후기 작성하러 가기");
		bt_review.setBounds(120, 10, 150, 70);
		p_south = new JPanel();
		p_south.setLayout(null);
		p_south.setPreferredSize(new Dimension(0, 100));
		p_south.add(bt_review);
		
		setLayout(new BorderLayout());
		add("Center",sb_ta);
		add("North",p_north);
		add("South",p_south);
		
		
		
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
	
}
