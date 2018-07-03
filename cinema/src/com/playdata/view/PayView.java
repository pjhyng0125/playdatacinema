package com.playdata.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JList;
import java.awt.Choice;
/*
 * ������
 */
public class PayView extends JFrame {
	JPanel p;
	JPanel p_cash,p_discount;
	
	//-----------------------------��
	JLabel la_member;//ȸ�����
	JLabel la_pay;//�����ݾ�
	JLabel la_discount;//���αݾ�
	JLabel la_point;//����Ʈ���
	JLabel la_final_pay;//���������ݾ�
	JLabel la_have_cash;//���� ĳ��
	JLabel la_balance;// ����� �ܾ�
	JLabel la_sc_point;// ���޿�������Ʈ
	JLabel la_cash;//���� ĳ��
	JLabel la_charge_cash;//ĳ������
	JLabel la_discount_list, la_discount_coupon,la_have_point;//���γ���,��������,��������Ʈ
	Choice ch_copoun;//���� ����
	
	//-----------------------------�ؽ�Ʈ�����
	JTextArea ta_grade;//�������
	JTextArea ta_pmovie_info;//��ȭ����
    JTextArea ta_pay;//�����ݾ�
    JTextArea ta_discount;//���αݾ�
    JTextArea ta_point;//����Ʈ�ݾ�
    JTextArea ta_final_pay;//���������ݾ�
    JTextArea ta_have_cash;//����ĳ��
    JTextArea ta_balance;//����� �ܾ�
    JTextArea ta_sc_point;//���޿�������Ʈ
    
    //------------------------------�ؽ�Ʈ�ʵ�
    JTextField tf_charge_cash;//ĳ������
    JTextField tf_use_point;//����Ʈ ���
    
