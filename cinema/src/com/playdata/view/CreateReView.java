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
	public JLabel la_id;
	public JButton bt_create, bt_cancle;
	public JTextArea ta_content;
	public JToggleButton tbt_stars[];
	public JScrollPane sp;
	public JPanel panel;
	ImageIcon icon1;
	public CreateReView(String id) {
		setTitle("CreateReView");
		getContentPane().setLayout(null);
//new	
		la_id = new JLabel(id);
		bt_create = new JButton("후기 입력");
		bt_create.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt_cancle = new JButton("취소");
		bt_cancle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
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
		bt_cancle.setBounds(320, 350, 120, 40);
		bt_cancle.setBackground(Color.black);
		bt_cancle.setForeground(Color.white);
		bt_create.setBounds(40, 350, 120, 40);
		bt_create.setBackground(Color.BLACK);
		bt_create.setForeground(Color.white);
		
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(bt_create);
		getContentPane().add(bt_cancle);
		getContentPane().add(panel);
		//add(la_cinema);
		setSize(500,450);
		setVisible(false);
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
	
	
	public boolean showConfirmMsg(String msg) {
		int t = JOptionPane.showConfirmDialog(this,msg,"회원가입 등록",JOptionPane.YES_NO_OPTION);
		  if(t==0) {
			  return true;
		  }
		  return false;
	  }
	
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

}


