package com.playdata.model.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.playdata.model.dao.CommentDAO;
import com.playdata.model.dao.MemberDAO;
import com.playdata.model.vo.Comment;
import com.playdata.model.vo.Member;



/*
 * 작성자:박진형 수정일자:07/09/ 19:09 
 * Server class
 */
public class Server implements Runnable{
	ArrayList<Service> clients;
	ServerSocket socketserver;
	public boolean serverrun;
	MemberDAO mem_dao;
	CommentDAO com_dao;
	
	static final String INSERTJOIN = "ij";
	static final String LOGIN = "li";
	static final String INSERTCOMMENT = "ic";
	static final String COMMENT = "co";
	
	
	public Server() {
		clients = new ArrayList<>();
		mem_dao = new MemberDAO();
		com_dao = new CommentDAO();
		new Thread(this).start();
	}//생성자
	@Override
	public void run() {
		try {
			socketserver = new ServerSocket(6000);
			System.out.println("Start Server......");
			while(serverrun) {
				Socket socket = socketserver.accept();//client 접속 대기
				Service client = new Service(socket, this);
				clients.add(client);
				System.out.println("Server> Client 추가!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void turnOn() {	//관리자 로그인 시
		new Server();
	}
	
	public void turnOff() {	//관리자 종료 시
		serverrun = false;
		try { 
			for(int i=0; i<clients.size(); i++) {				
				clients.get(i).sendMsg("end", "x");// 클라이언트들에게 서비스 종료 메세지를 보냄
				clients.get(i).in.close();
				clients.get(i).out.close();
				clients.get(i).socket.close();	//서비스 관련 스트림 끊기
			}
//		server.socketserver.close();	//서버 관련 스트림 끊기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public class Service extends Thread{
//소켓관련 입출력서비스
		
		public BufferedReader in;
		public OutputStream out;
//소켓
		public Socket socket;
		
		public Service(Socket socket, Server server) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
				
				start();	//스레드 시작
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//생성자
		@Override
		public void run() {
			try {
				while(serverrun) {
					String msg = in.readLine();//Client로부터 메세지 받기
					if(msg == null) return;
					if(msg.trim().length()>0) {
						System.out.println("from Client> "+ msg);
					}
					String msgs[] = msg.split("\\|");
					String protocol = msgs[0];
					String clientmsg = msgs[1];
					System.out.println(protocol);
					System.out.println(clientmsg);
					switch(protocol) {	//통신규약에 따라 Client로부터 메세지 받기
					case "h":
						System.out.println(clientmsg);
						break;
					case INSERTJOIN:	//서버로부터 회원가입 요청을 경우
						String ms[] = clientmsg.split("&");
//						for(int i=0; i<ms.length; i++)
//							System.out.println(ms[i]);
						Member m = new Member(
							ms[0], ms[1], ms[2], ms[3], ms[4],
							ms[5], ms[6], ms[7], Integer.parseInt(ms[8]), Integer.parseInt(ms[9]),
							Integer.parseInt(ms[10]), ms[11], ms[12]);
						if(mem_dao.join(m)) {
//							System.out.println("회원가입 성공");
							sendMsg("success", LOGIN);	//회원 가입 성공시 "li|success" 메세지 보냄
						}
						else {
							sendMsg("fail", LOGIN);  //회원 가입 실패시 "li|fail" 메세지 보냄
						}
						break;
					case INSERTCOMMENT:
						String ms_c[] = clientmsg.split("&");
						Comment c = new Comment(
							ms_c[0], ms_c[1], ms_c[2], Integer.parseInt(ms_c[3]));
							if(com_dao.insertComment(c)) {//comment 추가 성공시
								sendMsg("success", COMMENT);
							}else {	//comment 추가 실패시
								sendMsg("fail", COMMENT);								
							}
					}//서버 switch
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
 * 작성자:박진형 수정일자:07/09/ 19:09 
 * Server class
 */