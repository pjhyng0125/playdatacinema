package com.playdata.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CashView extends JFrame{
	// �ʱ� �ۼ��� : �̼���
	// ������������ - ĳ������ ��ư Ŭ���� ����â
	
	JPanel p_up, p_down;
	public JButton bt_cash, bt_phone, bt_paper;
	JLabel lb_text;
	
	public CashView() {
		setTitle("ĳ������â");
		
		p_down = new JPanel();
		p_up = new JPanel();
		
		lb_text = new JLabel("���� ���");
		lb_text.setBounds(10, 10, 150, 80);
		
		bt_cash = new JButton("ī��");
		bt_cash.setBounds(10, 10, 60, 60);
		bt_paper = new JButton("��ȭ��ǰ��");
		bt_paper.setBounds(100, 10, 60, 60);
		bt_phone = new JButton("�޴�������");
		bt_phone.setBounds(190, 10, 60, 60);
		
		p_up.setLayout(null);
		p_up.add(lb_text);
		
		p_down.setLayout(null);
		p_down.add(bt_cash);
		p_down.add(bt_paper);
		p_down.add(bt_phone);
		
		
		setLayout(new GridLayout(2, 1));
		add(p_up);
		add(p_down);
		
		setSize(300, 200);
		setVisible(true);
		
		
		
	}
	


}
