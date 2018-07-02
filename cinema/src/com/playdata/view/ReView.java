package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/*
 * 후기뷰
 */
public class ReView extends JFrame {
	JPanel p_content;
	JScrollPane sp_frame;
	Vector<ReviewSubView> v;
	public ReView() {
		setTitle("ReView");
		p_content = new JPanel();
		p_content.setBackground(Color.CYAN);
		v = new Vector<>();
		sp_frame = new JScrollPane();
//		sp_frame.setViewportView(this);
		setLayout(null);
		  
		p_content.setBounds(20,20,1140,350);
		
		ReviewSubView rsv = new ReviewSubView();
		ReviewSubView rsv1 = new ReviewSubView();
		ReviewSubView rsv2 = new ReviewSubView();
		ReviewSubView rsv3 = new ReviewSubView();
		ReviewSubView rsv4 = new ReviewSubView();
		v.add(rsv);
		v.add(rsv1);
		v.add(rsv2);
		v.add(rsv3);
		v.add(rsv4);
//sp_frame
		add(p_content);
		for(int i=0; i<v.size(); i++) {
			v.get(i).setBounds(20, 100*(i+1)+280, 1140, 100);
			add(v.get(i));
		}
//		sp_frame.setBackground(Color.pink);
//		add("Center",sp_frame);
		setSize(1200, 800);
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new ReView();
	}
}
