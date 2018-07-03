package com.playdata.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JList;
import java.awt.Choice;
/*
 * 결제뷰
 */
public class PayView extends JFrame {
	JPanel p;
	JPanel p_cash,p_discount;
	
	//-----------------------------라벨
	JLabel la_member;//회원등급
	JLabel la_pay;//결제금액
	JLabel la_discount;//할인금액
	JLabel la_point;//포인트사용
	JLabel la_final_pay;//최종결제금액
	JLabel la_have_cash;//보유 캐쉬
	JLabel la_balance;// 사용후 잔액
	JLabel la_sc_point;// 지급예정포인트
	JLabel la_cash;//왼쪽 캐쉬
	JLabel la_charge_cash;//캐쉬충전
	JLabel la_discount_list, la_discount_coupon,la_have_point;//할인내역,할인쿠폰,보유포인트
	Choice ch_copoun;//쿠폰 선택
	
	//-----------------------------텍스트에어리어
	JTextArea ta_grade;//등급정보
	JTextArea ta_pmovie_info;//영화정보
    JTextArea ta_pay;//결제금액
    JTextArea ta_discount;//할인금액
    JTextArea ta_point;//포인트금액
    JTextArea ta_final_pay;//최종결제금액
    JTextArea ta_have_cash;//보유캐쉬
    JTextArea ta_balance;//사용후 잔액
    JTextArea ta_sc_point;//지급예정포인트
    
    //------------------------------텍스트필드
    JTextField tf_charge_cash;//캐쉬충전
    JTextField tf_use_point;//포인트 사용
    
