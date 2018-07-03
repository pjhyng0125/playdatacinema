package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * ������������
 */
public class MyPageView extends JFrame {
	// �ʱ� �ۼ��� : �̼���
	// ���������� �� 
	
		//��ư �ǵ��ư��� , ����Ȯ��,   ��������,    ȸ����������,  ĳ������,   ȸ��Ż��,   �α׾ƿ�
	public JButton bt_back, bt_check,bt_history, bt_revise, bt_cash, bt_drop, bt_logout;	
	JPanel p_north, p_center;
	//	      ������������, ȯ����,   ��޶�,   ĳ����,   ����Ʈ��
	JLabel la_mypage, la_greet, la_grade, la_cash, la_point;
	public JLabel la_grade2, la_cash2, la_point2;	// �� ǥ�� ���� ��
	public ImageIcon i_grade, i_cash, i_point, i_back;
	public JCheckBox cb_grade, cb_cash, cb_point;
	
	public MyPageView() {
		setTitle("MyPageView");
		
		
		// �� 
		
		la_mypage = new JLabel("����������");
		la_mypage.setBounds(100, 5, 300, 100);
		la_mypage.setFont(new Font("�������", 0, 50));
		la_greet = new JLabel("�� ȯ���մϴ�!");
		la_greet.setBounds(20, 20, 300, 30);
		la_greet.setFont(new Font("�������", 0, 30));
		la_grade = new JLabel("��� : ");
		la_grade.setBounds(20, 70, 100, 30);
		la_grade.setFont(new Font("�������", 0, 30));
		la_grade2 = new JLabel("VIP");
		la_grade2.setBounds(180, 70, 230, 30);
		la_grade2.setFont(new Font("�������", 0, 30));
		la_cash = new JLabel("ĳ�� : ");
		la_cash.setBounds(20, 120, 100, 30);
		la_cash.setFont(new Font("�������", 0, 30));
		la_cash2 = new JLabel("20000��");
		la_cash2.setBounds(150, 120, 230, 30);
		la_cash2.setFont(new Font("�������", 0, 30));
		la_point = new JLabel("����Ʈ : ");
		la_point.setBounds(20, 170, 120, 30);
		la_point.setFont(new Font("�������", 0, 30));
		la_point2 = new JLabel("3000P");
		la_point2.setBounds(180, 170, 230, 30);
		la_point2.setFont(new Font("�������", 0, 30));
		
		
		// �̹���
		i_grade = new ImageIcon("cinema/imgage/crown.png");			// �̹��� ���ؼ� ��� �����ؾ���.
		i_cash = new ImageIcon("cinema/imgage/cash.png");
		i_point = new ImageIcon("cinema/imgage/point.png");
		i_back = new ImageIcon("cinema/imgage/back.png");
		
		
		// ��ư
		bt_back = new JButton(i_back);
		bt_back.setBounds(20, 16, 65, 65);
		bt_check = new JButton("���� Ȯ��/���");
		bt_check.setFont(new Font("�������", 0, 30));
		bt_check.setBounds(40, 220, 300, 50 );
		bt_history = new JButton("��������");
		bt_history.setFont(new Font("�������", 0, 30));
		bt_history.setBounds(40, 290, 300, 50);
		bt_revise = new JButton("ȸ������");
		bt_revise.setFont(new Font("�������", 0, 30));
		bt_revise.setBounds(40, 360, 300, 50);
		bt_cash = new JButton("ĳ������");
		bt_cash.setFont(new Font("�������", 0, 30));
		bt_cash.setBounds(40, 430, 300, 50);
		bt_drop = new JButton("ȸ��Ż��");
		bt_drop.setFont(new Font("�������", 0, 30));
		bt_drop.setBounds(40, 500, 300, 50);
		bt_logout = new JButton("�α׾ƿ�");
		bt_logout.setFont(new Font("�������", 0, 30));
		bt_logout.setBounds(40, 570, 300, 50);
		
		//üũ�ڽ�
		cb_grade = new JCheckBox(i_grade);
		cb_grade.setBounds(330, 55, 50, 50);
		cb_cash = new JCheckBox(i_cash);
		cb_cash.setBounds(330, 110, 50, 50);
		cb_point = new JCheckBox(i_point);
		cb_point.setBounds(330, 155, 50, 50);
		
		// �г�
		p_north = new JPanel();
		p_center = new JPanel();
		
		p_north.setLayout(null);
		p_north.setBackground(Color.blue);
		p_north.setPreferredSize(new Dimension(400, 100));
		p_north.add(bt_back);
		p_north.add(la_mypage);
		
		p_center.setLayout(null);
		p_center.setPreferredSize(new Dimension(400, 1000));
		p_center.add(cb_grade);
		p_center.add(cb_cash);
		p_center.add(cb_point);
		p_center.add(la_greet);
		p_center.add(la_grade);
		p_center.add(la_grade2);
		//p_center.add(i_grade);									// �̹����� add�� ������Ʈ�� �ƴϴ�!
		p_center.add(la_cash);
		p_center.add(la_cash2);
		//p_center.add(i_cash);
		p_center.add(la_point);
		p_center.add(la_point2);
		
		p_center.add(bt_check);
		p_center.add(bt_history);
		p_center.add(bt_revise);
		p_center.add(bt_cash);
		p_center.add(bt_drop);
		p_center.add(bt_logout);
		
		setLayout(new BorderLayout());
		add("North",p_north);
		add("Center",p_center);
		
		
		setSize(400, 950);
		setVisible(true);
	}//������
	
}
