package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.playdata.model.vo.Comment;
/*
 * 후기뷰
 */
public class ReView extends JFrame {
	public JPanel p_content, p_reviews, p_bottom;
	public JButton bt_back, bt_next, bt_reserve;
	public JLabel la_page, la_logo, la_image, la_name, la_genre, la_director, la_actor, la_startdate, la_runtime;
	public ArrayList<ReviewSubView> list;
	LineBorder linea;
	public JTextArea ta_summary;

	
	public ReView() {
		setTitle("ReView");
//new
		
		linea = new LineBorder(Color.black,8);
		p_content = new JPanel();
		p_reviews = new JPanel();
		p_bottom = new JPanel();
		bt_back = new JButton("이전");
		bt_next = new JButton("다음");
		la_page = new JLabel("- i -");
		bt_reserve = new JButton("예매창으로");
		la_image = new JLabel();
		la_name = new JLabel("영화이름: ");
		la_genre = new JLabel("영화장르: ");
		la_logo = new JLabel();
		la_director = new JLabel("감독명: ");
		la_actor = new JLabel("주연배우: ");
		ta_summary = new JTextArea("줄거리: ");
		la_startdate = new JLabel("개봉일: ");
		la_runtime = new JLabel("상영시간");
		
		//la_logo = new JLabel("icon1");
		
		
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
		p_content.setBackground(Color.orange);
		p_content.setBorder(linea);
		p_reviews.setBackground(Color.white);
//setSize
		p_content.setPreferredSize(new Dimension(0, 300));
		p_bottom.setPreferredSize(new Dimension(0, 50));
		la_page.setBounds(600, 10, 50, 30);
		la_page.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		bt_back.setBounds(360, 10, 70, 30);
		bt_back.setBackground(Color.black);
		bt_back.setForeground(Color.white);
		bt_next.setBounds(800, 10, 70, 30);
		bt_next.setBackground(Color.black);
		bt_next.setForeground(Color.WHITE);
		bt_reserve.setBounds(60, 10, 120, 30);
		bt_reserve.setBackground(Color.black);
		bt_reserve.setForeground(Color.white);
//add to frame
		add(p_content, BorderLayout.PAGE_START);
		add(p_reviews, BorderLayout.CENTER);
		add(p_bottom, BorderLayout.PAGE_END);
		p_bottom.add(la_page);
		p_bottom.add(bt_back);
		p_bottom.add(bt_next);	
		p_bottom.add(bt_reserve);	
		
		for(int i=0; i<list.size(); i++) {
			list.get(i).setBounds(20, 100*(i)+4, 1140, 95);
			p_reviews.add(list.get(i));
		}
//add p_content
		p_content.setLayout(null);
		la_image.setBounds(100, 50, 200, 200);
		la_name.setBounds(500, 40, 100, 30);
		la_genre.setBounds(500, 80, 100, 30);
		la_director.setBounds(500, 120, 100, 30);
		la_actor.setBounds(500, 160, 100, 30);
		la_startdate.setBounds(500, 200, 100, 30);
		la_runtime.setBounds(500, 240, 100, 30);
		ta_summary.setBounds(850, 50, 200, 100);
		p_content.add(la_image);
		p_content.add(la_name);
		p_content.add(la_genre);
		p_content.add(la_director);
		p_content.add(la_actor);
		p_content.add(la_startdate);
		p_content.add(la_runtime);
		p_content.add(ta_summary);

		
		
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
				list.get(i).setstarSelected(list_comment.get(i).getStar());
			}
			else{
				list.get(i).setVisible(false);
			}
				
		}
	}

}
