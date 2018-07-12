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
	int selected_date;// ScheduleDateView���� ���õ� toggle button�� index�� �����ϴ� ����
	int selected_time;// ScheduleTimeView���� ���õ� toggle button�� index�� �����ϴ� ����

	String DB_movie; // ������ ��ȭ�� �̸��� �����ϴ� ���� ... 0,1,2,3
	String DB_date; // Schedule â���� ������ ��¥�� �����ϴ� ���� ... 7/19
	String DB_time; // Schedule â���� ������ �ð��� �����ϴ� ���� ... 7/19

	boolean flag_date;
	boolean flag_time;

	int review_page; // �ı� â page ����
	int review_maxpage; // �ı�â
	// date
	String yoils[] = { "", "��", "��", "ȭ", "��", "��", "��", "��" };
	int month = cal.get(Calendar.MONTH) + 1;
	int day = cal.get(Calendar.DATE);
	int yoil = cal.get(Calendar.DAY_OF_WEEK);
	String today = month + "/" + day + "" + " (" + yoils[yoil] + ")"; // month/day (yoil)
	// String[]
	String[] mem_grade = { "�Ϲ�", "VIP", "VVIP" };

	// String
	String login_id = "login_id";
	String login_checkid = ""; // �α��� �ߺ�Ȯ��
	// arraylist
	ArrayList<Comment> list_comment;
	ArrayList<ReviewSubView> list_review;
	ArrayList<Movie> list_movie;
	// boolean
	boolean checkId = false; // �ߺ� üũ

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
		v_schedule.la_date.setText("��¥ : " + today);

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

		// review â �ı� ������ ����Ʈ�� ���� ---> �ı� â�� ��ﶧ���� �Ʒ��� 3���� �����־�� �Ѵ�.
		// v_review.rewriteReview(selectReview(list_comment, 0));
		// v_review.bt_back.setEnabled(false);
		// review_maxpage = list_comment.size() / 4; //�ִ� ������ ����
		// set ReserView stars...
		v_reserve.setstarSelected(0, 4);
		v_reserve.setstarSelected(1, 3);
		v_reserve.setstarSelected(2, 2);
		v_reserve.setstarSelected(3, 1);
		// ReserView => show movie list infos...
		// list_movie = movie_dao.movieSelectAll();
		list_movie = new ArrayList<>();
		list_movie.add(new Movie("��Ʈ��", "�׼��ڹ̵�", 50.0, 4, "image/antman.png"));
		list_movie.add(new Movie("�����丮", "��ΰ���", 25.0, 3, "image/her_story.png"));
		list_movie.add(new Movie("Ž��", "�׼��ڹ̵�", 20.0, 2, "image/returns.png"));
		list_movie.add(new Movie("����", "�׼��ڹ̵�", 15.0, 0, "image/witch.png"));
		showReserveInfo(list_movie);

		/*-------------------------------------EVENT LISTENER(�͸�)------------------------------------------*/

		/*
		 * �ۼ���: ������ ��������: 07/03 23:18 �̺�Ʈ������ ���: ReView => ���� ��ư Ŭ�� & ���� ��ư Ŭ��
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
		 * �ۼ���: ������ ��������: 07/03 23:18 �̺�Ʈ������ ���: ScheduleView => Check ScheduleTimeView
		 */
		for (int i = 0; i < v_schedule.v_st.length; i++) {
			v_schedule.v_st[i].tbt_time.addMouseListener(new MouseAdapter() {// ���ݿ��� ��ư Ŭ��!!
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
					boolean flag = false; // toggle button�� ���õǾ����� ���θ� Ȯ���ϴ� ����
					/*--------------------toggle button üũ Ȯ��------------------*/
					for (int i = 0; i < v_schedule.v_st.length; i++) {
						if (v_schedule.v_st[i].tbt_time.isSelected()) {
							flag = true;
							flag_time = true;
							selected_time = i;
						}
					}

					/*--------------------toggle button üũ ���ο� ���� setEnabled() ȣ�� ------------------*/
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
		 * �ۼ���: ������ ��������: 07/03 20:13 �̺�Ʈ������ ���: ScheduleView => Check ScheduleDateView
		 * (MouseReleased) ��������(!flag): �� false�� �Ǵ� ���� tbt.setEnabled(true) ����(flag):
		 * �ϳ��� true �Ǵ� ���� ���õ� �� ���� ������ tbt.setEnabled(false)
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
					boolean flag = false; // toggle button�� ���õǾ����� ���θ� Ȯ���ϴ� ����
					/*--------------------toggle button üũ Ȯ��------------------*/
					for (int i = 0; i < v_schedule.v_sd.length; i++) {
						if (v_schedule.v_sd[i].isSelected()) {
							flag = true;
							flag_date = true;
							selected_date = i;
							v_schedule.la_date.setText(v_schedule.v_sd[i].getText());
						}
					}

					/*--------------------toggle button üũ ���ο� ���� setEnabled() ȣ�� ------------------*/
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
		 * �ۼ���: ������ ��������: 07/03 20:13 �̺�Ʈ������ ���: ReserView => Move ReView
		 */
		for (int i = 0; i < v_reserve.subv_reserve.length; i++)
			v_reserve.subv_reserve[i].la_image.addMouseListener(this);

		/*
		 * �ۼ���: ������ ��������: 07/03 20:13 �̺�Ʈ������ ���: ReserView => Move ScheduleView
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
		 * �ۼ���: ������ ��������: 07/01 10:19 �̺�Ʈ������ ���: ReserveSubView Action Listener �߰�
		 */
		for (int i = 0; i < v_reserve.subv_reserve.length; i++)
			for (int j = 0; j < v_reserve.subv_reserve[i].tbt_stars.length; j++)
				v_reserve.subv_reserve[i].tbt_stars[j].addActionListener(this);

		// �¼� �׼Ǹ�����
		for (int i = 0; i < v_screen.bt_seat.length; i++)
			v_screen.bt_seat[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					v_screen.checkSelected();
				}
			});

		/*
		 * �ۼ���: ������ ��������: 07/01 10:01 �̺�Ʈ������ ���: For View Change Event
		 */
		// ȭ�� ��ȯ
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

		for (int i = 0; i < 5; i++) { // ����Ȯ�� ���
			v_myReserview.subv_create[i].bt_cancle.addActionListener(this);
		}
	}// ������

	// ---------------------------------------------------------������ eventUp
	public void adminEventUp() {
		v_admin.bt_postManage.addActionListener(this);
		v_admin.bt_canclePay.addActionListener(this);
		v_admin.bt_cmtManage.addActionListener(this);
		v_admin.bt_delete.addActionListener(this);
		v_admin.bt_select.addActionListener(this);
		v_admin.bt_selectAll.addActionListener(this);
	}

	/*
	 * �ۼ���: ������ ��������: 07/04 17:34 selectReview: ReView => �������� �ش��ϴ� 4����
	 * ReviewSubView�� ��� ���� ��ȯ
	 */
	public ArrayList<Comment> selectReview(ArrayList<Comment> v_in, int review_page) {
		v_review.la_page.setText("- " + (review_page + 1) + " -"); // review â ������ �� �ؽ�Ʈ ����
		ArrayList<Comment> v_out = new ArrayList<>();
		for (int i = 0; i < v_in.size(); i++)
			if ((i / 4) == review_page)
				v_out.add(v_in.get(i));
		return v_out;
	}

	/*
	 * �ۼ���: ������ ��������: 07/08 18:05 selectReview: ReView => ȭ�鿡 å ���� �ѷ��ִ� �Լ�
	 */
	// �����߰�0708
	public void showMovieInfo(ArrayList<Movie> list_movie, int index) {
		v_review.la_image.setIcon(new ImageIcon(list_movie.get(index).getPath()));
		v_review.la_name.setText(list_movie.get(index).getMovie_name());
		v_review.la_genre.setText(list_movie.get(index).getGenre());
	}

	public void showMovieInfo(Movie m) {
		v_review.la_image.setIcon(new ImageIcon(m.getPath()));
		v_review.la_name.setText("��ȭ����:" + m.getMovie_name());
		v_review.la_genre.setText("�帣: " + m.getGenre());
		v_review.la_actor.setText("�ֿ����: " + m.getActors());
		v_review.la_director.setText("����: " + m.getDirector());
		v_review.la_runtime.setText("�� �ð�: " + m.getRun_time() + "��");
		v_review.la_startdate.setText("��������: " + m.getStart_date());
		v_review.ta_summary.setText("<�ٰŸ�>\n" + m.getSummary());
	}

	public void showMyReserveInfo(ArrayList<Reserve> list) {// ���������� ���� Ȯ��/��ҹ�ư���� �ı��ۼ� �Ǵ� ������� ��ư ����
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
				v_myReserview.subv_create[i].bt_cancle.setText("�������");
			} else if ((Integer.parseInt(date) == Integer.parseInt(dates[0].trim() + dates[1].trim()))
					&& Integer.parseInt(time) < Integer.parseInt(times[0].trim() + times[1].trim())) {
				v_myReserview.subv_create[i].bt_cancle.setText("�������");
			} else {
				v_myReserview.subv_create[i].bt_cancle.setText("�ı��ۼ�");
			}
			v_myReserview.subv_create[i].setVisible(true);
		}
	}

	/*
	 * �ۼ���: ������ ��������: 07/05 17:38 selectReview: ReserView => 4���� ��ȭ ������ ReserView
	 * ȭ�鿡 �ѷ��ִ� �Լ�
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
	 * �ۼ���: ������ ��������: 07/05 17:38 Date 3�� ��� 1 �����ִ� �Լ�
	 */
	public void addDate() {
		cal.add(Calendar.DATE, 1);
		// cal.add(cal.DATE, 1);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DATE);
		yoil = cal.get(Calendar.DAY_OF_WEEK);
	}

	// Ȥ�� ���� ��¥ �����ϴ� �Լ�
	public void setDate(int day) {
		cal.set(Calendar.DATE, day);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DATE);
		yoil = cal.get(Calendar.DAY_OF_WEEK);
	}

	/*
	 * �ۼ���: ������ ��������: 07/05 17:38 Date => 4 5 ---> 4/5
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
		 * �ۼ���: ������ ��������: 07/03 20:13 �̺�Ʈ������ ���: ReserView => Move ReView
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
				System.out.println("DB_movie (�� ��ư) = " + DB_movie);
			}
		}
	}

	// review â �ı� ������ ����Ʈ�� ���� ---> �ı� â�� ��ﶧ���� �Ʒ��� 3���� �����־�� �Ѵ�.
	// v_review.rewriteReview(selectReview(list_comment, 0));
	// v_review.bt_back.setEnabled(false);
	// review_maxpage = list_comment.size() / 4; //�ִ� ������ ����

	/*-------------------------------------EVENT LISTENER(actionPerformed)------------------------------------------*/
	/*
	 * �ۼ���: ������ ��������: 07/01 12:35 �̺�Ʈ������ ���: ReserveSubView���� Selected�� ���� �̹��� ����
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		for (int i = 0; i < v_myReserview.subv_create.length; i++) {
			if (ob == v_myReserview.subv_create[i].bt_cancle) {
				String chk = v_myReserview.subv_create[i].bt_cancle.getText();
				if (chk.equals("�ı��ۼ�")) {
					DB_movie = v_myReserview.subv_create[i].lb_movie_name.getText();
					v_createreview.la_id.setText(login_id + "��");
					v_myReserview.setVisible(false);
					v_createreview.setVisible(true);
				} else {
					Reserve r = new Reserve();
					r.setId(login_id);
					r.setRun_date(v_myReserview.subv_create[i].lb_date.getText());
					r.setStart_time(v_myReserview.subv_create[i].lb_runtime.getText());
					if (new ReserveDAO().deleteReserve(r)) {
						System.out.println("�����Ϸ�");
					} else {
						System.out.println("��������");
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

		// ReserView���� ���� ��ư Ŭ����------------------------------------------------
		for (int i = 0; i < 4; i++) {
			if (ob == v_reserve.subv_reserve[i].bt_reserve) {
				DB_movie = list_movie.get(i).getMovie_name();
				v_schedule.la_title.setText(DB_movie);
				DB_date = v_schedule.v_sd[0].getText().substring(0, 6);
				System.out.println(DB_date);
				v_schedule.la_date.setText(DB_date);

				v_reserve.setVisible(false);
				v_schedule.setVisible(true);
				System.out.println("DB_movie (���� ��ư) = " + DB_movie);
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
				JOptionPane.showMessageDialog(v_login, id + " �α��� ����!");
				login_id = id;
				// --------------------------------------reserve �Ѹ���
				list_movie = new MovieDAO().selectAllMovie();
				showReserveInfo(list_movie);
				user = new Client();
				v_login.setVisible(false);
				v_reserve.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(v_login, id + " �α��� ����!");
			}
			v_login.tf_id.setText("");
			v_login.tf_pass.setText("");

		} else if (ob == v_reserve.bt_mypage) {
			// ------------------------------------------���������� �Ѹ���
			Member m = new MemberDAO().select_member(login_id);
			v_mypage.la_greet.setText(m.getName() + "��");
			v_mypage.la_grade2.setText(mem_grade[m.getMem_grade()]);
			v_mypage.la_cash2.setText(m.getCash() + "��");
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
			if (v_reserve.sendConfirmedMsg("�α׾ƿ� �Ͻðڽ��ϱ�?") == 0) {
				v_reserve.sendshowMsg("�α׾ƿ� �Ǿ����ϴ�.");
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
		} else if (ob == v_mypage.bt_drop) { // ȸ��Ż���ưŬ����
			if (v_mypage.showYesNOmsg("���� ȸ�� Ż�� �Ͻðڽ��ϱ�?")) {
				if (member_dao.deleteMember(login_id)) {
					v_mypage.showMsg("�׵��� �̿����ּż� �����մϴ�.");
				}
				v_mypage.setVisible(false);
				v_login.setVisible(true);
			}
		} else if (ob == v_mypage.bt_logout) {
			if (v_mypage.showYesNOmsg("�α׾ƿ��Ͻðڽ��ϱ�?")) {
				v_mypage.showMsg(login_id + "�� �̿��� �����մϴ�.");
				v_mypage.setVisible(false);
				v_login.setVisible(true);
			}
		} else if (ob == v_mypage.bt_cash) {
			v_cash.setVisible(true);
		} else if (ob == v_cash.bt_charge_ok) {// ����ʿ�----------------------------------------------------------
			String cash = v_cash.tf_charge_cash.getText().trim();
			if (!cash.matches("[\\d]+")) {
				v_cash.showMsg("�����ݾ��� ����� �Է����ּ���!");
				return;
			}
			if (new MemberDAO().updateCashPoint(login_id, Integer.parseInt(cash), 0)) {
				int newCash = new MemberDAO().selectCash(login_id);
				if (newCash >= 0) {
					v_cash.showMsg("�����Ϸ�!");
					v_mypage.la_cash2.setText(newCash + "��");
					v_cash.tf_charge_cash.setText("");
					v_cash.tf_charge_cash.requestFocus();
				}
			}
		} else if (ob == v_cash.bt_charge_cancle) {
			v_cash.setVisible(false);
		} else if (ob == v_mypage.bt_revise) {// ȸ������ ����(����ʿ�)-----------------------------------------
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
				v_joinupdate.showMsg("��й�ȣ�� �����ּ���!");
				v_joinupdate.tf_pass.setText("");
				v_joinupdate.tf_pass2.setText("");
				v_joinupdate.requestFocus();
			} else if (answer.length() == 0) {
				v_joinupdate.showMsg("��Ʈ�� ���� ���� �����ּ���!");
			}
			if (pass.equals(pass2)) {
				Member m = new Member();
				m.setId(login_id);
				m.setPass(pass);
				m.setHint(hint);
				m.setAnswer(answer);
				if (new MemberDAO().updateMember(m)) {
					v_joinupdate.showMsg("������ �Ϸ�Ǿ����ϴ�!");
					v_joinupdate.setVisible(false);
				} else {
					v_joinupdate.showMsg("���濡 �����Ͽ����ϴ�!");
				}
			} else {
				v_joinupdate.showMsg("��й�ȣ�� Ȯ�����ּ���!");
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
		} else if (ob == v_createreview.bt_create) { // ���� �ı� ���!--------------------------------
			int com_star = 0;
			for (int i = 0; i < v_createreview.tbt_stars.length; i++) {
				if (v_createreview.tbt_stars[i].isSelected())
					com_star++;
			}
			String content = v_createreview.ta_content.getText();
			Comment c = new Comment(login_id, DB_movie, content, com_star - 1);
			user.sendMsg(login_id + "&" + DB_movie + "&" + content + "&" + (com_star - 1), "ic");

			// ����ʿ�-----------------------------------------------------------------------------
			if (new MovieDAO().updateMovieAvgStar(DB_movie)) {
				System.out.println("��");
			} else {
				System.out.println("�Ф�");

			}
			// if(new CommentDAO().insertComment(c)) {
			// if(v_createreview.showConfirmMsg("�ı⸦ ����Ͻðڽ��ϱ�?")) {
			// v_createreview.showMsg("�ıⰡ ��ϵǾ����ϴ�.");
			// }else {
			// v_createreview.showMsg("�ı����� ��ҵǾ����ϴ�.");
			// }
			// }else {
			// v_createreview.showMsg("�ı����� ��ҵǾ����ϴ�.");
			// }
		} else if (ob == v_createreview.bt_mypage) {
			v_createreview.setVisible(false);
			v_createreview.ta_content.setText("");
			v_mypage.setVisible(true);
		} else if (ob == v_schedule.bt_back) {
			v_schedule.setVisible(false);
			v_reserve.setVisible(true);
		} else if (ob == v_login.bt_join) {// ȸ������������ �̵�.
			v_join.tf_id.requestFocus(); // ���̵� �ؽ�Ʈ�ʵ� ��Ŀ��.
			v_login.setVisible(false);
			v_join.setVisible(true);
		} else if (ob == v_login.bt_find) {// ã�� ��ư�� �����ٸ�
			v_login.setVisible(false);
			v_findidpw.setVisible(true);
			// v_findid.setVisible(true);
			// v_findpw.setVisible(true);
		} else if (ob == v_findidpw.bt_id) {// ���̵� ã�⸦ �����Ѵٸ�
			v_findidpw.setVisible(false);
			v_findid.setVisible(true);
		} else if (ob == v_findid.bt_find) {// ���̵� ã��!!
			String name = v_findid.tf_name.getText();
			String email = v_findid.tf_email1.getText() + "@" + v_findid.tf_email2.getText();
			String id = new MemberDAO().idfind(name, email);
			if (id == null) {
				v_findid.showMsg("���̵� ã�� �� �����ϴ�!");
			} else {
				v_findid.showMsg("���̵�� " + id + "�Դϴ�!");
				v_findid.setVisible(false);
				v_findidpw.setVisible(true);
			}
		} else if (ob == v_findid.bt_reset) {// ���̵� ã�� ���!!
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
				v_findpw.showMsg("��й�ȣ�� ã�� �� �����ϴ�!");
			} else {
				v_findpw.showMsg("��й�ȣ�� " + pass + "�Դϴ�!");
				v_findpw.setVisible(false);
				v_findidpw.setVisible(true);
			}
		} else if (ob == v_findpw.bt_reset) {
			v_findpw.setVisible(false);
			v_findidpw.setVisible(true);
		} else if (ob == v_findidpw.bt_cancel) {
			v_findidpw.setVisible(false);
			v_login.setVisible(true);
		} else if (ob == v_join.bt_checkid) {// ���̵� �ߺ�Ȯ��
			String id = v_join.tf_id.getText();
			if (new MemberDAO().duplicate(id)) {
				v_join.showMsg("�̹� �����ϴ� ���̵��Դϴ�!");
				v_join.tf_id.setText("");
				v_join.tf_id.requestFocus();
			} else {
				if (v_join.showConfirmMsg("��밡���մϴ�! ���� ���̵� ����Ͻðڽ��ϱ�?")) {
					checkId = true;
					login_checkid = id;
				} else {
					checkId = false;
					login_checkid = "";
				}
			}
		} else if (ob == v_join.bt_reset) {// ȸ������ ���.
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
			if (!v_join.cb_email.getSelectedItem().equals("�����Է�")) {
				email2 = v_join.cb_email.getSelectedItem().toString();
			} else
				email2 = v_join.tf_email2.getText();

			String addr1 = v_join.tf_addr.getText();

			// �� üũ
			if (id.length() == 0) {
				v_join.showMsg("���̵� �Է����ּ���!");
				return;
			} else if (pass.length() == 0 || pass2.length() == 0) {
				v_join.showMsg("��й�ȣ�� �Է����ּ���!");
				if (pass.length() == 0)
					v_join.tf_pass.requestFocus();
				else
					v_join.tf_pass.requestFocus();
				return;
			} else if (answer.length() == 0) {
				v_join.showMsg("��Ʈ�� ���� ���� �Է����ּ���!");
				return;
			} else if (name.length() == 0) {
				v_join.showMsg("�̸��� �Է����ּ���!");
				return;
			} else if (birth1.length() == 0 || birth2.length() == 0 || birth3.length() == 0) {
				v_join.showMsg("��������� �Է����ּ���!");
				if (birth1.length() == 0)
					v_join.tf_birth1.requestFocus();
				else if (birth1.length() == 0)
					v_join.tf_birth2.requestFocus();
				else
					v_join.tf_birth3.requestFocus();
				return;
			} else if (gender.length() == 0) {
				v_join.showMsg("������ üũ���ּ���!");
				return;
			} else if (phone1.length() == 0 || phone2.length() == 0 || phone3.length() == 0) {
				v_join.showMsg("����ó�� �Է����ּ���!");
				if (phone1.length() == 0)
					v_join.tf_phone1.requestFocus();
				else if (phone1.length() == 0)
					v_join.tf_phone2.requestFocus();
				else
					v_join.tf_phone3.requestFocus();
				return;
			} else if (email1.length() == 0 || email2.length() == 0) {
				v_join.showMsg("�̸����� �Է����ּ���!");
				if (email1.length() == 0)
					v_join.tf_email1.requestFocus();
				else
					v_join.tf_email2.requestFocus();
				return;
			} else if (addr1.length() == 0) {
				v_join.showMsg("�ּҸ� �Է����ּ���!");
				v_join.tf_addr.requestFocus();
				return;
			} else if (!pass.equals(pass2)) {// ��й�ȣ Ȯ�� ��ġ ����
				v_join.showMsg("��й�ȣ�� ��ġ���� �ʽ��ϴ�!");
				return;
			}
			String birth = birth1 + birth2 + birth3;
			String phone = phone1 + "-" + phone2 + "-" + phone3;
			String email = email1 + "@" + email2;
			String addr = addr1; // �ּ� �ؽ�Ʈ�ʵ� 2�� �ʿ�����.

			// -------------��ȿ�� �˻�!!---------------------------------

			// �ߺ�üũ ���� Ȯ��
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
				v_join.showMsg("���̵� �ߺ�Ȯ���� ���ּ���!");
			}
		}
		// ------------------------------������ ��-----------------------------
		if (login_id.equals("admin")) {
			if (ob == v_admin.bt_selectAll) {// ȸ�� ��ü��ȸ
				System.out.println("hi");
				ArrayList<Member> list = member_dao.selectAllMember();
				v_admin.dispTable(list);
			} else if (ob == v_admin.bt_select) {
				String id = v_admin.showInputmsg("��ȸ�Ͻ� ���̵� �Է����ּ���!");
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
			System.out.println("Client> ���� ����!");
			clientrun = true;
			start();
			System.out.println("Client> �޼��� ���� �غ� ��!");
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
					String msg = in.readLine();// Server�κ��� �޼��� �ޱ�
					if (msg == null)
						return;
					if (msg.trim().length() > 0) {
						System.out.println("from Server> " + msg + ":" + socket.getInetAddress().getHostAddress());
					}
					String msgs[] = msg.split("\\|");
					String protocol = msgs[0];
					String servermsg = msgs[1];

					switch (protocol) { // ��űԾ࿡ ���� Server�κ��� �޼��� �ޱ�
					case "x":
						System.out.println(servermsg);
						clientrun = false;
						in.close();
						out.close();
						socket.close();
						break;
					case "jo": {
						if (servermsg.equals("success")) {
							v_join.showMsg("ȸ�����Կ� �����ϼ̽��ϴ�^^");
							v_join.setVisible(false);
							v_login.setVisible(true);
						} else {
							v_join.showMsg("ȸ������ ����!");
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
		 * �ۼ���: ������ ��������: 07/01 12:34 �̺�Ʈ������ ���: Client class => Server On/Off
		 */
		public void turnOn() {
			new Client(); // Ŭ���̾�Ʈ�� �α��� ������ ��ü ������ ��
			sendMsg("", "o");// ������ login ���� �޼����� ������
		}

		public void turnOff() {
			try {
				sendMsg("", "x"); // Ŭ���̾�Ʈ�� ������ ������ �� ������ logout �޼��� ������
				in.close(); // ���� ����
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
