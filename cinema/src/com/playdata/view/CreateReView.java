package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import com.playdata.view.CreateReSubView;

import sun.net.www.content.image.jpeg;

import java.awt.Font;
import java.awt.GridLayout;


public class CreateReView extends JFrame {

	public JPanel p_center,p_north;
	public CreateReSubView[] subv_create;
	public JLabel lb_movie_name,lb_runtime,lb_seat;
	private JLabel label;
	private JLabel la_logo;
		
	public CreateReView() {
		setTitle("¿¹¸ÅÈ®ÀÎ/Ãë¼Ò Ã¢");
		
	
		
		p_center = new JPanel();
		
		subv_create = new CreateReSubView[5];
		
		//p_center
		getContentPane().add(p_center, BorderLayout.CENTER);
		p_center.setLayout(new GridLayout(5,1));
		p_north = new JPanel();
		lb_movie_name = new JLabel("¿µÈ­ÀÌ¸§");
		lb_movie_name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lb_runtime = new JLabel("ÁÂ¼® ¹øÈ£");
		lb_runtime.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lb_seat = new JLabel("»ó¿µ ½Ã°£");
		lb_seat.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		
		//p_north
		p_north.setPreferredSize(new Dimension(0, 60));
		p_north.setBackground(Color.ORANGE);
		getContentPane().add(p_north, BorderLayout.PAGE_START);
		p_north.setLayout(null);
		
		
		//¶óº§
		lb_movie_name.setBounds(50, 0, 69, 60);
		p_north.add(lb_movie_name);
		
		label = new JLabel("»ó¿µ ³¯Â¥");
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		label.setBounds(203, 0, 69, 60);
		p_north.add(label);
		lb_runtime.setBounds(516, 0, 69, 60);
		p_north.add(lb_runtime);
		lb_seat.setBounds(363, 0, 69, 60);
		p_north.add(lb_seat);
		
		
		
		
		for(int i=0; i<subv_create.length; i++) {
			subv_create[i] = new CreateReSubView();
			p_center.add(subv_create[i]);
		}
		setSize(800,800);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new CreateReView();
	}
}

