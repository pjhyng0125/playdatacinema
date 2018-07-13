package com.playdata.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.playdata.model.vo.Reserve;

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
   
   public ArrayList<Reserve> selectAll() {//보류메소드
	      ArrayList<Reserve> list = new ArrayList<>();
	      try {
	         connect();
	         String sql;
	            sql = "select * from reserve";            
	         
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            Reserve r = new Reserve(
	            	rs.getString(1),
	            	rs.getString(2),
	            	rs.getString(3),
	            	rs.getString(4),
	            	rs.getString(5),
	            	rs.getInt(6),
	            	rs.getInt(7)
	            		);
	            list.add(r);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return list;
	   }
   
   /*
      작성자:박형진 수정일자:07/09/00:42 클래스(함수)기능: 예매확인 뷰 또는 관람내역 뷰 
     after가 true이면 관람한 내역, false이면 봐야할 영화 예매 내역
    */
   public ArrayList<Reserve> selectOwnHistory(String id, String date, boolean after) {//보류메소드
      ArrayList<Reserve> list = new ArrayList<>();
      try {
         connect();
         String sql;
         if(after) {
            sql = "select movie_name, run_date, person_cnt from reserve where id=? and run_date<?";            
         }else {
            sql = "select movie_name, run_date, person_cnt from reserve where id=? and run_date>=?";            
         }
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);
         pstmt.setString(2, date);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            Reserve r = new Reserve();
               r.setMovie_name(rs.getString("movie_name"));
               r.setRun_date(rs.getString("run_date"));
                r.setPerson_cnt(rs.getInt("person_cnt"));
            list.add(r);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      return list;
   }
   public ArrayList<Reserve> selectOwnHistory(String id) {//상영 시간이 필요한지 확인필요
	      ArrayList<Reserve> list = new ArrayList<>();
	      try {
	         connect();
	         String sql= "select movie_name, run_date, start_time, seatnum from reserve where id=? order by run_date asc,start_time asc";            
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            Reserve r = new Reserve();
	               r.setMovie_name(rs.getString("movie_name"));
	               r.setRun_date(rs.getString("run_date"));
	               r.setStart_time(rs.getString("start_time"));
	                r.setSeatnum(rs.getString("seatnum"));
	            list.add(r);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return list;
	   }
   
   /*
      작성자:박형진 수정일자:07/09/00:42
      클래스(함수)기능: 티켓 뷰에 보일 내용  
    */
   public ArrayList<Object> selectTiket(Reserve r) {
      ArrayList<Object> list = new ArrayList<>();
      try {
         connect();
         String sql="select name, screen_code, seatnum from reserve natural join member "
               + "where id=? and run_date=? and start_time=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, r.getId());
         pstmt.setString(2, r.getRun_date());
         pstmt.setString(3, r.getStart_time());
         rs = pstmt.executeQuery();
         if(rs.next()) {
            list.add(rs.getString("name"));
            r.setScreen_code(rs.getInt("screen_code"));
            r.setSeatnum(rs.getString("seatnum"));
            list.add(r);            
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      return list;
   }
   
   /*
      작성자:박형진 수정일자:07/09/00:42
      클래스(함수)기능: 스케쥴 뷰에 보일 내용 // start_time 받기  
    */
   public ArrayList<String> selectSchedule(String movie_name, String run_date) {
      ArrayList<String> list = new ArrayList<>();
      try {
         connect();
         String sql="select start_time from reserve where movie_name=? and run_date=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_name);
         pstmt.setString(2, run_date);
         rs = pstmt.executeQuery();
         while(rs.next()) {            
            list.add(rs.getString("start_time"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      return list;
   }
   
   /*
   작성자:박형진 수정일자:07/09/18:18
   클래스(함수)기능: 결제후 reserveTable에 insert  
 */
   public boolean insertReserve(Reserve r) {
	    try {
	         connect();
	         String sql = "insert into reserve values (?,?,?,?,?,?,?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, r.getId());
	         pstmt.setString(2, r.getMovie_name());
	         pstmt.setString(3, r.getRun_date());
	         pstmt.setString(4, r.getStart_time());
	         pstmt.setString(5, r.getSeatnum());
	         pstmt.setInt(6, r.getScreen_code());
	         pstmt.setInt(7,r.getPerson_cnt());
	         
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	   return false;
   }
   
   public boolean deleteReserve(String id, String start_time, String run_date) {
	   try {
	         connect();
	         String sql = "delete from reserve where id=? and start_time=? and run_date=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         pstmt.setString(2, start_time);
	         pstmt.setString(3, run_date);
	         
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	   return false;
   }
   public int selectAllCount() {
	   try {
	         connect();
	         String sql = "select count(*) from reserve where movie_name in (select movie_name from movie where onshow>0)";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	        	return rs.getInt(1); 
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	   return -1;
   }
   
   public int[] selectCount() {
	   int[] rateCount = new int[4];
	   try {
	         connect();
	         String sql = "select count(*) from reserve " + 
	         			  "where movie_name in (select movie_name from movie where onshow>0) group by movie_name order by screen_code asc";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         for(int i=0;rs.next();i++) {
	        	 rateCount[i]=rs.getInt(1);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	   return null;
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
/*
  try {
         connect();
         String sql="";
         pstmt = conn.prepareStatement(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disconnect();
      }
      
 */