package com.playdata.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CashView extends JFrame{
	// �ʱ� �ۼ��� : �̼���
	// ������������ - ĳ������ ��ư Ŭ���� ����â
	
	JPanel p_up, p_down,p_center;
	public JButton bt_cash, bt_phone, bt_paper;
	public JButton bt_charge_ok, bt_charge_cancle;//���� Ȯ�� ��ư
	JLabel lb_text;
	private JLabel lb_pay_window, lb_cash_way;;
	public JTextField tf_charge_cash; //�����ݾ� �Է� �ʵ�
	
	public CashView() {
		setTitle("ĳ������â");

		p_down = new JPanel();
		p_down.setBounds(0, 239, 494, 154);
		p_down.setBackground(Color.WHITE);
		p_down.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,Color.BLACK, Color.BLACK, Color.BLACK));
		p_up = new JPanel();
		p_up.setBounds(0, 0, 494, 86);
		p_up.setBackground(Color.BLACK);
		
		bt_cash = new JButton("ī��");
		bt_cash.setFont(new Font("���� ���", Font.BOLD, 15));
			bt_cash.setBounds(24, 82, 114, 60);
			bt_cash.setBackground(Color.black);
			bt_cash.setForeground(Color.white);
		bt_paper = new JButton("��ȭ��ǰ��");
		bt_paper.setFont(new Font("���� ���", Font.BOLD, 15));
			bt_paper.setBounds(189, 82, 114, 60);
			bt_paper.setBackground(Color.black);
			bt_paper.setForeground(Color.white);
		bt_phone = new JButton("�޴�������");
		bt_phone.setFont(new Font("���� ���", Font.BOLD, 15));
			bt_phone.setBounds(352, 82, 114, 60);
			bt_phone.setBackground(Color.black);
			bt_phone.setForeground(Color.white);
		
		p_up.setLayout(null);
		p_up.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,Color.BLACK, Color.BLACK, Color.BLACK));
		
		p_down.setLayout(null);
		p_down.add(bt_cash);
		p_down.add(bt_paper);
		p_down.add(bt_phone);
		getContentPane().setLayout(null);
		getContentPane().add(p_up);
		
		lb_cash_way = new JLabel("����â");
		lb_cash_way.setHorizontalAlignment(SwingConstants.LEFT);
		lb_cash_way.setForeground(Color.WHITE);
		lb_cash_way.setFont(new Font("���� ���", Font.BOLD, 20));
		lb_cash_way.setBounds(14, 12, 140, 50);
		p_up.add(lb_cash_way);
		getContentPane().add(p_down);
		
		lb_text = new JLabel("���� ��� ����");
		lb_text.setBounds(14, 12, 140, 50);
		p_down.add(lb_text);
		lb_text.setForeground(Color.BLACK);
		lb_text.setFont(new Font("���� ���", Font.BOLD, 20));
		
		p_center = new JPanel();
		p_center.setBackground(Color.WHITE);
		p_center.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,Color.BLACK, Color.BLACK, Color.BLACK));
		p_center.setBounds(0, 86, 494, 154);
		getContentPane().add(p_center);
		p_center.setLayout(null);
		
		lb_pay_window = new JLabel("���� �ݾ�");
		lb_pay_window.setBounds(14, 12, 87, 27);
		p_center.add(lb_pay_window);
		lb_pay_window.setHorizontalAlignment(SwingConstants.LEFT);
		lb_pay_window.setForeground(Color.BLACK);
		lb_pay_window.setFont(new Font("���� ���", Font.BOLD, 20));
		
		
		//���� �ݾ� �Է� â
		tf_charge_cash = new JTextField();
		tf_charge_cash.setBounds(156, 60, 116, 24);
		p_center.add(tf_charge_cash);
		tf_charge_cash.setColumns(10);
		
		//���� �ݾ� Ȯ��
		bt_charge_ok = new JButton("Ȯ��");
		bt_charge_ok.setFont(new Font("���� ���", Font.BOLD, 15));
		bt_charge_ok.setBounds(109, 115, 87, 27);
		bt_charge_ok.setBackground(Color.BLACK);
		bt_charge_ok.setForeground(Color.WHITE);
		p_center.add(bt_charge_ok);
		
		//���� �ݾ� ���
		bt_charge_cancle = new JButton("���");
		bt_charge_cancle.setFont(new Font("���� ���", Font.BOLD, 15));
		bt_charge_cancle.setBounds(244, 115, 87, 27);
		bt_charge_cancle.setBackground(Color.black);
		bt_charge_cancle.setForeground(Color.WHITE);
		p_center.add(bt_charge_cancle);
		
		setSize(512, 440);
		setVisible(false);
	}
	
	public boolean showYesNOmsg(String msg) {
		int t = JOptionPane.showConfirmDialog(this, msg,"ĳ������",JOptionPane.YES_NO_OPTION);
		System.out.println(t);
		if(t==0)return true;
		
		return false;
	}

}
