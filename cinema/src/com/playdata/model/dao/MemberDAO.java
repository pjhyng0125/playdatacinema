package com.playdata.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;

import com.playdata.model.vo.Member;
import com.playdata.model.vo.Reserve;

/*
 * ���DAO: ȸ���� ���� - DB
 * �ʱ� �ۼ��� : �̼���
 * ���� : 2018.07.04
 */
public class MemberDAO {

   Properties pro;
   Connection conn;
   PreparedStatement prestmt;
   ResultSet rs;
   Member m;
   Reserve reserve;

   ArrayList<Member> list;

   public MemberDAO() {
      list = new ArrayList<>();

      pro = new Properties();
      try {
         pro.load(new FileReader("conn/conn.properties"));
         Class.forName(pro.getProperty("driver"));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }// ������

   public void connection() {
      try {
         conn = DriverManager.getConnection(pro.getProperty("url"), pro);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      System.out.println("DB ���� ����!");
   }// connection()

   public void diss() {
      try {
         if (rs != null)
            rs.close();
         if (prestmt != null)
            prestmt.close();
         if (conn != null)
            conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }// diss()

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.04 ��ɼ��� : �α��� ���
    */
   public boolean login(String id, String pass) {
      connection();
      String sql = "select id, pass from member where id=? and pass=?";
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, id);
         prestmt.setString(2, pass);
         rs = prestmt.executeQuery();

         if (rs.next()) {
            return true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return false;
   }// login

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.04 ��ɼ��� : ȸ������â - ȸ������ ��ư Ŭ����
    */
   public boolean join(Member m) {
      connection(); // id,pass,gender,name,birth,phone,addr,email,point,cash,memgrade,hint,answer
      String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, m.getId());
         prestmt.setString(2, m.getPass());
         prestmt.setString(3, m.getGender());
         prestmt.setString(4, m.getName());
         prestmt.setString(5, m.getBirth());
         prestmt.setString(6, m.getPhone());
         prestmt.setString(7, m.getAddr());
         prestmt.setString(8, m.getEmail());
         prestmt.setInt(9, m.getPoint());
         prestmt.setInt(10, m.getCash());
         prestmt.setInt(11, m.getMem_grade());
         prestmt.setString(12, m.getHint());
         prestmt.setString(13, m.getAnswer());

         int t = prestmt.executeUpdate();

         if (t > 0) {
            return true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return false;
   }// join()

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.04 ��ɼ��� : ȸ������ â - ���̵� �ߺ�üũ ���
    */
   public boolean duplicate(String id) {
      connection();
      String sql = "select id from member where id=?";
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, id);
         rs = prestmt.executeQuery();

         if (rs.next()) {
            return true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return false;
   }// duplicate()

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.04 ��ɼ��� : �α��� ȭ�� - ���̵� ã��
    */ // �̸� �̸���
   public String idfind(String name, String email) {
      connection();
      String sql = "select id from member where name=? and email=?";
      String id;
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, name);
         prestmt.setString(2, email);
         rs = prestmt.executeQuery();

         if (rs.next()) {
            id = rs.getString("id");
            return id;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return null;
   }// idfind()

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.04 ��ɼ��� : �α��� ȭ�� - ��й�ȣ ã��
    */
   // ��й�ȣ ã�� id, ��Ʈ, ��Ʈ ��
   public String passfind(String id, String hint, String answer) {
      connection();
      String sql = "select pass from member where id=? and hint=? and answer=?";
      String pass;
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, id);
         prestmt.setString(2, hint);
         prestmt.setString(3, answer);
         rs = prestmt.executeQuery();

         if (rs.next()) {
            pass = rs.getString("pass");
            return pass;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return null;
   }

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.04 ��ɼ��� : ����������â - ȸ����������
    */
   public boolean updateMember(Member m) {
	   try {
	         connection();
	         String sql = "update member set pass=?,hint=?,answer=? where id=? ";
	         prestmt = conn.prepareStatement(sql);
	         prestmt.setString(1, m.getPass());
	         prestmt.setString(2, m.getHint());
	         prestmt.setString(3, m.getAnswer());
	         prestmt.setString(4, m.getId());
	         
	         int t = prestmt.executeUpdate();
	         if(t>0) return true;
	    } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         diss();
	      }
	    return false;
   }// updateMember

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.04 ��ɼ��� : ����������â - ȸ��Ż��
    */
   public boolean deleteMember2(String id) {
      connection();
      String sql = "delete from member where id=?";
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, id);
         int t = prestmt.executeUpdate();

         if (t > 0) {
            return true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return false;
   }// deleteMember
   /*
    * �ۼ��� : �̼��� �ۼ����� :07.04 ��ɼ��� : ����������â - ȸ��Ż��
    */
   public boolean deleteMember(String id) {
      connection();
      String sql1 = "delete from reserve where id=?";
      String sql2 = "delete from member where id=?";
      try {
         prestmt = conn.prepareStatement(sql1);
         prestmt.setString(1, id);
         int t = prestmt.executeUpdate();
         if (t > 0) {
        	 connection();
        	 prestmt = conn.prepareStatement(sql2);
        	 prestmt.setString(1, id);
        	 int j = prestmt.executeUpdate();
        	 if(j>0) {
        		 return true;
        	 }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return false;
   }// deleteMember

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.05 ��ɼ��� : ����������â - ���� Ȯ��/���
    */
   public ArrayList<Reserve> moviecheck(String id) {
      connection();
      ArrayList<Reserve> list = new ArrayList<>();
      String sql = "select * from reserve where id=?";
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, id);

         rs = prestmt.executeQuery();

         while (rs.next()) {
            String m_id = reserve.getId();
            String m_moviename = reserve.getMovie_name();
            String m_run_date = reserve.getRun_date();
            String m_run_time = reserve.getStart_time();
            String m_seatnum = reserve.getSeatnum();
            int m_screencode = reserve.getScreen_code();
            int m_person_cnt = reserve.getPerson_cnt();

            Reserve send_reserve = new Reserve(m_id, m_moviename, m_run_date, m_run_time, m_seatnum, m_screencode,m_person_cnt);
            list.add(send_reserve);

         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }

      return list; // list �ȿ� id, ��ȭ ����, ������, �󿵽ð�, �¼���ȣ

   }

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.05 ��ɼ��� : ����������â- ����Ȯ��/���â - ��ҹ�ư Ŭ���� 4�ܰ� ȯ��+���͹�ȯ+����
    */
   public boolean cancel(String id, String movie_name) {

	   int t = refund(id, movie_name);
      if (profit_minus(t,id)) {
         if (delete_reserve(id, movie_name)) {
            return true;
         }
      }

      return false;
   }

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.04 ��ɼ��� : ����������â - �������� - �ı� �ۼ� ��ư 
    */
   public boolean write_review(String id, String movie_name, int star, String comment) {
      connection();

      String sql = "insert into movie_comment values(?,?,?,?)";
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, id);
         prestmt.setString(2, movie_name);
         prestmt.setInt(3, star);
         prestmt.setString(4, comment);
         int t = prestmt.executeUpdate();

         if (t > 0) {
            return true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return false;
   }

   /*
    * �ۼ��� : �̼��� �ۼ����� :07.05 ��ɼ��� : ����Ʈ �߰� / ����
    */                     //   ���̵�      ����Ʈ      ��ȣ +,- �߰��� +, ������ -�� �Ķ���ͷ� �޾ƾ� �Ѵ�. 
   public boolean point_plma(String id, int point, String symbol) {
      connection();
      String sql1 = "select point from member where id=?";// ���� �ܾ�����Ʈ ��ȸ
      String sql2 = "update member set point=? where id=?"; // ������ ����Ʈ ������Ʈ

      try {
         prestmt = conn.prepareStatement(sql1);
         prestmt.setString(1, id);
         rs = prestmt.executeQuery();

         if (rs.next()) {
            int mypoint = rs.getInt(1);
            String result = mypoint+symbol+point;
            connection();
            prestmt = conn.prepareStatement(sql2);
            prestmt.setInt(1, Integer.parseInt(result));
            prestmt.setString(2, id);
            int t = prestmt.executeUpdate();

            if (t > 0) {
               return true;
            }

         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return false;
   }
   
   /*
    * �ۼ��� : �̼��� �ۼ����� :07.11 ��ɼ��� : ĳ�� �߰� ����
    */                  // ���̵�      ĳ��         +/- ��ȣ  +�� �߰� -�� ����
   public boolean cash_plma(String id, int cash, String symbol) {
      connection();
      String sql1 = "select cash from member where id=?";// ���� �ܾ�����Ʈ ��ȸ
      String sql2 = "update member set cash=? where id=?"; // ������ ����Ʈ ������Ʈ
      int result;
      try {
         prestmt = conn.prepareStatement(sql1);
         prestmt.setString(1, id);
         rs = prestmt.executeQuery();

         if (rs.next()) {
            int mycash = rs.getInt(1);
            if(symbol.equals("+")) {
               result = mycash+cash;
               profit_ck(cash, symbol);
            }else {
               result = mycash-cash;
               profit_ck(cash, symbol);
            }
            connection();
            prestmt = conn.prepareStatement(sql2);
            prestmt.setInt(1, result);
            prestmt.setString(2, id);
            int t = prestmt.executeUpdate();

            if (t > 0) {
               return true;
            }

         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return false;
   }
   /*
    * �ۼ��� : �̼��� �ۼ����� :07.06 ��ɼ��� : ȸ����ȸ
    */                  //       ���̵�      
   public Member select_member(String id) {
      connection();
      String sql = "select * from member where id=?";
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, id);
         rs=prestmt.executeQuery();
         if(rs.next()) {
            m= new Member(rs.getString("id"), rs.getString("pass"), rs.getString("gender"), rs.getString("name"), rs.getString("birth"),
                  rs.getString("phone"), rs.getString("addr"), rs.getString("email"), rs.getInt("point"), rs.getInt("cash"), 
                  rs.getInt("mem_grade"), rs.getString("hint"), rs.getString("answer"));
            
            return m;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return null;
   }
   
   public boolean updateCashPoint(String id, int cash,int point) {
	   	connection();
	      String sql = "update member set cash=cash+?, point=point+? where id=?";
	      try {
	         prestmt = conn.prepareStatement(sql);
	         prestmt.setInt(1, cash);
	         prestmt.setInt(2, point);
	         prestmt.setString(3, id);
	         int t = prestmt.executeUpdate();
	         if(t>0) return true;
	      }catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         diss();
	      }
	      return false;
   }
   
   public int selectCash(String id) {
		connection();
	      String sql = "select cash from member where id=?";
	      try {
	         prestmt = conn.prepareStatement(sql);
	         prestmt.setString(1, id);
	         rs = prestmt.executeQuery();
	         if(rs.next()) return rs.getInt("cash");
	      }catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         diss();
	      }
	      return -1;
   }
   
   
   // ************************************  ������ �ʿ� �����ϴ�        ***************************************  
   
   
   /*
    * ��Ʈ�ѷ��� 3�ܰ踦 ������ �ۼ��� : �̼��� �ۼ����� :07.05 ��ɼ��� : ����������â- ����Ȯ��/���â - ��ҹ�ư Ŭ���� 1�ܰ�
    * ȯ��
    */
   private int refund(String id, String movie_name) {
      connection();
      String sql1 = "select r.price from movie m, reserve r where r.movie_name= m.name and r.movie_name=?";// ȯ���� Ƽ�ϰ���
      String sql2 = "select cash from member where id=?"; // ȯ���� ��� �ܾ� ��ȸ
      String sql3 = "update member set cash=? where id=?"; // ȯ���� ��� �ܾ׿� Ƽ�ϰ��� �߰�
      

      try {
         prestmt = conn.prepareStatement(sql1);
         prestmt.setString(1, movie_name);
         rs = prestmt.executeQuery();

         if (rs.next()) {
            int refund = rs.getInt(1);
            connection();
            prestmt = conn.prepareStatement(sql2);
            prestmt.setString(1, id);
            rs = prestmt.executeQuery();

            if (rs.next()) {
               int cash = rs.getInt(1);
               connection();
               prestmt = conn.prepareStatement(sql3);
               prestmt.setInt(1, (cash + refund));
               prestmt.setString(2, id);

               int t = prestmt.executeUpdate();
               if (t > 0) {
                  return refund;
               }
            }

         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return 0;
   }
   
   /*
    * �ۼ��� : �̼��� �ۼ����� :07.09 ��ɼ��� : ����������â- ����Ȯ��/���â - ��ҹ�ư Ŭ���� 2�ܰ� ���͹�ȯ
    */
   private boolean profit_minus(int ticket_price,String id) {
	   connection();
	   String sql1 = "select profit from admin"; // profit ��ȸ
	   String sql2 = "update admin set profit=?"; // profit�� Ƽ�ϰ��� ����
	   try {
		prestmt = conn.prepareStatement(sql1);
		   rs = prestmt.executeQuery();
		   if(rs.next()) {
			   int new_profit = rs.getInt(1)-ticket_price;
			   connection();
			   prestmt = conn.prepareStatement(sql2);
			   prestmt.setInt(1, new_profit);
			   int t = prestmt.executeUpdate();
			   if(t>0) {
				   return true;
			   }
		   }
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		diss();
	}
	   return false;
   }

   /*
    * ��Ʈ�ѷ��� 3�ܰ踦 ������ �ۼ��� : �̼��� �ۼ����� :07.05 ��ɼ��� : ����������â- ����Ȯ��/���â - ��ҹ�ư Ŭ���� 3�ܰ�
    * ����
    */
   private boolean delete_reserve(String id, String movie_name) {
      connection();
      String sql = "delete from reserve where id=? and movie_name =?"; // ȯ���� ���� ����
      try {
         prestmt = conn.prepareStatement(sql);
         prestmt.setString(1, id);
         prestmt.setString(2, movie_name);
         int t = prestmt.executeUpdate();

         if (t > 0) {
            return true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         diss();
      }
      return false;
   }
   
   private void profit_ck(int ticket_price, String symbol) {
	   connection();
	   String sql1 = "select profit from admin"; // profit ��ȸ
	   String sql2 = "update admin set profit=?"; // profit�� Ƽ�ϰ��� ����
	   try {
		prestmt = conn.prepareStatement(sql1);
		   rs = prestmt.executeQuery();
		   if(rs.next()) {
			   int new_profit = rs.getInt(1);
			   if(symbol.equals("+")) {
				   new_profit = rs.getInt(1)+ticket_price;
			   }else {
				   new_profit = rs.getInt(1)-ticket_price;
			   }
			   connection();
			   prestmt = conn.prepareStatement(sql2);
			   prestmt.setInt(1, new_profit);
			   int t = prestmt.executeUpdate();
			 
		   }
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		diss();
	}
	  
   }
   
   public ArrayList<Member> selectAllMember() {
	   ArrayList<Member> list = new ArrayList<>();
	    try {
	         connection();
	         String sql = "select id,gender,name,birth,phone,addr"
	         		+ ", email,point,cash,mem_grade from member";
	         prestmt = conn.prepareStatement(sql);
	         rs = prestmt.executeQuery();
	         while (rs.next()) {
	        	 Member m = new Member();
	        	 	m.setId(rs.getString("id"));
	        	 	m.setGender(rs.getString("gender"));
	        	 	m.setName(rs.getString("name"));
	        	 	m.setBirth(rs.getString("birth"));
	        	 	m.setPhone(rs.getString("phone"));
	        	 	m.setAddr(rs.getString("addr"));
	        	 	m.setEmail(rs.getString("email"));
	        	 	m.setPoint(rs.getInt("point"));
	        	 	m.setCash(rs.getInt("cash"));
	        	 	m.setMem_grade(rs.getInt("mem_grade"));
	        	 list.add(m);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         diss();
	      }
	    return list;
   }

   
   
//   /*
//    * �ۼ��� : �̼��� �ۼ����� :07.05 ��ɼ��� : ����Ʈ ����
//    */
//   public boolean point_minus(String id, int point) {
//      connection();
//      String sql1 = "select point from member where id=?";// ���� �ܾ�����Ʈ ��ȸ
//      String sql2 = "update member set point=? where id=?"; // ������ ����Ʈ ������Ʈ
//
//      try {
//         prestmt = conn.prepareStatement(sql1);
//         prestmt.setString(1, id);
//         rs = prestmt.executeQuery();
//
//         if (rs.next()) {
//            int mypoint = rs.getInt(1);
//            prestmt = conn.prepareStatement(sql2);
//            prestmt.setInt(1, (mypoint - point));
//            prestmt.setString(2, id);
//            int t = prestmt.executeUpdate();
//
//            if (t > 0) {
//               return true;
//            }
//
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      } finally {
//         diss();
//      }
//      return false;
//   }


//
//   /*
//    * �ۼ��� : �̼��� �ۼ����� :07.05 ��ɼ��� : ĳ�� ����
//    */
//   public boolean cash_minus(String id, int cash) {
//      connection();
//      String sql1 = "select cash from member where id=?";// ���� �ܾ�����Ʈ ��ȸ
//      String sql2 = "update member set cash=? where id=?"; // ������ ����Ʈ ������Ʈ
//
//      try {
//         prestmt = conn.prepareStatement(sql1);
//         prestmt.setString(1, id);
//         rs = prestmt.executeQuery();
//
//         if (rs.next()) {
//            int mycash = rs.getInt(1);
//            prestmt = conn.prepareStatement(sql2);
//            prestmt.setInt(1, (mycash - cash));
//            prestmt.setString(2, id);
//            int t = prestmt.executeUpdate();
//
//            if (t > 0) {
//               return true;
//            }
//
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      } finally {
//         diss();
//      }
//      return false;
//   }
   // �ı� �ۼ� ����2 - ����
   // public boolean write_review(String id, String movie_name, int star, String
   // comment) {
   // connection();
   // String sql = "select count(*) from movie_comment where id=? and
   // movie_name=?";
   // String sql2 = "insert into movie_comment values(?,?,?,?)";
   // try {
   //
   // prestmt = conn.prepareStatement(sql);
   // prestmt.setString(1, id);
   // prestmt.setString(2, movie_name);
   // rs= prestmt.executeQuery();
   // rs.next();
   // int j = rs.getInt(1);
   //
   // if (!(j > 0)) {
   //
   // prestmt = conn.prepareStatement(sql2);
   // prestmt.setString(1, id);
   // prestmt.setString(2, movie_name);
   // prestmt.setInt(3, star);
   // prestmt.setString(4, comment);
   // int t = prestmt.executeUpdate();
   //
   // if (t > 0) {
   // return true;
   // }
   // }
   // } catch (SQLException e) {
   // e.printStackTrace();
   // } finally {
   // diss();
   // }
   // return false;
   // }

}