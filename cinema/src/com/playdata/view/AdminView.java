package com.playdata.view;

import java.awt.Color;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * �����ں�
 */
public class AdminView extends JFrame implements Runnable {
	
	JTextField tf_totProfit;
	
	JTable t_customerInf;
	JTable t_profitInf;
	JTable t_payHistory;
	
	DefaultTableModel dtm_cus;
	DefaultTableModel dtm_pro;
	DefaultTableModel dtm_pay;
	
	JLabel la_customerInf;
	JLabel la_profitInf;
	JLabel la_payHistory;
	JLabel la_totProfit;
	JLabel la_time;
	
	JButton bt_selectAll;
	JButton bt_select;
	JButton bt_save;
	JButton bt_delete;
	JButton bt_canclePay;
	JButton bt_postManage;
	JButton bt_cmtManage;
	
	JScrollPane sp_cus;
	JScrollPane sp_pro;
	JScrollPane sp_pay;
	
	Calendar c;
	/*
	�ۼ���:������
	��������:07/02/20:17
	��¥ �� ��ư �߰�
	*/
	public AdminView() {
		setTitle("AdminView");
		la_time = new JLabel();
			la_time.setBounds(980, 30, 200, 30);
		la_customerInf = new JLabel("ȸ������");
			la_customerInf.setBounds(150, 60, 100, 30);
		la_profitInf = new JLabel("��������");
			la_profitInf.setBounds(150,440,100,30);
		la_payHistory = new JLabel("��������");
			la_payHistory.setBounds(550,440,100,30);
			
		la_totProfit = new JLabel("�Ѽ���");
			la_totProfit.setBounds(250, 675, 100, 30);
		tf_totProfit = new JTextField("0000000��");
			tf_totProfit.setBounds(300, 675, 150, 30);
			tf_totProfit.setHorizontalAlignment(JTextField.RIGHT);
			
		
		bt_selectAll = new JButton("��ü��ȸ");
			bt_selectAll.setBounds(620, 380, 100, 30);
		bt_select = new JButton("������ȸ");
			bt_select.setBounds(740, 380, 100, 30);
		bt_save = new JButton("����");
			bt_save.setBounds(860, 380, 80, 30);
		bt_delete = new JButton("����");
			bt_delete.setBounds(960, 380, 80, 30);
		bt_canclePay = new JButton("�������");
			bt_canclePay.setBounds(750, 675, 100, 30);
		bt_postManage = new JButton("�Խù�����");
			bt_postManage.setBounds(960, 550, 100, 30);
		bt_cmtManage = new JButton("�ı����");
			bt_cmtManage.setBounds(960, 600, 100, 30);
		Object[] cusCol = {"���̵�","����","�̸�","�������","����ó"
							,"�ּ�","�̸���","����Ʈ","ĳ��","ȸ�����"};
		Object[] payCol = {"���̵�","������","Ƽ���ڵ�"};
		Object[] proCol = {"���̵�","�����ݾ�"};
		
		dtm_cus = new DefaultTableModel(cusCol,15);
		dtm_pay = new DefaultTableModel(proCol,10);
		dtm_pro = new DefaultTableModel(payCol,10);
		
		t_customerInf = new JTable(dtm_cus);
		t_payHistory = new JTable(dtm_pay);
		t_profitInf = new JTable(dtm_pro);

		sp_cus = new JScrollPane(t_customerInf);
			sp_cus.setBounds(150, 100, 900, 265);
		sp_pay = new JScrollPane(t_payHistory);
			sp_pay.setBounds(150,480,300,185);
		sp_pro = new JScrollPane(t_profitInf);
			sp_pro.setBounds(550, 480, 300, 185);

		setLayout(null);
		
		add(la_time);
		add(la_customerInf);
		add(la_payHistory);
		add(la_profitInf);
		add(la_totProfit);
		add(sp_cus);
		add(sp_pay);
		add(sp_pro);
		add(bt_selectAll);
		add(bt_select);
		add(bt_save);
		add(bt_delete);
		add(bt_canclePay);
		add(bt_postManage);
		add(bt_cmtManage);
		add(tf_totProfit);
		
		Thread t = new Thread(this);
		t.start();
		setBounds(300, 400, 1200, 800);	
		setVisible(true);
	}//������
	
	@Override
	public void run() {
		try {
			while(true) {
			c = Calendar.getInstance();
			
			String timeStr = c.get(Calendar.YEAR)+ "�� "+
						 (c.get(Calendar.MONTH)+1)+"�� "+
						 c.get(Calendar.DATE)+"�� "+
						 c.get(Calendar.HOUR_OF_DAY)+"�� "+
						 c.get(Calendar.MINUTE)+ "�� "+
						 c.get(Calendar.SECOND)+"��";			 
			la_time.setText(timeStr);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new AdminView();
	}

}

