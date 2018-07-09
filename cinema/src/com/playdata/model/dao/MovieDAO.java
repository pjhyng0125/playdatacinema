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
    */
   public ArrayList<Movie> selectAllMovie() {/* 이미지경로, 영화제목, 예매율, 장르 */
      ArrayList<Movie> movieList = new ArrayList<>();
      try {
         connect();
         String sql = "select path, movie_name, rate, genre,avg_star from movie "
                  + "where onshow > 0 order by rate desc";
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
    * 작성자:박형진 수정일자:07/06/21:18 클래스(함수)기능: 영화추가하기, 관리자 기능.
    */
   public boolean insertMovie(Movie m) {
         try {
            connect();
            String sql = "insert into movie "
                  + "values (?,?,?,?,?,0,0,?,?,?,?,?,?,0)";//14개의 ? / 6번째 0: 예매율, 7번째 0 : 평점 14번째 0: onShow 미상영중
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getMovie_name());
            pstmt.setString(2, m.getDirector());
            pstmt.setString(3, m.getActors());
            pstmt.setString(4, m.getSummary());
            pstmt.setString(5, m.getGenre());
            pstmt.setInt(6, m.getLimit());
            pstmt.setInt(7, m.getPrice());
            pstmt.setString(8, m.getPath());
            pstmt.setString(9, m.getStart_date());
            pstmt.setString(10, m.getRun_date());
            pstmt.setInt(11, m.getRun_time());
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
    * 작성자:박형진 수정일자:07/06/21:34 클래스(함수)기능: 영화 상영중인 경우를 수정하기
    *                                 영화이름과 flag를 받아 
    *                               flag가 true이면  해당영화를 상영중으로 onshow
    *                               flag가 false이면 해당영화를 미상영중으로
    */
   public boolean updateMovie(String movie_name,boolean flag) {
      String sql;
      try {
            connect();
            if(flag) {
               sql = "update movie set onshow=1 where movie_name=?";               
            }else {
               sql = "update movie set onshow=0 where movie_name=?";               
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movie_name);
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
    * 작성자:박형진 수정일자:07/06/21:41 클래스(함수)기능: 영화이름을 받아 삭제하기
    */
   public boolean deleteMovie(String movie_name) {
       try {
            connect();
            String sql = "delete from movie where movie_name=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movie_name);
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
   /* 이미지경로, 영화제목, 개봉일자, 감독명, 주연배우, 줄거리, 아이디, 후기 */
   public ArrayList<Object> selectReview(String movie_name) {
      ArrayList<Object> list = new ArrayList<>();
      try {
         connect();
         String sql = "select path, start_date, director, actors, summary,id,content,com_star"
               + "from movie natural join movie_comment where movie_name = ? order by no asc";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_name);
         rs = pstmt.executeQuery();
         while (rs.next()) {
            Movie m = new Movie();
               m.setMovie_name(movie_name);
               m.setPath(rs.getString("path"));
               m.setStart_date(rs.getString("start_date"));
               m.setDirector(rs.getString("director"));
               m.setActors(rs.getString("actors"));
               m.setSummary(rs.getString("summary"));
            Comment c = new Comment(rs.getString("id"), rs.getString("content"),
                  Integer.parseInt(rs.getString("com_star")));

            list.add(m); // 영화에 관한것
            list.add(c); // id, content, 개인평점
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      return list;
   }

   public int selectSchedule(String movie_name) {
      try {
         connect();
         String sql="select onshow from movie where moviename=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_name);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            return rs.getInt("onshow");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      return -1;
   }

   /*
    * 작성자:박형진 수정일자:07/05/21:17 클래스(함수)기능: screenView 영화이미지, 가격보여주기.
    */
   public Movie selectScreen(String movie_name) {
      Movie m = new Movie();
      connect();
      try {
         connect();
         String sql = "select path,limit,price from movie"
                  + " while movie_name = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_name);
         rs = pstmt.executeQuery();
         if(rs.next()) {
               m.setPath(rs.getString("path"));
               m.setLimit(rs.getInt("limit"));
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