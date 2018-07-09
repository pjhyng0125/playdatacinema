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
    * �ۼ���:������ ��������:07/05/00:42 Ŭ����(�Լ�)���: ReserView _ ��Ȯ���� ReserveSubView�� �Ѹ� ��ȭ����
    */
   public ArrayList<Movie> selectAllMovie() {/* �̹������, ��ȭ����, ������, �帣 */
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
    * �ۼ���:������ ��������:07/06/21:18 Ŭ����(�Լ�)���: ��ȭ�߰��ϱ�, ������ ���.
    */
   public boolean insertMovie(Movie m) {
         try {
            connect();
            String sql = "insert into movie "
                  + "values (?,?,?,?,?,0,0,?,?,?,?,?,?,0)";//14���� ? / 6��° 0: ������, 7��° 0 : ���� 14��° 0: onShow �̻���
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
    * �ۼ���:������ ��������:07/06/21:34 Ŭ����(�Լ�)���: ��ȭ ������ ��츦 �����ϱ�
    *                                 ��ȭ�̸��� flag�� �޾� 
    *                               flag�� true�̸�  �ش翵ȭ�� �������� onshow
    *                               flag�� false�̸� �ش翵ȭ�� �̻�������
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
    * �ۼ���:������ ��������:07/06/21:41 Ŭ����(�Լ�)���: ��ȭ�̸��� �޾� �����ϱ�
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
    * �ۼ���:������ ��������:07/05/00:42 Ŭ����(�Լ�)���: Review�� �ݿ��ϴ� �޼ҵ�.
    */
   /* �̹������, ��ȭ����, ��������, ������, �ֿ����, �ٰŸ�, ���̵�, �ı� */
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

            list.add(m); // ��ȭ�� ���Ѱ�
            list.add(c); // id, content, ��������
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
    * �ۼ���:������ ��������:07/05/21:17 Ŭ����(�Լ�)���: screenView ��ȭ�̹���, ���ݺ����ֱ�.
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