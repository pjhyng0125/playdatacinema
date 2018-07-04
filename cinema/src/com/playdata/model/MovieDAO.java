package com.playdata.model;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/*
 * 무비DAO: 영화의 정보 - DB
 */
public class MovieDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties pro;
	
	public MovieDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void movieSelectAll() {//배열로 파라미터 받기
		connect();
		
		
		
	}
	public void insert() {
		
	}
	public void update() {
		
	}
	public void delete() {
		
	}
	
	private void connect() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void disconnect() {
		try {
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
