package com.playdata.model;

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

/*
 * 멤버DAO: 회원의 정보 - DB
 * 초기 작성자 : 이성훈
 * 일자 : 2018.07.04
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
	}// 생성자

	public void connection() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	 * 작성자 : 이성훈 작성일자 :07.04 기능설명 : 로그인 기능
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
	 * 작성자 : 이성훈 작성일자 :07.04 기능설명 : 회원가입창 - 회원가입 버튼 클릭시
	 */
	public boolean join(Member m) {
		connection(); // id,pass,gender,name,birth,phone,addr,mail,point,cash,memgrade,hint,answer
		String sql = "insert into member value (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, m.getId());
			prestmt.setString(2, m.getPass());
			prestmt.setString(3, m.getGender());
			prestmt.setString(4, m.getName());
			prestmt.setDate(5, m.getBirth());
			prestmt.setString(6, m.getPhone());
			prestmt.setString(7, m.getAddr());
			prestmt.setString(8, m.getMail());
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
	 * 작성자 : 이성훈 작성일자 :07.04 기능설명 : 회원가입 창 - 아이디 중복체크 기능
	 */
	public boolean duplicate(String id) {
		connection();
		String sql = "select id from emp where id=?";
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
	 * 작성자 : 이성훈 작성일자 :07.04 기능설명 : 로그인 화면 - 아이디 찾기
	 */ // 이름 이메일
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
		return "fail";
	}// idfind()

	/*
	 * 작성자 : 이성훈 작성일자 :07.04 기능설명 : 로그인 화면 - 비밀번호 찾기
	 */
	// 비밀번호 찾을 id, 힌트, 힌트 답
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
		return "fail";
	}

	/*
	 * 작성자 : 이성훈 작성일자 :07.04 기능설명 : 마이페이지창 - 회원정보수정
	 */
	public boolean updateMember(Member m) {
		connection(); // id,pass,gender,name,birth,phone,addr,mail,point,cash,memgrade,hint,answer
		String sql = "update member set pass=?, phone=?, addr=?, mail=?, hint=?,answer=?";
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, m.getPass());
			prestmt.setString(2, m.getPhone());
			prestmt.setString(3, m.getAddr());
			prestmt.setString(4, m.getMail());
			prestmt.setString(5, m.getHint());
			prestmt.setString(6, m.getAnswer());
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
	}// updateMember

	/*
	 * 작성자 : 이성훈 작성일자 :07.04 기능설명 : 마이페이지창 - 회원탈퇴
	 */
	public boolean deleteMember(String id) {
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
	 * 작성자 : 이성훈 작성일자 :07.05 기능설명 : 마이페이지창 - 예매 확인/취소
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
				Date m_run_date = reserve.getRun_date();
				String m_run_time = reserve.getRun_time();
				String m_seatnum = reserve.getSeatnum();
				String m_screencode = reserve.getScreen_code();

				Reserve send_reserve = new Reserve(m_id, m_moviename, m_run_date, m_run_time, m_seatnum, m_screencode);
				list.add(send_reserve);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			diss();
		}

		return list; // list 안에 id, 영화 제목, 상영일자, 상영시간, 좌석번호

	}

	/*
	 * 컨트롤러는 3단계를 쓰세요 작성자 : 이성훈 작성일자 :07.05 기능설명 : 마이페이지창- 예매확인/취소창 - 취소버튼 클릭시 1단계
	 * 환불
	 */
	private boolean refund(String id, String movie_name) {
		connection();
		String sql1 = "select r.price from movie m, reserve r where r.movie_name= m.name and r.movie_name=?";// 환불할 티켓가격
		String sql2 = "select cash from member where id=?"; // 환불할 사람 잔액 조회
		String sql3 = "update member set cash=? where id=?"; // 환불할 사람 잔액에 티켓가격 추가

		try {
			prestmt = conn.prepareStatement(sql1);
			prestmt.setString(1, movie_name);
			rs = prestmt.executeQuery();

			if (rs.next()) {
				int refund = rs.getInt(1);
				prestmt = conn.prepareStatement(sql2);
				prestmt.setString(1, id);
				rs = prestmt.executeQuery();

				if (rs.next()) {
					int cash = rs.getInt(1);
					prestmt = conn.prepareStatement(sql3);
					prestmt.setInt(1, (cash + refund));
					prestmt.setString(2, id);

					int t = prestmt.executeUpdate();
					if (t > 0) {
						return true;
					}
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
	 * 컨트롤러는 3단계를 쓰세요 작성자 : 이성훈 작성일자 :07.05 기능설명 : 마이페이지창- 예매확인/취소창 - 취소버튼 클릭시 2단계
	 * 삭제
	 */
	private boolean delete_reserve(String id, String movie_name) {
		connection();
		String sql = "delete from reserve where id=? and movie_name =?"; // 환불자 예약 삭제
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

	/*
	 * 작성자 : 이성훈 작성일자 :07.05 기능설명 : 마이페이지창- 예매확인/취소창 - 취소버튼 클릭시 3단계 환불+삭제
	 */
	public boolean cancel(String id, String movie_name) {

		if (refund(id, movie_name)) {
			if (delete_reserve(id, movie_name)) {
				return true;
			}
		}

		return false;
	}

	/*
	 * 작성자 : 이성훈 작성일자 :07.04 기능설명 : 마이페이지창 - 관람내역 - 후기 작성 버튼 
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
	 * 작성자 : 이성훈 작성일자 :07.05 기능설명 : 포인트 추가 / 차감
	 */							//	아이디      포인트		기호 +,- 추가는 +, 차감은 -를 파라미터로 받아야 한다. 
	public boolean point_plma(String id, int point, String symbol) {
		connection();
		String sql1 = "select point from member where id=?";// 유저 잔액포인트 조회
		String sql2 = "update member set point=? where id=?"; // 차감한 포인트 업데이트

		try {
			prestmt = conn.prepareStatement(sql1);
			prestmt.setString(1, id);
			rs = prestmt.executeQuery();

			if (rs.next()) {
				int mypoint = rs.getInt(1);
				String result = mypoint+symbol+point;
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
	 * 작성자 : 이성훈 작성일자 :07.05 기능설명 : 캐시 추가 감소
	 */						// 아이디		캐쉬			+/- 기호  +는 추가 -는 감소
	public boolean cash_plma(String id, int cash, String symbol) {
		connection();
		String sql1 = "select cash from member where id=?";// 유저 잔액포인트 조회
		String sql2 = "update member set cash=? where id=?"; // 차감한 포인트 업데이트
		int result;
		try {
			prestmt = conn.prepareStatement(sql1);
			prestmt.setString(1, id);
			rs = prestmt.executeQuery();

			if (rs.next()) {
				int mycash = rs.getInt(1);
				if(symbol.equals("+")) {
					result = mycash+cash;
				}else {
					result = mycash-cash;
				}
				
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
	
	
	// ************************************  보류할 메소드 참조할 필요 없습니다 ***************************************

//	/*
//	 * 작성자 : 이성훈 작성일자 :07.05 기능설명 : 포인트 차감
//	 */
//	public boolean point_minus(String id, int point) {
//		connection();
//		String sql1 = "select point from member where id=?";// 유저 잔액포인트 조회
//		String sql2 = "update member set point=? where id=?"; // 차감한 포인트 업데이트
//
//		try {
//			prestmt = conn.prepareStatement(sql1);
//			prestmt.setString(1, id);
//			rs = prestmt.executeQuery();
//
//			if (rs.next()) {
//				int mypoint = rs.getInt(1);
//				prestmt = conn.prepareStatement(sql2);
//				prestmt.setInt(1, (mypoint - point));
//				prestmt.setString(2, id);
//				int t = prestmt.executeUpdate();
//
//				if (t > 0) {
//					return true;
//				}
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			diss();
//		}
//		return false;
//	}


//
//	/*
//	 * 작성자 : 이성훈 작성일자 :07.05 기능설명 : 캐시 차감
//	 */
//	public boolean cash_minus(String id, int cash) {
//		connection();
//		String sql1 = "select cash from member where id=?";// 유저 잔액포인트 조회
//		String sql2 = "update member set cash=? where id=?"; // 차감한 포인트 업데이트
//
//		try {
//			prestmt = conn.prepareStatement(sql1);
//			prestmt.setString(1, id);
//			rs = prestmt.executeQuery();
//
//			if (rs.next()) {
//				int mycash = rs.getInt(1);
//				prestmt = conn.prepareStatement(sql2);
//				prestmt.setInt(1, (mycash - cash));
//				prestmt.setString(2, id);
//				int t = prestmt.executeUpdate();
//
//				if (t > 0) {
//					return true;
//				}
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			diss();
//		}
//		return false;
//	}
	// 후기 작성 버전2 - 보류
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
