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
       * �ۼ���:������ ��������:07/05/21:17 Ŭ����(�Լ�)���: screenView �¼������ֱ�.
       */
      public ArrayList<String> selectScreen(int screen_code, String start_time) {
         ArrayList<String> list = new ArrayList<>();  //�¼���ȣ, �̿밡�ɻ��¸� ��� ���� ����Ʈ
         
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
       * �ۼ���:������ ��������:07/05/21:17 Ŭ����(�Լ�)���: scheduleView���� ���� �¼� �����ֱ� �迭.
       */
      public String[] selectSchedule(int screen_code) {
         String[] list = new String[4]; // �󿵽ð� ����
         try {
            connect();
            String sql = "select count(*),start_time as count from screen" + " group by start_time"
                  + " having screen_code =? and flag=0";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, screen_code);
            rs = pstmt.executeQuery();
            for (int i = 0; rs.next(); i++) {
               list[i] = rs.getString("start_time")+"|"+rs.getInt("count");
               // ��: 7��10�� 11�� >> 710|11
            }

         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disconnect();
         }
         return list;
      }
      
      
      /*
      �ۼ���:������ ��������:07/09/18:18
      Ŭ����(�Լ�)���: ������ screenFlag ����  
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