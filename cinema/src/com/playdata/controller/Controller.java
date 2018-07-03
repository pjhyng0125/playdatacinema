package com.playdata.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import com.playdata.view.LoginView;
import com.playdata.view.MyPageView;
import com.playdata.view.PayView;
import com.playdata.view.ReView;
import com.playdata.view.ReserView;
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
	
	int seleted_date;//ScheduleDateView에서 선택된 toggle button의 index를 저장하는 변수
	int seleted_time;//ScheduleTimeView에서 선택된 toggle button의 index를 저장하는 변수
	
	public Controller() {
		v_login = new LoginView();
		v_reserve = new ReserView();
		v_review = new ReView();
		v_schedule = new ScheduleView();
		v_mypage = new MyPageView();
		v_screen = new ScreenView();
		v_pay = new PayView();
		
/*-------------------------------------EVENT LISTENER(익명)------------------------------------------*/
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/03 23:40
		 * 이벤트리스너 기능: About ScreenView
		 */
		v_screen.pay_view.addActionListener(this);
		v_screen.select_movie.addActionListener(this);
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/03 23:18
		 * 이벤트리스너 기능: ScheduleView => ScheduleTimeView Check
		 */
		v_schedule.bt_next.addActionListener(this);
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/03 23:18
		 * 이벤트리스너 기능: ReserView => MyPageView
		 */
		v_reserve.bt_mypage.addActionListener(this);
		
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
		 * 수정일자: 07/01 10:01
		 * 이벤트리스너 기능: LoginView (bt_login) click => Move ReserView
		 */
		v_login.bt_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				v_login.setVisible(false);
				v_reserve.setVisible(true);
			}
		}); //bt_login actionListener
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/01 10:19
		 * 이벤트리스너 기능: ReserveSubView Action Listener 추가
		 */
		for(int i=0; i<v_reserve.subv_reserve.length; i++)
			for(int j=0; j<v_reserve.subv_reserve[i].tbt_stars.length;j++)
				v_reserve.subv_reserve[i].tbt_stars[j].addActionListener(this);
	}//생성자
	
	public static void main(String[] args) {
		new Controller();
	}
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/01 12:35
	 * 이벤트리스너 기능: ReserveSubView에서 Selected된 별의 이미지 변경
	 */
	
/*-------------------------------------EVENT LISTENER(actionPerformed)------------------------------------------*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		for(int i=0; i<v_reserve.subv_reserve.length;i++) {
			for(int j=0; j<v_reserve.subv_reserve[i].tbt_stars.length;j++) {
				if(ob == v_reserve.subv_reserve[i].tbt_stars[j]) {
					if(v_reserve.subv_reserve[i].tbt_stars[j].isSelected())
						v_reserve.setstarSelected(i, j);
					else
						v_reserve.setstarSelected(i, j);
				}
			}//for-j
		}//for-i
		
		if(ob == v_reserve.bt_mypage) {
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
	}//actionPerformed
	
}
