package com.playdata.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
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
	private JLabel la_have_cash_1;
	JLabel la_balance;// 사용후 잔액
	JLabel la_sc_point;// 지급예정포인트
	JLabel la_cash;//왼쪽 캐쉬
	JLabel la_charge_cash;//캐쉬충전
	JLabel la_discount_list, la_discount_coupon,la_have_point;//할인내역,할인쿠폰,보유포인트
	Choice ch_copoun;//쿠폰 선택
	
	//-----------------------------텍스트필드
	JTextField tf_grade;//등급정보
	JTextField tf_pmovie_info;//영화정보
    JTextField tf_pay;//결제금액
    JTextField tf_discount;//할인금액
    JTextField tf_point;//포인트금액
    JTextField tf_final_pay;//최종결제금액
    JTextField tf_have_cash;//보유캐쉬
    private JTextField tf_have_cash_1;
    JTextField tf_balance;//사용후 잔액
    JTextField tf_sc_point;//지급예정포인트
    JTextField tf_charge_cash;//캐쉬충전
    JTextField tf_use_point;//포인트 사용
    
    //-------------------------------버튼
    JButton b_ok,b_cancel;//오른쪽 확인,취소
    JButton b_charge_ok,b_charge_cancel;//캐쉬 충전 취소
    JButton b_discount_ok,b_discount_cancel;//할인 쿠폰 사용 취소
    JButton b_point_ok,b_point_cancel;//포인트 사용 취소
    private JPanel panel_1;
    
    //-------------------------------테두리
    LineBorder lineb,linea;
    

	
	
	public PayView() {
		setTitle("결제창");
		lineb = new LineBorder(Color.white);
		linea = new LineBorder(Color.BLACK,3);
//============ 결제 진행 정보 ===========
		p = new JPanel();
			p.setBackground(Color.WHITE);
			p.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, 
					Color.BLACK, Color.BLACK, Color.BLACK));
			p.setBounds(667, 40, 470, 652);
		la_member = new JLabel("회원등급");
			la_member.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		tf_pmovie_info = new JTextField();
			tf_pmovie_info.setText("영화정보 (날짜,시작시간,상영관)");
		tf_grade = new JTextField();
			tf_grade.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			tf_grade.setText("등급정보");
			tf_grade.setBorder(lineb);
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
		
		//텍스트필드	
		tf_pay = new JTextField();
		tf_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		    tf_pay.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		    tf_pay.setText("16,000");	
		    tf_pay.setBorder(lineb);
		tf_discount = new JTextField();
		tf_discount.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_discount.setText("0");
			tf_discount.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			tf_discount.setBorder(lineb);
		tf_point = new JTextField();
		tf_point.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_point.setText("2,000");
			tf_point.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			tf_point.setBorder(lineb);
		tf_final_pay = new JTextField();
		tf_final_pay.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_final_pay.setText("14,000");
			tf_final_pay.setFont(new Font("맑은 고딕", Font.PLAIN, 22));	
			tf_final_pay.setBorder(lineb);
		tf_have_cash = new JTextField();
		tf_have_cash.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_have_cash.setText("30,000");
			tf_have_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			tf_have_cash.setBorder(lineb);
		tf_balance = new JTextField();
		tf_balance.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_balance.setText("16,000");
			tf_balance.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			tf_balance.setBorder(lineb);
		tf_sc_point = new JTextField();
		tf_sc_point.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_sc_point.setText("140");
			tf_sc_point.setFont(new Font("맑은 고딕", Font.PLAIN, 21));		
			tf_sc_point.setBorder(lineb);
		
			
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
		
		//텍스트필드
		tf_grade.setBounds(253, 40, 161, 34);//등급정보
		tf_pmovie_info.setBounds(86, 96, 311, 35);//영화정보
		tf_pay.setBounds(252, 170, 110, 37);//결제금액
		tf_discount.setBounds(253, 242, 110, 37);//할인금액
		tf_point.setBounds(252, 310, 110, 37);//포인트금액
		tf_final_pay.setBounds(253, 372, 110, 37);//최종결제금액
		tf_have_cash.setBounds(252, 441, 110, 37);//보유캐쉬
		tf_balance.setBounds(252, 476, 110, 37);//사용후잔액
		tf_sc_point.setBounds(252, 529, 110, 37);//지급예정포인트
			
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
		p.add(tf_pmovie_info);
		p.add(tf_grade);
		p.add(la_pay);
		p.add(la_discount);
		p.add(la_point);
		p.add(la_final_pay);
		p.add(la_have_cash);
		p.add(la_balance);
		p.add(la_sc_point);
		p.add(b_ok);
		p.add(b_cancel);
		p.add(tf_pay);
		p.add(tf_discount);
		p.add(tf_point);
		p.add(tf_final_pay);
		p.add(tf_have_cash);
		p.add(tf_balance);
		p.add(tf_sc_point);
		
		
        //왼쪽 캐쉬 충전, 할인내역 라벨
		la_cash = new JLabel("캐쉬");
		la_cash.setHorizontalAlignment(SwingConstants.CENTER);
			la_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			la_cash.setBorder(linea);
		la_have_cash_1 = new JLabel("보유캐쉬");
		la_have_cash_1.setHorizontalAlignment(SwingConstants.CENTER);
			la_have_cash_1.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	/*	tf_have_cash = new JTextField();
			tf_have_cash.setBackground(SystemColor.text);
			tf_have_cash.setText("30,000");	
			tf_have_cash.setBorder(lineb);*///왜 더있지??
		tf_have_cash = new JTextField();
			tf_have_cash.setBackground(SystemColor.text);
			tf_have_cash.setText("30,000");
			tf_have_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			
		//왼쪽 라벨 위치
		la_cash.setBounds(101, 103, 109, 47);
		la_have_cash_1.setBounds(101, 178, 109, 50);
		
		//contentpane
		getContentPane().add(la_cash);
		getContentPane().add(la_have_cash_1);
		
		
		
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
			ch_copoun.setBounds(253, 503, 129, 24);
			getContentPane().add(ch_copoun);
			
		//패널 테두리	
			p_cash = new JPanel();
				p_cash.setBackground(Color.white);
				p_cash.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,Color.BLACK, Color.BLACK, Color.BLACK));
				p_cash.setBounds(77, 84, 532, 259);
				getContentPane().add(p_cash);
				p_cash.setLayout(null);
				la_charge_cash = new JLabel("캐쉬 충전");
				la_charge_cash.setHorizontalAlignment(SwingConstants.CENTER);
				la_charge_cash.setBounds(27, 167, 109, 47);
				p_cash.add(la_charge_cash);
				la_charge_cash.setForeground(SystemColor.desktop);
				la_charge_cash.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
				tf_have_cash_1 = new JTextField();
				tf_have_cash_1.setBounds(195, 102, 110, 37);
				p_cash.add(tf_have_cash_1);
				tf_have_cash_1.setHorizontalAlignment(SwingConstants.RIGHT);
				tf_have_cash_1.setBackground(SystemColor.text);
				tf_have_cash_1.setText("30,000");
				tf_have_cash_1.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
				tf_have_cash_1.setBorder(lineb);
			p_discount = new JPanel();
				p_discount.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
				p_discount.setBackground(Color.WHITE);
				p_discount.setBounds(77, 406, 532, 259);
				getContentPane().add(p_discount);
				p_discount.setLayout(null);
				la_discount_list = new JLabel("할인내역");
				la_discount_list.setHorizontalAlignment(SwingConstants.CENTER);
				la_discount_list.setBorder(linea);
				la_discount_list.setBounds(24, 12, 109, 47);
				p_discount.add(la_discount_list);
				la_discount_list.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
				la_discount_coupon = new JLabel("할인 쿠폰");
				la_discount_coupon.setHorizontalAlignment(SwingConstants.CENTER);
				la_discount_coupon.setBounds(24, 83, 109, 50);
				p_discount.add(la_discount_coupon);
				la_discount_coupon.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
				la_have_point = new JLabel("보유 포인트");
				la_have_point.setHorizontalAlignment(SwingConstants.CENTER);
				la_have_point.setBounds(24, 166, 129, 47);
				p_discount.add(la_have_point);
				la_have_point.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			
		
		setSize(1200, 800);
		setVisible(true);
		
	}//생성자
}
