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
	private JLabel la_name;//�� �̸�
	
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
		la_myhis.setForeground(Color.WHITE);
		la_myhis.setFont(new Font("���� ���", Font.BOLD, 15));
		la_myhis.setBounds(279, 24, 89, 36);
		p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(Color.BLACK);
		p_north.setPreferredSize(new Dimension(0, 60));
		p_north.add(la_myhis);
		
		//south ����
		bt_review = new JButton("�ı� �ۼ��Ϸ� ����");
		bt_review.setBounds(95, 10, 219, 70);
		p_south = new JPanel();
		p_south.setBackground(Color.WHITE);
		p_south.setLayout(null);
		p_south.setPreferredSize(new Dimension(0, 100));
		p_south.add(bt_review);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("Center",sb_ta);
		getContentPane().add("North",p_north);
		
		//�� �̸�
		la_name = new JLabel("gildong");
		la_name.setForeground(Color.WHITE);
		la_name.setFont(new Font("���� ���", Font.BOLD, 23));
		la_name.setBounds(129, 12, 140, 48);
		p_north.add(la_name);
		getContentPane().add("South",p_south);
		
		
		
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
	
	public static void main(String[] args) {
		new MyHistory();
	}
}
