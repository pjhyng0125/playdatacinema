package com.playdata.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class ScreenView extends JFrame {

	//----------------------------��ư
	JToggleButton seat_a1,seat_a2,seat_a3,seat_a4,seat_a5,seat_a6,seat_a7,seat_a8,seat_a9,seat_a10; //a�¼�
	JToggleButton seat_b1,seat_b2,seat_b3,seat_b4,seat_b5,seat_b6,seat_b7,seat_b8,seat_b9,seat_b10; //b�¼�
	JToggleButton seat_c1,seat_c2,seat_c3,seat_c4,seat_c5,seat_c6,seat_c7,seat_c8,seat_c9,seat_c10; //c�¼�
	
	JButton select_movie,pay_view;//������ �̵�

	//---------------------------------------��
	JLabel a_l,b_l,c_l;//�¼���
	JLabel select_l,Unselectable_l,selecting_l;//����,���� �Ұ��� ��
	JLabel image_select, image_unselecting,image_selecting;//����,���� �Ұ��� �̹��� ��
	JLabel screen_l;//��ũ�� ��
	JLabel theater_l;//1��,2��....
	JLabel movie_image;//��ȭ ������
	
	//--------------------------------------�г�
	JPanel p;//screen �г�
	
	//--------------------------------------�ؽ�Ʈ�����
	JTextArea info_ta;//�󿵰�����
	JTextArea seat_info_ta;//�¼�����
	JTextArea select_pay_ta;//���ð���
	JTextArea movie_info_ta;//��ȭ����

	public ScreenView() {
		setTitle("ScreenView");

//===================== ��ư �� ��  =======================================================	
		//a�¼�
		seat_a1 = new JToggleButton("1");
			seat_a1.setForeground(Color.WHITE);
			seat_a1.setBackground(Color.BLUE);
		seat_a2 = new JToggleButton("2");
			seat_a2.setForeground(Color.WHITE);
			seat_a2.setBackground(Color.BLUE);
		seat_a3 = new JToggleButton("3");
			seat_a3.setForeground(Color.WHITE);
			seat_a3.setBackground(Color.BLUE);
		seat_a4 = new JToggleButton("4");
			seat_a4.setForeground(Color.WHITE);
			seat_a4.setBackground(Color.BLUE);
		seat_a5 = new JToggleButton("5");
			seat_a5.setForeground(Color.WHITE);
			seat_a5.setBackground(Color.BLUE);
		seat_a6 = new JToggleButton("6");
			seat_a6.setForeground(Color.WHITE);
			seat_a6.setBackground(Color.BLUE);
		seat_a7 = new JToggleButton("7");
			seat_a7.setForeground(Color.WHITE);
			seat_a7.setBackground(Color.BLUE);
		seat_a8 = new JToggleButton("8");
			seat_a8.setForeground(Color.WHITE);
			seat_a8.setBackground(Color.BLUE);
		seat_a9 = new JToggleButton("9");
			seat_a9.setForeground(Color.WHITE);
			seat_a9.setBackground(Color.BLUE);
		seat_a10 = new JToggleButton("10");
			seat_a10.setForeground(Color.WHITE);
			seat_a10.setBackground(Color.BLUE);
		

		//b�¼�
		seat_b1 = new JToggleButton("1");
			seat_b1.setForeground(Color.WHITE);
			seat_b1.setBackground(Color.BLUE);
		seat_b2 = new JToggleButton("2");
			seat_b2.setForeground(Color.WHITE);
			seat_b2.setBackground(Color.BLUE);
		seat_b3 = new JToggleButton("3");
			seat_b3.setForeground(Color.WHITE);
			seat_b3.setBackground(Color.BLUE);
		seat_b4 = new JToggleButton("4");
			seat_b4.setForeground(Color.WHITE);
			seat_b4.setBackground(Color.BLUE);
		seat_b5 = new JToggleButton("5");
			seat_b5.setForeground(Color.WHITE);
			seat_b5.setBackground(Color.BLUE);
		seat_b6 = new JToggleButton("6");
			seat_b6.setForeground(Color.WHITE);
			seat_b6.setBackground(Color.BLUE);
		seat_b7 = new JToggleButton("7");
			seat_b7.setForeground(Color.WHITE);
			seat_b7.setBackground(Color.BLUE);
		seat_b8 = new JToggleButton("8");
			seat_b8.setForeground(Color.WHITE);
			seat_b8.setBackground(Color.BLUE);
		seat_b9 = new JToggleButton("9");
			seat_b9.setForeground(Color.WHITE);
			seat_b9.setBackground(Color.BLUE);
		seat_b10 = new JToggleButton("10");
			seat_b10.setForeground(Color.WHITE);
			seat_b10.setBackground(Color.BLUE);
		
		//c�¼�
		seat_c1 = new JToggleButton("1");
			seat_c1.setForeground(Color.WHITE);
			seat_c1.setBackground(Color.BLUE);
		seat_c2 = new JToggleButton("2");
			seat_c2.setForeground(Color.WHITE);
			seat_c2.setBackground(Color.BLUE);
		seat_c3 = new JToggleButton("3");
			seat_c3.setForeground(Color.WHITE);
			seat_c3.setBackground(Color.BLUE);
		seat_c4 = new JToggleButton("4");
			seat_c4.setForeground(Color.WHITE);
			seat_c4.setBackground(Color.BLUE);
		seat_c5 = new JToggleButton("5");
			seat_c5.setForeground(Color.WHITE);
			seat_c5.setBackground(Color.BLUE);
		seat_c6 = new JToggleButton("6");
			seat_c6.setForeground(Color.WHITE);
			seat_c6.setBackground(Color.BLUE);
		seat_c7 = new JToggleButton("7");
			seat_c7.setForeground(Color.WHITE);
			seat_c7.setBackground(Color.BLUE);
		seat_c8 = new JToggleButton("8");
			seat_c8.setForeground(Color.WHITE);
			seat_c8.setBackground(Color.BLUE);
		seat_c9 = new JToggleButton("9");
			seat_c9.setForeground(Color.WHITE);
			seat_c9.setBackground(Color.BLUE);
		seat_c10 = new JToggleButton("10");
			seat_c10.setForeground(Color.WHITE);
			seat_c10.setBackground(Color.BLUE);
		
		//abc ��
		a_l = new JLabel(" A");
			a_l.setFont(new Font("����", Font.PLAIN, 25));
		b_l = new JLabel(" B");
			b_l.setFont(new Font("����", Font.PLAIN, 25));
		c_l = new JLabel(" C");
			c_l.setFont(new Font("����", Font.PLAIN, 25));
		
		//������ �̵�
		select_movie = new JButton("��ȭ���� (����������)");
			select_movie.setBackground(Color.BLACK);
			select_movie.setForeground(Color.WHITE);
		pay_view = new JButton("����");
			pay_view.setBackground(Color.BLACK);
			pay_view.setForeground(Color.WHITE);
		
		//����,�Ұ���,���� ��
		select_l = new JLabel("������");
		Unselectable_l = new JLabel("����(���úҰ�)");
		selecting_l = new JLabel("���ð���");
		
		//����,�Ұ���,���� �̹���
		image_select = new JLabel("image");
		image_unselecting = new JLabel("image");
		image_selecting = new JLabel("image");
		

//===================== ��ġ =======================================================	
		//a�¼� ��ġ
		seat_a1.setBounds(273, 422, 60, 56);
		seat_a2.setBounds(347, 422, 60, 56);
		seat_a3.setBounds(462, 422, 60, 56);
		seat_a4.setBounds(536, 422, 60, 56);
		seat_a5.setBounds(610, 422, 60, 56);
		seat_a6.setBounds(726, 422, 60, 56);
		seat_a7.setBounds(800, 422, 60, 56);
		seat_a8.setBounds(874, 422, 60, 56);
		seat_a9.setBounds(989, 422, 60, 56);
		seat_a10.setBounds(1063, 422, 60, 56);
		
		//b�¼� ��ġ
		seat_b1.setBounds(273, 490, 60, 56);
		seat_b2.setBounds(347, 490, 60, 56);
		seat_b3.setBounds(462, 490, 60, 56);
		seat_b4.setBounds(536, 490, 60, 56);
		seat_b5.setBounds(610, 490, 60, 56);
		seat_b6.setBounds(726, 490, 60, 56);
		seat_b7.setBounds(800, 490, 60, 56);
		seat_b8.setBounds(874, 490, 60, 56);
		seat_b9.setBounds(989, 490, 60, 56);
		seat_b10.setBounds(1063, 490, 60, 56);

		//c�¼� ��ġ
		seat_c1.setBounds(273, 558, 60, 56);
		seat_c2.setBounds(347, 558, 60, 56);
		seat_c3.setBounds(462, 558, 60, 56);
		seat_c4.setBounds(536, 558, 60, 56);
		seat_c5.setBounds(610, 558, 60, 56);
		seat_c6.setBounds(726, 558, 60, 56);
		seat_c7.setBounds(800, 558, 60, 56);
		seat_c8.setBounds(874, 558, 60, 56);
		seat_c9.setBounds(989, 558, 60, 56);
		seat_c10 .setBounds(1063, 558, 60, 56);
	
		
		//abc �� ��ġ
		a_l.setBounds(216, 432, 43, 37);
		b_l.setBounds(216, 498, 43, 37);
		c_l.setBounds(216, 568, 43, 37);
		
		//������ �̵� ��ġ
		select_movie.setBounds(48, 816, 170, 125);
		pay_view.setBounds(1063, 816, 170, 125);

		//����,�Ұ���,���� �� ��ġ
		select_l.setBounds(91, 441, 62, 18);
		Unselectable_l.setBounds(88, 509, 114, 18);
		selecting_l.setBounds(88, 577, 62, 18);
		
		//����,�Ұ���,���� �̹��� ��ġ
		image_select.setBounds(14, 441, 62, 18);
		image_unselecting.setBounds(14, 509, 96, 18);
		image_selecting.setBounds(14, 577, 62, 18);

//===================== contentpane =======================================================	
		//a�¼� contentpane
		getContentPane().setLayout(null);
		getContentPane().add(seat_a1);
		getContentPane().add(seat_a2);
		getContentPane().add(seat_a3);
		getContentPane().add(seat_a4);
		getContentPane().add(seat_a5);
		getContentPane().add(seat_a6);
		getContentPane().add(seat_a7);
		getContentPane().add(seat_a8);
		getContentPane().add(seat_a9);
		getContentPane().add(seat_a10);
		
		
		//b�¼� contentpane
		getContentPane().add(seat_b1);
		getContentPane().add(seat_b2);
		getContentPane().add(seat_b3);
		getContentPane().add(seat_b4);
		getContentPane().add(seat_b5);
		getContentPane().add(seat_b6);
		getContentPane().add(seat_b7);
		getContentPane().add(seat_b8);
		getContentPane().add(seat_b9);
		getContentPane().add(seat_b10);
		
		//c�¼� contentpane
		getContentPane().add(seat_c1);
		getContentPane().add(seat_c2);
		getContentPane().add(seat_c3);
		getContentPane().add(seat_c4);
		getContentPane().add(seat_c5);
		getContentPane().add(seat_c6);
		getContentPane().add(seat_c7);
		getContentPane().add(seat_c8);
		getContentPane().add(seat_c9);
		getContentPane().add(seat_c10);
		
		//abc�� contentpane
		getContentPane().add(a_l);
		getContentPane().add(b_l);
		getContentPane().add(c_l);
		
		//������ �̵� contentpane
		getContentPane().add(select_movie);
		getContentPane().add(pay_view);

		//����,�Ұ���,���� �� contentpane
		getContentPane().add(select_l);
		getContentPane().add(Unselectable_l);
		getContentPane().add(selecting_l);
		
		//����,�Ұ���,���� �̹��� contentpane
		getContentPane().add(image_select);
		getContentPane().add(image_unselecting);
		getContentPane().add(image_selecting);
		
		
		
//============================ screen ================================
		screen_l = new JLabel("screen");
		p = new JPanel();
			p.setBackground(Color.WHITE);
			getContentPane().add(p);
			p.setLayout(null);
		
		
		//��ġ
		p.setBounds(273, 339, 850, 37);
		screen_l.setBounds(400, 12, 44, 18);
		p.add(screen_l);
			
		
//=========================== ��ũ�� ���� ===================================		
		info_ta = new JTextArea();
		theater_l = new JLabel("<1��>");
			theater_l.setFont(new Font("���� ���", Font.PLAIN, 30));
		
			//�ؽ�Ʈ �����
		info_ta.setText("��ȭ ���� (�����¼�,��¥,�󿵽ð�)");
			
		//��ġ
		info_ta.setBounds(390, 92, 590, 208);
		theater_l.setBounds(642, 43, 113, 37);
		
		//contentpane
		getContentPane().add(info_ta);
		getContentPane().add(theater_l);
		
		
//========================== ����, �¼�, ��ȭ ���� ============================
		select_pay_ta = new JTextArea();
		seat_info_ta = new JTextArea();
		movie_image = new JLabel("image");
		movie_info_ta = new JTextArea();
		
		//�ؽ�Ʈ �����
		select_pay_ta.setText("���ð���");
		seat_info_ta.setText("�¼�����");
		movie_info_ta.setText("��ȭ����");
	
		
		//��ġ
		select_pay_ta.setBounds(784, 815, 196, 126);
		seat_info_ta.setBounds(536, 815, 170, 126);
		movie_info_ta.setBounds(349, 815, 96, 126);
		movie_image.setBounds(259, 869, 62, 18);
		
		//contentpane
		getContentPane().add(select_pay_ta);
		getContentPane().add(seat_info_ta);
		getContentPane().add(movie_image);
		getContentPane().add(movie_info_ta);
		

		
		setBounds(10, 10, 1300, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		
	}
	
	public static void main(String[] args) {
		new ScreenView();
	}
}
	
