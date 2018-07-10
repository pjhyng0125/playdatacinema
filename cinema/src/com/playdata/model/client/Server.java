package com.playdata.model.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.playdata.model.dao.MemberDAO;
import com.playdata.model.vo.Member;



/*
 * �ۼ���:������ ��������:07/09/ 19:09 
 * Server class
 */
public class Server implements Runnable{
	ArrayList<Service> clients;
	ServerSocket socketserver;
	public boolean serverrun;
	MemberDAO mem_dao;
	
	public Server() {
		clients = new ArrayList<>();
		mem_dao = new MemberDAO();
		new Thread(this).start();
	}//������
	@Override
	public void run() {
		try {
			socketserver = new ServerSocket(5000);
			System.out.println("Start Server......");
			while(serverrun) {
				Socket socket = socketserver.accept();//client ���� ���
				Service client = new Service(socket, this);
				clients.add(client);
				System.out.println("Server> Client �߰�!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void turnOn() {	//������ �α��� ��
		new Server();
	}
	
	public void turnOff() {	//������ ���� ��
		serverrun = false;
		try { 
			for(int i=0; i<clients.size(); i++) {				
				clients.get(i).sendMsg("end", "x");// Ŭ���̾�Ʈ�鿡�� ���� ���� �޼����� ����
				clients.get(i).in.close();
				clients.get(i).out.close();
				clients.get(i).socket.close();	//���� ���� ��Ʈ�� ����
			}
//		server.socketserver.close();	//���� ���� ��Ʈ�� ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public class Service extends Thread{
//���ϰ��� ����¼���
		
		public BufferedReader in;
		public OutputStream out;
//����
		public Socket socket;
		
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
				while(serverrun) {
					String msg = in.readLine();//Client�κ��� �޼��� �ޱ�
					if(msg == null) return;
					if(msg.trim().length()>0) {
						System.out.println("from Client> "+ msg +":"+
								socket.getInetAddress().getHostAddress());
					}
					String msgs[] = msg.split("\\|");
					String protocol = msgs[0];
					String clientmsg = msgs[1];
					
					switch(protocol) {	//��űԾ࿡ ���� Client�κ��� �޼��� �ޱ�
					case "h":
						System.out.println(clientmsg);
						break;
					case "ij":
						String ms[] = clientmsg.split("&");
						Member m = new Member(
							ms[0], ms[1], ms[2], ms[3], ms[4],
							ms[5], ms[6], ms[7], Integer.parseInt(ms[8]), Integer.parseInt(ms[9]),
							Integer.parseInt(ms[10]), ms[11], ms[12]
								);
						if(mem_dao.join(m)) {
							System.out.println("ȸ������ ����");
						}
					}//���� switch
				}//while(true)
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//run
		public void sendMsg(String msg, String type) {
			try {
				out.write((type +"|"+ msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//sendMsg
	}//Service
}//Server


/*
 * �ۼ���:������ ��������:07/09/ 19:09 
 * Server class
 */