package com.playdata.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.playdata.model.dao.CommentDAO;
import com.playdata.model.dao.MemberDAO;
import com.playdata.model.dao.MovieDAO;
import com.playdata.model.dao.ReserveDAO;
import com.playdata.model.dao.ScreenDAO;
import com.playdata.model.vo.Comment;
import com.playdata.model.vo.Member;
import com.playdata.model.vo.Movie;
import com.playdata.model.vo.Reserve;
import com.playdata.view.AdminView;
import com.playdata.view.Admin_ReserSubView;
import com.playdata.view.Admin_Reserview;
import com.playdata.view.Admin_movie_view;
import com.playdata.view.Admin_re_view;
import com.playdata.view.CashView;
import com.playdata.view.CheckView;
import com.playdata.view.Check_sub_View;
import com.playdata.view.CreateReView;
import com.playdata.view.FindIdPwView;
import com.playdata.view.FindIdView;
import com.playdata.view.FindPwView;
import com.playdata.view.JoinUpdateView;
import com.playdata.view.JoinView;
import com.playdata.view.LoginView;
import com.playdata.view.MyPageView;
import com.playdata.view.PayView;
import com.playdata.view.ReView;
import com.playdata.view.ReserView;
import com.playdata.view.ReviewSubView;
import com.playdata.view.ScheduleView;
import com.playdata.view.ScreenView;

public class Controller extends MouseAdapter implements ActionListener {
	// client
	Client user;

	// view
	LoginView v_login;
	ReserView v_reserve;
	ReView v_review;
	ScheduleView v_schedule;
	MyPageView v_mypage;
	ScreenView v_screen;
	PayView v_pay;
	CreateReView v_createreview;
	JoinView v_join;
	JoinUpdateView v_joinupdate;
	FindIdView v_findid;
	FindPwView v_findpw;
	FindIdPwView v_findidpw;
	CashView v_cash;
	CheckView v_check;
	Check_sub_View v_check_sub;
	Calendar cal = Calendar.getInstance();
	AdminView v_admin;
	Admin_movie_view v_admin_movie;
	Admin_re_view v_admin_review;

	Admin_Reserview v_myReserview;
	// dao
	MovieDAO movie_dao;
	MemberDAO member_dao;
	// int
	int selected_date;// ScheduleDateView에서 선택된 toggle button의 index를 저장하는 변수
	int selected_time;// ScheduleTimeView에서 선택된 toggle button의 index를 저장하는 변수

	String DB_movie; // 선택한 영화의 이름을 저장하는 변수 ... 0,1,2,3
	String DB_date; // Schedule 창에서 선택한 날짜를 저장하는 변수 ... 7/19
	String DB_time; // Schedule 창에서 선택한 시간을 저장하는 변수 ... 7/19

	boolean flag_date;
	boolean flag_time;

	int review_page; // 후기 창 page 변수
	int review_maxpage; // 후기창
	// date
	String yoils[] = { "", "일", "월", "화", "수", "목", "금", "토" };
	int month = cal.get(Calendar.MONTH) + 1;
	int day = cal.get(Calendar.DATE);
	int yoil = cal.get(Calendar.DAY_OF_WEEK);
	String today = month + "/" + day + "" + " (" + yoils[yoil] + ")"; // month/day (yoil)
	// String[]
	String[] mem_grade = { "일반", "VIP", "VVIP" };

	// String
	String login_id = "login_id";
	String login_checkid = ""; // 로그인 중복확인
	// arraylist
	ArrayList<Comment> list_comment;
	ArrayList<ReviewSubView> list_review;
	ArrayList<Movie> list_movie;
	// boolean
	boolean checkId = false; // 중복 체크

