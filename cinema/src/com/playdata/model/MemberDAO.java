package com.playdata.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;


/*
 * 멤버DAO: 회원의 정보 - DB
 * 초기 작성자 : 이성훈
 * 일자 : 2018.07.04
 */
public class MemberDAO {

	Properties pro;
	Connection conn;
	PreparedStatement prestmt;
	ResultSet rs;
	Member m;
	Reserve reserve;
	
	ArrayList<Member> list;
	
	public MemberDAO() {
		list = new ArrayList<>();
		
		pro = new Properties();
		try {
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//생성자
	
	public void connection() {	
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"),pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}// connection()
	
	public void diss() {	
		try {
			if(rs!=null) rs.close();
			if(prestmt != null) prestmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}// diss()
	
	// 로그인 기능 
	public boolean login(String id, String pass) {		
		connection();
		String sql = "select id, pass from member where id=? and pass=?"; 
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, id);
			prestmt.setString(2, pass);
			rs=prestmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			diss();
		}	
		return false;
	}// login
	
	// 회원가입
	public boolean join(Member m) {	
		connection();						//id,pass,gender,name,birth,phone,addr,mail,point,cash,memgrade,hint,answer
		String sql = "insert into member value (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, m.getId());
			prestmt.setString(2, m.getPass());
			prestmt.setString(3, m.getGender());
			prestmt.setString(4, m.getName());
			prestmt.setDate(5,   m.getBirth());			
			prestmt.setString(6, m.getPhone());
			prestmt.setString(7, m.getAddr());
			prestmt.setString(8, m.getMail());
			prestmt.setInt(9, m.getPoint());
			prestmt.setInt(10, m.getCash());
			prestmt.setInt(11, m.getMem_grade());
			prestmt.setString(12, m.getHint());
			prestmt.setString(13, m.getAnswer());
			
			int t = prestmt.executeUpdate();
			
			if(t>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			diss();
		}
		return false;
	}// join()
	
	//회원가입창 - 중복확인기능
	public boolean duplicate(String id) {		
		connection();
		String sql="select id from emp where id=?";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, id);
			rs = prestmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			diss();
		}
		return false;
	}//duplicate()
	
	// 아이디찾기				이름			이메일
	public String idfind(String name, String email) {
		connection();
		String sql ="select id from member where name=? and email=?";
		String id;
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, name);
			prestmt.setString(2, email);
			rs = prestmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("id");
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			diss();
		}
		return "fail";				
	}// idfind()
	
	
	// 비밀번호 찾기				비밀번호 찾을  id, 힌트, 힌트 답
	public String passfind(String id, String hint, String answer) {	
		connection();
		String sql = "select pass from member where id=? and hint=? and answer=?";
		String pass;
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, id);
			prestmt.setString(2, hint);
			prestmt.setString(3, answer);
			rs = prestmt.executeQuery();
			
			if(rs.next()) {
				pass= rs.getString("pass");
				return pass;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			diss();
		}
		return "fail";
	}
	
	// 마이페이지창- 회원정보수정						
	public boolean updateMember(Member m) {
		connection();			//id,pass,gender,name,birth,phone,addr,mail,point,cash,memgrade,hint,answer
		String sql = "update member set pass=?, phone=?, addr=?, mail=?, hint=?,answer=?";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, m.getPass());
			prestmt.setString(2, m.getPhone());
			prestmt.setString(3, m.getAddr());
			prestmt.setString(4, m.getMail());
			prestmt.setString(5, m.getHint());
			prestmt.setString(6, m.getAnswer());
			int t = prestmt.executeUpdate();
			
			if(t>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			diss();
		}
		
		return false;
	}//updateMember
	
	//마이페이지 - 회원탈퇴
	public boolean deleteMember(String id) {
		connection();
		String sql="delete from member where id=?";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, id);
			int t= prestmt.executeUpdate();
			
			if(t>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			diss();
		}
		return false;
	}//deleteMember
	
	//마이페이지창- 예매 확인/취소
	public ArrayList<Reserve> moviecheck(String id) {
		connection();
		ArrayList<Reserve>list = new ArrayList<>();
		String sql = "select * from reserve where id=?";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, id);
			
			rs = prestmt.executeQuery();
			
			while(rs.next()) {
				String m_id = reserve.getId();
				String m_moviename = reserve.getMovie_name();
				String m_ticket_key = reserve.getTicket_key();
				Date m_run_date= reserve.getRun_date();
				String m_run_time = reserve.getRun_time();
				String m_seatnum = reserve.getSeatnum();
				String m_screencode = reserve.getScreen_code();
				
				Reserve send_reserve = new Reserve(m_id, m_moviename, m_ticket_key, m_run_date, m_run_time, m_seatnum, m_screencode);
				list.add(send_reserve);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			diss();
		}
		
		return list;		// list  안에 id, 영화 제목, 상영일자, 상영시간, 좌석번호  
		
	}
	
	//마이페이지창- 예매확인/취소창 - 취소버튼 클릭시 
	public boolean deleteMovie(String moive_name) {
		
		
		
		return false;
	}
}
