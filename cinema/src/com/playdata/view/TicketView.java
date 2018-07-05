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
 * �����Ƽ�Ϻ�
 */
public class TicketView extends JFrame {
	// Ƽ�� ��  �ʱ� �ۼ��� : �̼��� 
	
	JPanel p_north, p_center;
	//		�����Ƽ��		��ȭ������		���ſ�ȭ	 ��������	   �����ð�		�����ο�	   �����¼�
	JLabel la_ticket, la_reserver, la_movie, la_date, la_time, la_person, la_seat;
	JLabel la_reserver2, la_movie2, la_date2, la_time2, la_person2, la_seat2; 
	
	public TicketView() {
		setTitle("����� Ƽ��");
		
		la_ticket = new JLabel("����� Ƽ��");
		la_ticket.setForeground(Color.WHITE);
		la_ticket.setFont(new Font("���� ���", Font.BOLD, 22));
		la_ticket.setBounds(14, 12, 172, 80);
		la_reserver = new JLabel("��ȭ ������ : ");
		la_reserver.setFont(new Font("�������", 0, 30));
		la_reserver.setBounds(14,39,200,70);
		la_movie = new JLabel("���� ��ȭ     : ");
		la_movie.setFont(new Font("�������", 0, 30));
		la_movie.setBounds(14, 111, 200, 70);
		la_date = new JLabel("���� ����     : ");
		la_date.setFont(new Font("�������", 0, 30));
		la_date.setBounds(14, 182, 200, 70);
		la_time = new JLabel("���� �ð�     :");
		la_time.setFont(new Font("�������", 0, 30));
		la_time.setBounds(14, 253, 200, 70);
		la_person = new JLabel("���� �ο�     : ");
		la_person.setFont(new Font("�������", 0, 30));
		la_person.setBounds(14, 325, 200, 70);
		la_seat = new JLabel("���� �¼�     : ");
		la_seat.setFont(new Font("�������", 0, 30));
		la_seat.setBounds(14, 397, 200, 70);
		
		la_reserver2 = new JLabel("ȫ�浿��");
		la_reserver2.setBounds(224, 39, 244, 70);
		la_reserver2.setFont(new Font("�������", 0, 30));
		la_movie2 = new JLabel("ȫ�浿��");
		la_movie2.setFont(new Font("�������", 0, 30));
		la_movie2.setBounds(224, 111, 244, 70);
		la_date2 = new JLabel("2018�� 6�� 29�� ");
		la_date2.setFont(new Font("�������", 0, 30));
		la_date2.setBounds(224, 182, 244, 70);
		la_time2 = new JLabel("19�� 40��");
		la_time2.setFont(new Font("�������", 0, 30));
		la_time2.setBounds(224, 253, 244, 70);
		la_person2 = new JLabel("���� 1��");
		la_person2.setFont(new Font("�������", 0, 30));
		la_person2.setBounds(224, 325, 244, 70);
		la_seat2 = new JLabel("1�󿵰� B�� 4��");
		la_seat2.setFont(new Font("�������", 0, 30));
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
	}//������
	public static void main(String[] args) {
		new TicketView();
	}
	
}