	public Controller() {
		// new
		v_login = new LoginView();
		v_reserve = new ReserView();
		v_review = new ReView();
		v_schedule = new ScheduleView();
		v_mypage = new MyPageView();
		v_screen = new ScreenView();
		v_pay = new PayView();
		v_createreview = new CreateReView(login_id);
		v_join = new JoinView();
		v_joinupdate = new JoinUpdateView();
		v_findid = new FindIdView();
		v_findpw = new FindPwView();
		v_findidpw = new FindIdPwView();
		v_cash = new CashView();
		v_check = new CheckView();
		v_check_sub = new Check_sub_View();

		v_myReserview = new Admin_Reserview();
		// dao
		movie_dao = new MovieDAO();
		member_dao = new MemberDAO();
		// ScheduleDate
		for (int i = 0; i < v_schedule.v_sd.length; i++) {
			v_schedule.v_sd[i].setText(combineDate(month, day) + " (" + yoils[yoil] + ")");
			addDate();
		}
		v_schedule.la_date.setText("날짜 : " + today);

		// add comments in list
		// list_comment = new ArrayList<>();
		// list_comment.add(new Comment("a", "1234", 1));
		// list_comment.add(new Comment("b", "5678", 2));
		// list_comment.add(new Comment("c", "9101", 4));
		// list_comment.add(new Comment("d", "1121", 4));
		// list_comment.add(new Comment("e", "3141", 2));
		// list_comment.add(new Comment("f", "1161", 4));
		// list_comment.add(new Comment("g", "1161", 0));
		// list_comment.add(new Comment("h", "1161", 4));
		// list_comment.add(new Comment("i", "1161", 2));
		// list_comment.add(new Comment("j", "1161", 2));
		// list_comment.add(new Comment("k", "1161", 4));

		// review 창 후기 페이지 디폴트값 설정 ---> 후기 창을 띄울때마다 아래의 3줄을 적어주어야 한다.
		// v_review.rewriteReview(selectReview(list_comment, 0));
		// v_review.bt_back.setEnabled(false);
		// review_maxpage = list_comment.size() / 4; //최대 페이지 설정
		// set ReserView stars...
		v_reserve.setstarSelected(0, 4);
		v_reserve.setstarSelected(1, 3);
		v_reserve.setstarSelected(2, 2);
		v_reserve.setstarSelected(3, 1);
		// ReserView => show movie list infos...
		// list_movie = movie_dao.movieSelectAll();
		list_movie = new ArrayList<>();
		list_movie.add(new Movie("앤트맨", "액션코미디", 50.0, 4, "image/antman.png"));
		list_movie.add(new Movie("히스토리", "멜로감동", 25.0, 3, "image/her_story.png"));
		list_movie.add(new Movie("탐정", "액션코미디", 20.0, 2, "image/returns.png"));
		list_movie.add(new Movie("마녀", "액션코미디", 15.0, 0, "image/witch.png"));
		showReserveInfo(list_movie);

		/*-------------------------------------EVENT LISTENER(익명)------------------------------------------*/

		/*
		 * 작성자: 박진형 수정일자: 07/03 23:18 이벤트리스너 기능: ReView => 다음 버튼 클릭 & 이전 버튼 클릭
		 */

		v_review.bt_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (review_page >= 0 && review_page < review_maxpage) {
					review_page++;
					v_review.rewriteReview(selectReview(list_comment, review_page));
					if (review_page == review_maxpage) {
						v_review.bt_next.setEnabled(false);
						v_review.bt_back.setEnabled(true);
					} else {
						v_review.bt_back.setEnabled(true);
						v_review.bt_next.setEnabled(true);
					}
				}
			}
		});
		v_review.bt_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (review_page > 0 && review_page <= review_maxpage) {
					review_page--;
					v_review.rewriteReview(selectReview(list_comment, review_page));
					if (review_page == 0) {
						v_review.bt_back.setEnabled(false);
						v_review.bt_next.setEnabled(true);
					} else {
						v_review.bt_next.setEnabled(true);
						v_review.bt_back.setEnabled(true);
					}
				}
			}
		});

		/*
		 * 작성자: 박진형 수정일자: 07/03 23:18 이벤트리스너 기능: ScheduleView => Check ScheduleTimeView
		 */
		for (int i = 0; i < v_schedule.v_st.length; i++) {
			v_schedule.v_st[i].tbt_time.addMouseListener(new MouseAdapter() {// 지금예매 버튼 클릭!!
				@Override
				public void mouseClicked(MouseEvent e) {
					if (flag_time && flag_date)
						v_schedule.bt_next.setEnabled(true);
					else
						v_schedule.bt_next.setEnabled(false);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					flag_time = false;
					boolean flag = false; // toggle button이 선택되었는지 여부를 확인하는 변수
					/*--------------------toggle button 체크 확인------------------*/
					for (int i = 0; i < v_schedule.v_st.length; i++) {
						if (v_schedule.v_st[i].tbt_time.isSelected()) {
							flag = true;
							flag_time = true;
							selected_time = i;
						}
					}

					/*--------------------toggle button 체크 여부에 따라 setEnabled() 호출 ------------------*/
					if (!flag) {
						for (int j = 0; j < v_schedule.v_st.length; j++)
							v_schedule.v_st[j].tbt_time.setEnabled(true);
					} else {
						for (int j = 0; j < v_schedule.v_st.length; j++)
							if (selected_time != j)
								v_schedule.v_st[j].tbt_time.setEnabled(false);
					}
					DB_time = v_schedule.v_st[selected_time].tbt_time.getText();
					System.out.println("DB_time : " + DB_time);
				}// mouseReleased
			});// v_schedule.v_st[i].addMouseListener
		} // for

		/*
		 * 작성자: 박진형 수정일자: 07/03 20:13 이벤트리스너 기능: ScheduleView => Check ScheduleDateView
		 * (MouseReleased) 선택해제(!flag): 다 false가 되는 순간 tbt.setEnabled(true) 선택(flag):
		 * 하나가 true 되는 순간 선택된 것 제외 나머지 tbt.setEnabled(false)
		 */
		for (int i = 0; i < v_schedule.v_sd.length; i++) {
			v_schedule.v_sd[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (flag_date && flag_time)
						v_schedule.bt_next.setEnabled(true);
					else
						v_schedule.bt_next.setEnabled(false);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					flag_date = false;
					boolean flag = false; // toggle button이 선택되었는지 여부를 확인하는 변수
					/*--------------------toggle button 체크 확인------------------*/
					for (int i = 0; i < v_schedule.v_sd.length; i++) {
						if (v_schedule.v_sd[i].isSelected()) {
							flag = true;
							flag_date = true;
							selected_date = i;
							v_schedule.la_date.setText(v_schedule.v_sd[i].getText());
						}
					}

					/*--------------------toggle button 체크 여부에 따라 setEnabled() 호출 ------------------*/
					if (!flag) {
						for (int j = 0; j < v_schedule.v_sd.length; j++) {
							v_schedule.v_sd[j].setEnabled(true);
						}
					} else {
						for (int j = 0; j < v_schedule.v_sd.length; j++)
							if (selected_date != j)
								v_schedule.v_sd[j].setEnabled(false);

					}
					DB_date = splitTbtText(v_schedule.v_sd[selected_date].getText());
					String[] dates = DB_date.split("/");
					String run_date = dates[0] + dates[1];
					System.out.println("DB_date : " + DB_date);
				}// mouseReleased
			});// v_schedule.v_sd[i].addMouseListener
		} // for

		/*
		 * 작성자: 박진형 수정일자: 07/03 20:13 이벤트리스너 기능: ReserView => Move ReView
		 */
		for (int i = 0; i < v_reserve.subv_reserve.length; i++)
			v_reserve.subv_reserve[i].la_image.addMouseListener(this);

		/*
		 * 작성자: 박진형 수정일자: 07/03 20:13 이벤트리스너 기능: ReserView => Move ScheduleView
		 */
		for (int i = 0; i < v_reserve.subv_reserve.length; i++)
			v_reserve.subv_reserve[i].bt_reserve.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(DB_date);
					System.out.println(DB_movie);
					String[] scheduleInfo = new ScreenDAO().selectSchedule(new MovieDAO().selectSchedule(DB_movie),DB_date);
					System.out.println(scheduleInfo[0]);
					for(int j =0; j<scheduleInfo.length;j++) {
						String[] subScheduleInfo = scheduleInfo[j].split(",");
						int run_time = movie_dao.selectRuntime(DB_movie);
						v_schedule.v_st[j].tbt_time.setText(v_schedule.timeCount(subScheduleInfo[0], run_time));
					}
				   
					v_reserve.setVisible(false);
					v_schedule.setVisible(true);
				}
			});

		/*
		 * 작성자: 박진형 수정일자: 07/01 10:19 이벤트리스너 기능: ReserveSubView Action Listener 추가
		 */
		for (int i = 0; i < v_reserve.subv_reserve.length; i++)
			for (int j = 0; j < v_reserve.subv_reserve[i].tbt_stars.length; j++)
				v_reserve.subv_reserve[i].tbt_stars[j].addActionListener(this);

		// 좌석 액션리스너
		for (int i = 0; i < v_screen.bt_seat.length; i++)
			v_screen.bt_seat[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					v_screen.checkSelected();
				}
			});

		/*
		 * 작성자: 박진형 수정일자: 07/01 10:01 이벤트리스너 기능: For View Change Event
		 */
		// 화면 전환
		v_login.bt_login.addActionListener(this);
		v_schedule.bt_next.addActionListener(this);
		v_screen.pay_view.addActionListener(this);
		v_screen.select_movie.addActionListener(this);
		v_reserve.bt_mypage.addActionListener(this);
		v_reserve.bt_logout.addActionListener(this);
		v_mypage.bt_back.addActionListener(this);
		v_mypage.bt_check.addActionListener(this);
		v_mypage.bt_cash.addActionListener(this);
		v_mypage.bt_revise.addActionListener(this);
		v_mypage.bt_logout.addActionListener(this);
		v_mypage.bt_revise.addActionListener(this);
		v_review.bt_reserve.addActionListener(this);
		v_createreview.bt_mypage.addActionListener(this);
		v_createreview.bt_create.addActionListener(this);
		v_login.bt_find.addActionListener(this);
		v_login.bt_join.addActionListener(this);
		v_join.bt_reset.addActionListener(this);
		v_join.bt_submit.addActionListener(this);
		v_join.bt_checkid.addActionListener(this);

		v_joinupdate.bt_submit.addActionListener(this);
		v_joinupdate.bt_reset.addActionListener(this);

		v_findidpw.bt_id.addActionListener(this);
		v_findidpw.bt_pw.addActionListener(this);
		v_findidpw.bt_cancel.addActionListener(this);
		v_findid.bt_find.addActionListener(this);
		v_findid.bt_reset.addActionListener(this);
		v_findpw.bt_find.addActionListener(this);
		v_findpw.bt_reset.addActionListener(this);
		v_cash.bt_cash.addActionListener(this);
		v_cash.bt_charge_cancle.addActionListener(this);
		v_cash.bt_charge_ok.addActionListener(this);

		// v_check.bt_cancel.addActionListener(this);
		// v_check_sub.bt_cancel.addActionListener(this);
		for (int i = 0; i < v_createreview.tbt_stars.length; i++)
			v_createreview.tbt_stars[i].addActionListener(this);
		v_schedule.bt_back.addActionListener(this);
		for (int i = 0; i < 4; i++)
			v_reserve.subv_reserve[i].bt_reserve.addActionListener(this);

		for (int i = 0; i < 5; i++) { // 예매확인 취소
			v_myReserview.subv_create[i].bt_cancle.addActionListener(this);
		}
	}// 생성자

	// ---------------------------------------------------------관리자 eventUp
	public void adminEventUp() {
		v_admin.bt_postManage.addActionListener(this);
		v_admin.bt_canclePay.addActionListener(this);
		v_admin.bt_cmtManage.addActionListener(this);
		v_admin.bt_delete.addActionListener(this);
		v_admin.bt_select.addActionListener(this);
		v_admin.bt_selectAll.addActionListener(this);
	}

	/*
	 * 작성자: 박진형 수정일자: 07/04 17:34 selectReview: ReView => 페이지에 해당하는 4개의
	 * ReviewSubView가 담긴 벡터 반환
	 */
	public ArrayList<Comment> selectReview(ArrayList<Comment> v_in, int review_page) {
		v_review.la_page.setText("- " + (review_page + 1) + " -"); // review 창 페이지 라벨 텍스트 설정
		ArrayList<Comment> v_out = new ArrayList<>();
		for (int i = 0; i < v_in.size(); i++)
			if ((i / 4) == review_page)
				v_out.add(v_in.get(i));
		return v_out;
	}

	/*
	 * 작성자: 박진형 수정일자: 07/08 18:05 selectReview: ReView => 화면에 책 정보 뿌려주는 함수
	 */
	// 진형추가0708
	public void showMovieInfo(ArrayList<Movie> list_movie, int index) {
		v_review.la_image.setIcon(new ImageIcon(list_movie.get(index).getPath()));
		v_review.la_name.setText(list_movie.get(index).getMovie_name());
		v_review.la_genre.setText(list_movie.get(index).getGenre());
	}

	public void showMovieInfo(Movie m) {
		v_review.la_image.setIcon(new ImageIcon(m.getPath()));
		v_review.la_name.setText("영화제목:" + m.getMovie_name());
		v_review.la_genre.setText("장르: " + m.getGenre());
		v_review.la_actor.setText("주연배우: " + m.getActors());
		v_review.la_director.setText("감독: " + m.getDirector());
		v_review.la_runtime.setText("상영 시간: " + m.getRun_time() + "분");
		v_review.la_startdate.setText("개봉일자: " + m.getStart_date());
		v_review.ta_summary.setText("<줄거리>\n" + m.getSummary());
	}

	public void showMyReserveInfo(ArrayList<Reserve> list) {// 마이페이지 예매 확인/취소버튼에서 후기작성 또는 예매취소 버튼 띄우기
		Calendar c = Calendar.getInstance();
		String date = "" + (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DATE);
		String time = "" + c.get(Calendar.HOUR) + c.get(Calendar.MINUTE);

		for (int i = 0; i < list.size(); i++) {
			String[] dates = list.get(i).getRun_date().split("/");
			String[] times = list.get(i).getStart_time().split(":");
			v_myReserview.subv_create[i].lb_movie_name.setText(list.get(i).getMovie_name());
			v_myReserview.subv_create[i].lb_date.setText(list.get(i).getRun_date());
			v_myReserview.subv_create[i].lb_runtime.setText(list.get(i).getStart_time());
			v_myReserview.subv_create[i].lb_seat.setText(list.get(i).getSeatnum());

			if (Integer.parseInt(date) < Integer.parseInt(dates[0].trim() + dates[1].trim())) {
				v_myReserview.subv_create[i].bt_cancle.setText("예매취소");
			} else if ((Integer.parseInt(date) == Integer.parseInt(dates[0].trim() + dates[1].trim()))
					&& Integer.parseInt(time) < Integer.parseInt(times[0].trim() + times[1].trim())) {
				v_myReserview.subv_create[i].bt_cancle.setText("예매취소");
			} else {
				v_myReserview.subv_create[i].bt_cancle.setText("후기작성");
			}
			v_myReserview.subv_create[i].setVisible(true);
		}
	}

	/*
	 * 작성자: 박진형 수정일자: 07/05 17:38 selectReview: ReserView => 4개의 영화 정보를 ReserView
	 * 화면에 뿌려주는 함수
	 */
	public void showReserveInfo(ArrayList<Movie> list_movie) {
		for (int i = 0; i < 4; i++) {
			System.out.println(list_movie.get(i).getPath());
			v_reserve.subv_reserve[i].la_title.setText(list_movie.get(i).getMovie_name());
			v_reserve.subv_reserve[i].la_percent.setText(list_movie.get(i).getRate() + " %");
			v_reserve.subv_reserve[i].la_genre.setText(list_movie.get(i).getGenre());
			v_reserve.subv_reserve[i].la_image.setIcon(new ImageIcon(list_movie.get(i).getPath()));
			v_reserve.setstarSelected(i, list_movie.get(i).getAvg_star());
		}
	}

	/*
	 * 작성자: 박진형 수정일자: 07/05 17:38 Date 3개 요소 1 더해주는 함수
	 */
	public void addDate() {
		cal.add(Calendar.DATE, 1);
		// cal.add(cal.DATE, 1);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DATE);
		yoil = cal.get(Calendar.DAY_OF_WEEK);
	}

	// 혹시 몰라서 날짜 조정하는 함수
	public void setDate(int day) {
		cal.set(Calendar.DATE, day);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DATE);
		yoil = cal.get(Calendar.DAY_OF_WEEK);
	}

	/*
	 * 작성자: 박진형 수정일자: 07/05 17:38 Date => 4 5 ---> 4/5
	 */
	public String combineDate(int m, int d) {
		if(m<10) {
			if(d<10) {
				return "0"+m + "/0" + d;
			}else {
				return "0"+m + "/" + d;
			}
		}
		return m + "/" + d;
	}

	public void splitDate(String date) {
		String arr[] = date.split("/");
		month = Integer.parseInt(arr[0]);
		day = Integer.parseInt(arr[1]);
	}

	public String splitTbtText(String date) {
		String arr[] = date.split(" ");
		return arr[0];
	}

	// main
	public static void main(String[] args) {
		new Controller();
	}

	@Override
	/*-------------------------------------EVENT LISTENER(mouseclicked)------------------------------------------*/
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();
		/*
		 * 작성자: 박진형 수정일자: 07/03 20:13 이벤트리스너 기능: ReserView => Move ReView
		 */
		for (int i = 0; i < v_reserve.subv_reserve.length; i++) {
			if (ob == v_reserve.subv_reserve[i].la_image) {
				v_reserve.setVisible(false);
				v_review.setVisible(true);

				DB_movie = list_movie.get(i).getMovie_name();
				Movie m = new MovieDAO().selectReview(DB_movie);
				showMovieInfo(m);
				list_comment = new CommentDAO().selectReview(DB_movie);
				// for(int j=0;j<list_comment.size()/4;j++) {
				// selectReview(list_comment, j);
				// }
				v_review.rewriteReview(selectReview(list_comment, 0));
				v_review.bt_back.setEnabled(false);
				review_maxpage = list_comment.size() / 4;
				System.out.println("DB_movie (라벨 버튼) = " + DB_movie);
			}
		}
	}

	// review 창 후기 페이지 디폴트값 설정 ---> 후기 창을 띄울때마다 아래의 3줄을 적어주어야 한다.
	// v_review.rewriteReview(selectReview(list_comment, 0));
	// v_review.bt_back.setEnabled(false);
	// review_maxpage = list_comment.size() / 4; //최대 페이지 설정

	/*-------------------------------------EVENT LISTENER(actionPerformed)------------------------------------------*/
	/*
	 * 작성자: 박진형 수정일자: 07/01 12:35 이벤트리스너 기능: ReserveSubView에서 Selected된 별의 이미지 변경
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		for (int i = 0; i < v_myReserview.subv_create.length; i++) {
			if (ob == v_myReserview.subv_create[i].bt_cancle) {
				String chk = v_myReserview.subv_create[i].bt_cancle.getText();
				if (chk.equals("후기작성")) {
					DB_movie = v_myReserview.subv_create[i].lb_movie_name.getText();
					v_createreview.la_id.setText(login_id + "님");
					v_myReserview.setVisible(false);
					v_createreview.setVisible(true);
				} else {
					Reserve r = new Reserve();
					r.setId(login_id);
					r.setRun_date(v_myReserview.subv_create[i].lb_date.getText());
					r.setStart_time(v_myReserview.subv_create[i].lb_runtime.getText());
					if (new ReserveDAO().deleteReserve(r)) {
						System.out.println("삭제완료");
					} else {
						System.out.println("삭제실패");
					}
				}
			}
		}

		for (int j = 0; j < v_createreview.tbt_stars.length; j++) {
			if (ob == v_createreview.tbt_stars[j]) {
				if (v_createreview.tbt_stars[j].isSelected())
					v_createreview.setstarSelected(j);
				else
					v_createreview.setstarSelected(j);
			}
		} // for-j

		// ReserView에서 예매 버튼 클릭시------------------------------------------------
		for (int i = 0; i < 4; i++) {
			if (ob == v_reserve.subv_reserve[i].bt_reserve) {
				DB_movie = list_movie.get(i).getMovie_name();
				v_schedule.la_title.setText(DB_movie);
				DB_date = v_schedule.v_sd[0].getText().substring(0, 6);
				System.out.println(DB_date);
				v_schedule.la_date.setText(DB_date);

				v_reserve.setVisible(false);
				v_schedule.setVisible(true);
				System.out.println("DB_movie (예매 버튼) = " + DB_movie);
			} // if
		} // for

		/*---------------View Change EVENT---------------*/
		if (ob == v_login.bt_login) {
			String id = v_login.tf_id.getText();
			String pass = new String(v_login.tf_pass.getPassword());

			if (id.equals("admin") && pass.equals("1234")) {
				System.out.println("hi");
				v_admin = new AdminView();
				// v_admin_movie = new Admin_movie_view();
				// v_admin_review = new Admin_re_view();
				adminEventUp();
				v_login.setVisible(false);
				v_admin.setVisible(true);
			} else if (member_dao.login(id, pass)) {
				System.out.println(id + "," + pass);
				JOptionPane.showMessageDialog(v_login, id + " 로그인 성공!");
				login_id = id;
				// --------------------------------------reserve 뿌리기
				list_movie = new MovieDAO().selectAllMovie();
				showReserveInfo(list_movie);
				user = new Client();
				v_login.setVisible(false);
				v_reserve.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(v_login, id + " 로그인 실패!");
			}
			v_login.tf_id.setText("");
			v_login.tf_pass.setText("");

		} else if (ob == v_reserve.bt_mypage) {
			// ------------------------------------------마이페이지 뿌리기
			Member m = new MemberDAO().select_member(login_id);
			v_mypage.la_greet.setText(m.getName() + "님");
			v_mypage.la_grade2.setText(mem_grade[m.getMem_grade()]);
			v_mypage.la_cash2.setText(m.getCash() + "원");
			v_mypage.la_point2.setText(m.getPoint() + "P");

			v_reserve.setVisible(false);
			v_mypage.setVisible(true);
		} else if (ob == v_schedule.bt_next) {
			v_schedule.setVisible(false);
			v_screen.setVisible(true);
		} else if (ob == v_screen.select_movie) {
			v_screen.setVisible(false);
			v_schedule.setVisible(true);
		} else if (ob == v_screen.pay_view) {
			v_screen.setVisible(false);
			v_pay.setVisible(true);
		} else if (ob == v_reserve.bt_logout) {
			if (v_reserve.sendConfirmedMsg("로그아웃 하시겠습니까?") == 0) {
				v_reserve.sendshowMsg("로그아웃 되었습니다.");
				login_id = "";
				v_login.tf_id.setText("");
				v_login.tf_pass.setText("");
				v_login.tf_id.requestFocus();
				v_reserve.setVisible(false);
				v_login.setVisible(true);
			}
		} else if (ob == v_mypage.bt_back) {
			v_mypage.setVisible(false);
			v_reserve.setVisible(true);
		} else if (ob == v_mypage.bt_drop) { // 회원탈퇴버튼클릭시
			if (v_mypage.showYesNOmsg("정말 회원 탈퇴 하시겠습니까?")) {
				if (member_dao.deleteMember(login_id)) {
					v_mypage.showMsg("그동안 이용해주셔서 감사합니다.");
				}
				v_mypage.setVisible(false);
				v_login.setVisible(true);
			}
		} else if (ob == v_mypage.bt_logout) {
			if (v_mypage.showYesNOmsg("로그아웃하시겠습니까?")) {
				v_mypage.showMsg(login_id + "님 이용을 종료합니다.");
				v_mypage.setVisible(false);
				v_login.setVisible(true);
			}
		} else if (ob == v_mypage.bt_cash) {
			v_cash.setVisible(true);
		} else if (ob == v_cash.bt_charge_ok) {// 통신필요----------------------------------------------------------
			String cash = v_cash.tf_charge_cash.getText().trim();
			if (!cash.matches("[\\d]+")) {
				v_cash.showMsg("충전금액을 제대로 입력해주세요!");
				return;
			}
			if (new MemberDAO().updateCashPoint(login_id, Integer.parseInt(cash), 0)) {
				int newCash = new MemberDAO().selectCash(login_id);
				if (newCash >= 0) {
					v_cash.showMsg("충전완료!");
					v_mypage.la_cash2.setText(newCash + "원");
					v_cash.tf_charge_cash.setText("");
					v_cash.tf_charge_cash.requestFocus();
				}
			}
		} else if (ob == v_cash.bt_charge_cancle) {
			v_cash.setVisible(false);
		} else if (ob == v_mypage.bt_revise) {// 회원정보 수정(통신필요)-----------------------------------------
			Member m = new MemberDAO().select_member(login_id);
			v_joinupdate.tf_id.setText(login_id);
			v_joinupdate.tf_name.setText(m.getName());
			String birth = m.getBirth();
			v_joinupdate.tf_birth1.setText(birth.substring(0, 4));
			v_joinupdate.tf_birth2.setText(birth.substring(4, 6));
			v_joinupdate.tf_birth3.setText(birth.substring(7));
			v_joinupdate.fixRb(m.getGender());
			v_joinupdate.cb_hint.setSelectedItem(m.getHint());
			v_joinupdate.tf_hint2.setText(m.getAnswer());
			String[] phones = m.getPhone().split("-");
			v_joinupdate.tf_phone1.setText(phones[0]);
			v_joinupdate.tf_phone2.setText(phones[1]);
			v_joinupdate.tf_phone3.setText(phones[2]);
			String[] emails = m.getEmail().split("@");
			v_joinupdate.tf_email1.setText(emails[0]);
			v_joinupdate.tf_email2.setText(emails[1]);
			v_joinupdate.cb_email.setEditable(false);
			v_joinupdate.tf_addr.setText(m.getAddr());

			v_joinupdate.setVisible(true);
		} else if (ob == v_joinupdate.bt_submit) {
			String pass = new String(v_joinupdate.tf_pass.getPassword());
			String pass2 = new String(v_joinupdate.tf_pass2.getPassword());
			String hint = v_joinupdate.cb_hint.getSelectedItem().toString();
			String answer = v_joinupdate.tf_hint2.getText();
			if (pass.length() == 0 || pass2.length() == 0) {
				v_joinupdate.showMsg("비밀번호를 적어주세요!");
				v_joinupdate.tf_pass.setText("");
				v_joinupdate.tf_pass2.setText("");
				v_joinupdate.requestFocus();
			} else if (answer.length() == 0) {
				v_joinupdate.showMsg("힌트에 대한 답을 적어주세요!");
			}
			if (pass.equals(pass2)) {
				Member m = new Member();
				m.setId(login_id);
				m.setPass(pass);
				m.setHint(hint);
				m.setAnswer(answer);
				if (new MemberDAO().updateMember(m)) {
					v_joinupdate.showMsg("변경이 완료되었습니다!");
					v_joinupdate.setVisible(false);
				} else {
					v_joinupdate.showMsg("변경에 실패하였습니다!");
				}
			} else {
				v_joinupdate.showMsg("비밀번호를 확인해주세요!");
			}

		} else if (ob == v_joinupdate.bt_reset) {
			v_joinupdate.setVisible(false);
		} else if (ob == v_review.bt_reserve) {
			v_review.setVisible(false);
			v_reserve.setVisible(true);
		} else if (ob == v_mypage.bt_check) {
			ArrayList<Reserve> list = new ReserveDAO().selectOwnHistory(login_id);
			showMyReserveInfo(list);
			v_mypage.setVisible(false);
			v_myReserview.setVisible(true);
		} else if (ob == v_createreview.bt_create) { // 개인 후기 등록!--------------------------------
			int com_star = 0;
			for (int i = 0; i < v_createreview.tbt_stars.length; i++) {
				if (v_createreview.tbt_stars[i].isSelected())
					com_star++;
			}
			String content = v_createreview.ta_content.getText();
			Comment c = new Comment(login_id, DB_movie, content, com_star - 1);
			user.sendMsg(login_id + "&" + DB_movie + "&" + content + "&" + (com_star - 1), "ic");

			// 통신필요-----------------------------------------------------------------------------
			if (new MovieDAO().updateMovieAvgStar(DB_movie)) {
				System.out.println("굿");
			} else {
				System.out.println("ㅠㅠ");

			}
			// if(new CommentDAO().insertComment(c)) {
			// if(v_createreview.showConfirmMsg("후기를 등록하시겠습니까?")) {
			// v_createreview.showMsg("후기가 등록되었습니다.");
			// }else {
			// v_createreview.showMsg("후기등록이 취소되었습니다.");
			// }
			// }else {
			// v_createreview.showMsg("후기등록이 취소되었습니다.");
			// }
		} else if (ob == v_createreview.bt_mypage) {
			v_createreview.setVisible(false);
			v_createreview.ta_content.setText("");
			v_mypage.setVisible(true);
		} else if (ob == v_schedule.bt_back) {
			v_schedule.setVisible(false);
			v_reserve.setVisible(true);
		} else if (ob == v_login.bt_join) {// 회원가입폼으로 이동.
			v_join.tf_id.requestFocus(); // 아이디 텍스트필드 포커스.
			v_login.setVisible(false);
			v_join.setVisible(true);
		} else if (ob == v_login.bt_find) {// 찾기 버튼을 누른다면
			v_login.setVisible(false);
			v_findidpw.setVisible(true);
			// v_findid.setVisible(true);
			// v_findpw.setVisible(true);
		} else if (ob == v_findidpw.bt_id) {// 아이디 찾기를 선택한다면
			v_findidpw.setVisible(false);
			v_findid.setVisible(true);
		} else if (ob == v_findid.bt_find) {// 아이디 찾기!!
			String name = v_findid.tf_name.getText();
			String email = v_findid.tf_email1.getText() + "@" + v_findid.tf_email2.getText();
			String id = new MemberDAO().idfind(name, email);
			if (id == null) {
				v_findid.showMsg("아이디를 찾을 수 없습니다!");
			} else {
				v_findid.showMsg("아이디는 " + id + "입니다!");
				v_findid.setVisible(false);
				v_findidpw.setVisible(true);
			}
		} else if (ob == v_findid.bt_reset) {// 아이디 찾기 취소!!
			v_findid.setVisible(false);
			v_findidpw.setVisible(true);
		} else if (ob == v_findidpw.bt_pw) {
			v_findidpw.setVisible(false);
			v_findpw.setVisible(true);
		} else if (ob == v_findpw.bt_find) {
			String id = v_findpw.tf_id.getText();
			String hint = v_findpw.cb_hint.getSelectedItem().toString();
			String answer = v_findpw.tf_hint.getText();

			String pass = new MemberDAO().passfind(id, hint, answer);
			if (pass == null) {
				v_findpw.showMsg("비밀번호를 찾을 수 없습니다!");
			} else {
				v_findpw.showMsg("비밀번호는 " + pass + "입니다!");
				v_findpw.setVisible(false);
				v_findidpw.setVisible(true);
			}
		} else if (ob == v_findpw.bt_reset) {
			v_findpw.setVisible(false);
			v_findidpw.setVisible(true);
		} else if (ob == v_findidpw.bt_cancel) {
			v_findidpw.setVisible(false);
			v_login.setVisible(true);
		} else if (ob == v_join.bt_checkid) {// 아이디 중복확인
			String id = v_join.tf_id.getText();
			if (new MemberDAO().duplicate(id)) {
				v_join.showMsg("이미 존재하는 아이디입니다!");
				v_join.tf_id.setText("");
				v_join.tf_id.requestFocus();
			} else {
				if (v_join.showConfirmMsg("사용가능합니다! 현재 아이디를 사용하시겠습니까?")) {
					checkId = true;
					login_checkid = id;
				} else {
					checkId = false;
					login_checkid = "";
				}
			}
		} else if (ob == v_join.bt_reset) {// 회원가입 등록.
			v_join.setVisible(false);
			v_login.setVisible(true);
		} else if (ob == v_join.bt_submit) {
			String id = v_join.tf_id.getText();
			String pass = new String(v_join.tf_pass.getPassword());
			String pass2 = new String(v_join.tf_pass2.getPassword());
			String hint = v_join.cb_hint.getSelectedItem().toString();
			String answer = v_join.tf_hint2.getText();
			String name = v_join.tf_name.getText();
			String birth1 = v_join.tf_birth1.getText();
			String birth2 = v_join.tf_birth2.getText();
			String birth3 = v_join.tf_birth3.getText();

			String gender = "";
			if (v_join.rb_gender1.isSelected()) {
				gender = v_join.la_man.getText().substring(0, 1);
			} else if (v_join.rb_gender2.isSelected()) {
				gender = v_join.la_woman.getText().substring(0, 1);
			}

			String phone1 = v_join.tf_phone1.getText();
			String phone2 = v_join.tf_phone2.getText();
			String phone3 = v_join.tf_phone3.getText();

			String email1 = v_join.tf_email1.getText();
			String email2 = "";
			if (!v_join.cb_email.getSelectedItem().equals("직접입력")) {
				email2 = v_join.cb_email.getSelectedItem().toString();
			} else
				email2 = v_join.tf_email2.getText();

			String addr1 = v_join.tf_addr.getText();

			// 빈값 체크
			if (id.length() == 0) {
				v_join.showMsg("아이디를 입력해주세요!");
				return;
			} else if (pass.length() == 0 || pass2.length() == 0) {
				v_join.showMsg("비밀번호를 입력해주세요!");
				if (pass.length() == 0)
					v_join.tf_pass.requestFocus();
				else
					v_join.tf_pass.requestFocus();
				return;
			} else if (answer.length() == 0) {
				v_join.showMsg("힌트에 대한 답을 입력해주세요!");
				return;
			} else if (name.length() == 0) {
				v_join.showMsg("이름을 입력해주세요!");
				return;
			} else if (birth1.length() == 0 || birth2.length() == 0 || birth3.length() == 0) {
				v_join.showMsg("생년월일을 입력해주세요!");
				if (birth1.length() == 0)
					v_join.tf_birth1.requestFocus();
				else if (birth1.length() == 0)
					v_join.tf_birth2.requestFocus();
				else
					v_join.tf_birth3.requestFocus();
				return;
			} else if (gender.length() == 0) {
				v_join.showMsg("성별을 체크해주세요!");
				return;
			} else if (phone1.length() == 0 || phone2.length() == 0 || phone3.length() == 0) {
				v_join.showMsg("연락처를 입력해주세요!");
				if (phone1.length() == 0)
					v_join.tf_phone1.requestFocus();
				else if (phone1.length() == 0)
					v_join.tf_phone2.requestFocus();
				else
					v_join.tf_phone3.requestFocus();
				return;
			} else if (email1.length() == 0 || email2.length() == 0) {
				v_join.showMsg("이메일을 입력해주세요!");
				if (email1.length() == 0)
					v_join.tf_email1.requestFocus();
				else
					v_join.tf_email2.requestFocus();
				return;
			} else if (addr1.length() == 0) {
				v_join.showMsg("주소를 입력해주세요!");
				v_join.tf_addr.requestFocus();
				return;
			} else if (!pass.equals(pass2)) {// 비밀번호 확인 일치 여부
				v_join.showMsg("비밀번호가 일치하지 않습니다!");
				return;
			}
			String birth = birth1 + birth2 + birth3;
			String phone = phone1 + "-" + phone2 + "-" + phone3;
			String email = email1 + "@" + email2;
			String addr = addr1; // 주소 텍스트필드 2개 필요한지.

			// -------------유효성 검사!!---------------------------------

			// 중복체크 여부 확인
			if (checkId == true && (login_checkid.equals(id))) {
				user = new Client();
				String msg = id + "&" + pass + "&" + gender + "&" + name + "&" + birth + "&" + phone + "&" + addr + "&"
						+ email + "&" + 0 + "&" + 0 + "&" + 0 + "&" + hint + "&" + answer;
				user.sendMsg(msg, "ij");

				v_join.setVisible(false);
				v_login.setVisible(true);

			} else {
				checkId = false;
				login_checkid = "";
				v_join.showMsg("아이디 중복확인을 해주세요!");
			}
		}
		// ------------------------------관리자 뷰-----------------------------
		if (login_id.equals("admin")) {
			if (ob == v_admin.bt_selectAll) {// 회원 전체조회
				System.out.println("hi");
				ArrayList<Member> list = member_dao.selectAllMember();
				v_admin.dispTable(list);
			} else if (ob == v_admin.bt_select) {
				String id = v_admin.showInputmsg("조회하실 아이디를 입력해주세요!");
			}
			if (ob == v_admin.bt_postManage) {
				v_admin_movie.setVisible(true);
				v_admin_review.setVisible(true);
			}
		}
	}// actionPerformed

	public class Client extends Thread {
		public Socket socket;
		public BufferedReader in;
		public OutputStream out;
		boolean clientrun;

		static final int PORT_NUM = 6000;

		public Client() {
			connect();
			System.out.println("Client> 연결 성공!");
			clientrun = true;
			start();
			System.out.println("Client> 메세지 받을 준비 끝!");
		}

		public void connect() {
			try {
				InetAddress localHost = InetAddress.getLocalHost();
				socket = new Socket(localHost.getHostAddress(), PORT_NUM);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
				sendMsg("hello", "h");

			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (clientrun) {
				try {
					String msg = in.readLine();// Server로부터 메세지 받기
					if (msg == null)
						return;
					if (msg.trim().length() > 0) {
						System.out.println("from Server> " + msg + ":" + socket.getInetAddress().getHostAddress());
					}
					String msgs[] = msg.split("\\|");
					String protocol = msgs[0];
					String servermsg = msgs[1];

					switch (protocol) { // 통신규약에 따라 Server로부터 메세지 받기
					case "x":
						System.out.println(servermsg);
						clientrun = false;
						in.close();
						out.close();
						socket.close();
						break;
					case "jo": {
						if (servermsg.equals("success")) {
							v_join.showMsg("회원가입에 성공하셨습니다^^");
							v_join.setVisible(false);
							v_login.setVisible(true);
						} else {
							v_join.showMsg("회원가입 실패!");
						}
					}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}// run

		public void sendMsg(String msg, String type) {
			try {
				out.write((type + "|" + msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// sendMsg

		/*
		 * 작성자: 박진형 수정일자: 07/01 12:34 이벤트리스너 기능: Client class => Server On/Off
		 */
		public void turnOn() {
			new Client(); // 클라이언트가 로그인 성공시 객체 생성한 후
			sendMsg("", "o");// 서버에 login 성공 메세지를 보낸다
		}

		public void turnOff() {
			try {
				sendMsg("", "x"); // 클라이언트가 접속을 끊었을 때 서버에 logout 메세지 보내고
				in.close(); // 접속 종료
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
