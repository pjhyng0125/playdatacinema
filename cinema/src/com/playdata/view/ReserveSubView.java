package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
/*
 * �ۼ���: ������
 * ��������: 07/01 12:20
 * Ŭ���� ���: ReserView �ȿ� 1��4���� ��ġ�� SubView
 */
import javax.swing.border.LineBorder;
import java.awt.Font;
public class ReserveSubView extends JPanel {
	public JButton bt_reserve;//����, ��ȭ ����
	public JLabel la_image, la_title, la_percent, la_genre;
	public JToggleButton []tbt_stars;
	JPanel p_image, p_content, p_stars, p_ps, p_pe, p_ls, p_le, p_center;
	LineBorder linea,lineb;
	
	ImageIcon image_poster;
	
	public ReserveSubView() {
		/*
		 * �ۼ��� : ��쿵
		 * �������� : 07/04 17:42
		 * �̹����������� �̿��� �󺧿� �̹��� �ֱ�.
		*/
		
		linea = new LineBorder(Color.BLACK,5);// �� �׵θ� ����
		lineb = new LineBorder(Color.BLACK,1);// �� �׵θ� ����
		
		
		image_poster = new ImageIcon("image/antman_reserview.png");
		bt_reserve = new JButton("���� ����");
		bt_reserve.setBackground(new Color(52,52,51));
		bt_reserve.setForeground(Color.WHITE);
		bt_reserve.setFont(new Font("����", Font.BOLD, 18));
		
		
		la_image = new JLabel(image_poster);
		la_image.setBounds(61, 61, 141, 181);
		la_title = new JLabel("��Ʈ�ǰ� �ͽ���");
		la_title.setFont(new Font("�ü�", Font.BOLD, 25));
		la_percent = new JLabel("������ 35.5%");
		la_percent.setFont(new Font("����", Font.BOLD | Font.ITALIC, 21));
		la_genre = new JLabel("�ڹ̵�׼�");
		la_genre.setFont(new Font("���� ��� Semilight", Font.BOLD, 21));
		tbt_stars = new JToggleButton[5];
		
		la_percent.setBorder(lineb);
		la_image.setBorder(linea);
//Label ����
		la_title.setHorizontalAlignment(JLabel.CENTER);
		la_percent.setHorizontalAlignment(JLabel.CENTER);
		la_genre.setHorizontalAlignment(JLabel.CENTER);
		
		p_image = new JPanel();
		p_content = new JPanel();
		p_stars = new JPanel();
		p_ps = new JPanel();
		p_pe = new JPanel();
		p_ls = new JPanel();
		p_le = new JPanel();
		p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
	
//tbt_starts �迭 �̹��� ���� & ��ư ���� ����
		for(int i=0; i<tbt_stars.length; i++) {
			tbt_stars[i] = new JToggleButton(new ImageIcon("image/star_blank.png"));
			tbt_stars[i].setBorderPainted(false);	//tbt Border �����ֱ�
			tbt_stars[i].setContentAreaFilled(false);	//tbt ���뿵�� ä���� ����
			tbt_stars[i].setFocusPainted(false);	//tbt ���� �׵θ� ��� ����
		}
		
//p_image
		p_image.setPreferredSize(new Dimension(0, 300));
		p_center.add(p_image, BorderLayout.PAGE_START);
		p_image.setLayout(null);
		p_image.add(la_image);
		p_image.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, 
				Color.BLACK, Color.BLACK, Color.BLACK));
		p_image.setBackground(new Color(247, 246, 239));
//p_content
		p_center.add("Center",p_content);
		p_content.setLayout(new GridLayout(5, 1));
			p_content.add(la_title);
			p_content.add(la_percent);
			p_content.add(la_genre);
		p_content.add(p_stars);
		p_content.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, 
				Color.BLACK, Color.BLACK, Color.BLACK));
		p_stars.setBackground(Color.BLUE);
		p_stars.setLayout(null);
//p_stars
		for(int i=0; i<tbt_stars.length; i++) {
			tbt_stars[i].setBounds(50*(i)+5, 10, 50, 50);
			p_stars.add(tbt_stars[i]);
		}
		p_content.add(bt_reserve);
//set panel layout
		setLayout(new BorderLayout());
//add panels space size
		p_ps.setPreferredSize(new Dimension(0, 30));
		p_pe.setPreferredSize(new Dimension(0, 30));
		p_ls.setPreferredSize(new Dimension(30, 0));
		p_ls.setPreferredSize(new Dimension(30, 0));
//add panels to this panel
		add(p_ps,BorderLayout.PAGE_START);
		add(p_pe,BorderLayout.PAGE_END);
		add(p_ls,BorderLayout.LINE_START);
		add(p_le,BorderLayout.LINE_END);
		add(p_center,BorderLayout.CENTER);
		
		setBackground(Color.BLUE);
		setSize(300, 740);
	}//������
}
