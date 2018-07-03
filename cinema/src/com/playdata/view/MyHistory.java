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
	// ���� ���������� view - �������� ��ư Ŭ�� �� ������ ��ȭ���� ��� Ȯ�� â.
	// �ʱ� ����� : �̼��� 
	
   
	JLabel la_myhis;	
	public JTable table;
	String datasort[] = {"no","��ȭ���� ", "�������� ", "�ο���"};
	Object [][]his;
	public DefaultTableModel dtm;
	JTextArea ta_his;
	JScrollPane sb_ta;
	public JButton bt_review;	//�ı� ��ư
	JPanel p_north, p_south;
	
	public MyHistory() {
		setTitle("��������â");
		
		
		//center ����
		his = new Object[0][4];
		dtm = new DefaultTableModel(his, datasort);
		table = new JTable(dtm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sb_ta = new JScrollPane(table);
		
		//north ����
		la_myhis = new JLabel("�� ��������");
		la_myhis.setBounds(10, 10, 150, 50);
		p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(Color.blue);
		p_north.setPreferredSize(new Dimension(0, 60));
		p_north.add(la_myhis);
		
		//south ����
		bt_review = new JButton("�ı� �ۼ��Ϸ� ����");
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
	// ************   ��������������  *******************
//	public void displayTable(ArrayList<History> list) {
//		   dtm.setRowCount(0);//��µ� �������� ��ġ 0 ---> ù��°��
//		   
//		   for(int i=0; i<list.size(); i++) {
//			   History h = list.get(i);
//			   					// no,  ��ȭ����		��������		�ο���
//			   Object rowData[]= {(i+1),h.getName(),h.getAge(),h.getJob()};
//			   dtm.addRow(rowData);
//		   }
//	   }//displayTable
//	
	
}
