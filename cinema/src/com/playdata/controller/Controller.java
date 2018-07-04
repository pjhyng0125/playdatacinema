package com.playdata.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.playdata.model.Comment;
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
//int
	int seleted_date;//ScheduleDateView에서 선택된 toggle button의 index를 저장하는 변수
	int seleted_time;//ScheduleTimeView에서 선택된 toggle button의 index를 저장하는 변수
	int review_page; //후기 창 page 변수
	int review_maxpage;
	
//arraylist
	ArrayList<Comment> list_comment;
	ArrayList<ReviewSubView> list_review;
	
	public Controller() {
//new
		v_login = new LoginView();
		v_reserve = new ReserView();
		v_review = new ReView();
		v_schedule = new ScheduleView();
		v_mypage = new MyPageView();
		v_screen = new ScreenView();
		v_pay = new PayView();
		
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

//review 창 후기 페이지 0으로 설정
		v_review.rewriteReview(selectReview(list_comment, 0));
		review_maxpage = list_comment.size() / 4;
//set ReserView stars...
		v_reserve.setstarSelected(0, 4);
		v_reserve.setstarSelected(1, 3);
		v_reserve.setstarSelected(2, 2);
		v_reserve.setstarSelected(3, 1);
		
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
				}
			}
		});
		v_review.bt_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(review_page > 0 && review_page <= review_maxpage) {
					review_page--;
					v_review.rewriteReview(selectReview(list_comment, review_page));
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
		
//		for(int i=0; i<v_reserve.subv_reserve.length;i++) {
//			for(int j=0; j<v_reserve.subv_reserve[i].tbt_stars.length;j++) {
//				if(ob == v_reserve.subv_reserve[i].tbt_stars[j]) {
//					if(v_reserve.subv_reserve[i].tbt_stars[j].isSelected())
//						v_reserve.setstarSelected(i, j);
//					else
//						v_reserve.setstarSelected(i, j);
//				}
//			}//for-j
//		}//for-i
		
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
	}//actionPerformed
	
}
