package com.playdata.model;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ReserveDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties pro;

	public ReserveDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
