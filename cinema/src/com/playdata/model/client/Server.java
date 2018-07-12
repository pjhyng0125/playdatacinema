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
import com.playdata.model.dao.MovieDAO;
import com.playdata.model.dao.ReserveDAO;
import com.playdata.model.vo.Comment;
import com.playdata.model.vo.Member;
import com.playdata.model.vo.Reserve;



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
	ReserveDAO res_dao;
	MovieDAO mov_dao;
//회원가입 추가
	static final String INSERTJOIN = "ij";
	static final String JOIN = "jo";
//후기 추가
	static final String INSERTCOMMENT = "ic";
	static final String COMMENT = "co";
//예약 삭제
	static final String RESERVECANCEL = "dr";
	static final String RESERVE = "re";
//회원 삭제
	static final String MEMBERDELETE = "dm";
	static final String MEMBER="me";
//회원 포인트 추가
	static final String CASHUPDATE = "uc";
	static final String CASH = "ca";
//영화 평점 갱신
	static final String STARUPDATE = "us";
	static final String STAR = "st";
//클라이언트 종료 메세지 (받을 예정)
	static final String CLIENTEXIT = "ce";
//서버 종료 메세지 (보낼 예정)
	static final String SERVEREXIT = "se"; 
	
	public Server() {
		clients = new ArrayList<>();
		mem_dao = new MemberDAO();
		com_dao = new CommentDAO();
		res_dao = new ReserveDAO();
		mov_dao = new MovieDAO();
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
						Member m = new Member(
							ms[0], ms[1], ms[2], ms[3], ms[4],
							ms[5], ms[6], ms[7], Integer.parseInt(ms[8]), Integer.parseInt(ms[9]),
							Integer.parseInt(ms[10]), ms[11], ms[12]);
						if(mem_dao.join(m))
							sendMsg("success", JOIN);	//회원 가입 성공시 "li|success" 메세지 보냄
						else
							sendMsg("fail", JOIN);  //회원 가입 실패시 "li|fail" 메세지 보냄
						break;
					case INSERTCOMMENT:
						String ms_c[] = clientmsg.split("&");
						Comment c = new Comment(
							ms_c[0], ms_c[1], ms_c[2], Integer.parseInt(ms_c[3]));
							if(com_dao.insertComment(c)) {//comment 추가 성공시
								sendMsg("success", COMMENT);	// co|success
							}else {	//comment 추가 실패시
								sendMsg("fail", COMMENT);	//co|fail			
							}
							break;
					case RESERVECANCEL:
						String ms_r[] = clientmsg.split("&");
						if(res_dao.deleteReserve(ms_r[0], ms_r[1], ms_r[2]))
							sendMsg("success", RESERVE);
						else
							sendMsg("fail", RESERVE);
						break;
					case MEMBERDELETE:
						String ms_m =  clientmsg;
						if(mem_dao.deleteMember(ms_m))
							sendMsg("success", MEMBER);
						else
							sendMsg("fail", MEMBER);
						break;
					case CASHUPDATE:
						String ms_ca[] = clientmsg.split("&");
if(mem_dao.updateCashPoint(ms_ca[0], Integer.parseInt(ms_ca[1]), Integer.parseInt(ms_ca[2])))
							sendMsg("success", CASH);
						else
							sendMsg("fail", CASH);
						break;
					case STARUPDATE:
				String []ms_s = clientmsg.split("&");
						if(mov_dao.updateMovieAvgStar(ms_s[0], Integer.parseInt(ms_s[1])))
							sendMsg("success", STAR);
						else
							sendMsg("fail", STAR);
					break;
					case CLIENTEXIT:	//ce|exit
						if(clientmsg.equals("exit")) {
							System.out.println("클라이언트 접속 종료 요청");
							clients.remove(this);	//벡터에서 삭제 ---> 클라이언트에서는 메세지 보내고 close()해주면 될 듯
						}	//관리자 창 꺼질 때는 server.clients의 모든 요소에 종료 메세지 보낸 후 turnOff();
							//AdminView 생성자에서 WindowListener();
					break;
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