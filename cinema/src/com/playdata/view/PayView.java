package com.playdata.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
/*
 * ������
 */
public class PayView extends JFrame {
	JPanel p;
	JPanel p_cash,p_discount;
	  
	//-----------------------------��
	JLabel lb_member;//ȸ�����
	JLabel lb_pay;//�����ݾ�
	JLabel lb_discount;//���αݾ�
	JLabel lb_point;//����Ʈ���
	JLabel lb_final_pay;//���������ݾ�
	JLabel lb_have_cash;//���� ĳ��
	private JLabel lb_have_cash_1;
	JLabel lb_balance;// ����� �ܾ�
	JLabel lb_sc_point;// ���޿�������Ʈ
	JLabel lb_cash;//���� ĳ��
	JLabel lb_charge_cash;//ĳ������
	JLabel lb_discount_list, lb_discount_coupon,lb_have_point;//���γ���,��������,��������Ʈ
	Choice ch_copoun;//���� ����
	
	//-----------------------------�ؽ�Ʈ�ʵ�
	JTextField tf_grade;//�������
	JTextField tf_pmovie_info;//��ȭ����
    JTextField tf_pay;//�����ݾ�
    JTextField tf_discount;//���αݾ�
    JTextField tf_point;//����Ʈ�ݾ�
    JTextField tf_final_pay;//���������ݾ�
    JTextField tf_have_cash;//����ĳ��
    private JTextField tf_have_cash_1;
    JTextField tf_balance;//����� �ܾ�
    JTextField tf_sc_point;//���޿�������Ʈ
    JTextField tf_charge_cash;//ĳ������
    JTextField tf_use_point;//����Ʈ ���
    
    //-------------------------------��ư
    JButton bt_ok,bt_cancel;//������ Ȯ��,���
    JButton bt_charge_ok,bt_charge_cancel;//ĳ�� ���� ���
    JButton bt_discount_ok,bt_discount_cancel;//���� ���� ��� ���
    JButton bt_point_ok,bt_point_cancel;//����Ʈ ��� ���
    private JPanel panel_1;
    
    //-------------------------------�׵θ�
    LineBorder lineb,linea;
    

	
	
