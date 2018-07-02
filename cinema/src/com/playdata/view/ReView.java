package com.playdata.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
/*
 * 후기뷰
 */
public class ReView extends JFrame {
	JPanel p_content, p_reviews;
	JScrollPane sp;
	Vector<ReviewSubView> v;
	
	public ReView() {
		setTitle("ReView");
//new
		p_content = new JPanel();
		p_reviews = new JPanel();
		v = new Vector<>();

//setBackground
		p_content.setBackground(Color.CYAN);
		p_reviews.setBackground(Color.green);
		p_reviews.setPreferredSize(new Dimension(1140, 250));
		
//setlayout
		p_reviews.setLayout(null);
		setLayout(null);
		
//setSize
		p_content.setBounds(20,20,1140,350);
		
//JScrollerPane
		sp = new JScrollPane();
		sp.setViewportView(p_reviews);

		sp.setPreferredSize(new Dimension(1140, 250));
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		sp.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVisible(true);
		sp.setBounds(20, 370, 1140, 350);
		add(sp);
		
//addReviewSubView
		ReviewSubView rsv = new ReviewSubView();
		ReviewSubView rsv1 = new ReviewSubView();
		ReviewSubView rsv2 = new ReviewSubView();
		ReviewSubView rsv3 = new ReviewSubView();
		ReviewSubView rsv4 = new ReviewSubView();
//		ReviewSubView rsv5 = new ReviewSubView();
		v.add(rsv);
		v.add(rsv1);
		v.add(rsv2);
		v.add(rsv3);
		v.add(rsv4);
//		v.add(rsv5);

//add to frame
		add(p_content);
		for(int i=0; i<v.size(); i++) {
//			v.get(i).setBounds(20, 100*(i+1)+280, 1140, 100);
			v.get(i).setBounds(20, 100*(i), 1140, 100);			
			p_reviews.add(v.get(i));
		}
		
		setSize(1200, 800);
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new ReView();
	}
}
