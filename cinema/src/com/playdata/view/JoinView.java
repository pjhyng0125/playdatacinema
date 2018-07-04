package com.playdata.view;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinView extends JFrame 
{
	public JTextField tf_id,tf_name,tf_phone1,tf_phone2,tf_phone3,tf_addr,tf_addr2,tf_hint2,tf_email1,tf_email2;
	public JPasswordField tf_pass,tf_pass2;
	public JButton bt_submit,bt_reset,bt_checkid;
	JLabel la_id,la_pass1,la_pass2,la_n,la_t,la_addr,la_addr2,la_hint1,la_gender,la_email,la_man,la_woman;
	public JComboBox<String> cb_hint;
	JLabel jb[],at[];
	public JCheckBox cb_gender1, cb_gender2;

	    
	
	 
	
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
		tf_name= new JTextField();
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
		la_n = new JLabel("이  름:");
		la_t = new JLabel("전화번호:");
		la_addr = new JLabel("주  소:");
		la_addr2 = new JLabel("상세주소");
		la_hint1 = new JLabel("비번힌트:");
		la_gender = new JLabel("성별:");
		la_email = new JLabel("이메일:");
		la_man = new JLabel("남자");
		la_woman = new JLabel("여자");
		
		cb_hint = new JComboBox<String>(hintT);
		
		cb_gender1 = new JCheckBox();
		cb_gender2 = new JCheckBox();
		
		
		
		tf_id.setBounds(80,30,100,25);
		tf_pass.setBounds(80,70,100,25);
		tf_pass2.setBounds(80,110,100,25);
		tf_hint2.setBounds(80,180,100,25);
		tf_name.setBounds(80,220,100,25);
		
		tf_phone1.setBounds(80,300,40,25);
		jb[0].setBounds(121,300,8,25);
		tf_phone2.setBounds(130,300,40,25);
		jb[1].setBounds(171,300,8,25);
		tf_phone3.setBounds(180,300,40,25);
		
		tf_email1.setBounds(80,340,80,25);
		at[0].setBounds(163,340,25,25);
		tf_email2.setBounds(180,340,70,25);
		
		tf_addr.setBounds(80,380,200,25);
		tf_addr2.setBounds(80,410,150,25);
		
		bt_submit.setBounds(50,500,90,25);
		bt_reset.setBounds(150,500,90,25);
		bt_checkid.setBounds(190,30,90,25);
		
		la_id.setBounds(10,30,100,25);
		la_pass1.setBounds(10,70,100,25);
		la_pass2.setBounds(10,110,100,25);
		la_hint1.setBounds(10,150,100,25);
		la_n.setBounds(10,220,100,25);
		la_gender.setBounds(10,260,100,25);
		la_t.setBounds(10,300,100,25);
		la_email.setBounds(10,340,100,25);
		la_addr.setBounds(10,380,100,25);
		
		
		
		cb_hint.setBounds(80,150,130,25);
		
		cb_gender1.setBounds(80,260,25,25);
		cb_gender2.setBounds(120,260,25,25);
		
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
		
		add(bt_submit);
		add(bt_reset);
		add(bt_checkid);
		
		add(la_id); 
		add(la_pass1); 
		add(la_pass2); 
		add(la_n);
		add(la_t);
		add(la_addr);
		add(la_addr2);
		add(la_hint1);
		add(la_gender);
		add(la_email);
		add(la_man);
		add(la_woman);
		
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
		
				
		
		setBounds(350,200,300,600);	
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
	  cb_hint.setSelectedIndex(0);
  }
  public static void main(String[] args) {
	new JoinView();
}

}//JoinForm

