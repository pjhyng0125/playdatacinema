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
 * 작성자: 박진형
 * 수정일자: 07/01 12:20
 * 클래스 기능: ReserView 안에 1행4열로 배치될 SubView
 */
import javax.swing.border.LineBorder;
import java.awt.Font;
public class ReserveSubView extends JPanel {
	public JButton bt_reserve;//예매, 영화 변경
	public JLabel la_image, la_title, la_percent, la_genre;
	public JToggleButton []tbt_stars;
	JPanel p_image, p_content, p_stars, p_ps, p_pe, p_ls, p_le, p_center;
	LineBorder linea,lineb;
	
	ImageIcon image_poster;
	
	public ReserveSubView() {
		/*
		 * 작성자 : 장우영
		 * 수정일자 : 07/04 17:42
		 * 이미지아이콘을 이용한 라벨에 이미지 넣기.
		*/
		
		linea = new LineBorder(Color.BLACK,5);// 라벨 테두리 설정
		lineb = new LineBorder(Color.BLACK,1);// 라벨 테두리 설정
		
		
		image_poster = new ImageIcon("image/antman_reserview.png");
		bt_reserve = new JButton("지금 예매");
		bt_reserve.setBackground(new Color(52,52,51));
		bt_reserve.setForeground(Color.WHITE);
		bt_reserve.setFont(new Font("굴림", Font.BOLD, 18));
		
		
		la_image = new JLabel(image_poster);
		la_image.setBounds(61, 61, 141, 181);
		la_title = new JLabel("앤트맨과 와스프");
		la_title.setFont(new Font("궁서", Font.BOLD, 25));
		la_percent = new JLabel("예매율 35.5%");
		la_percent.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 21));
		la_genre = new JLabel("코미디액션");
		la_genre.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 21));
		tbt_stars = new JToggleButton[5];
		
		la_percent.setBorder(lineb);
		la_image.setBorder(linea);
//Label 정렬
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
	
//tbt_starts 배열 이미지 삽입 & 버튼 투명 적용
		for(int i=0; i<tbt_stars.length; i++) {
			tbt_stars[i] = new JToggleButton(new ImageIcon("image/star_blank.png"));
			tbt_stars[i].setBorderPainted(false);	//tbt Border 없애주기
			tbt_stars[i].setContentAreaFilled(false);	//tbt 내용영역 채우지 않음
			tbt_stars[i].setFocusPainted(false);	//tbt 선택 테두리 사용 안함
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
	}//생성자
}
