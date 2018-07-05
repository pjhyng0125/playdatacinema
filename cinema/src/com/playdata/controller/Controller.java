package com.playdata.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

import com.playdata.model.Comment;
import com.playdata.model.Movie;
import com.playdata.model.MovieDAO;
import com.playdata.view.CreateReView;
import com.playdata.view.LoginView;
import com.playdata.view.MyPageView;
import com.playdata.view.PayView;
import com.playdata.view.ReView;
import com.playdata.view.ReserView;
import com.playdata.view.ReviewSubView;
import com.playdata.view.ScheduleView;
import com.playdata.view.ScreenView;

public class Controller implements ActionListener {	
//view
	LoginView v_login;
	ReserView v_reserve;
	ReView v_review;
	ScheduleView v_schedule;
	MyPageView v_mypage;
	ScreenView v_screen;
	PayView v_pay;
	CreateReView v_createreview;
//dao
	MovieDAO movie_dao;
//int
	int seleted_date;//ScheduleDateView에서 선택된 toggle button의 index를 저장하는 변수
	int seleted_time;//ScheduleTimeView에서 선택된 toggle button의 index를 저장하는 변수
	int seleted_movie; //선택한 영화의 index를 저장하는 변수 ... 0,1,2,3
	int review_page; //후기 창 page 변수
	int review_maxpage;	//후기창 
	
//String
	String login_id="login_id";
//arraylist
	ArrayList<Comment> list_comment;
	ArrayList<ReviewSubView> list_review;
	ArrayList<Movie> list_movie;
	
