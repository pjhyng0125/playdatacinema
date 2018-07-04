package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.playdata.model.Comment;
/*
 * 후기뷰
 */
public class ReView extends JFrame {
	public JPanel p_content, p_reviews, p_bottom;
	public JButton bt_back, bt_next;
	public JLabel la_page;
	public ArrayList<ReviewSubView> list;
	
	public ReView() {
		setTitle("ReView");
//new
		p_content = new JPanel();
		p_reviews = new JPanel();
		p_bottom = new JPanel();
		bt_back = new JButton("이전");
		bt_next = new JButton("다음");
		la_page = new JLabel("- i -");
		
		list = new ArrayList<>();
		ReviewSubView rsv1 = new ReviewSubView("blank", "blank", 1);
		ReviewSubView rsv2 = new ReviewSubView("blank", "blank", 2);
		ReviewSubView rsv3 = new ReviewSubView("blank", "blank", 3);
		ReviewSubView rsv4 = new ReviewSubView("blank", "blank", 4);
		
		list.add(rsv1);
		list.add(rsv2);
		list.add(rsv3);
		list.add(rsv4);

//setlayout
		p_reviews.setLayout(null);
		p_bottom.setLayout(null);
		setLayout(new BorderLayout());
		
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
		
		for(int i=0; i<list.size(); i++) {
			list.get(i).setBounds(20, 100*(i)+4, 1140, 95);
			p_reviews.add(list.get(i));
		}
		
		setSize(1200, 800);
		setVisible(false);
	}//생성자
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/02 23:59
	 * 함수 기능: 파라미터의 ArrayList(0~4)를 화면에 출력! 그저 출력만
	 */
	public void rewriteReview(ArrayList<Comment> list_comment) {
		int list_size = list_comment.size();
		for(int i=0; i<4; i++) {
			if(i < list_size) {
				list.get(i).setVisible(true);
				list.get(i).la_id.setText(list_comment.get(i).getId());
				list.get(i).la_content.setText(list_comment.get(i).getContent());
			}
			else{
				list.get(i).setVisible(false);
			}
				
		}
	}
}
