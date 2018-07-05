package com.playdata.model;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/*
 * ����DAO: ��ȭ�� ���� - DB
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
   
   /*
   �ۼ���:������
   ��������:07/05/00:42
   Ŭ����(�Լ�)���: ReserView _ ��Ȯ���� ReserveSubView�� �Ѹ� ��ȭ���� �迭.
   */
   public ArrayList<Movie> movieSelectAll() {/*�̹������, ��ȭ����, ������, �帣*/
      ArrayList<Movie> movieList = new ArrayList<>();
      try {
         connect();
         String sql = "select path, movie_name, rate, genre from movie order by rate desc";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            Movie m = new Movie();
                 m.setPath(rs.getString("path"));
                 m.setPath(rs.getString("movie_name"));
                 m.setRate(rs.getDouble("rate"));
                 m.setGenre(rs.getString("genre"));
            movieList.add(m);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();         
      }
      return movieList;
   }
   
   /*
   �ۼ���:������
   ��������:07/05/00:42
   Ŭ����(�Լ�)���: Review�� �ݿ��ϴ� �޼ҵ�.
   */
   /*�̹������, ��ȭ����, ��������, ������, �ֿ����, �ٰŸ�, ���̵�, �ı�*/
   public ArrayList<Object> reviewSelect(String path) {
      ArrayList<Object> list = new ArrayList<>();
      try {
         connect();
         String sql="select movie_name, start_date, director, actors, summary,id,content"
                  + "from movie natural join movie_comment where path = ? order by no asc";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, path);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            Movie m = new Movie();
                 m.setName(rs.getString("movie_name"));
                 m.setStart_date(rs.getDate("start_date"));
                 m.setDirector(rs.getString("director"));
                 m.setActors(rs.getString("actors"));
                 m.setSummary(rs.getString("summary"));
            list.add(path); // �ε���0 : �̹������
            list.add(m); // �ε���1 : movie ����
            list.add(rs.getString("id")); // �ε���2 : �ı� �ۼ��� id
            list.add(rs.getString("content")); // �ε���3 : �ı⳻��
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      return list;
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