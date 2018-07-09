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
   
   /*
      �ۼ���:������ ��������:07/09/00:42 Ŭ����(�Լ�)���: ����Ȯ�� �� �Ǵ� �������� �� 
     after�� true�̸� ������ ����, false�̸� ������ ��ȭ ���� ����
    */
   public ArrayList<Reserve> selectOwnHistory(String id, String date, boolean after) {//�� �ð��� �ʿ����� Ȯ���ʿ�
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
   
   
   /*
      �ۼ���:������ ��������:07/09/00:42
      Ŭ����(�Լ�)���: Ƽ�� �信 ���� ����  
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
      �ۼ���:������ ��������:07/09/00:42
      Ŭ����(�Լ�)���: ������ �信 ���� ���� // start_time �ޱ�  
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