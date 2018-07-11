package com.playdata.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.playdata.model.vo.Comment;
import com.playdata.model.vo.Movie;

public class CommentDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties pro;

	public CommentDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertComment(Comment c) {
	    try {
	         connect();
	         String sql = "insert into movie_comment (id,movie_name,no,com_star,content) values (?,?,com_seq.nextval,?,?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, c.getId());
	         pstmt.setString(2, c.getMovie_name());
	         pstmt.setInt(3, c.getStar());
	         pstmt.setString(4, c.getContent());
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	
	   /*
	    * 작성자:박형진 수정일자:07/05/00:42 클래스(함수)기능: Review에 반영하는 메소드.
	    */
	   /* 아이디, 후기 */
	   public ArrayList<Comment> selectReview(String movie_name) {
	      ArrayList<Comment> list = new ArrayList<>();
	      try {
	         connect();
	         String sql = "select id, com_star, content from movie_comment where movie_name = ? order by no asc";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, movie_name);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 Comment c = new Comment(rs.getString("id"),movie_name, rs.getString("content"),
	        	            Integer.parseInt(rs.getString("com_star")));
	        		
	        		list.add(c); // id, content, 개인평점
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return list;
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
