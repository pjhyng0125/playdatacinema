package com.playdata.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class AdminView extends JFrame implements Runnable {
	JPanel p_member; // ȸ������ �г�
	JPanel p_history; // ��������(��������, ��������) �г�

	JComboBox<String> cb_menu;
	JComboBox<String> cb_month;
	JTextField tf_totProfit;

	JTable t_memberInf;
	JTable t_profitInf;
	JTable t_payHistory;

	DefaultTableModel dtm_member;
	DefaultTableModel dtm_pro;
	DefaultTableModel dtm_pay;

	JLabel la_memberInf;
	JLabel la_profitInf;
	JLabel la_payHistory;
	JLabel la_totProfit;
	JLabel la_time;

	JButton bt_selectAll;
	JButton bt_select;
	JButton bt_delete;
	JButton bt_canclePay;
	JButton bt_postManage;
	JButton bt_cmtManage;

	JScrollPane sp_member;
	JScrollPane sp_pro;
	JScrollPane sp_pay;

	Calendar c;

	/*
	 * �ۼ���:������ ��������:07/03/21:24 
	 */
	public AdminView() {
		setTitle("������â");
//		memberInf(); //ȸ������ �г� �޼ҵ�
		history(); //�������� �г� �޼ҵ�
		
		new Server();

		la_time = new JLabel();
			la_time.setBounds(980, 30, 200, 30);

		getContentPane().setLayout(null);
			getContentPane().add(la_time);
//			getContentPane().add(p_member);

			getContentPane().add(p_history);
			bt_cmtManage = new JButton("�ı����");
			bt_cmtManage.setBounds(1050, 563, 100, 30);
			bt_cmtManage.setBackground(Color.BLACK);
			bt_cmtManage.setForeground(Color.WHITE);
			getContentPane().add(bt_cmtManage);
			
			bt_postManage = new JButton("�Խù�����");
			bt_postManage.setBounds(1050, 521, 100, 30);
			bt_postManage.setBackground(Color.black);
			bt_postManage.setForeground(Color.white);
			getContentPane().add(bt_postManage);
			cb_menu = new JComboBox<>();
			cb_menu.setBounds(1050, 606, 100, 30);
			
			getContentPane().add(cb_menu);
			cb_menu.addItem("ȸ������");
			cb_menu.addItem("��������");
		Thread t = new Thread(this);
		t.start();
		setBounds(500, 100, 1200, 800);
		setVisible(true);
	}// ������

	public void memberInf() { //ȸ������ �г�
		p_member = new JPanel();
			p_member.setLayout(null);
			p_member.setBounds(0, 0, 1036, 753);
		la_memberInf = new JLabel("ȸ������");
			la_memberInf.setBounds(150, 58, 100, 30);
		bt_selectAll = new JButton("��ü��ȸ");
			bt_selectAll.setBounds(689, 651, 100, 30);
			bt_selectAll.setBackground(Color.BLACK);
			bt_selectAll.setForeground(Color.WHITE);
		bt_select = new JButton("������ȸ");
			bt_select.setBounds(803, 651, 100, 30);
			bt_select.setBackground(Color.BLACK);
			bt_select.setForeground(Color.white);
		bt_delete = new JButton("����");
			bt_delete.setBounds(917, 651, 80, 30);
			bt_delete.setBackground(Color.BLACK);
			bt_delete.setForeground(Color.WHITE);
		Object[] memberCol = { "���̵�", "����", "�̸�", "�������", "����ó", "�ּ�", "�̸���", "����Ʈ", "ĳ��", "ȸ�����" };
		dtm_member = new DefaultTableModel(memberCol, 32);
		t_memberInf = new JTable(dtm_member);
			t_memberInf.getTableHeader().setBackground(Color.LIGHT_GRAY); // ���̺� ��� ���� ����
			t_memberInf.getTableHeader().setReorderingAllowed(false); //���̺� �������� ����
			t_memberInf.getTableHeader().setResizingAllowed(false);  //���̺� ������ ���� ����
			t_memberInf.getColumnModel().getColumn(0).setPreferredWidth(50); // �ش��÷� �ʺ� ����			
			t_memberInf.getColumnModel().getColumn(1).setPreferredWidth(1); 	
			t_memberInf.getColumnModel().getColumn(2).setPreferredWidth(30);
			t_memberInf.getColumnModel().getColumn(3).setPreferredWidth(30);
			t_memberInf.getColumnModel().getColumn(4).setPreferredWidth(40);
			t_memberInf.getColumnModel().getColumn(7).setPreferredWidth(40);
			t_memberInf.getColumnModel().getColumn(8).setPreferredWidth(40);
			t_memberInf.getColumnModel().getColumn(9).setPreferredWidth(40);
		sp_member = new JScrollPane(t_memberInf);
			sp_member.setBounds(150, 100, 861, 537);
		p_member.add(la_memberInf);
		p_member.add(sp_member);
		p_member.add(bt_selectAll);
		p_member.add(bt_select);
		p_member.add(bt_delete);

		p_member.setVisible(true);
	}
 
	public void history() {// ��������(��������, ��������) �г�
		p_history = new JPanel();
			p_history.setLayout(null);
			p_history.setBounds(0, 0, 1036, 800);
			p_history.setBackground(Color.pink);
			p_history.setPreferredSize(new Dimension(500,500));
		la_profitInf = new JLabel("��������");
		la_profitInf.setFont(new Font("���� ���", Font.BOLD, 22));
			la_profitInf.setBounds(150, 82, 100, 30);
		la_payHistory = new JLabel("��������");
		la_payHistory.setFont(new Font("���� ���", Font.BOLD, 22));
			la_payHistory.setBounds(550, 82, 100, 30);
		la_totProfit = new JLabel("�Ѽ���:");
		la_totProfit.setFont(new Font("���� ���", Font.BOLD, 16));
			la_totProfit.setBounds(240, 675, 70, 30);
			
		bt_canclePay = new JButton("�������");
			bt_canclePay.setBounds(750, 675, 100, 30);
			bt_canclePay.setBackground(Color.black);
			bt_canclePay.setForeground(Color.white);			
		cb_month = new JComboBox<>();
			cb_month.setBounds(864, 126, 70, 30);
		for(int i=1;i<13;i++) {
				cb_month.addItem(i+"��");			
			}
		//<<------------------------------------------------------table	
		tf_totProfit = new JTextField("0000000��");
			tf_totProfit.setEditable(false);
			tf_totProfit.setBounds(300, 675, 150, 30);
			tf_totProfit.setBorder(new BevelBorder(0, Color.BLACK, Color.BLACK));
		tf_totProfit.setHorizontalAlignment(JTextField.RIGHT);
		


		Object[] payCol = { "���̵�", "������", "Ƽ���ڵ�" };
		Object[] proCol = { "���̵�", "�����ݾ�" };

		
		dtm_pay = new DefaultTableModel(proCol, 32);
		dtm_pro = new DefaultTableModel(payCol, 32);

		
		t_payHistory = new JTable(dtm_pay);
			t_payHistory.getTableHeader().setBackground(Color.LIGHT_GRAY);
		t_profitInf = new JTable(dtm_pro);
			t_profitInf.getTableHeader().setBackground(Color.LIGHT_GRAY);

		sp_pay = new JScrollPane(t_payHistory);
			sp_pay.setBounds(150, 124, 300, 537);
			sp_pay.setBorder(new BevelBorder(0, Color.BLACK, Color.BLACK));
		sp_pro = new JScrollPane(t_profitInf);
			sp_pro.setBounds(550, 124, 300, 537);
			sp_pro.setBorder(new BevelBorder(0, Color.BLACK, Color.BLACK));
		
		p_history.add(cb_month);
		p_history.add(la_payHistory);
		p_history.add(la_profitInf);
		p_history.add(la_totProfit);
		
		p_history.add(sp_pay);
		p_history.add(sp_pro);

		p_history.add(bt_canclePay);
		p_history.add(tf_totProfit);
		p_history.setVisible(true);
	}

	@Override
	public void run() {
		try {
			while (true) {
				c = Calendar.getInstance();

				String timeStr = c.get(Calendar.YEAR) + "�� " + (c.get(Calendar.MONTH) + 1) + "�� " + c.get(Calendar.DATE)
						+ "�� " + c.get(Calendar.HOUR_OF_DAY) + "�� " + c.get(Calendar.MINUTE) + "�� "
						+ c.get(Calendar.SECOND) + "��";
				la_time.setText(timeStr);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	 * �ۼ���:������ ��������:07/09/ 19:09 
	 * Server class
	 */
	public class Server implements Runnable{
		ArrayList<Service> clients;
		public Server() {
			clients = new ArrayList<>();
			
			new Thread(this).start();
		}//������
		@Override
		public void run() {
			try {
				ServerSocket socketserver = new ServerSocket(5000);
				System.out.println("Start Server......");
				while(true) {
					Socket socket = socketserver.accept();//client ���� ���
					Service client = new Service(socket, this);
					clients.add(client);
					System.out.println("Server> Client �߰�!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//Server
	
	/*
	 * �ۼ���:������ ��������:07/09/ 19:09 
	 * Server class
	 */
	public class Service extends Thread{
	//���ϰ��� ����¼���
		BufferedReader in;
		OutputStream out;
	//����
		Socket socket;
		
		public Service(Socket socket, Server server) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
				
				start();	//������ ����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//������
		@Override
			public void run() {
				try {
					while(true) {
						String msg = in.readLine();//Client�κ��� �޼��� �ޱ�
						if(msg == null) return;
						if(msg.trim().length()>0) {
							System.out.println("from Client> "+ msg +":"+
					                  socket.getInetAddress().getHostAddress());
						}
						String msgs[] = msg.split("\\|");
						String protocol = msgs[0];
						
						switch(protocol) {	//��űԾ࿡ ���� Client�κ��� �޼��� �ޱ�
						case "100":
							
							break;
						}//���� switch
					}//while(true)
				} catch (IOException e) {
					e.printStackTrace();
				}
			}//run
		public void sendMsg(String msg, char type) {
			try {
				out.write((type + msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//sendMsg
	}//Service
	
 	public void dispTable(ArrayList<Object[]> list,String table) { //table : "ȸ������" "��������" "��������"
		if(table.equals("ȸ������")) {
			dtm_member.setRowCount(0); // ��µ� ����Ʈ ���� 0���� ����!!
			for(int i=0; i < list.size();i++) {
				Object [] rowData = list.get(i);
				dtm_member.addRow(rowData);
			}
		}else if(table.equals("��������")){
			dtm_pro.setRowCount(0);
			for(int i=0; i < list.size();i++) {
				Object [] rowData = list.get(i);
				dtm_pro.addRow(rowData);
			}
		}else if(table.equals("��������")) {
			dtm_pay.setRowCount(0);
			for(int i=0; i < list.size();i++) {
				Object [] rowData = list.get(i);
				dtm_pay.addRow(rowData);
			}			
		}
	}
	public static void main(String[] args) {
		new AdminView();
	}


}
