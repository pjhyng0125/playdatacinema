package com.playdata.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Check_sub_View extends JPanel {
	// �ʱ� �ۼ��� : �̼��� 
	// check view ���� ��
	
	//	    ��ȣ       ��ȭ����  ��������   ���
 	JLabel la_num, la_name, la_date, la_screen;
 	public JButton bt_cancel;
	
	public Check_sub_View() {
		
		la_num = new JLabel("1");
		la_num.setBounds(5, 10, 20, 40);
		la_name = new JLabel("��ȭ�̸�");
		la_name.setBounds(30, 10, 200, 40);
		la_date = new JLabel("2018/06/18");
		la_date.setBounds(130, 10, 200, 40);
		la_screen = new JLabel("a�󿵰� b�� 3��");
		la_screen.setBounds(250, 10, 200, 40);
		bt_cancel = new JButton("���");
		bt_cancel.setFont(new Font("���� ���", Font.BOLD, 13));
		bt_cancel.setForeground(Color.WHITE);
		bt_cancel.setBackground(Color.BLACK);
		bt_cancel.setBounds(370, 10, 60, 40);
		
		setLayout(null);
		add(la_num);
		add(la_name);
		add(la_date);
		add(la_screen);
		add(bt_cancel);
		
		setSize(450, 60);
		setVisible(false);
	}
	

}
