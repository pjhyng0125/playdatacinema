package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class CheckView extends JFrame{

	// �ʱ� �ۼ��� : �̼���
	// ���������� - ���� Ȯ��/��� ��ư Ŭ���� ����â
	   
	JLabel la_sort;
	public JButton bt_cancel;	//�ı� ��ư
	JPanel p_north, p_center;
	public Check_sub_View[] sub_view = new Check_sub_View[4] ;
	
	public CheckView() {
		setTitle("���� Ȯ��/��� â");
		
		la_sort = new JLabel("no, ��ȭ����, ��������, ��ȭ��");
		p_center = new JPanel();
	//	p_center.setLayout(new GridLayout(sub_view.length, 1));
		p_center.setLayout(new GridLayout(5, 1));
		

		
		setLayout(new BorderLayout());
		add("North",la_sort);
		add("Center",p_center);
		
		//center ����
		for(int i=0;i<sub_view.length;i++) {
		
			sub_view[i] = new Check_sub_View();
			p_center.add(sub_view[i]);
			
			
			
			
		}
	
		
		setSize(450, 650);
		setVisible(false);
	}
	
}