	public Controller() {
//new
		v_login = new LoginView();
		v_reserve = new ReserView();
		v_review = new ReView();
		v_schedule = new ScheduleView();
		v_mypage = new MyPageView();
		v_screen = new ScreenView();
		v_pay = new PayView();
		v_createreview = new CreateReView(login_id);
//dao
		movie_dao = new MovieDAO();
//add comments in list
		list_comment = new ArrayList<>();
		list_comment.add(new Comment("a", "1234", 1));
		list_comment.add(new Comment("b", "5678", 2));
		list_comment.add(new Comment("c", "9101", 4));
		list_comment.add(new Comment("d", "1121", 4));
		list_comment.add(new Comment("e", "3141", 2));
		list_comment.add(new Comment("f", "1161", 4));
		list_comment.add(new Comment("g", "1161", 0));
		list_comment.add(new Comment("h", "1161", 4));
		list_comment.add(new Comment("i", "1161", 2));
		list_comment.add(new Comment("j", "1161", 2));
		list_comment.add(new Comment("k", "1161", 4));

//review 창 후기 페이지 디폴트값 설정 ---> 후기 창을 띄울때마다 아래의 3줄을 적어주어야 한다.
		v_review.rewriteReview(selectReview(list_comment, 0));
		v_review.bt_back.setEnabled(false);
		review_maxpage = list_comment.size() / 4;	//최대 페이지 설정
//set ReserView stars...
		v_reserve.setstarSelected(0, 4);
		v_reserve.setstarSelected(1, 3);
		v_reserve.setstarSelected(2, 2);
		v_reserve.setstarSelected(3, 1);
//ReserView => show movie list infos...
		list_movie = movie_dao.movieSelectAll();
		list_movie = new ArrayList<>();
		list_movie.add(new Movie("앤트맨", "액션코미디", 50.0, 4, "image/antman.png"));
		list_movie.add(new Movie("히스토리", "멜로감동", 25.0, 3, "image/her_story.png"));
		list_movie.add(new Movie("탐점", "액션코미디", 20.0, 2, "image/returns.png"));
		list_movie.add(new Movie("마녀", "액션코미디", 15.0, 0, "image/witch.png"));
		showReserveInfo(list_movie);
		
/*-------------------------------------EVENT LISTENER(익명)------------------------------------------*/
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/03 23:18
		 * 이벤트리스너 기능: ReView => 다음 버튼 클릭 & 이전 버튼 클릭
		 */
		v_review.bt_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(review_page >= 0 && review_page < review_maxpage) {
					review_page++;
					v_review.rewriteReview(selectReview(list_comment, review_page));
					if(review_page == review_maxpage)
						v_review.bt_next.setEnabled(false);
					else {
						v_review.bt_back.setEnabled(true);
						v_review.bt_next.setEnabled(true);
					}
				}
			}
		});
		v_review.bt_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(review_page > 0 && review_page <= review_maxpage) {
					review_page--;
					v_review.rewriteReview(selectReview(list_comment, review_page));
					if(review_page == 0)
						v_review.bt_back.setEnabled(false);
					else {
						v_review.bt_next.setEnabled(true);
						v_review.bt_back.setEnabled(true);
					}
				}
			}
		});
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/03 23:18
		 * 이벤트리스너 기능: ScheduleView => Check ScheduleTimeView
		 */
		for(int i=0; i<v_schedule.v_st.length; i++) {
			v_schedule.v_st[i].tbt_time.addMouseListener(new MouseAdapter() {
			@Override
				public void mouseReleased(MouseEvent e) {		
				boolean flag = false;	//toggle button이 선택되었는지 여부를 확인하는 변수
				
			/*--------------------toggle button 체크 확인------------------*/
				for(int i=0; i<v_schedule.v_st.length; i++) {
					if(v_schedule.v_st[i].tbt_time.isSelected()) {
						flag = true;
						seleted_time = i;
					}
				}
				
		/*--------------------toggle button 체크 여부에 따라 setEnabled() 호출 ------------------*/
				if(!flag) {	
					for(int j=0; j<v_schedule.v_st.length; j++)
						v_schedule.v_st[j].tbt_time.setEnabled(true);
				}
				else {
					for(int j=0; j<v_schedule.v_st.length; j++)
						if(seleted_time != j)
							v_schedule.v_st[j].tbt_time.setEnabled(false);
				}
				}//mouseReleased	
			});//v_schedule.v_st[i].addMouseListener
		}//for
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/03 20:13
		 * 이벤트리스너 기능: ScheduleView => Check ScheduleDateView
		 * (MouseReleased)
		 * 선택해제(!flag): 다 false가 되는 순간 tbt.setEnabled(true)
		 * 선택(flag): 하나가 true 되는 순간  선택된 것 제외 나머지 tbt.setEnabled(false)
		 */
		for(int i=0; i<v_schedule.v_sd.length; i++) {
			v_schedule.v_sd[i].addMouseListener(new MouseAdapter() {
			@Override
				public void mouseReleased(MouseEvent e) {		
				boolean flag = false;	//toggle button이 선택되었는지 여부를 확인하는 변수
				
			/*--------------------toggle button 체크 확인------------------*/
				for(int i=0; i<v_schedule.v_sd.length; i++) {
					if(v_schedule.v_sd[i].isSelected()) {
						flag = true;
						seleted_date = i;
					}
				}
				
		/*--------------------toggle button 체크 여부에 따라 setEnabled() 호출 ------------------*/
				if(!flag) {	
					for(int j=0; j<v_schedule.v_sd.length; j++)
						v_schedule.v_sd[j].setEnabled(true);
				}
				else {
					for(int j=0; j<v_schedule.v_sd.length; j++)
						if(seleted_date != j)
							v_schedule.v_sd[j].setEnabled(false);
								
				}
				}//mouseReleased	
			});//v_schedule.v_sd[i].addMouseListener
		}//for
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/03 20:13
		 * 이벤트리스너 기능: ReserView => Move ReView
		 */
		for(int i=0; i<v_reserve.subv_reserve.length; i++)
			v_reserve.subv_reserve[i].la_image.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					v_reserve.setVisible(false);
					v_review.setVisible(true);
				}
			});
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/03 20:13
		 * 이벤트리스너 기능: ReserView => Move ScheduleView
		 */
		for(int i=0; i<v_reserve.subv_reserve.length; i++)
			v_reserve.subv_reserve[i].bt_reserve.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					v_reserve.setVisible(false);
					v_schedule.setVisible(true);
				}
			});
		
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/01 10:19
		 * 이벤트리스너 기능: ReserveSubView Action Listener 추가
		 */
		for(int i=0; i<v_reserve.subv_reserve.length; i++)
			for(int j=0; j<v_reserve.subv_reserve[i].tbt_stars.length;j++)
				v_reserve.subv_reserve[i].tbt_stars[j].addActionListener(this);

		/*
		 * 작성자: 박진형
		 * 수정일자: 07/01 10:01
		 * 이벤트리스너 기능: For View Change Event
		 */
		v_login.bt_login.addActionListener(this);
		v_schedule.bt_next.addActionListener(this);
		v_screen.pay_view.addActionListener(this);
		v_screen.select_movie.addActionListener(this);
		v_reserve.bt_mypage.addActionListener(this);
		v_reserve.bt_logout.addActionListener(this);
		v_mypage.bt_back.addActionListener(this);
		v_review.bt_reserve.addActionListener(this);
		v_mypage.bt_history.addActionListener(this);
		v_createreview.bt_mypage.addActionListener(this);
		for(int i=0; i<v_createreview.tbt_stars.length; i++)
			v_createreview.tbt_stars[i].addActionListener(this);
		v_schedule.bt_back.addActionListener(this);
		for(int i=0; i<4; i++)
			v_reserve.subv_reserve[i].bt_reserve.addActionListener(this);
	}//생성자
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/04 17:34
	 * selectReview: ReView => 페이지에 해당하는 4개의 ReviewSubView가 담긴 벡터 반환 
	 */
	public ArrayList<Comment> selectReview(ArrayList<Comment> v_in, int review_page){
		v_review.la_page.setText("- "+(review_page+1)+" -");	//review 창 페이지 라벨 텍스트 설정
		ArrayList<Comment> v_out = new ArrayList<>();
		for(int i=0; i<v_in.size(); i++)
			if((i/4) == review_page)
				v_out.add(v_in.get(i));
		return v_out;
	}
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/05 17:38
	 * selectReview: ReserView => 4개의 영화 정보를 ReserView 화면에 뿌려주는 함수
	 */
	public void showReserveInfo(ArrayList<Movie> list_movie) {
		for(int i=0; i<4; i++) {
			v_reserve.subv_reserve[i].la_title.setText(list_movie.get(i).getName());
			v_reserve.subv_reserve[i].la_percent.setText(list_movie.get(i).getRate()+" %");
			v_reserve.subv_reserve[i].la_genre.setText(list_movie.get(i).getGenre());
			v_reserve.subv_reserve[i].la_image.setIcon(new ImageIcon(list_movie.get(i).getPath()));
			v_reserve.setstarSelected(i, list_movie.get(i).getAvg_star());
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
	
	
/*-------------------------------------EVENT LISTENER(actionPerformed)------------------------------------------*/
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/01 12:35
	 * 이벤트리스너 기능: ReserveSubView에서 Selected된 별의 이미지 변경
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
			for(int j=0; j<v_createreview.tbt_stars.length;j++) {
				if(ob == v_createreview.tbt_stars[j]) {
					if(v_createreview.tbt_stars[j].isSelected())
						v_createreview.setstarSelected(j);
					else
						v_createreview.setstarSelected(j);
				}
			}//for-j
			
			for(int i=0; i<4; i++) {
				if(ob ==v_reserve.subv_reserve[i].bt_reserve) {
					seleted_movie = i;
					System.out.println(seleted_movie);
				}//if
			}//for
		
/*---------------View Change EVENT---------------*/	
		if(ob == v_login.bt_login) {
			v_login.setVisible(false);
			v_reserve.setVisible(true);
		}
		else if(ob == v_reserve.bt_mypage) {
			v_reserve.setVisible(false);
			v_mypage.setVisible(true);
		}
		else if(ob == v_schedule.bt_next) {
			v_schedule.setVisible(false);
			v_screen.setVisible(true);
		}
		else if(ob == v_screen.select_movie) {
			v_screen.setVisible(false);
			v_schedule.setVisible(true);
		}
		else if(ob == v_screen.pay_view) {
			v_screen.setVisible(false);
			v_pay.setVisible(true);
		}
		else if(ob == v_reserve.bt_logout) {
			if(v_reserve.sendConfirmedMsg("로그아웃 하시겠습니까?") == 0) {
				v_reserve.sendshowMsg("로그아웃 되었습니다.");
				v_reserve.setVisible(false);
				v_login.setVisible(true);
			}
		}
		else if(ob == v_mypage.bt_back) {
			v_mypage.setVisible(false);
			v_reserve.setVisible(true);
		}
		else if(ob == v_review.bt_reserve) {
			v_review.setVisible(false);
			v_reserve.setVisible(true);
		}
		else if(ob == v_mypage.bt_history) {
			v_mypage.setVisible(false);
			v_createreview.setVisible(true);
		}
		else if(ob == v_createreview.bt_mypage) {
			v_createreview.setVisible(false);
			v_createreview.ta_content.setText("");
			v_mypage.setVisible(true);
		}
		else if(ob == v_schedule.bt_back) {
			v_schedule.setVisible(false);
			v_reserve.setVisible(true);
		}
	}//actionPerformed
	
}
