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
 
	//----------------------------��ư

	public JButton select_movie,pay_view;//������ �̵� 

	//---------------------------------------��
	JLabel lb_a;//�¼���
	JLabel lb_select,lb_unselectable,lb_selecting;//����,���� �Ұ��� ��
	JLabel image_select, image_unselecting,image_selecting;//����,���� �Ұ��� �̹��� ��
	JLabel lb_screen;//��ũ�� ��
	JLabel lb_theater;//1��,2��....
	JLabel lb_movie_image;//��ȭ ������
	
	
	//--------------------------------------�г�
	JPanel p;//screen �г�
	
	
	//--------------------------------------�ؽ�Ʈ�ʵ�
	JTextField tf_info;//�󿵰�����
	JTextField tf_seat_info;//�¼�����
	JTextField tf_select_pay;//���ð���
	JTextField tf_movie_info;//��ȭ����
	
    //--------------------------------------�̹���������

	ImageIcon image_witch;
	ImageIcon imageicon_select,imageicon_selecting,imageicon_unselect;
	
	
	LineBorder linea;
	
	//--------------------------------------��ȣ��
	private JLabel lb_1,lb_2,lb_3,lb_4,lb_5,lb_6,lb_7,lb_8,lb_9,lb_10,lb_table1,lb_table2,lb_table3,lb_table4,lb_table5;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	

	
	public ScreenView() {
		setTitle("�¼�����â");
		
		
	

//===================== ��ư �� ��  =======================================================	
		
		//�¼���ư �迭
		bt_seat = new JToggleButton[10];
		int cnt;
		for(int i=0; i<bt_seat.length; i++) {
				
				bt_seat[i] = new JToggleButton();
				bt_seat[i].setForeground(Color.WHITE);
				bt_seat[i].setBackground(Color.BLUE);
			//a_bt[i].setBounds(273*(i)+70, 422, 60, 56);//x,y,����,����
			//                     70, 343,  616, ..... (273����) 273-60=213
				bt_seat[i].setBounds(273+(i*75), 509, 60, 56);//x,y,����,����
			if(i>=2)
				bt_seat[i].setBounds(273+(i*75)+39, 509, 60, 56);//x,y,����,����
			if(i>=4)
				bt_seat[i].setBounds(273+(i*75)+78, 509, 60, 56);//x,y,����,����
			if(i>=6)
				bt_seat[i].setBounds(273+(i*75)+117, 509, 60, 56);//x,y,����,����
			if(i>=8)
				bt_seat[i].setBounds(273+(i*75)+156, 509, 60, 56);//x,y,����,����
		

			getContentPane().add(bt_seat[i]);
			
		}
		//�� �׵θ�
		linea = new LineBorder(new Color(153, 56, 0),2);
		
		//abc ��
		lb_a = new JLabel(" A");
			lb_a.setFont(new Font("����", Font.PLAIN, 25));
		
		//������ �̵�
		select_movie = new JButton("��ȭ����(����������)");
		select_movie.setFont(new Font("����", Font.BOLD, 12));
			select_movie.setBackground(new Color(52,52,51));
			select_movie.setForeground(Color.WHITE);
		
		pay_view = new JButton("����");
		pay_view.setFont(new Font("����", Font.BOLD, 15));
			pay_view.setBackground(new Color(52,52,51));
			pay_view.setForeground(Color.WHITE);
		
		//����,�Ұ���,���� ��
		lb_select = new JLabel("������");
		lb_unselectable = new JLabel("����(���úҰ�)");
		lb_selecting = new JLabel("���ð���");
		
		//��ȭ ���� �̹���
		image_witch = new ImageIcon("image/witch.png");
		imageicon_select = new ImageIcon("image/select.png");
		imageicon_selecting = new ImageIcon("image/selecting.png");
		imageicon_unselect = new ImageIcon("image/unselect.png");

		//����,�Ұ���,���� �̹���
		image_select = new JLabel(imageicon_selecting);
		image_unselecting = new JLabel(imageicon_unselect);
		image_selecting = new JLabel(imageicon_select);
		
		
//===================== ��ġ =======================================================	

		//abc �� ��ġ
		lb_a.setBounds(216, 522, 43, 37);
		
		//������ �̵� ��ġ
		select_movie.setBounds(50, 804, 170, 125);
		pay_view.setBounds(1063, 804, 170, 125);

		//����,�Ұ���,���� �� ��ġ
		lb_select.setBounds(91, 441, 62, 18);
		lb_unselectable.setBounds(88, 509, 114, 18);
		lb_selecting.setBounds(88, 577, 62, 18);
		
		//����,�Ұ���,���� �̹��� ��ġ
		image_select.setBounds(15, 422, 62, 56);
		image_unselecting.setBounds(15, 490, 62, 56);
		image_selecting.setBounds(14, 558, 62, 56);

//===================== contentpane =======================================================	
		//contentpane
		getContentPane().setLayout(null);

		
		

		
		//abc�� contentpane
		getContentPane().add(lb_a);
		
		//������ �̵� contentpane
		getContentPane().add(select_movie);
		getContentPane().add(pay_view);

		//����,�Ұ���,���� �� contentpane
		getContentPane().add(lb_select);
		getContentPane().add(lb_unselectable);
		getContentPane().add(lb_selecting);
		
		//����,�Ұ���,���� �̹��� contentpane
		getContentPane().add(image_select);
		getContentPane().add(image_unselecting);
		getContentPane().add(image_selecting);
		
		
		
//============================ screen ================================
		lb_screen = new JLabel("screen");
		p = new JPanel();
			p.setBackground(Color.WHITE);
			getContentPane().add(p);
			p.setLayout(null);
		
		
		//��ġ
		p.setBounds(273, 339, 850, 37);
		lb_screen.setBounds(400, 12, 44, 18);
		p.add(lb_screen);
			
		
//=========================== ��ũ�� ���� ===================================		
		tf_info = new JTextField();
		lb_theater = new JLabel("<1��>");
			lb_theater.setFont(new Font("���� ���", Font.PLAIN, 30));
		
			//�ؽ�Ʈ �����
		tf_info.setText("��ȭ ���� (�����¼�,��¥,�󿵽ð�)");
			
		//��ġ
		tf_info.setBounds(390, 92, 590, 208);
		lb_theater.setBounds(642, 43, 113, 37);
		
		//contentpane
		getContentPane().setBackground(new Color(247, 246, 239));
		getContentPane().add(tf_info);
		getContentPane().add(lb_theater);
		
		
//========================== ����, �¼�, ��ȭ ���� ============================
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
		
		//�ؽ�Ʈ �����
		tf_select_pay.setText("���ð���");
		tf_seat_info.setText("�¼�����");
		tf_movie_info.setText("��ȭ����");
	
		
		//��ġ
		tf_select_pay.setBounds(784, 803, 196, 126);
		tf_seat_info.setBounds(569, 803, 170, 126);
		tf_movie_info.setBounds(390, 803, 96, 126);
		lb_movie_image.setBounds(228, 726, 151, 227);
		
		//contentpane
		getContentPane().add(tf_select_pay);
		getContentPane().add(tf_seat_info);
		getContentPane().add(lb_movie_image);
		getContentPane().add(tf_movie_info);
		
		
		//�׳� �¼� ����
		lb_1 = new JLabel("1");
		lb_1.setFont(new Font("����", Font.BOLD, 15));
		lb_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_1.setBounds(273, 483, 62, 18);
		getContentPane().add(lb_1);
		
		lb_2 = new JLabel("2");
		lb_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_2.setFont(new Font("����", Font.BOLD, 15));
		lb_2.setBounds(345, 483, 62, 18);
		getContentPane().add(lb_2);
		
		lb_3 = new JLabel("3");
		lb_3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_3.setFont(new Font("����", Font.BOLD, 15));
		lb_3.setBounds(459, 483, 62, 18);
		getContentPane().add(lb_3);
		
		lb_4 = new JLabel("4");
		lb_4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_4.setFont(new Font("����", Font.BOLD, 15));
		lb_4.setBounds(534, 483, 62, 18);
		getContentPane().add(lb_4);
		
		lb_5 = new JLabel("5");
		lb_5.setHorizontalAlignment(SwingConstants.CENTER);
		lb_5.setFont(new Font("����", Font.BOLD, 15));
		lb_5.setBounds(648, 483, 62, 18);
		getContentPane().add(lb_5);
		
		lb_6 = new JLabel("6");
		lb_6.setHorizontalAlignment(SwingConstants.CENTER);
		lb_6.setFont(new Font("����", Font.BOLD, 15));
		lb_6.setBounds(723, 483, 62, 18);
		getContentPane().add(lb_6);
		
		lb_7 = new JLabel("7");
		lb_7.setHorizontalAlignment(SwingConstants.CENTER);
		lb_7.setFont(new Font("����", Font.BOLD, 15));
		lb_7.setBounds(837, 483, 62, 18);
		getContentPane().add(lb_7);
		
		lb_8 = new JLabel("8");
		lb_8.setHorizontalAlignment(SwingConstants.CENTER);
		lb_8.setFont(new Font("����", Font.BOLD, 15));
		lb_8.setBounds(912, 483, 62, 18);
		getContentPane().add(lb_8);
		
		lb_9 = new JLabel("9");
		lb_9.setHorizontalAlignment(SwingConstants.CENTER);
		lb_9.setFont(new Font("����", Font.BOLD, 15));
		lb_9.setBounds(1026, 483, 62, 18);
		getContentPane().add(lb_9);
		
		lb_10 = new JLabel("10");
		lb_10.setHorizontalAlignment(SwingConstants.CENTER);
		lb_10.setFont(new Font("����", Font.BOLD, 15));
		lb_10.setBounds(1101, 483, 62, 18);
		getContentPane().add(lb_10);
		
		//���̺�
		lb_table1 = new JLabel("table");
		lb_table1.setBackground(Color.WHITE);
		lb_table1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lb_table1.setForeground(Color.BLACK);
		lb_table1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_table1.setOpaque(true);
		lb_table1.setBorder(linea);
		lb_table1.setBounds(304, 453, 75, 18);
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
		lb_table3.setBounds(680, 453, 75, 18);
		getContentPane().add(lb_table3);
		
		lb_table4 = new JLabel("table");
		lb_table4.setOpaque(true);
		lb_table4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_table4.setForeground(Color.BLACK);
		lb_table4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lb_table4.setBorder(linea);
		lb_table4.setBackground(Color.WHITE);
		lb_table4.setBounds(869, 453, 75, 18);
		getContentPane().add(lb_table4);
		
		lb_table5 = new JLabel("table");
		lb_table5.setOpaque(true);
		lb_table5.setHorizontalAlignment(SwingConstants.CENTER);
		lb_table5.setForeground(Color.BLACK);
		lb_table5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lb_table5.setBorder(linea);
		lb_table5.setBackground(Color.WHITE);
		lb_table5.setBounds(1059, 453, 75, 18);
		getContentPane().add(lb_table5);
		
		
		
		
		setBounds(10, 10, 1300, 1000);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
	
