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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class ScreenView extends JFrame {

	//----------------------------ÁÂ¼®
	JButton seat_a1,seat_a2,seat_a3,seat_a4,seat_a5,seat_a6,seat_a7,seat_a8,seat_a9,seat_a10; //aÁÂ¼®
	JButton seat_b1,seat_b2,seat_b3,seat_b4,seat_b5,seat_b6,seat_b7,seat_b8,seat_b9,seat_b10; //bÁÂ¼®
	JButton seat_c1,seat_c2,seat_c3,seat_c4,seat_c5,seat_c6,seat_c7,seat_c8,seat_c9,seat_c10; //cÁÂ¼®
	

	//----------------------------ÆäÀÌÁö ÀÌµ¿
	JButton select_movie,pay_view;
	
	//JTextArea info_movie, screen,number;

	JLabel a_l,b_l,c_l;
	private JButton button;
	
	public ScreenView() {
		setTitle("ScreenView");

//===================== ÁÂ¼®  =======================================================	
		//aÁÂ¼®
		seat_a1 = new JButton("1");
		seat_a2 = new JButton("2");
		seat_a3 = new JButton("3");
		seat_a4 = new JButton("4");
		seat_a5 = new JButton("5");
		seat_a6 = new JButton("6");
		seat_a7 = new JButton("7");
		seat_a8 = new JButton("8");
		seat_a9 = new JButton("9");
		seat_a10 = new JButton("10");
		

		//bÁÂ¼®
		seat_b1 = new JButton("1");
		seat_b2 = new JButton("2");
		seat_b3 = new JButton("3");
		seat_b4 = new JButton("4");
		seat_b5 = new JButton("5");
		seat_b6 = new JButton("6");
		seat_b7 = new JButton("7");
		seat_b8 = new JButton("8");
		seat_b9 = new JButton("9");
		seat_b10 = new JButton("10");
		
		//cÁÂ¼®
		seat_c1 = new JButton("1");
		seat_c2 = new JButton("2");
		seat_c3 = new JButton("3");
		seat_c4 = new JButton("4");
		seat_c5 = new JButton("5");
		seat_c6 = new JButton("6");
		seat_c7 = new JButton("7");
		seat_c8 = new JButton("8");
		seat_c9 = new JButton("9");
		seat_c10 = new JButton("10");
		
		//abc ¶óº§
		a_l = new JLabel(" A");
		a_l.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		b_l = new JLabel(" B");
		b_l.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		c_l = new JLabel(" C");
		c_l.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		
		
//===================== À§Ä¡ =======================================================	
		//aÁÂ¼® À§Ä¡
		seat_a1.setBounds(215, 421, 60, 56);
		seat_a2.setBounds(289, 421, 60, 56);
		seat_a3.setBounds(404, 421, 60, 56);
		seat_a4.setBounds(478, 421, 60, 56);
		seat_a5.setBounds(552, 421, 60, 56);
		seat_a6.setBounds(668, 421, 60, 56);
		seat_a7.setBounds(742, 421, 60, 56);
		seat_a8.setBounds(816, 421, 60, 56);
		seat_a9.setBounds(931, 421, 60, 56);
		seat_a10.setBounds(1005, 421, 60, 56);
		
		//bÁÂ¼® À§Ä¡
		seat_b1.setBounds(215, 489, 60, 56);
		seat_b2.setBounds(289, 489, 60, 56);
		seat_b3.setBounds(404, 489, 60, 56);
		seat_b4.setBounds(478, 489, 60, 56);
		seat_b5.setBounds(552, 489, 60, 56);
		seat_b6.setBounds(668, 489, 60, 56);
		seat_b7.setBounds(742, 489, 60, 56);
		seat_b8.setBounds(816, 489, 60, 56);
		seat_b9.setBounds(931, 489, 60, 56);
		seat_b10.setBounds(1005, 489, 60, 56);

		//cÁÂ¼® À§Ä¡
		seat_c1.setBounds(215, 557, 60, 56);
		seat_c2.setBounds(289, 557, 60, 56);
		seat_c3.setBounds(404, 557, 60, 56);
		seat_c4.setBounds(478, 557, 60, 56);
		seat_c5.setBounds(552, 557, 60, 56);
		seat_c6.setBounds(668, 557, 60, 56);
		seat_c7.setBounds(742, 557, 60, 56);
		seat_c8.setBounds(816, 557, 60, 56);
		seat_c9.setBounds(931, 557, 60, 56);
		seat_c10 .setBounds(1005, 557, 60, 56);
	
		
		//abc ¶óº§ À§Ä¡
		a_l.setBounds(158, 431, 43, 37);
		b_l.setBounds(158, 497, 43, 37);
		c_l.setBounds(158, 567, 43, 37);
		
//===================== contentpane =======================================================	
		//aÁÂ¼® contentpane
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
		
		
		//bÁÂ¼® contentpane
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
		
		//cÁÂ¼® contentpane
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
		
		//abc¶óº§ contentpane
		getContentPane().add(a_l);
		getContentPane().add(b_l);
		getContentPane().add(c_l);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(215, 338, 850, 37);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblScreen = new JLabel("screen");
		lblScreen.setBounds(400, 12, 44, 18);
		panel.add(lblScreen);
		
		JButton btnNewButton = new JButton("¿µÈ­¼±ÅÃ (ÀÌÀüÆäÀÌÁö)");
		btnNewButton.setBounds(48, 816, 170, 125);
		getContentPane().add(btnNewButton);
		
		button = new JButton("°áÁ¦");
		button.setBounds(1063, 816, 170, 125);
		getContentPane().add(button);
		

		
		
		
		

		
		setBounds(10, 10, 1300, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		
	}
	
	public static void main(String[] args) {
		new ScreenView();
	}
}
	
