package com.playdata.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

/*
 * 멤버DAO: 회원의 정보 - DB
 */
public class MemberDAO {

	Properties pro;
	Connection conn;
	PreparedStatement prestmt;
	ResultSet rs;
	
	Vector<Member> m;
	
	public MemberDAO() {
		m = new Vector<>();
		
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
	}
	
	public void connection() {	
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"),pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void diss() {	
		try {
			if(rs!=null) rs.close();
			if(prestmt != null) prestmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public boolean login(String id, String pass) {		// 로그인 기능
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
	}
	
	public void join() {		// 회원가입
		
	}
	
}
