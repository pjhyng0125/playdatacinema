package com.playdata.view;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinView extends JFrame 
{
	public JTextField tf_id,tf_name,tf_phone1,tf_phone2,tf_phone3,tf_addr,tf_addr2,tf_hint2,tf_email1,tf_email2,tf_birth;
	public JPasswordField tf_pass,tf_pass2;
	public JButton bt_submit,bt_reset,bt_checkid;
	JLabel la_id,la_pass1,la_pass2,la_name,la_phone,la_addr,la_addr2,la_hint1,la_gender,la_email,
		   la_man,la_woman,la_birth,la_title;
	public JComboBox<String> cb_hint;
	JLabel jb[],at[];
	public JCheckBox cb_gender1, cb_gender2;
	JPanel panel;

	    
	
	 
	
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
		
		
		tf_id = new JTextField();
		tf_pass = new JPasswordField();
		tf_pass2 = new JPasswordField();
		tf_name = new JTextField();
		tf_birth = new JTextField();
		tf_phone1 = new JTextField();
		tf_phone2 = new JTextField();
		tf_phone3 = new JTextField();
		tf_addr = new JTextField();
		tf_addr2 = new JTextField();
		tf_hint2 = new JTextField();
		tf_email1 = new JTextField();
		tf_email2 = new JTextField();
		
	    bt_submit = new JButton("등록");
	    bt_reset = new JButton("취소");
		bt_checkid = new JButton("중복확인");
		
		la_id = new JLabel("I  D:");
		la_pass1 = new JLabel("비  번:");
		la_pass2 = new JLabel("비번확인:");
		la_name = new JLabel("이  름:");
		la_phone = new JLabel("전화번호:");
		la_addr = new JLabel("주  소:");
		la_addr2 = new JLabel("상세주소");
		la_hint1 = new JLabel("비번힌트:");
		la_gender = new JLabel("성 별:");
		la_email = new JLabel("이메일:");
		la_man = new JLabel("남자");
		la_woman = new JLabel("여자");
		la_birth = new JLabel("생 일:");
		la_title = new JLabel("회원가입");
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,300,70);
		panel.setBackground(Color.BLACK);
		
		cb_hint = new JComboBox<String>(hintT);
		
		cb_gender1 = new JCheckBox();
		cb_gender2 = new JCheckBox();
		
		
		
		tf_id.setBounds(80,100,100,25);
		tf_pass.setBounds(80,140,100,25);
		tf_pass2.setBounds(80,180,100,25);
		tf_hint2.setBounds(80,250,100,25);
		tf_name.setBounds(80,300,100,25);
		tf_birth.setBounds(80,340,100,25);
		
		tf_phone1.setBounds(80,420,40,25);
		jb[0].setBounds(121,420,8,25);
		tf_phone2.setBounds(130,420,40,25);
		jb[1].setBounds(171,420,8,25);
		tf_phone3.setBounds(180,420,40,25);
		
		tf_email1.setBounds(80,460,80,25);
		at[0].setBounds(163,460,25,25);
		tf_email2.setBounds(180,460,70,25);
		
		tf_addr.setBounds(80,500,200,25);
		tf_addr2.setBounds(80,530,150,25);
		
		bt_submit.setBounds(50,600,90,25);
		bt_reset.setBounds(150,600,90,25);
		bt_checkid.setBounds(190,100,90,25);
		
		la_id.setBounds(10,100,100,25);
		la_pass1.setBounds(10,140,100,25);
		la_pass2.setBounds(10,180,100,25);
		la_hint1.setBounds(10,220,100,25);
		la_name.setBounds(10,300,100,25);
		la_birth.setBounds(10,340,100,25);
		la_gender.setBounds(10,380,50,25);
		la_man.setBounds(80,380,40,25);
		la_woman.setBounds(140,380,40,25);
		la_phone.setBounds(10,420,100,25);
		la_email.setBounds(10,460,100,25);
		la_addr.setBounds(10,500,100,25);
		la_title.setBounds(90,15,130,50);
		la_title.setFont(new Font("돋움", Font.PLAIN, 30));
		la_title.setForeground(Color.WHITE);
		
		
		
		cb_hint.setBounds(80,220,130,25);
		
		cb_gender1.setBounds(110,380,25,25);
		cb_gender2.setBounds(170,380,25,25);
		
		setLayout(null);
		add(tf_id);
		add(tf_pass);
		add(tf_pass2);
		add(tf_name);
		add(tf_phone1); 
		add(tf_phone2); 
		add(tf_phone3); 
		add(tf_addr); 
		add(tf_addr2);
		add(tf_hint2);
		add(tf_email1);
		add(tf_email2);
		add(tf_birth);
		
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
		
		add(panel);
		panel.add(la_title);
		
		add(cb_gender1);
		add(cb_gender2);
		
		add(cb_hint);
		
		for(int i=0; i<jb.length; i++)
		{
			add(jb[i]);
			}
		
		for(int i=0; i<at.length; i++)
		{
			add(at[i]);
		}
		
				
		
		setBounds(350,200,300,700);	
		setResizable(false);
		setVisible(true);
	}//생성자  
  public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
  
  public void setEmpty() {
	  tf_id.setText("");
	  tf_addr.setText("");
	  tf_addr2.setText("");
	  tf_name.setText("");
	  tf_pass.setText("");
	  tf_pass2.setText("");
	  tf_hint2.setText("");
	  tf_phone1.setText("");
	  tf_phone2.setText("");
	  tf_phone3.setText("");
	  tf_email1.setText("");
	  tf_email2.setText("");
	  tf_birth.setText("");
	  cb_hint.setSelectedIndex(0);
  }
  public static void main(String[] args) {
	new JoinView();
}

}//JoinForm

