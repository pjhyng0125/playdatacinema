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

   /*
    * 작성자:박형진 수정일자:07/05/00:42 클래스(함수)기능: ReserView _ 정확히는 ReserveSubView에 뿌릴 영화정보
    * 배열.
    */
   public ArrayList<Movie> movieSelectAll() {/* 이미지경로, 영화제목, 예매율, 장르 */
      ArrayList<Movie> movieList = new ArrayList<>();
      try {
         connect();
         String sql = "select path, movie_name, rate, genre,avg_star from movie order by rate desc";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while (rs.next()) {
            Movie m = new Movie(rs.getString("movie_name"), rs.getString("genre"), rs.getDouble("rate"),
                  rs.getInt("avg_star"), rs.getString("path"));
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
    * 작성자:박형진 수정일자:07/05/00:42 클래스(함수)기능: Review에 반영하는 메소드.
    */
   /* 이미지경로, 영화제목, 개봉일자, 감독명, 주연배우, 줄거리, 아이디, 후기 */
   public ArrayList<Object> reviewSelect(String path) {
      ArrayList<Object> list = new ArrayList<>();
      try {
         connect();
         String sql = "select movie_name, start_date, director, actors, summary,id,content,com_star"
               + "from movie natural join movie_comment where path = ? order by no asc";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, path);
         rs = pstmt.executeQuery();
         while (rs.next()) {
            Movie m = new Movie();
            m.setPath(path);
            m.setMovie_name(rs.getString("movie_name"));
            m.setStart_date(rs.getDate("start_date"));
            m.setDirector(rs.getString("director"));
            m.setActors(rs.getString("actors"));
            m.setSummary(rs.getString("summary"));
            Comment c = new Comment(rs.getString("id"), rs.getString("content"),
                  Integer.parseInt(rs.getString("com_star")));

            list.add(rs.getString("id")); // 인덱스2 : 후기 작성한 id
            list.add(rs.getString("content")); // 인덱스3 : 후기내용
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      return list;
   }

   /*
    * 작성자:박형진 수정일자:07/05/21:17 클래스(함수)기능: scheduleView에서 남은 좌석 보여주기 배열.
    */
   public int[] seatNumSelect(int screen_code) {
      int[] list = new int[8]; // 상영시간 갯수
      try {
         connect();
         String sql = "select count(*) as count from screen" + " group by start_time"
               + " having screen_code =? and flag='yes';";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, screen_code);
         rs = pstmt.executeQuery();
         for (int i = 0; rs.next(); i++) {
            list[i] = rs.getInt("count");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      return list;
   }

   /*
    * 작성자:박형진 수정일자:07/05/21:17 클래스(함수)기능: screenView 좌석보여주기(미완).
    */
   public ArrayList<SeatModel> screenSelect(int screen_code, String screen_time) {
      ArrayList<SeatModel> list = new ArrayList<>();  //좌석번호, 이용가능상태를 담기 위한 리스트
      
      try {
         connect();
         String sql = "select seatnum,flag from screen " + "where screen_code = ? and screen_time = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, screen_code);
         pstmt.setString(2, screen_time);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            SeatModel sm = new SeatModel();
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
    * 작성자:박형진 수정일자:07/05/21:17 클래스(함수)기능: screenView 영화이미지, 가격보여주기.
    */
   public Movie screenSelect(String movie_name) {
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
         if (conn != null)
            conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}