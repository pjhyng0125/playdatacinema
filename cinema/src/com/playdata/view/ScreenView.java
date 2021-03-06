package com.playdata.view;

import javax.swing.ButtonGroup;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class ScreenView extends JFrame {
	
    public JToggleButton []bt_seat;
 
	//----------------------------버튼

	public JButton select_movie,pay_view;//페이지 이동 

	//---------------------------------------라벨
	JLabel lb_a;//좌석라벨
	JLabel lb_select,lb_unselectable,lb_selecting;//선택,가능 불가능 라벨
	JLabel image_select, image_unselecting,image_selecting;//선택,가능 불가능 이미지 라벨
	JLabel lb_screen;//스크린 라벨
	JLabel lb_theater;//1관,2관....
	JLabel lb_movie_image;//영화 포스터
	public JLabel lb_people;//선택인
	
	int selected_time;
	
	//--------------------------------------패널
	JPanel p;//screen 패널
	
	
	//--------------------------------------텍스트필드
	JTextField tf_info;//상영관정보
	public JTextField tf_seat_info;//좌석정보
	public JTextField tf_select_pay;//선택가격
	JTextField tf_movie_info;//영화정보
	
    //--------------------------------------이미지아이콘

	ImageIcon image_witch;
	ImageIcon imageicon_select,imageicon_selecting,imageicon_unselect;
	
	
	LineBorder linea;
	
	//--------------------------------------번호라벨
	private JLabel lb_1,lb_2,lb_3,lb_4,lb_5,lb_6,lb_7,lb_8,lb_9,lb_10,lb_table1,lb_table2,lb_table3,lb_table4,lb_table5;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblNewLabel;
	

	
	public ScreenView() {
		setTitle("좌석선택창");
		
		
	

//===================== 버튼 및 라벨  =======================================================	
		
		//좌석버튼 배열
		bt_seat = new JToggleButton[5];
		int rightShift=0;
		for(int i=0; i<bt_seat.length; i++) {
				
				bt_seat[i] = new JToggleButton();
				bt_seat[i].setForeground(Color.WHITE);
				bt_seat[i].setBackground(Color.BLUE);
				
				//bt_seat[i].setBounds(273+(i*75), 509, 60, 56);//x,y,가로,세로
				bt_seat[i].setBounds(273+(i*195)+rightShift, 509, 120, 56);//x,y,가로,세로
			if(i%1!=0) {
				rightShift+=39;
			}
			
		
			getContentPane().add(bt_seat[i]);
			
		}
		//라벨 테두리
		linea = new LineBorder(new Color(153, 56, 0),2);
		
		
		//abc 라벨
		lb_a = new JLabel(" A");
			lb_a.setFont(new Font("굴림", Font.PLAIN, 25));
		
		//페이지 이동
		select_movie = new JButton("영화선택(이전페이지)");
		select_movie.setFont(new Font("굴림", Font.BOLD, 12));
			select_movie.setBackground(new Color(52,52,51));
			select_movie.setForeground(Color.WHITE);
		
		pay_view = new JButton("결제");
		pay_view.setFont(new Font("굴림", Font.BOLD, 15));
			pay_view.setBackground(new Color(52,52,51));
			pay_view.setForeground(Color.WHITE);
		pay_view.setEnabled(false);
			
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
		lb_a.setBounds(216, 522, 43, 37);
		
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
		p.setBorder(new BevelBorder(1, Color.BLACK, Color.black));
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
		tf_select_pay.setHorizontalAlignment(JTextField.CENTER);
		tf_seat_info = new JTextField();
		tf_seat_info.setHorizontalAlignment(JTextField.CENTER);
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
		lb_1.setBounds(266, 483, 62, 18);
		getContentPane().add(lb_1);
		
		lb_2 = new JLabel("2");
		lb_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_2.setFont(new Font("굴림", Font.BOLD, 15));
		lb_2.setBounds(339, 483, 62, 18);
		getContentPane().add(lb_2);
		
		lb_3 = new JLabel("3");
		lb_3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_3.setFont(new Font("굴림", Font.BOLD, 15));
		lb_3.setBounds(461, 483, 62, 18);
		getContentPane().add(lb_3);
		
		lb_4 = new JLabel("4");
		lb_4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_4.setFont(new Font("굴림", Font.BOLD, 15));
		lb_4.setBounds(532, 483, 62, 18);
		getContentPane().add(lb_4);
		
		lb_5 = new JLabel("5");
		lb_5.setHorizontalAlignment(SwingConstants.CENTER);
		lb_5.setFont(new Font("굴림", Font.BOLD, 15));
		lb_5.setBounds(655, 483, 62, 18);
		getContentPane().add(lb_5);
		
		lb_6 = new JLabel("6");
		lb_6.setHorizontalAlignment(SwingConstants.CENTER);
		lb_6.setFont(new Font("굴림", Font.BOLD, 15));
		lb_6.setBounds(730, 483, 62, 18);
		getContentPane().add(lb_6);
		
		lb_7 = new JLabel("7");
		lb_7.setHorizontalAlignment(SwingConstants.CENTER);
		lb_7.setFont(new Font("굴림", Font.BOLD, 15));
		lb_7.setBounds(847, 483, 62, 18);
		getContentPane().add(lb_7);
		
		lb_8 = new JLabel("8");
		lb_8.setHorizontalAlignment(SwingConstants.CENTER);
		lb_8.setFont(new Font("굴림", Font.BOLD, 15));
		lb_8.setBounds(922, 483, 62, 18);
		getContentPane().add(lb_8);
		
		lb_9 = new JLabel("9");
		lb_9.setHorizontalAlignment(SwingConstants.CENTER);
		lb_9.setFont(new Font("굴림", Font.BOLD, 15));
		lb_9.setBounds(1038, 483, 62, 18);
		getContentPane().add(lb_9);
		
		lb_10 = new JLabel("10");
		lb_10.setHorizontalAlignment(SwingConstants.CENTER);
		lb_10.setFont(new Font("굴림", Font.BOLD, 15));
		lb_10.setBounds(1113, 483, 62, 18);
		getContentPane().add(lb_10);
		
		//테이블
		lb_table1 = new JLabel("table");
		lb_table1.setBackground(Color.WHITE);
		lb_table1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lb_table1.setForeground(Color.BLACK);
		lb_table1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_table1.setOpaque(true);
		lb_table1.setBorder(linea);
		lb_table1.setBounds(297, 453, 75, 18);
		getContentPane().add(lb_table1);
		
		lb_table2 = new JLabel("table");
		lb_table2.setOpaque(true);
		lb_table2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_table2.setForeground(Color.BLACK);
		lb_table2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lb_table2.setBorder(linea);
		lb_table2.setOpaque(true);
		lb_table2.setBorder(linea);
		lb_table2.setBackground(Color.WHITE);
		lb_table2.setBounds(492, 453, 75, 18);
		getContentPane().add(lb_table2);
		
		lb_table3 = new JLabel("table");
		lb_table3.setOpaque(true);
		lb_table3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_table3.setForeground(Color.BLACK);
		lb_table3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lb_table3.setBorder(linea);
		lb_table3.setBackground(Color.WHITE);
		lb_table3.setBounds(687, 453, 75, 18);
		getContentPane().add(lb_table3);
		
		lb_table4 = new JLabel("table");
		lb_table4.setOpaque(true);
		lb_table4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_table4.setForeground(Color.BLACK);
		lb_table4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lb_table4.setBorder(linea);
		lb_table4.setBackground(Color.WHITE);
		lb_table4.setBounds(879, 453, 75, 18);
		getContentPane().add(lb_table4);
		
		lb_table5 = new JLabel("table");
		lb_table5.setOpaque(true);
		lb_table5.setHorizontalAlignment(SwingConstants.CENTER);
		lb_table5.setForeground(Color.BLACK);
		lb_table5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lb_table5.setBorder(linea);
		lb_table5.setBackground(Color.WHITE);
		lb_table5.setBounds(1071, 453, 75, 18);
		getContentPane().add(lb_table5);
		
		lb_people = new JLabel("선택인원: ");
		lb_people.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_people.setBounds(59, 121, 200, 50);
		getContentPane().add(lb_people);
		
		
		
		
		setBounds(10, 10, 1300, 1000);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	
	public int checkindex() {
		int index = 0;
	
		for(int i=0; i<bt_seat.length; i++) {
			if(bt_seat[i].isSelected())
				index = i;
			
				
			tf_seat_info.setText("좌석 번호: A"+index+"");			
		}
		return index;
	}
	
	public int checkClicked() {
		int count=0;
		for(int i=0; i<bt_seat.length; i++) {
			if(bt_seat[i].isSelected())
				count+=2;
		}
		return count;
	}
	
	public boolean checkSelected() {
		boolean flag = false;
		for(int i=0; i<bt_seat.length; i++) {
			if(bt_seat[i].isSelected()) {
				flag = true;
				bt_seat[i].setIcon(new ImageIcon("image/selecting.png"));
			}else {
				bt_seat[i].setIcon(new ImageIcon("image/select.png"));
			}
			
		}
		return flag;
	}
	
	public void checklast() {
		for(int i=0; i<bt_seat.length; i++) {
			if(bt_seat[i].isSelected()) {
				bt_seat[i].setIcon(new ImageIcon("image/selecting.png"));
			}else {
				bt_seat[i].setIcon(new ImageIcon("image/select.png"));
			}
		}
	}
	
	public ArrayList<Integer> addIndexList() {	//좌석을 선택하고 결제 버튼 선택 직후 선택된 좌석의 인덱스를 리턴
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<bt_seat.length; i++) {
			if(bt_seat[i].isSelected())
				list.add(i);
		}
		return list;
	}
	
	public void setDefaultSeat() {	//v_screen 앞 뒤로 이동시 가장 먼저 호출
		for(int i=0; i<bt_seat.length; i++)
			bt_seat[i].setSelected(false);
	}
	
	
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	  public void showMsg(String msg) {
			JOptionPane.showMessageDialog(this, msg);
		}
	  
}
	
