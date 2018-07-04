package com.playdata.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class CreateReView extends JFrame {
	JLabel la_id;
	public JButton bt_create, bt_mypage;
	public JTextArea ta_content;
	public JToggleButton tbt_stars[];
	public JScrollPane sp;
	public CreateReView(String id) {
		setTitle("CreateReView");
		setLayout(null);
//new
		la_id = new JLabel(id);
		bt_create = new JButton("�ı� �Է�");
		bt_mypage = new JButton("���� ������");
		ta_content = new JTextArea();
		sp = new JScrollPane(ta_content);
		tbt_stars = new JToggleButton[5];
//set starts
		for(int i=0; i<tbt_stars.length; i++) {
			tbt_stars[i] = new JToggleButton(new ImageIcon("image/star_blank.png"));
			tbt_stars[i].setBorderPainted(false);	//tbt Border �����ֱ�
			tbt_stars[i].setContentAreaFilled(false);	//tbt ���뿵�� ä���� ����
			tbt_stars[i].setFocusPainted(false);	//tbt ���� �׵θ� ��� ����
			}
//add stars
		for(int i=0; i<tbt_stars.length; i++) {
			tbt_stars[i].setBounds(50*(i)+120, 100, 50, 50);
			add(tbt_stars[i]);
		}
		setstarSelected(0);
//add
		la_id.setBounds(200, 50, 100, 30);
		add(la_id);
		sp.setBounds(43, 200, 400, 100);
		add(sp);
		bt_mypage.setBounds(320, 350, 120, 40);
		bt_create.setBounds(40, 350, 120, 40);
		add(bt_create);
		add(bt_mypage);
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
}


