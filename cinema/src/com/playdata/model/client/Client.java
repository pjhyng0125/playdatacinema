package com.playdata.model.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread {
	Socket socket;
	BufferedReader in;
	OutputStream out;
	
	String connect_flag;
	
	static final int PORT_NUM = 5000;
	
	public Client()  {
		connect();
		start();
		System.out.println("Client> ���� ����!");
	}
	
	
	public void connect() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			socket = new Socket(localHost.getHostAddress(), 5000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			String protocol;
			try {
				String msg = in.readLine();//Server�κ��� �޼��� �ޱ�
				if(msg == null) return;
				if(msg.trim().length()>0) {
					System.out.println("from Server> "+ msg +":"+
							socket.getInetAddress().getHostAddress());
				}
				String msgs[] = msg.split("\\|");
				protocol = msgs[0];
				switch(protocol){	//��űԾ࿡ ���� Server�κ��� �޼��� �ޱ�
				case "300": 
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//run
	
	public void sendMsg(String msg, char type) {
		try {
			out.write((type + msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//sendMsg
	
	public static void main(String[] args) {
		new Client();
	}
}
