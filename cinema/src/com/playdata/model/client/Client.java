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
		System.out.println("Client> 연결 성공!");
		clientrun = true;
		start();
		System.out.println("Client> 메세지 받을 준비 끝!");
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
				String msg = in.readLine();//Server로부터 메세지 받기
				if(msg == null) return;
				if(msg.trim().length()>0) {
					System.out.println("from Server> "+ msg +":"+
							socket.getInetAddress().getHostAddress());
				}
				String msgs[] = msg.split("\\|");
				String protocol = msgs[0];
				String servermsg = msgs[1];
				
				switch(protocol){	//통신규약에 따라 Server로부터 메세지 받기
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
	 * 작성자: 박진형
	 * 수정일자: 07/01 12:34
	 * 이벤트리스너 기능: Client class => Server On/Off
	 */
	public void turnOn() {
		new Client();	//클라이언트가 로그인 성공시 객체 생성한 후
		sendMsg("", 'o');//서버에 login 성공 메세지를 보낸다
	}
	
	public void turnOff() {
		try {
			sendMsg("", 'x');	//클라이언트가 접속을 끊었을 때 서버에 logout 메세지 보내고
			in.close();			//접속 종료
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
