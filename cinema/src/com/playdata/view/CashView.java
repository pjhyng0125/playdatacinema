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
	// 초기 작성자 : 이성훈
	// 마이페이지뷰 - 캐시충전 버튼 클릭시 생성창
	
	JPanel p_up, p_down,p_center;
	public JButton bt_cash, bt_phone, bt_paper;
	public JButton bt_charge_ok, bt_charge_cancle;//결제 확인 버튼
	JLabel lb_text;
	private JLabel lb_pay_window, lb_cash_way;;
	public JTextField tf_charge_cash; //결제금액 입력 필드
	
	public CashView() {
		setTitle("캐쉬충전창");

		p_down = new JPanel();
		p_down.setBounds(0, 239, 494, 154);
		p_down.setBackground(Color.WHITE);
		p_down.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,Color.BLACK, Color.BLACK, Color.BLACK));
		p_up = new JPanel();
		p_up.setBounds(0, 0, 494, 86);
		p_up.setBackground(Color.BLACK);
		
		bt_cash = new JButton("카드");
		bt_cash.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			bt_cash.setBounds(24, 82, 114, 60);
			bt_cash.setBackground(Color.black);
			bt_cash.setForeground(Color.white);
		bt_paper = new JButton("문화상품권");
		bt_paper.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			bt_paper.setBounds(189, 82, 114, 60);
			bt_paper.setBackground(Color.black);
			bt_paper.setForeground(Color.white);
		bt_phone = new JButton("휴대폰결제");
		bt_phone.setFont(new Font("맑은 고딕", Font.BOLD, 15));
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
		
		lb_cash_way = new JLabel("결제창");
		lb_cash_way.setHorizontalAlignment(SwingConstants.LEFT);
		lb_cash_way.setForeground(Color.WHITE);
		lb_cash_way.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lb_cash_way.setBounds(14, 12, 140, 50);
		p_up.add(lb_cash_way);
		getContentPane().add(p_down);
		
		lb_text = new JLabel("결제 방식 선택");
		lb_text.setBounds(14, 12, 140, 50);
		p_down.add(lb_text);
		lb_text.setForeground(Color.BLACK);
		lb_text.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		p_center = new JPanel();
		p_center.setBackground(Color.WHITE);
		p_center.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,Color.BLACK, Color.BLACK, Color.BLACK));
		p_center.setBounds(0, 86, 494, 154);
		getContentPane().add(p_center);
		p_center.setLayout(null);
		
		lb_pay_window = new JLabel("결제 금액");
		lb_pay_window.setBounds(14, 12, 87, 27);
		p_center.add(lb_pay_window);
		lb_pay_window.setHorizontalAlignment(SwingConstants.LEFT);
		lb_pay_window.setForeground(Color.BLACK);
		lb_pay_window.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		
		//결제 금액 입력 창
		tf_charge_cash = new JTextField();
		tf_charge_cash.setBounds(156, 60, 116, 24);
		p_center.add(tf_charge_cash);
		tf_charge_cash.setColumns(10);
		
		//결제 금액 확인
		bt_charge_ok = new JButton("확인");
		bt_charge_ok.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt_charge_ok.setBounds(109, 115, 87, 27);
		bt_charge_ok.setBackground(Color.BLACK);
		bt_charge_ok.setForeground(Color.WHITE);
		p_center.add(bt_charge_ok);
		
		//결제 금액 취소
		bt_charge_cancle = new JButton("취소");
		bt_charge_cancle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt_charge_cancle.setBounds(244, 115, 87, 27);
		bt_charge_cancle.setBackground(Color.black);
		bt_charge_cancle.setForeground(Color.WHITE);
		p_center.add(bt_charge_cancle);
		
		setSize(512, 440);
		setVisible(false);
	}
	
	public boolean showYesNOmsg(String msg) {
		int t = JOptionPane.showConfirmDialog(this, msg,"캐쉬충전",JOptionPane.YES_NO_OPTION);
		System.out.println(t);
		if(t==0)return true;
		
		return false;
	}

}
