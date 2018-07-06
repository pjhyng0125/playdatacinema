package com.playdata.model;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class ScreenDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties pro;

	public ScreenDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	    * �ۼ���:������ ��������:07/05/21:17 Ŭ����(�Լ�)���: screenView �¼������ֱ�.
	    */
	   public ArrayList<Screen> selectScreen(int screen_code, String screen_time) {
	      ArrayList<Screen> list = new ArrayList<>();  //�¼���ȣ, �̿밡�ɻ��¸� ��� ���� ����Ʈ
	      
	      try {
	         connect();
	         String sql = "select seatnum,flag from screen " + "where screen_code = ? and screen_time = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, screen_code);
	         pstmt.setString(2, screen_time);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            Screen sm = new Screen();
	                  sm.setSeatnum(rs.getString("seatnum"));
	                  sm.setFlag(rs.getString("flag"));
	            list.add(sm);      
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return list;
	   }
	   /*
	    * �ۼ���:������ ��������:07/05/21:17 Ŭ����(�Լ�)���: screenView ��ȭ�̹���, ���ݺ����ֱ�.
	    */
	   public Movie selectScreen(String movie_name) {
	      Movie m = new Movie();
	      connect();
	      try {
	         connect();
	         String sql = "select path,price from movie"
	                  + " while movie_name = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, movie_name);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	               m.setPath(rs.getString("path"));
	               m.setPrice(rs.getInt("price"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return m;
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
	         if (conn != null)
	            conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
}
