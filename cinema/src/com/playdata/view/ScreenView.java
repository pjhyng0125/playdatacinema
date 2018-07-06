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
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class ScreenView extends JFrame {
	
    public JToggleButton []bt_seat; 
 
	//----------------------------버튼

	public JButton select_movie,pay_view;//페이지 이동 

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
	
	
	//--------------------------------------번호라벨
	private JLabel lb_1,lb_2,lb_3,lb_4,lb_5,lb_6,lb_7,lb_8,lb_9,lb_10;
	

	
	public ScreenView() {
		setTitle("좌석선택창");
		
		
	

//===================== 버튼 및 라벨  =======================================================	
		
		//좌석버튼 배열
		bt_seat = new JToggleButton[30];
		for(int i=0; i<bt_seat.length; i++) {
				bt_seat[i] = new JToggleButton();
				bt_seat[i].setForeground(Color.WHITE);
				bt_seat[i].setBackground(Color.BLUE);
			//a_bt[i].setBounds(273*(i)+70, 422, 60, 56);//x,y,가로,세로
			//                     70, 343,  616, ..... (273간격) 273-60=213
				bt_seat[i].setBounds(273+(i*75), 422, 60, 56);//x,y,가로,세로
			if(i>=2)
				bt_seat[i].setBounds(273+(i*75)+39, 422, 60, 56);//x,y,가로,세로
			if(i>=5)
				bt_seat[i].setBounds(273+(i*75)+78, 422, 60, 56);//x,y,가로,세로
			if(i>=8)
				bt_seat[i].setBounds(273+(i*75)+117, 422, 60, 56);//x,y,가로,세로
			if(i>9)
				bt_seat[i].setBounds((i*75)-477, 490, 60, 56);//x,y,가로,세로
			if(i>11)
				bt_seat[i].setBounds((i*75)-438, 490, 60, 56);//x,y,가로,세로
			if(i>14)
				bt_seat[i].setBounds((i*75)-399, 490, 60, 56);//x,y,가로,세로
			if(i>17)
				bt_seat[i].setBounds((i*75)-360, 490, 60, 56);//x,y,가로,세로
			if(i>19)
				bt_seat[i].setBounds((i*75)-1227, 558, 60, 56);//x,y,가로,세로
			if(i>21)
				bt_seat[i].setBounds((i*75)-1188, 558, 60, 56);//x,y,가로,세로
			if(i>24)
				bt_seat[i].setBounds((i*75)-1149, 558, 60, 56);//x,y,가로,세로
			if(i>27)
				bt_seat[i].setBounds((i*75)-1110, 558, 60, 56);//x,y,가로,세로

			getContentPane().add(bt_seat[i]);
			
		}
		
		//abc 라벨
		lb_a = new JLabel(" A");
			lb_a.setFont(new Font("굴림", Font.PLAIN, 25));
		lb_b = new JLabel(" B");
			lb_b.setFont(new Font("굴림", Font.PLAIN, 25));
		lb_c = new JLabel(" C");
			lb_c.setFont(new Font("굴림", Font.PLAIN, 25));
		
		//페이지 이동
		select_movie = new JButton("영화선택(이전페이지)");
		select_movie.setFont(new Font("굴림", Font.BOLD, 12));
			select_movie.setBackground(new Color(52,52,51));
			select_movie.setForeground(Color.WHITE);
		
		pay_view = new JButton("결제");
		pay_view.setFont(new Font("굴림", Font.BOLD, 15));
			pay_view.setBackground(new Color(52,52,51));
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
		image_select = new JLabel(imageicon_selecting);
		image_unselecting = new JLabel(imageicon_unselect);
		image_selecting = new JLabel(imageicon_select);
		
		
//===================== 위치 =======================================================	

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
		//contentpane
		getContentPane().setLayout(null);

		
		

		
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
		getContentPane().setBackground(new Color(247, 246, 239));
		getContentPane().add(tf_info);
		getContentPane().add(lb_theater);
		
		
//========================== 가격, 좌석, 영화 정보 ============================
		tf_select_pay = new JTextField();
		tf_select_pay.setBackground(new Color(52,52,51));
		tf_select_pay.setForeground(SystemColor.text);
		tf_seat_info = new JTextField();
		tf_seat_info.setForeground(Color.WHITE);
		tf_seat_info.setBackground(new Color(52,52,51));
		lb_movie_image = new JLabel(image_witch);
		lb_movie_image.setText("");
		tf_movie_info = new JTextField();
		tf_movie_info.setBackground(new Color(52,52,51));
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
		
		
		//그냥 좌석 숫자
		lb_1 = new JLabel("1");
		lb_1.setFont(new Font("굴림", Font.BOLD, 15));
		lb_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_1.setBounds(273, 398, 62, 18);
		getContentPane().add(lb_1);
		
		lb_2 = new JLabel("2");
		lb_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_2.setFont(new Font("굴림", Font.BOLD, 15));
		lb_2.setBounds(347, 398, 62, 18);
		getContentPane().add(lb_2);
		
		lb_3 = new JLabel("3");
		lb_3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_3.setFont(new Font("굴림", Font.BOLD, 15));
		lb_3.setBounds(460, 398, 62, 18);
		getContentPane().add(lb_3);
		
		lb_4 = new JLabel("4");
		lb_4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_4.setFont(new Font("굴림", Font.BOLD, 15));
		lb_4.setBounds(536, 398, 62, 18);
		getContentPane().add(lb_4);
		
		lb_5 = new JLabel("5");
		lb_5.setHorizontalAlignment(SwingConstants.CENTER);
		lb_5.setFont(new Font("굴림", Font.BOLD, 15));
		lb_5.setBounds(610, 398, 62, 18);
		getContentPane().add(lb_5);
		
		lb_6 = new JLabel("6");
		lb_6.setHorizontalAlignment(SwingConstants.CENTER);
		lb_6.setFont(new Font("굴림", Font.BOLD, 15));
		lb_6.setBounds(724, 398, 62, 18);
		getContentPane().add(lb_6);
		
		lb_7 = new JLabel("7");
		lb_7.setHorizontalAlignment(SwingConstants.CENTER);
		lb_7.setFont(new Font("굴림", Font.BOLD, 15));
		lb_7.setBounds(798, 398, 62, 18);
		getContentPane().add(lb_7);
		
		lb_8 = new JLabel("8");
		lb_8.setHorizontalAlignment(SwingConstants.CENTER);
		lb_8.setFont(new Font("굴림", Font.BOLD, 15));
		lb_8.setBounds(872, 398, 62, 18);
		getContentPane().add(lb_8);
		
		lb_9 = new JLabel("9");
		lb_9.setHorizontalAlignment(SwingConstants.CENTER);
		lb_9.setFont(new Font("굴림", Font.BOLD, 15));
		lb_9.setBounds(989, 398, 62, 18);
		getContentPane().add(lb_9);
		
		lb_10 = new JLabel("10");
		lb_10.setHorizontalAlignment(SwingConstants.CENTER);
		lb_10.setFont(new Font("굴림", Font.BOLD, 15));
		lb_10.setBounds(1063, 398, 62, 18);
		getContentPane().add(lb_10);
		
		
		
		
		setBounds(10, 10, 1300, 1000);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		
	}

}
	
