package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/*
 * 모바일티켓뷰
 */
public class TicketView extends JFrame {
	// 티켓 뷰  초기 작성자 : 이성훈 
	
	JPanel p_north, p_center;
	//		모바일티켓		영화예매자		예매영화	 관림일자	   관람시각		예매인원	   예매좌석
	JLabel la_ticket, la_reserver, la_movie, la_date, la_time, la_person, la_seat;
	JLabel la_reserver2, la_movie2, la_date2, la_time2, la_person2, la_seat2; 
	
	public TicketView() {
		setTitle("모바일 티켓");
		
		la_ticket = new JLabel("모바일 티켓");
		la_ticket.setForeground(Color.WHITE);
		la_ticket.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		la_ticket.setBounds(14, 12, 172, 80);
		la_reserver = new JLabel("영화 예매자 : ");
		la_reserver.setFont(new Font("맑은고딕", 0, 30));
		la_reserver.setBounds(14,39,200,70);
		la_movie = new JLabel("예매 영화     : ");
		la_movie.setFont(new Font("맑은고딕", 0, 30));
		la_movie.setBounds(14, 111, 200, 70);
		la_date = new JLabel("관람 일자     : ");
		la_date.setFont(new Font("맑은고딕", 0, 30));
		la_date.setBounds(14, 182, 200, 70);
		la_time = new JLabel("관람 시각     :");
		la_time.setFont(new Font("맑은고딕", 0, 30));
		la_time.setBounds(14, 253, 200, 70);
		la_person = new JLabel("예매 인원     : ");
		la_person.setFont(new Font("맑은고딕", 0, 30));
		la_person.setBounds(14, 325, 200, 70);
		la_seat = new JLabel("예매 좌석     : ");
		la_seat.setFont(new Font("맑은고딕", 0, 30));
		la_seat.setBounds(14, 397, 200, 70);
		
		la_reserver2 = new JLabel("홍길동님");
		la_reserver2.setBounds(224, 39, 244, 70);
		la_reserver2.setFont(new Font("맑은고딕", 0, 30));
		la_movie2 = new JLabel("홍길동전");
		la_movie2.setFont(new Font("맑은고딕", 0, 30));
		la_movie2.setBounds(224, 111, 244, 70);
		la_date2 = new JLabel("2018년 6월 29일 ");
		la_date2.setFont(new Font("맑은고딕", 0, 30));
		la_date2.setBounds(224, 182, 244, 70);
		la_time2 = new JLabel("19시 40분");
		la_time2.setFont(new Font("맑은고딕", 0, 30));
		la_time2.setBounds(224, 253, 244, 70);
		la_person2 = new JLabel("성인 1명");
		la_person2.setFont(new Font("맑은고딕", 0, 30));
		la_person2.setBounds(224, 325, 244, 70);
		la_seat2 = new JLabel("1상영관 B열 4석");
		la_seat2.setFont(new Font("맑은고딕", 0, 30));
		la_seat2.setBounds(224, 397, 244, 70);
		
		p_north = new JPanel();
		p_north.setForeground(Color.WHITE);
		p_north.setLayout(null);
		p_north.setPreferredSize(new Dimension(500, 100));
		p_north.setBackground(Color.BLACK);
		p_north.add(la_ticket);
		
		p_center = new JPanel();
		p_center.setBackground(Color.WHITE);
		p_center.setLayout(null);
		p_center.setPreferredSize(new Dimension(500, 600));
		p_center.add(la_reserver);
		p_center.add(la_movie);
		p_center.add(la_date);
		p_center.add(la_time);
		p_center.add(la_person);
		p_center.add(la_seat);
		
		p_center.add(la_reserver2);
		p_center.add(la_movie2);
		p_center.add(la_date2);
		p_center.add(la_time2);
		p_center.add(la_person2);
		p_center.add(la_seat2);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("North",p_north);
		getContentPane().add("Center",p_center);
		
		
		setSize(500, 700);
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new TicketView();
	}
	
}
