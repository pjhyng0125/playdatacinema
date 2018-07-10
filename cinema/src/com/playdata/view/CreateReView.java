package com.playdata.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import java.awt.Font;

public class CreateReView extends JFrame {
<<<<<<< HEAD
	JLabel la_id, la_logo, la_cinema;
=======
	public JLabel la_id;
>>>>>>> de72aae49677f2b4b3253f64d1c5458cf6e25d09
	public JButton bt_create, bt_mypage;
	public JTextArea ta_content;
	public JToggleButton tbt_stars[];
	public JScrollPane sp;
	public JPanel panel;
	ImageIcon icon1;
	public CreateReView(String id) {
		setTitle("CreateReView");
		getContentPane().setLayout(null);
//new
		
		icon1 = new ImageIcon("image/logo.png");
		la_logo = new JLabel(icon1);
		la_logo.setBounds(200, 50, 50, 50);
		//la_cinema = new JLabel("Cinema");
		//la_cinema.setBounds(0, 0, 150, 50);
		//la_cinema.setFont(new Font("도움", Font.HANGING_BASELINE, 20));
		
		
		la_id = new JLabel(id);
		bt_create = new JButton("후기 입력");
		bt_create.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt_mypage = new JButton("마이 페이지");
		bt_mypage.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		ta_content = new JTextArea();
		
		sp = new JScrollPane(ta_content);
		tbt_stars = new JToggleButton[5];
		
		panel = new JPanel();
		panel.setBackground(new Color(245,201,203));//연한핑크색
//set starts
		for(int i=0; i<tbt_stars.length; i++) {
			tbt_stars[i] = new JToggleButton(new ImageIcon("image/star_blank.png"));
			tbt_stars[i].setBorderPainted(false);	//tbt Border 없애주기
			tbt_stars[i].setContentAreaFilled(false);	//tbt 내용영역 채우지 않음
			tbt_stars[i].setFocusPainted(false);	//tbt 선택 테두리 사용 안함
			}
//add stars
		for(int i=0; i<tbt_stars.length; i++) {
			tbt_stars[i].setBounds(50*(i)+120, 100, 50, 50);
			getContentPane().add(tbt_stars[i]);
		}
		setstarSelected(0);
//add
		la_id.setBounds(200, 50, 100, 30);
		getContentPane().add(la_id);
		sp.setBounds(43, 200, 400, 100);
		getContentPane().add(sp);
		bt_mypage.setBounds(320, 350, 120, 40);
		bt_mypage.setBackground(Color.black);
		bt_mypage.setForeground(Color.white);
		bt_create.setBounds(40, 350, 120, 40);
		bt_create.setBackground(Color.BLACK);
		bt_create.setForeground(Color.white);
		
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(bt_create);
		getContentPane().add(bt_mypage);
		getContentPane().add(panel);
		add(la_logo);
		//add(la_cinema);
		setSize(500,450);
		setVisible(true);
	}
	public void setstarSelected(int checked) {
		for(int k=0; k<tbt_stars.length; k++) {
			if(k<=checked) {
				tbt_stars[k].setSelected(true);
				tbt_stars[k].setIcon(new ImageIcon("image/star_yellow.png"));
			}
			else {
				tbt_stars[k].setSelected(false);
				tbt_stars[k].setIcon(new ImageIcon("image/star_blank.png"));
			}
		}
	}//setstarSelected
<<<<<<< HEAD
	public static void main(String[] args) {
		new CreateReView(null);
=======
	
	
	public boolean showConfirmMsg(String msg) {
		int t = JOptionPane.showConfirmDialog(this,msg,"회원가입 등록",JOptionPane.YES_NO_OPTION);
		  if(t==0) {
			  return true;
		  }
		  return false;
	  }
	
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
>>>>>>> de72aae49677f2b4b3253f64d1c5458cf6e25d09
	}

}


