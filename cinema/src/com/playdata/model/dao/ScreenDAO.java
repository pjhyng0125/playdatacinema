package com.playdata.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.playdata.model.vo.Movie;
import com.playdata.model.vo.Screen;

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
       * 작성자:박형진 수정일자:07/05/21:17 클래스(함수)기능: screenView 좌석보여주기.
       */
      public ArrayList<String> selectScreen(int screen_code, String start_time) {
         ArrayList<String> list = new ArrayList<>();  //좌석번호, 이용가능상태를 담기 위한 리스트
         
         try {
            connect();
            String sql = "select seatnum from screen " 
                     + "where screen_code = ? and start_time = ? and flag=0";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, screen_code);
            pstmt.setString(2, start_time);
            rs = pstmt.executeQuery();
            while(rs.next()) {
               list.add(rs.getString("seatnum"));      
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
      public String[] selectSchedule(int screen_code,String run_date) {
         String[] list = new String[4]; // 상영시간 갯수
         try {
            connect();
            System.out.println("상영날짜"+run_date);
            System.out.println("상영관코드"+screen_code);
            String sql = "select start_time, case when flag=1 and count(*)=5 then 0 " + 
            									" when flag=0 then count(*) end " + 
            									"from screen " + 
            									"where screen_code =?" + 
            									" and run_date=?" + 
            									" group by start_time,flag order by start_time asc";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, screen_code);
            pstmt.setString(2, run_date);
            rs = pstmt.executeQuery();
            int i=0;
            while(rs.next()) {
                list[i] = rs.getString("start_time")+","+rs.getInt(2);
                i++;
            }
               // 예: 18시30분 11석 >> 18:30,11
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disconnect();
         }
         return list;
      }
      
      
      /*
      작성자:박형진 수정일자:07/09/18:18
      클래스(함수)기능: 결제후 screenFlag 변경  
    */
   public boolean updateSeatFlag(Screen s) {
	    try {
	         connect();
	         String sql = "update screen set flag=1 where screen_code=? and start_time=? and seatnum=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, s.getScreen_code());
	         pstmt.setString(2, s.getStart_time());
	         pstmt.setString(3, s.getSeatnum());
	         
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
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