	public PayView() {
		setTitle("����â");
		lineb = new LineBorder(Color.white);
		linea = new LineBorder(Color.BLACK,3);
//============ ���� ���� ���� ===========
		p = new JPanel();
			p.setBackground(Color.WHITE);
			p.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, 
					Color.BLACK, Color.BLACK, Color.BLACK));
			p.setBounds(667, 40, 470, 652);
		lb_member = new JLabel("ȸ�����");
			lb_member.setFont(new Font("���� ���", Font.PLAIN, 22));
		tf_pmovie_info = new JTextField();
			tf_pmovie_info.setText("��ȭ���� (��¥,���۽ð�,�󿵰�)");
		tf_grade = new JTextField();
			tf_grade.setFont(new Font("���� ���", Font.PLAIN, 22));
			tf_grade.setText("�������");
			tf_grade.setBorder(lineb);
		lb_pay = new JLabel("�����ݾ�");
			lb_pay.setFont(new Font("���� ���", Font.PLAIN, 21));
		lb_discount = new JLabel("���αݾ�");
			lb_discount.setFont(new Font("���� ���", Font.PLAIN, 21));
		lb_point = new JLabel("����Ʈ���");
			lb_point.setFont(new Font("���� ���", Font.PLAIN, 21));
		lb_final_pay = new JLabel("���������ݾ�");
			lb_final_pay.setFont(new Font("���� ���", Font.PLAIN, 21));
		lb_have_cash = new JLabel("���� ĳ��");
			lb_have_cash.setFont(new Font("���� ���", Font.PLAIN, 21));
		lb_balance = new JLabel("����� �ܾ�");
			lb_balance.setFont(new Font("���� ���", Font.PLAIN, 21));
		lb_sc_point = new JLabel("���޿�������Ʈ");
			lb_sc_point.setFont(new Font("���� ���", Font.PLAIN, 19));
		
		//�ؽ�Ʈ�ʵ�	
		tf_pay = new JTextField();
		tf_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		    tf_pay.setFont(new Font("���� ���", Font.PLAIN, 22));
		    tf_pay.setText("16,000");	
		    tf_pay.setBorder(lineb);
		tf_discount = new JTextField();
		tf_discount.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_discount.setText("0");
			tf_discount.setFont(new Font("���� ���", Font.PLAIN, 22));
			tf_discount.setBorder(lineb);
		tf_point = new JTextField();
		tf_point.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_point.setText("2,000");
			tf_point.setFont(new Font("���� ���", Font.PLAIN, 22));
			tf_point.setBorder(lineb);
		tf_final_pay = new JTextField();
		tf_final_pay.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_final_pay.setText("14,000");
			tf_final_pay.setFont(new Font("���� ���", Font.PLAIN, 22));	
			tf_final_pay.setBorder(lineb);
		tf_have_cash = new JTextField();
		tf_have_cash.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_have_cash.setText("30,000");
			tf_have_cash.setFont(new Font("���� ���", Font.PLAIN, 22));
			tf_have_cash.setBorder(lineb);
		tf_balance = new JTextField();
		tf_balance.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_balance.setText("16,000");
			tf_balance.setFont(new Font("���� ���", Font.PLAIN, 22));
			tf_balance.setBorder(lineb);
		tf_sc_point = new JTextField();
		tf_sc_point.setHorizontalAlignment(SwingConstants.RIGHT);
			tf_sc_point.setText("140");
			tf_sc_point.setFont(new Font("���� ���", Font.PLAIN, 21));		
			tf_sc_point.setBorder(lineb);
		
			
	    //��ư
		bt_ok = new JButton("Ȯ��");   		   //�������� Ȯ��
		bt_cancel = new JButton("���");		   //�������� ���
		bt_charge_ok = new JButton("����");	   //���� Ȯ��
		bt_charge_cancel = new JButton("���");  //���� ���
		bt_discount_ok = new JButton("���");    //���� ���
		bt_discount_cancel = new JButton("���");//���� ���
		bt_point_ok = new JButton("���");       //����Ʈ ���
		bt_point_cancel = new JButton("���");   //����Ʈ ���
		
		//����ġ
		lb_member.setBounds(148, 30, 121, 54);//ȸ�����
		lb_pay.setBounds(40, 170, 121, 41);//�����ݾ�
		lb_discount.setBounds(40, 242, 121, 41);//���αݾ�
		lb_point.setBounds(40, 306, 136, 41);//����Ʈ�ݾ�
		lb_final_pay.setBounds(40, 368, 161, 41);//���������ݾ�
		lb_have_cash.setBounds(40, 437, 161, 41);//����ĳ��
		lb_balance.setBounds(40, 476, 161, 41);//������ܾ�
		lb_sc_point.setBounds(40, 529, 161, 41);//���޿�������Ʈ
		
		//�ؽ�Ʈ�ʵ�
		tf_grade.setBounds(253, 40, 161, 34);//�������
		tf_pmovie_info.setBounds(86, 96, 311, 35);//��ȭ����
		tf_pay.setBounds(252, 170, 110, 37);//�����ݾ�
		tf_discount.setBounds(253, 242, 110, 37);//���αݾ�
		tf_point.setBounds(252, 310, 110, 37);//����Ʈ�ݾ�
		tf_final_pay.setBounds(253, 372, 110, 37);//���������ݾ�
		tf_have_cash.setBounds(252, 441, 110, 37);//����ĳ��
		tf_balance.setBounds(252, 476, 110, 37);//������ܾ�
		tf_sc_point.setBounds(252, 529, 110, 37);//���޿�������Ʈ
			
		//��ư ��ġ
		bt_ok.setBounds(118, 599, 105, 41);    		 //�������� Ȯ��
		bt_cancel.setBounds(271, 599, 105, 41); 		 //�������� ���
		bt_charge_ok.setBounds(432, 264, 61, 27);     //���� Ȯ��
		bt_charge_cancel.setBounds(507, 264, 61, 27); //���� ���
		bt_discount_ok.setBounds(432, 500, 61, 27);   //���� ���
		bt_discount_cancel.setBounds(507, 500, 61, 27);//���� ���
		bt_point_ok.setBounds(432, 586, 61, 27);      //����Ʈ ���
		bt_point_cancel.setBounds(507, 586, 61, 27);  //����Ʈ ���

		

		
		//contentpane
	    getContentPane().add(p);
	    getContentPane().setLayout(null);
	    getContentPane().setBackground(new Color(247, 246, 239));
	    getContentPane().add(bt_charge_ok);
		getContentPane().add(bt_charge_cancel);
		getContentPane().add(bt_point_ok);
		getContentPane().add(bt_point_cancel);
		getContentPane().add(bt_discount_ok);
		getContentPane().add(bt_discount_cancel);
		
	    
		p.setLayout(null);
		p.add(lb_member);
		p.add(tf_pmovie_info);
		p.add(tf_grade);
		p.add(lb_pay);
		p.add(lb_discount);
		p.add(lb_point);
		p.add(lb_final_pay);
		p.add(lb_have_cash);
		p.add(lb_balance);
		p.add(lb_sc_point);
		p.add(bt_ok);
		p.add(bt_cancel);
		p.add(tf_pay);
		p.add(tf_discount);
		p.add(tf_point);
		p.add(tf_final_pay);
		p.add(tf_have_cash);
		p.add(tf_balance);
		p.add(tf_sc_point);
		
		
        //���� ĳ�� ����, ���γ��� ��
		lb_cash = new JLabel("ĳ��");
		lb_cash.setHorizontalAlignment(SwingConstants.CENTER);
			lb_cash.setFont(new Font("���� ���", Font.PLAIN, 22));
			lb_cash.setBorder(linea);
		lb_have_cash_1 = new JLabel("����ĳ��");
		lb_have_cash_1.setHorizontalAlignment(SwingConstants.CENTER);
			lb_have_cash_1.setFont(new Font("���� ���", Font.PLAIN, 22));
	/*	tf_have_cash = new JTextField();
			tf_have_cash.setBackground(SystemColor.text);
			tf_have_cash.setText("30,000");	
			tf_have_cash.setBorder(lineb);*///�� ������??
		tf_have_cash = new JTextField();
			tf_have_cash.setBackground(SystemColor.text);
			tf_have_cash.setText("30,000");
			tf_have_cash.setFont(new Font("���� ���", Font.PLAIN, 22));
			
		//���� �� ��ġ
		lb_cash.setBounds(101, 103, 109, 47);
		lb_have_cash_1.setBounds(101, 178, 109, 50);
		
		//contentpane
		getContentPane().add(lb_cash);
		getContentPane().add(lb_have_cash_1);
		
		
		
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
			ch_copoun.setBounds(253, 503, 129, 24);
			getContentPane().add(ch_copoun);
			
		//�г� �׵θ�	
			p_cash = new JPanel();
				p_cash.setBackground(Color.white);
				p_cash.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,Color.BLACK, Color.BLACK, Color.BLACK));
				p_cash.setBounds(77, 84, 532, 259);
				getContentPane().add(p_cash);
				p_cash.setLayout(null);
				lb_charge_cash = new JLabel("ĳ�� ����");
				lb_charge_cash.setHorizontalAlignment(SwingConstants.CENTER);
				lb_charge_cash.setBounds(27, 167, 109, 47);
				p_cash.add(lb_charge_cash);
				lb_charge_cash.setForeground(SystemColor.desktop);
				lb_charge_cash.setFont(new Font("���� ���", Font.PLAIN, 22));
				tf_have_cash_1 = new JTextField();
				tf_have_cash_1.setBounds(195, 102, 110, 37);
				p_cash.add(tf_have_cash_1);
				tf_have_cash_1.setHorizontalAlignment(SwingConstants.RIGHT);
				tf_have_cash_1.setBackground(SystemColor.text);
				tf_have_cash_1.setText("30,000");
				tf_have_cash_1.setFont(new Font("���� ���", Font.PLAIN, 22));
				tf_have_cash_1.setBorder(lineb);
			p_discount = new JPanel();
				p_discount.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
				p_discount.setBackground(Color.WHITE);
				p_discount.setBounds(77, 406, 532, 259);
				getContentPane().add(p_discount);
				p_discount.setLayout(null);
				lb_discount_list = new JLabel("���γ���");
				lb_discount_list.setHorizontalAlignment(SwingConstants.CENTER);
				lb_discount_list.setBorder(linea);
				lb_discount_list.setBounds(24, 12, 109, 47);
				p_discount.add(lb_discount_list);
				lb_discount_list.setFont(new Font("���� ���", Font.PLAIN, 22));
				lb_discount_coupon = new JLabel("���� ����");
				lb_discount_coupon.setHorizontalAlignment(SwingConstants.CENTER);
				lb_discount_coupon.setBounds(24, 83, 109, 50);
				p_discount.add(lb_discount_coupon);
				lb_discount_coupon.setFont(new Font("���� ���", Font.PLAIN, 22));
				lb_have_point = new JLabel("���� ����Ʈ");
				lb_have_point.setHorizontalAlignment(SwingConstants.CENTER);
				lb_have_point.setBounds(24, 166, 129, 47);
				p_discount.add(lb_have_point);
				lb_have_point.setFont(new Font("���� ���", Font.PLAIN, 22));
			
		
		setSize(1200, 800);
		setVisible(false);
		
	}//������
}