    //-------------------------------버튼
    JButton b_ok,b_cancel;//오른쪽 확인,취소
    JButton b_charge_ok,b_charge_cancel;//캐쉬 충전 취소
    JButton b_discount_ok,b_discount_cancel;//할인 쿠폰 사용 취소
    JButton b_point_ok,b_point_cancel;//포인트 사용 취소
    private JPanel panel_1;

	
	
	
	public PayView() {
		setTitle("결제창");

//============ 결제 진행 정보 ===========
		p = new JPanel();
			p.setBackground(Color.WHITE);
			p.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, 
					Color.BLACK, Color.BLACK, Color.BLACK));
			p.setBounds(667, 40, 470, 652);
		la_member = new JLabel("회원등급");
			la_member.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		ta_pmovie_info = new JTextArea();
			ta_pmovie_info.setText("영화정보 (날짜,시작시간,상영관)");
		ta_grade = new JTextArea();
			ta_grade.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			ta_grade.setText("등급정보");
		la_pay = new JLabel("결제금액");
			la_pay.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		la_discount = new JLabel("할인금액");
			la_discount.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		la_point = new JLabel("포인트사용");
			la_point.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		la_final_pay = new JLabel("최종결제금액");
			la_final_pay.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		la_have_cash = new JLabel("보유 캐쉬");
			la_have_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		la_balance = new JLabel("사용후 잔액");
			la_balance.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		la_sc_point = new JLabel("지급예정포인트");
			la_sc_point.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		
		//텍스트에어이어	
		ta_pay = new JTextArea();
		    ta_pay.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		    ta_pay.setText("16,000");	
		ta_discount = new JTextArea();
			ta_discount.setText("0");
			ta_discount.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		ta_point = new JTextArea();
			ta_point.setText("2,000");
			ta_point.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		ta_final_pay = new JTextArea();
			ta_final_pay.setText("14,000");
			ta_final_pay.setFont(new Font("맑은 고딕", Font.PLAIN, 22));			
		ta_have_cash = new JTextArea();
			ta_have_cash.setText("30,000");
			ta_have_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));			
		ta_balance = new JTextArea();
			ta_balance.setText("16,000");
			ta_balance.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		ta_sc_point = new JTextArea();
			ta_sc_point.setText("140");
			ta_sc_point.setFont(new Font("맑은 고딕", Font.PLAIN, 21));			
		
			
	    //버튼
		b_ok = new JButton("확인");   		   //최종결제 확인
		b_cancel = new JButton("취소");		   //최종결제 취소
		b_charge_ok = new JButton("충전");	   //충전 확인
		b_charge_cancel = new JButton("취소");  //충전 취소
		b_discount_ok = new JButton("사용");    //쿠폰 사용
		b_discount_cancel = new JButton("취소");//쿠폰 취소
		b_point_ok = new JButton("사용");       //포인트 사용
		b_point_cancel = new JButton("취소");   //포인트 취소
		
		//라벨위치
		la_member.setBounds(148, 30, 121, 54);//회원등급
		la_pay.setBounds(40, 170, 121, 41);//결제금액
		la_discount.setBounds(40, 242, 121, 41);//할인금액
		la_point.setBounds(40, 306, 136, 41);//포인트금액
		la_final_pay.setBounds(40, 368, 161, 41);//최종결제금액
		la_have_cash.setBounds(40, 437, 161, 41);//보유캐쉬
		la_balance.setBounds(40, 476, 161, 41);//사용후잔액
		la_sc_point.setBounds(40, 529, 161, 41);//지급예정포인트
		
		//텍스트에어리어	
		ta_grade.setBounds(253, 40, 161, 34);//등급정보
		ta_pmovie_info.setBounds(86, 96, 311, 35);//영화정보
		ta_pay.setBounds(252, 170, 110, 37);//결제금액
		ta_discount.setBounds(253, 242, 110, 37);//할인금액
		ta_point.setBounds(252, 310, 110, 37);//포인트금액
		ta_final_pay.setBounds(253, 372, 110, 37);//최종결제금액
		ta_have_cash.setBounds(252, 441, 110, 37);//보유캐쉬
		ta_balance.setBounds(252, 476, 110, 37);//사용후잔액
		ta_sc_point.setBounds(252, 529, 110, 37);//지급예정포인트
			
		//버튼 위치
		b_ok.setBounds(118, 599, 105, 41);    		 //최종결제 확인
		b_cancel.setBounds(271, 599, 105, 41); 		 //최종결제 취소
		b_charge_ok.setBounds(432, 264, 61, 27);     //충전 확인
		b_charge_cancel.setBounds(507, 264, 61, 27); //충전 취소
		b_discount_ok.setBounds(432, 500, 61, 27);   //쿠폰 사용
		b_discount_cancel.setBounds(507, 500, 61, 27);//쿠폰 취소
		b_point_ok.setBounds(432, 586, 61, 27);      //포인트 사용
		b_point_cancel.setBounds(507, 586, 61, 27);  //포인트 취소



		
		//contentpane
	    getContentPane().add(p);
	    getContentPane().setLayout(null);
	    getContentPane().add(b_charge_ok);
		getContentPane().add(b_charge_cancel);
		getContentPane().add(b_point_ok);
		getContentPane().add(b_point_cancel);
		getContentPane().add(b_discount_ok);
		getContentPane().add(b_discount_cancel);
		
	    
		p.setLayout(null);
		p.add(la_member);
		p.add(ta_pmovie_info);
		p.add(ta_grade);
		p.add(la_pay);
		p.add(la_discount);
		p.add(la_point);
		p.add(la_final_pay);
		p.add(la_have_cash);
		p.add(la_balance);
		p.add(la_sc_point);
		p.add(b_ok);
		p.add(b_cancel);
		p.add(ta_pay);
		p.add(ta_discount);
		p.add(ta_point);
		p.add(ta_final_pay);
		p.add(ta_have_cash);
		p.add(ta_balance);
		p.add(ta_sc_point);
		
		
        //왼쪽 캐쉬 충전, 할인내역 라벨
		la_cash = new JLabel("캐쉬");
			la_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		la_have_cash = new JLabel("보유캐쉬");
			la_have_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		la_charge_cash = new JLabel("캐쉬 충전");
		la_charge_cash.setForeground(SystemColor.desktop);
			la_charge_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		la_discount_list = new JLabel("할인내역");
			la_discount_list.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		la_discount_coupon = new JLabel("할인 쿠폰");
			la_discount_coupon.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		la_have_point = new JLabel("보유 포인트");
			la_have_point.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		ta_have_cash = new JTextArea();
			ta_have_cash.setBackground(SystemColor.text);
			ta_have_cash.setText("30,000");	
		ta_have_cash = new JTextArea();
			ta_have_cash.setBackground(SystemColor.text);
			ta_have_cash.setText("30,000");
			ta_have_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		ta_have_cash = new JTextArea();
			ta_have_cash.setBackground(SystemColor.text);
			ta_have_cash.setText("30,000");
			ta_have_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			
		//왼쪽 라벨 위치
		la_cash.setBounds(101, 84, 109, 66);
		la_have_cash.setBounds(101, 162, 109, 66);
		la_charge_cash.setBounds(101, 240, 109, 66);
		la_discount_list.setBounds(101, 406, 109, 66);
		la_discount_coupon.setBounds(101, 484, 109, 66);
		la_have_point.setBounds(101, 572, 138, 66);	
		ta_have_cash.setBounds(272, 178, 110, 37);
		
		//contentpane
		getContentPane().add(la_cash);
		getContentPane().add(la_have_cash);
		getContentPane().add(la_charge_cash);
		getContentPane().add(la_discount_list);
		getContentPane().add(la_discount_coupon);
		getContentPane().add(la_have_point);
		getContentPane().add(ta_have_cash);
		
		
		
		//텍스트필드
		tf_charge_cash = new JTextField();
			tf_charge_cash.setBounds(253, 258, 129, 31);
			getContentPane().add(tf_charge_cash);
			tf_charge_cash.setColumns(10);
		tf_use_point = new JTextField();
			tf_use_point.setBounds(253, 584, 129, 31);
			getContentPane().add(tf_use_point);
			tf_use_point.setColumns(10);
		
		//초이스
		ch_copoun= new Choice();
			ch_copoun.add("===== 선택 =====");
			ch_copoun.add("생일 50%할인 쿠폰");
			ch_copoun.add("생일 50%할인 쿠폰");
			ch_copoun.add("생일 50%할인 쿠폰");
			ch_copoun.add("생일 50%할인 쿠폰");
			ch_copoun.setBounds(262, 503, 120, 24);
			getContentPane().add(ch_copoun);
			
		//패널 테두리	
			p_cash = new JPanel();
				p_cash.setBackground(Color.white);
				p_cash.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,Color.BLACK, Color.BLACK, Color.BLACK));
				p_cash.setBounds(77, 84, 532, 259);
				getContentPane().add(p_cash);
				p_cash.setLayout(null);
			p_discount = new JPanel();
				p_discount.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
				p_discount.setBackground(Color.WHITE);
				p_discount.setBounds(77, 406, 532, 259);
				getContentPane().add(p_discount);
				p_discount.setLayout(null);
			
		
		setSize(1200, 800);
		setVisible(false);
		
	}//생성자
}
