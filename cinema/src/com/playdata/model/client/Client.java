package com.playdata.model.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread {
	public Socket socket;
	public BufferedReader in;
	public OutputStream out;
	
	boolean clientrun;
	
	static final int PORT_NUM = 5000;
	
	public Client()  {
		connect();
		System.out.println("Client> ���� ����!");
		clientrun = true;
		start();
		System.out.println("Client> �޼��� ���� �غ� ��!");
	}
	
	
	public void connect() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			socket = new Socket(localHost.getHostAddress(), 5000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			sendMsg("hello", 'h');
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(clientrun) {
			try {
				String msg = in.readLine();//Server�κ��� �޼��� �ޱ�
				if(msg == null) return;
				if(msg.trim().length()>0) {
					System.out.println("from Server> "+ msg +":"+
							socket.getInetAddress().getHostAddress());
				}
				String msgs[] = msg.split("\\|");
				String protocol = msgs[0];
				String servermsg = msgs[1];
				
				switch(protocol){	//��űԾ࿡ ���� Server�κ��� �޼��� �ޱ�
				case "x":
					System.out.println(servermsg);
					clientrun = false;
					in.close();
					out.close();
					socket.close();
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//run
	
	public void sendMsg(String msg, char type) {
		try {
			out.write((type + "|" + msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//sendMsg
	
	/*
	 * �ۼ���: ������
	 * ��������: 07/01 12:34
	 * �̺�Ʈ������ ���: Client class => Server On/Off
	 */
	public void turnOn() {
		new Client();	//Ŭ���̾�Ʈ�� �α��� ������ ��ü ������ ��
		sendMsg("", 'o');//������ login ���� �޼����� ������
	}
	
	public void turnOff() {
		try {
			sendMsg("", 'x');	//Ŭ���̾�Ʈ�� ������ ������ �� ������ logout �޼��� ������
			in.close();			//���� ����
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
