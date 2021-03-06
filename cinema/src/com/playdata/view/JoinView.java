package com.playdata.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JoinView extends JFrame 
{
	public JTextField tf_id,tf_name,tf_phone1,tf_phone2,tf_phone3,tf_addr,
					  tf_hint2,tf_email1,tf_email2,tf_birth1,tf_birth2,tf_birth3;
	public JPasswordField tf_pass,tf_pass2;
	public JButton bt_submit,bt_reset,bt_checkid;
	JLabel la_id,la_pass1,la_pass2,la_name,la_phone,la_addr,la_addr2,la_hint1,la_gender,la_email,
		   la_birth,la_title,la_ex1,la_ex2,la_logo,la_cinema;
	public JLabel la_man,la_woman;
	public JComboBox<String> cb_hint,cb_email; 
	JLabel jb[],at[];
	public JRadioButton rb_gender1, rb_gender2;
	ButtonGroup bg;
	JPanel panel;
	ImageIcon icon1;

	    
	
	 
	
  public JoinView()
	{	  
		setTitle("JoinView");
		
		jb = new JLabel[2];
		for(int i=0; i<jb.length; i++)
		{
			jb[i]=new JLabel("-");
			}
		at = new JLabel[1];
		for(int i=0; i<at.length; i++)
		{
			at[i]=new JLabel("@");
		}
		
		
		String hintT[]= {"초등학교 이름은?", "좋아하는책은?", "태어난곳은?", "어릴적 별명은?", "좋아하는 게임은?"};
		String emailT[]= {"직접입력", "naver.com", "gmail.com", "yahoo.com", "daum.net"};
		
		
		tf_id = new JTextField();
		tf_pass = new JPasswordField();
		tf_pass2 = new JPasswordField();
		tf_name = new JTextField();
		tf_birth1 = new JTextField();
		tf_birth2 = new JTextField();
		tf_birth3 = new JTextField();
		tf_phone1 = new JTextField();
		tf_phone2 = new JTextField();
		tf_phone3 = new JTextField();
		tf_addr = new JTextField();
		tf_hint2 = new JTextField();
		tf_email1 = new JTextField();
		tf_email2 = new JTextField();
		
		
	    bt_submit = new JButton("등록");
	    bt_reset = new JButton("취소");
		bt_checkid = new JButton("중복확인");
		
		la_id = new JLabel("*I  D:");
		la_pass1 = new JLabel("*비  번:");
		la_pass2 = new JLabel("*비번확인:");
		la_name = new JLabel("*이  름:");
		la_phone = new JLabel("*전화번호:");
		la_addr = new JLabel("*주  소:");
		la_addr2 = new JLabel("*상세주소");
		la_hint1 = new JLabel("*비번힌트:");
		la_gender = new JLabel("*성 별:");
		la_email = new JLabel("*이메일:");
		la_man = new JLabel("남자");
		la_woman = new JLabel("여자");
		la_birth = new JLabel("*생년월일:");
		la_title = new JLabel("회원가입");
		la_ex1 = new JLabel("ex)1999.05.15");
		la_ex2 = new JLabel("ex)a123@naver.com");
		
		icon1 = new ImageIcon("image/logo.png");
		la_logo = new JLabel(icon1);
		la_logo.setBounds(300, 590, 50, 50);
		la_cinema = new JLabel("Cinema");
		la_cinema.setBounds(230, 590, 100, 50);
		la_cinema.setFont(new Font("도움", Font.HANGING_BASELINE, 20));
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,370,70);
		panel.setBackground(Color.BLACK);
		
		cb_hint = new JComboBox<String>(hintT);
		cb_email = new JComboBox<String>(emailT);
		
		rb_gender1 = new JRadioButton();
		rb_gender2 = new JRadioButton();
		bg = new ButtonGroup();
		bg.add(rb_gender1);
		bg.add(rb_gender2);
		
		tf_id.setBounds(80,100,100,25);
		tf_pass.setBounds(80,140,100,25);
		tf_pass2.setBounds(80,180,100,25);
		tf_hint2.setBounds(80,250,100,25);
		tf_name.setBounds(80,300,100,25);
		tf_birth1.setBounds(80,340,50,25);
		tf_birth2.setBounds(140,340,25,25);
		tf_birth3.setBounds(170,340,25,25);
		
		tf_phone1.setBounds(80,420,40,25);
		jb[0].setBounds(121,420,8,25);
		tf_phone2.setBounds(130,420,40,25);
		jb[1].setBounds(171,420,8,25);
		tf_phone3.setBounds(180,420,40,25);
		
		tf_email1.setBounds(80,460,80,25);
		at[0].setBounds(163,460,25,25);
		tf_email2.setBounds(180,460,70,25);
		
		tf_addr.setBounds(80,500,200,25);
		
		bt_submit.setBounds(70,560,90,25);
		bt_submit.setBackground(Color.BLACK);
		bt_submit.setForeground(Color.WHITE);
		bt_reset.setBounds(190,560,90,25);
		bt_reset.setBackground(Color.BLACK);
		bt_reset.setForeground(Color.WHITE);
		bt_checkid.setBounds(190,100,90,25);
		bt_checkid.setBackground(Color.BLACK);
		bt_checkid.setForeground(Color.WHITE);
		
		
		la_id.setBounds(10,100,100,25);
		la_pass1.setBounds(10,140,100,25);
		la_pass2.setBounds(10,180,100,25);
		la_hint1.setBounds(10,220,100,25);
		la_name.setBounds(10,300,100,25);
		la_birth.setBounds(10,340,100,25);
		la_ex1.setBounds(90,360,100,20);
		la_ex1.setFont(new Font("궁서체", Font.PLAIN, 12));
		la_gender.setBounds(10,380,50,25);
		la_man.setBounds(105,380,40,25);
		la_woman.setBounds(165,380,40,25);
		la_phone.setBounds(10,420,100,25);
		la_email.setBounds(10,460,100,25);
		la_ex2.setBounds(90,480,150,20);
		la_ex2.setFont(new Font("궁서체", Font.PLAIN, 12));
		la_addr.setBounds(10,500,100,25);
		la_title.setBounds(120,15,130,50);
		la_title.setFont(new Font("돋움", Font.PLAIN, 30));
		la_title.setForeground(Color.WHITE);
		
		
		
		
		cb_hint.setBounds(80,220,130,25);
		cb_email.setBounds(255,460,100,25);
	
	
		
		rb_gender1.setBounds(80,380,25,25);
		rb_gender2.setBounds(140,380,25,25);
		
		setLayout(null);
		add(tf_id);
		add(tf_pass);
		add(tf_pass2);
		add(tf_name);
		add(tf_phone1); 
		add(tf_phone2); 
		add(tf_phone3); 
		add(tf_addr); 
		add(tf_hint2);
		add(tf_email1);
		add(tf_email2);
		add(tf_birth1);
		add(tf_birth2);
		add(tf_birth3);
		
		
		add(bt_submit);
		add(bt_reset);
		add(bt_checkid);
		
		add(la_id); 
		add(la_pass1); 
		add(la_pass2); 
		add(la_name);
		add(la_phone);
		add(la_addr);
		add(la_addr2);
		add(la_hint1);
		add(la_gender);
		add(la_email);
		add(la_man);
		add(la_woman);
		add(la_birth);
		add(la_title);
		add(la_ex1);
		add(la_ex2);
		add(la_logo);
		add(la_cinema);
		
		add(panel);
		panel.add(la_title);
		
		add(rb_gender1);
		add(rb_gender2);
		
		add(cb_hint);
		add(cb_email);
		
		
		for(int i=0; i<jb.length; i++)
		{
			add(jb[i]);
			}
		
		for(int i=0; i<at.length; i++)
		{
			add(at[i]);
		}
		
				
		
		setBounds(350,200,370,680);	
		setResizable(false);
		setVisible(false);
	}//생성자  
  public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
  
  
  
  public void setEmpty() {
	  tf_id.setText("");
	  tf_addr.setText("");
	  tf_name.setText("");
	  tf_pass.setText("");
	  tf_pass2.setText("");
	  tf_hint2.setText("");
	  tf_phone1.setText("");
	  tf_phone2.setText("");
	  tf_phone3.setText("");
	  tf_email1.setText("");
	  tf_email2.setText("");
	  tf_birth1.setText("");
	  tf_birth2.setText("");
	  tf_birth3.setText("");
	  cb_hint.setSelectedIndex(0);
	  cb_email.setSelectedIndex(0);
	  
  }
  
  
  public boolean showConfirmMsg(String msg) {
	  int t = JOptionPane.showConfirmDialog(this,msg,"회원가입 등록",JOptionPane.YES_NO_OPTION);
	  if(t==0) {
		  return true;
	  }
	  return false;
  }

}//JoinForm

