package com.playdata.view;

import javax.swing.ImageIcon; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class ScreenView extends JFrame {

	//----------------------------버튼
	JToggleButton bt_seat_a1,bt_seat_a2,bt_seat_a3,bt_seat_a4,bt_seat_a5,bt_seat_a6,bt_seat_a7,bt_seat_a8,bt_seat_a9,bt_seat_a10; //a좌석
	JToggleButton bt_seat_b1,bt_seat_b2,bt_seat_b3,bt_seat_b4,bt_seat_b5,bt_seat_b6,bt_seat_b7,bt_seat_b8,bt_seat_b9,bt_seat_b10; //b좌석
	JToggleButton bt_seat_c1,bt_seat_c2,bt_seat_c3,bt_seat_c4,bt_seat_c5,bt_seat_c6,bt_seat_c7,bt_seat_c8,bt_seat_c9,bt_seat_c10; //c좌석
	
	public JButton select_movie;//페이지 이동
	public JButton pay_view;

	//---------------------------------------라벨
	JLabel lb_a,lb_b,lb_c;//좌석라벨
	JLabel lb_select,lb_unselectable,lb_selecting;//선택,가능 불가능 라벨
	JLabel image_select, image_unselecting,image_selecting;//선택,가능 불가능 이미지 라벨
	JLabel lb_screen;//스크린 라벨
	JLabel lb_theater;//1관,2관....
	JLabel lb_movie_image;//영화 포스터
	
	//--------------------------------------패널
	JPanel p;//screen 패널
	
	
	//--------------------------------------텍스트필드
	JTextField tf_info;//상영관정보
	JTextField tf_seat_info;//좌석정보
	JTextField tf_select_pay;//선택가격
	JTextField tf_movie_info;//영화정보
	
    //--------------------------------------이미지아이콘

	ImageIcon image_witch;
	ImageIcon imageicon_select,imageicon_selecting,imageicon_unselect;
	
	
	public ScreenView() {
		setTitle("ScreenView");

//===================== 버튼 및 라벨  =======================================================	
		//a좌석
		bt_seat_a1 = new JToggleButton("1");
			bt_seat_a1.setForeground(Color.WHITE);
			bt_seat_a1.setBackground(Color.BLUE);
		bt_seat_a2 = new JToggleButton("2");
			bt_seat_a2.setForeground(Color.WHITE);
			bt_seat_a2.setBackground(Color.BLUE);
		bt_seat_a3 = new JToggleButton("3");
			bt_seat_a3.setForeground(Color.WHITE);
			bt_seat_a3.setBackground(Color.BLUE);
		bt_seat_a4 = new JToggleButton("4");
			bt_seat_a4.setForeground(Color.WHITE);
			bt_seat_a4.setBackground(Color.BLUE);
		bt_seat_a5 = new JToggleButton("5");
			bt_seat_a5.setForeground(Color.WHITE);
			bt_seat_a5.setBackground(Color.BLUE);
		bt_seat_a6 = new JToggleButton("6");
			bt_seat_a6.setForeground(Color.WHITE);
			bt_seat_a6.setBackground(Color.BLUE);
		bt_seat_a7 = new JToggleButton("7");
			bt_seat_a7.setForeground(Color.WHITE);
			bt_seat_a7.setBackground(Color.BLUE);
		bt_seat_a8 = new JToggleButton("8");
			bt_seat_a8.setForeground(Color.WHITE);
			bt_seat_a8.setBackground(Color.BLUE);
		bt_seat_a9 = new JToggleButton("9");
			bt_seat_a9.setForeground(Color.WHITE);
			bt_seat_a9.setBackground(Color.BLUE);
		bt_seat_a10 = new JToggleButton("10");
			bt_seat_a10.setForeground(Color.WHITE);
			bt_seat_a10.setBackground(Color.BLUE);
		

		//b좌석
		bt_seat_b1 = new JToggleButton("1");
			bt_seat_b1.setForeground(Color.WHITE);
			bt_seat_b1.setBackground(Color.BLUE);
		bt_seat_b2 = new JToggleButton("2");
			bt_seat_b2.setForeground(Color.WHITE);
			bt_seat_b2.setBackground(Color.BLUE);
		bt_seat_b3 = new JToggleButton("3");
			bt_seat_b3.setForeground(Color.WHITE);
			bt_seat_b3.setBackground(Color.BLUE);
		bt_seat_b4 = new JToggleButton("4");
			bt_seat_b4.setForeground(Color.WHITE);
			bt_seat_b4.setBackground(Color.BLUE);
		bt_seat_b5 = new JToggleButton("5");
			bt_seat_b5.setForeground(Color.WHITE);
			bt_seat_b5.setBackground(Color.BLUE);
		bt_seat_b6 = new JToggleButton("6");
			bt_seat_b6.setForeground(Color.WHITE);
			bt_seat_b6.setBackground(Color.BLUE);
		bt_seat_b7 = new JToggleButton("7");
			bt_seat_b7.setForeground(Color.WHITE);
			bt_seat_b7.setBackground(Color.BLUE);
		bt_seat_b8 = new JToggleButton("8");
			bt_seat_b8.setForeground(Color.WHITE);
			bt_seat_b8.setBackground(Color.BLUE);
		bt_seat_b9 = new JToggleButton("9");
			bt_seat_b9.setForeground(Color.WHITE);
			bt_seat_b9.setBackground(Color.BLUE);
		bt_seat_b10 = new JToggleButton("10");
			bt_seat_b10.setForeground(Color.WHITE);
			bt_seat_b10.setBackground(Color.BLUE);
		
		//c좌석
		bt_seat_c1 = new JToggleButton("1");
			bt_seat_c1.setForeground(Color.WHITE);
			bt_seat_c1.setBackground(Color.BLUE);
		bt_seat_c2 = new JToggleButton("2");
			bt_seat_c2.setForeground(Color.WHITE);
			bt_seat_c2.setBackground(Color.BLUE);
		bt_seat_c3 = new JToggleButton("3");
			bt_seat_c3.setForeground(Color.WHITE);
			bt_seat_c3.setBackground(Color.BLUE);
		bt_seat_c4 = new JToggleButton("4");
			bt_seat_c4.setForeground(Color.WHITE);
			bt_seat_c4.setBackground(Color.BLUE);
		bt_seat_c5 = new JToggleButton("5");
			bt_seat_c5.setForeground(Color.WHITE);
			bt_seat_c5.setBackground(Color.BLUE);
		bt_seat_c6 = new JToggleButton("6");
			bt_seat_c6.setForeground(Color.WHITE);
			bt_seat_c6.setBackground(Color.BLUE);
		bt_seat_c7 = new JToggleButton("7");
			bt_seat_c7.setForeground(Color.WHITE);
			bt_seat_c7.setBackground(Color.BLUE);
		bt_seat_c8 = new JToggleButton("8");
			bt_seat_c8.setForeground(Color.WHITE);
			bt_seat_c8.setBackground(Color.BLUE);
		bt_seat_c9 = new JToggleButton("9");
			bt_seat_c9.setForeground(Color.WHITE);
			bt_seat_c9.setBackground(Color.BLUE);
		bt_seat_c10 = new JToggleButton("10");
			bt_seat_c10.setForeground(Color.WHITE);
			bt_seat_c10.setBackground(Color.BLUE);
		
		//abc 라벨
		lb_a = new JLabel(" A");
			lb_a.setFont(new Font("굴림", Font.PLAIN, 25));
		lb_b = new JLabel(" B");
			lb_b.setFont(new Font("굴림", Font.PLAIN, 25));
		lb_c = new JLabel(" C");
			lb_c.setFont(new Font("굴림", Font.PLAIN, 25));
		
		//페이지 이동
		select_movie = new JButton("영화선택 (이전페이지)");
			select_movie.setBackground(Color.BLACK);
			select_movie.setForeground(Color.WHITE);
		pay_view = new JButton("결제");
			pay_view.setBackground(Color.BLACK);
			pay_view.setForeground(Color.WHITE);
		
		//선택,불가능,가능 라벨
		lb_select = new JLabel("선택중");
		lb_unselectable = new JLabel("예매(선택불가)");
		lb_selecting = new JLabel("선택가능");
		
		//영화 정보 이미지
		image_witch = new ImageIcon("image/witch.png");
		imageicon_select = new ImageIcon("image/select.png");
		imageicon_selecting = new ImageIcon("image/selecting.png");
		imageicon_unselect = new ImageIcon("image/unselect.png");

		//선택,불가능,가능 이미지
		image_select = new JLabel(imageicon_select);
		image_unselecting = new JLabel(imageicon_unselect);
		image_selecting = new JLabel(imageicon_selecting);
		
		
//===================== 위치 =======================================================	
		//a좌석 위치
		bt_seat_a1.setBounds(273, 422, 60, 56);
		bt_seat_a2.setBounds(347, 422, 60, 56);
		bt_seat_a3.setBounds(462, 422, 60, 56);
		bt_seat_a4.setBounds(536, 422, 60, 56);
		bt_seat_a5.setBounds(610, 422, 60, 56);
		bt_seat_a6.setBounds(726, 422, 60, 56);
		bt_seat_a7.setBounds(800, 422, 60, 56);
		bt_seat_a8.setBounds(874, 422, 60, 56);
		bt_seat_a9.setBounds(989, 422, 60, 56);
		bt_seat_a10.setBounds(1063, 422, 60, 56);
		
		//b좌석 위치
		bt_seat_b1.setBounds(273, 490, 60, 56);
		bt_seat_b2.setBounds(347, 490, 60, 56);
		bt_seat_b3.setBounds(462, 490, 60, 56);
		bt_seat_b4.setBounds(536, 490, 60, 56);
		bt_seat_b5.setBounds(610, 490, 60, 56);
		bt_seat_b6.setBounds(726, 490, 60, 56);
		bt_seat_b7.setBounds(800, 490, 60, 56);
		bt_seat_b8.setBounds(874, 490, 60, 56);
		bt_seat_b9.setBounds(989, 490, 60, 56);
		bt_seat_b10.setBounds(1063, 490, 60, 56);

		//c좌석 위치
		bt_seat_c1.setBounds(273, 558, 60, 56);
		bt_seat_c2.setBounds(347, 558, 60, 56);
		bt_seat_c3.setBounds(462, 558, 60, 56);
		bt_seat_c4.setBounds(536, 558, 60, 56);
		bt_seat_c5.setBounds(610, 558, 60, 56);
		bt_seat_c6.setBounds(726, 558, 60, 56);
		bt_seat_c7.setBounds(800, 558, 60, 56);
		bt_seat_c8.setBounds(874, 558, 60, 56);
		bt_seat_c9.setBounds(989, 558, 60, 56);
		bt_seat_c10 .setBounds(1063, 558, 60, 56);
	
		
		//abc 라벨 위치
		lb_a.setBounds(216, 432, 43, 37);
		lb_b.setBounds(216, 498, 43, 37);
		lb_c.setBounds(216, 568, 43, 37);
		
		//페이지 이동 위치
		select_movie.setBounds(50, 804, 170, 125);
		pay_view.setBounds(1063, 804, 170, 125);

		//선택,불가능,가능 라벨 위치
		lb_select.setBounds(91, 441, 62, 18);
		lb_unselectable.setBounds(88, 509, 114, 18);
		lb_selecting.setBounds(88, 577, 62, 18);
		
		//선택,불가능,가능 이미지 위치
		image_select.setBounds(15, 422, 62, 56);
		image_unselecting.setBounds(15, 490, 62, 56);
		image_selecting.setBounds(14, 558, 62, 56);

//===================== contentpane =======================================================	
		//a좌석 contentpane
		getContentPane().setLayout(null);
		getContentPane().add(bt_seat_a1);
		getContentPane().add(bt_seat_a2);
		getContentPane().add(bt_seat_a3);
		getContentPane().add(bt_seat_a4);
		getContentPane().add(bt_seat_a5);
		getContentPane().add(bt_seat_a6);
		getContentPane().add(bt_seat_a7);
		getContentPane().add(bt_seat_a8);
		getContentPane().add(bt_seat_a9);
		getContentPane().add(bt_seat_a10);
		
		
		//b좌석 contentpane
		getContentPane().add(bt_seat_b1);
		getContentPane().add(bt_seat_b2);
		getContentPane().add(bt_seat_b3);
		getContentPane().add(bt_seat_b4);
		getContentPane().add(bt_seat_b5);
		getContentPane().add(bt_seat_b6);
		getContentPane().add(bt_seat_b7);
		getContentPane().add(bt_seat_b8);
		getContentPane().add(bt_seat_b9);
		getContentPane().add(bt_seat_b10);
		
		//c좌석 contentpane
		getContentPane().add(bt_seat_c1);
		getContentPane().add(bt_seat_c2);
		getContentPane().add(bt_seat_c3);
		getContentPane().add(bt_seat_c4);
		getContentPane().add(bt_seat_c5);
		getContentPane().add(bt_seat_c6);
		getContentPane().add(bt_seat_c7);
		getContentPane().add(bt_seat_c8);
		getContentPane().add(bt_seat_c9);
		getContentPane().add(bt_seat_c10);
		
		//abc라벨 contentpane
		getContentPane().add(lb_a);
		getContentPane().add(lb_b);
		getContentPane().add(lb_c);
		
		//페이지 이동 contentpane
		getContentPane().add(select_movie);
		getContentPane().add(pay_view);

		//선택,불가능,가능 라벨 contentpane
		getContentPane().add(lb_select);
		getContentPane().add(lb_unselectable);
		getContentPane().add(lb_selecting);
		
		//선택,불가능,가능 이미지 contentpane
		getContentPane().add(image_select);
		getContentPane().add(image_unselecting);
		getContentPane().add(image_selecting);
		
		
		
//============================ screen ================================
		lb_screen = new JLabel("screen");
		p = new JPanel();
			p.setBackground(Color.WHITE);
			getContentPane().add(p);
			p.setLayout(null);
		
		
		//위치
		p.setBounds(273, 339, 850, 37);
		lb_screen.setBounds(400, 12, 44, 18);
		p.add(lb_screen);
			
		
//=========================== 스크린 정보 ===================================		
		tf_info = new JTextField();
		lb_theater = new JLabel("<1관>");
			lb_theater.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		
			//텍스트 에어리어
		tf_info.setText("영화 정보 (남은좌석,날짜,상영시간)");
			
		//위치
		tf_info.setBounds(390, 92, 590, 208);
		lb_theater.setBounds(642, 43, 113, 37);
		
		//contentpane
		getContentPane().add(tf_info);
		getContentPane().add(lb_theater);
		
		
//========================== 가격, 좌석, 영화 정보 ============================
		tf_select_pay = new JTextField();
		tf_select_pay.setBackground(Color.BLACK);
		tf_select_pay.setForeground(SystemColor.text);
		tf_seat_info = new JTextField();
		tf_seat_info.setForeground(Color.WHITE);
		tf_seat_info.setBackground(Color.BLACK);
		lb_movie_image = new JLabel(image_witch);
		lb_movie_image.setText("");
		tf_movie_info = new JTextField();
		tf_movie_info.setBackground(Color.BLACK);
		tf_movie_info.setForeground(Color.WHITE);
		
		//텍스트 에어리어
		tf_select_pay.setText("선택가격");
		tf_seat_info.setText("좌석정보");
		tf_movie_info.setText("영화정보");
	
		
		//위치
		tf_select_pay.setBounds(784, 803, 196, 126);
		tf_seat_info.setBounds(569, 803, 170, 126);
		tf_movie_info.setBounds(390, 803, 96, 126);
		lb_movie_image.setBounds(228, 726, 151, 227);
		
		//contentpane
		getContentPane().add(tf_select_pay);
		getContentPane().add(tf_seat_info);
		getContentPane().add(lb_movie_image);
		getContentPane().add(tf_movie_info);
		
		
		setBounds(10, 10, 1300, 1000);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		
	}
}
	
