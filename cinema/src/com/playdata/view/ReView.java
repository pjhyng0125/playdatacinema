package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * 후기뷰
 */
public class ReView extends JFrame {
	JPanel p_content, p_reviews, p_bottom;
	JButton bt_back, bt_next;
	JLabel la_page;
	Vector<ReviewSubView> v;
	
	public ReView() {
		setTitle("ReView");
//new
		p_content = new JPanel();
		p_reviews = new JPanel();
		p_bottom = new JPanel();
		v = new Vector<>();
		bt_back = new JButton("이전");
		bt_next = new JButton("다음");
		la_page = new JLabel("- i -");

//setlayout
		p_reviews.setLayout(null);
		p_bottom.setLayout(null);
		setLayout(new BorderLayout());
		
		
//addReviewSubView
		ReviewSubView rsv = new ReviewSubView();
		ReviewSubView rsv1 = new ReviewSubView();
		ReviewSubView rsv2 = new ReviewSubView();
		ReviewSubView rsv3 = new ReviewSubView();
		ReviewSubView rsv4 = new ReviewSubView();
		ReviewSubView rsv5 = new ReviewSubView();
		ReviewSubView rsv6 = new ReviewSubView();
		ReviewSubView rsv7 = new ReviewSubView();
		ReviewSubView rsv8 = new ReviewSubView();
		ReviewSubView rsv9 = new ReviewSubView();
		
		v.add(rsv);
		v.add(rsv1);
		v.add(rsv2);
		v.add(rsv3);
		v.add(rsv4);
		v.add(rsv5);
		v.add(rsv6);
		v.add(rsv7);
		v.add(rsv8);
		v.add(rsv9);

//setBackground
				p_content.setBackground(Color.CYAN);
				p_reviews.setBackground(Color.green);
//setSize
		p_content.setPreferredSize(new Dimension(0, 300));
		p_bottom.setPreferredSize(new Dimension(0, 50));
		la_page.setBounds(600, 10, 50, 30);
		la_page.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		bt_back.setBounds(360, 10, 70, 30);
		bt_next.setBounds(800, 10, 70, 30);
//add to frame
		add(p_content, BorderLayout.PAGE_START);
		add(p_reviews, BorderLayout.CENTER);
		add(p_bottom, BorderLayout.PAGE_END);
		p_bottom.add(la_page);
		p_bottom.add(bt_back);
		p_bottom.add(bt_next);		
		
		int page_now = 0;	//후기창 하단의 페이지 저장하는 변수 0부터 시작
		la_page.setText("- "+page_now+" -");
		Vector<ReviewSubView> vr = selectReview(v, page_now);
		
		for(int i=0; i<vr.size(); i++) {
			vr.get(i).setBounds(20, 100*(i)+4, 1140, 95);
			p_reviews.add(vr.get(i));
		}
		
		setSize(1200, 800);
		setVisible(true);
	}//생성자
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/02 23:59
	 * 함수 기능: 후기 전체 백터에서 page_now에 해당하는 후기 4개만 뽑아서 벡터에 저장
	 */
	public Vector<ReviewSubView> selectReview(Vector<ReviewSubView> v_in, int page_now){
		Vector<ReviewSubView> v_out = new Vector<>();
		for(int i=0; i<v_in.size(); i++) {
			if((i/4) == page_now) {
				v_out.add(v_in.get(i));
			}
		v.get(i).la_content.setText("content num = "+i);
		}
		return v_out;
	}
	
	public static void main(String[] args) {
		new ReView();
	}
}