    //-------------------------------��ư
    JButton b_ok,b_cancel;//������ Ȯ��,���
    JButton b_charge_ok,b_charge_cancel;//ĳ�� ���� ���
    JButton b_discount_ok,b_discount_cancel;//���� ���� ��� ���
    JButton b_point_ok,b_point_cancel;//����Ʈ ��� ���
    private JPanel panel_1;

	
	
	
	public PayView() {
		setTitle("����â");

//============ ���� ���� ���� ===========
		p = new JPanel();
			p.setBackground(Color.WHITE);
			p.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, 
					Color.BLACK, Color.BLACK, Color.BLACK));
			p.setBounds(667, 40, 470, 652);
		la_member = new JLabel("ȸ�����");
			la_member.setFont(new Font("���� ���", Font.PLAIN, 22));
		ta_pmovie_info = new JTextArea();
			ta_pmovie_info.setText("��ȭ���� (��¥,���۽ð�,�󿵰�)");
		ta_grade = new JTextArea();
			ta_grade.setFont(new Font("���� ���", Font.PLAIN, 22));
			ta_grade.setText("�������");
		la_pay = new JLabel("�����ݾ�");
			la_pay.setFont(new Font("���� ���", Font.PLAIN, 21));
		la_discount = new JLabel("���αݾ�");
			la_discount.setFont(new Font("���� ���", Font.PLAIN, 21));
		la_point = new JLabel("����Ʈ���");
			la_point.setFont(new Font("���� ���", Font.PLAIN, 21));
		la_final_pay = new JLabel("���������ݾ�");
			la_final_pay.setFont(new Font("���� ���", Font.PLAIN, 21));
		la_have_cash = new JLabel("���� ĳ��");
			la_have_cash.setFont(new Font("���� ���", Font.PLAIN, 21));
		la_balance = new JLabel("����� �ܾ�");
			la_balance.setFont(new Font("���� ���", Font.PLAIN, 21));
		la_sc_point = new JLabel("���޿�������Ʈ");
			la_sc_point.setFont(new Font("���� ���", Font.PLAIN, 19));
		
		//�ؽ�Ʈ�����̾�	
		ta_pay = new JTextArea();
		    ta_pay.setFont(new Font("���� ���", Font.PLAIN, 22));
		    ta_pay.setText("16,000");	
		ta_discount = new JTextArea();
			ta_discount.setText("0");
			ta_discount.setFont(new Font("���� ���", Font.PLAIN, 22));
		ta_point = new JTextArea();
			ta_point.setText("2,000");
			ta_point.setFont(new Font("���� ���", Font.PLAIN, 22));
		ta_final_pay = new JTextArea();
			ta_final_pay.setText("14,000");
			ta_final_pay.setFont(new Font("���� ���", Font.PLAIN, 22));			
		ta_have_cash = new JTextArea();
			ta_have_cash.setText("30,000");
			ta_have_cash.setFont(new Font("���� ���", Font.PLAIN, 22));			
		ta_balance = new JTextArea();
			ta_balance.setText("16,000");
			ta_balance.setFont(new Font("���� ���", Font.PLAIN, 22));
		ta_sc_point = new JTextArea();
			ta_sc_point.setText("140");
			ta_sc_point.setFont(new Font("���� ���", Font.PLAIN, 21));			
		
			
	    //��ư
		b_ok = new JButton("Ȯ��");   		   //�������� Ȯ��
		b_cancel = new JButton("���");		   //�������� ���
		b_charge_ok = new JButton("����");	   //���� Ȯ��
		b_charge_cancel = new JButton("���");  //���� ���
		b_discount_ok = new JButton("���");    //���� ���
		b_discount_cancel = new JButton("���");//���� ���
		b_point_ok = new JButton("���");       //����Ʈ ���
		b_point_cancel = new JButton("���");   //����Ʈ ���
		
		//����ġ
		la_member.setBounds(148, 30, 121, 54);//ȸ�����
		la_pay.setBounds(40, 170, 121, 41);//�����ݾ�
		la_discount.setBounds(40, 242, 121, 41);//���αݾ�
		la_point.setBounds(40, 306, 136, 41);//����Ʈ�ݾ�
		la_final_pay.setBounds(40, 368, 161, 41);//���������ݾ�
		la_have_cash.setBounds(40, 437, 161, 41);//����ĳ��
		la_balance.setBounds(40, 476, 161, 41);//������ܾ�
		la_sc_point.setBounds(40, 529, 161, 41);//���޿�������Ʈ
		
		//�ؽ�Ʈ�����	
		ta_grade.setBounds(253, 40, 161, 34);//�������
		ta_pmovie_info.setBounds(86, 96, 311, 35);//��ȭ����
		ta_pay.setBounds(252, 170, 110, 37);//�����ݾ�
		ta_discount.setBounds(253, 242, 110, 37);//���αݾ�
		ta_point.setBounds(252, 310, 110, 37);//����Ʈ�ݾ�
		ta_final_pay.setBounds(253, 372, 110, 37);//���������ݾ�
		ta_have_cash.setBounds(252, 441, 110, 37);//����ĳ��
		ta_balance.setBounds(252, 476, 110, 37);//������ܾ�
		ta_sc_point.setBounds(252, 529, 110, 37);//���޿�������Ʈ
			
		//��ư ��ġ
		b_ok.setBounds(118, 599, 105, 41);    		 //�������� Ȯ��
		b_cancel.setBounds(271, 599, 105, 41); 		 //�������� ���
		b_charge_ok.setBounds(432, 264, 61, 27);     //���� Ȯ��
		b_charge_cancel.setBounds(507, 264, 61, 27); //���� ���
		b_discount_ok.setBounds(432, 500, 61, 27);   //���� ���
		b_discount_cancel.setBounds(507, 500, 61, 27);//���� ���
		b_point_ok.setBounds(432, 586, 61, 27);      //����Ʈ ���
		b_point_cancel.setBounds(507, 586, 61, 27);  //����Ʈ ���



		
		//contentpane
	    getContentPane().add(p);
	    getContentPane().setLayout(null);
	    getContentPane().add(b_charge_ok);
		getContentPane().add(b_charge_cancel);
		getContentPane().add(b_point_ok);
		getContentPane().add(b_point_cancel);
		getContentPane().add(b_discount_ok);
		getContentPane().add(b_discount_cancel);
		
	    
		p.setLayout(null);
		p.add(la_member);
		p.add(ta_pmovie_info);
		p.add(ta_grade);
		p.add(la_pay);
		p.add(la_discount);
		p.add(la_point);
		p.add(la_final_pay);
		p.add(la_have_cash);
		p.add(la_balance);
		p.add(la_sc_point);
		p.add(b_ok);
		p.add(b_cancel);
		p.add(ta_pay);
		p.add(ta_discount);
		p.add(ta_point);
		p.add(ta_final_pay);
		p.add(ta_have_cash);
		p.add(ta_balance);
		p.add(ta_sc_point);
		
		
        //���� ĳ�� ����, ���γ��� ��
		la_cash = new JLabel("ĳ��");
			la_cash.setFont(new Font("���� ���", Font.PLAIN, 22));
		la_have_cash = new JLabel("����ĳ��");
			la_have_cash.setFont(new Font("���� ���", Font.PLAIN, 22));
		la_charge_cash = new JLabel("ĳ�� ����");
		la_charge_cash.setForeground(SystemColor.desktop);
			la_charge_cash.setFont(new Font("���� ���", Font.PLAIN, 22));
		la_discount_list = new JLabel("���γ���");
			la_discount_list.setFont(new Font("���� ���", Font.PLAIN, 22));
		la_discount_coupon = new JLabel("���� ����");
			la_discount_coupon.setFont(new Font("���� ���", Font.PLAIN, 22));
		la_have_point = new JLabel("���� ����Ʈ");
			la_have_point.setFont(new Font("���� ���", Font.PLAIN, 22));
		ta_have_cash = new JTextArea();
			ta_have_cash.setBackground(SystemColor.text);
			ta_have_cash.setText("30,000");	
		ta_have_cash = new JTextArea();
			ta_have_cash.setBackground(SystemColor.text);
			ta_have_cash.setText("30,000");
			ta_have_cash.setFont(new Font("���� ���", Font.PLAIN, 22));
		ta_have_cash = new JTextArea();
			ta_have_cash.setBackground(SystemColor.text);
			ta_have_cash.setText("30,000");
			ta_have_cash.setFont(new Font("���� ���", Font.PLAIN, 22));
			
		//���� �� ��ġ
		la_cash.setBounds(101, 84, 109, 66);
		la_have_cash.setBounds(101, 162, 109, 66);
		la_charge_cash.setBounds(101, 240, 109, 66);
		la_discount_list.setBounds(101, 406, 109, 66);
		la_discount_coupon.setBounds(101, 484, 109, 66);
		la_have_point.setBounds(101, 572, 138, 66);	
		ta_have_cash.setBounds(272, 178, 110, 37);
		
		//contentpane
		getContentPane().add(la_cash);
		getContentPane().add(la_have_cash);
		getContentPane().add(la_charge_cash);
		getContentPane().add(la_discount_list);
		getContentPane().add(la_discount_coupon);
		getContentPane().add(la_have_point);
		getContentPane().add(ta_have_cash);
		
		
		
		//�ؽ�Ʈ�ʵ�
		tf_charge_cash = new JTextField();
			tf_charge_cash.setBounds(253, 258, 129, 31);
			getContentPane().add(tf_charge_cash);
			tf_charge_cash.setColumns(10);
		tf_use_point = new JTextField();
			tf_use_point.setBounds(253, 584, 129, 31);
			getContentPane().add(tf_use_point);
			tf_use_point.setColumns(10);
		
		//���̽�
		ch_copoun= new Choice();
			ch_copoun.add("===== ���� =====");
			ch_copoun.add("���� 50%���� ����");
			ch_copoun.add("���� 50%���� ����");
			ch_copoun.add("���� 50%���� ����");
			ch_copoun.add("���� 50%���� ����");
			ch_copoun.setBounds(262, 503, 120, 24);
			getContentPane().add(ch_copoun);
			
		//�г� �׵θ�	
			p_cash = new JPanel();
				p_cash.setBackground(Color.white);
				p_cash.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,Color.BLACK, Color.BLACK, Color.BLACK));
				p_cash.setBounds(77, 84, 532, 259);
				getContentPane().add(p_cash);
				p_cash.setLayout(null);
			p_discount = new JPanel();
				p_discount.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
				p_discount.setBackground(Color.WHITE);
				p_discount.setBounds(77, 406, 532, 259);
				getContentPane().add(p_discount);
				p_discount.setLayout(null);
			
		
		setSize(1200, 800);
		setVisible(false);
		
	}//������
}
