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
	int seleted_date;//ScheduleDateView���� ���õ� toggle button�� index�� �����ϴ� ����
	int seleted_time;//ScheduleTimeView���� ���õ� toggle button�� index�� �����ϴ� ����
	int review_page; //�ı� â page ����
	
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
		
//show review
		list_comment = new ArrayList<>();
		list_comment.add(new Comment("a", "1234", 1));
		list_comment.add(new Comment("b", "5678", 2));
		list_comment.add(new Comment("c", "9101", 3));
		list_comment.add(new Comment("d", "1121", 4));
		list_comment.add(new Comment("e", "3141", 4));
		list_comment.add(new Comment("f", "1161", 4));
//list_comment ������ page�� ���� 4�� ������ �ڸ�Ʈ�� list�� ����

		for(int i=0; i<list_comment.size(); i++) {
			ReviewSubView r = new ReviewSubView(list_comment.get(i).getId(), list_comment.get(i).getContent(), list_comment.get(i).getStar());
			list_review.add(r);
		}//�ϴ� �� �޾ƿ�
		
/*-------------------------------------EVENT LISTENER(�͸�)------------------------------------------*/
		/*
		 * �ۼ���: ������
		 * ��������: 07/03 23:18
		 * �̺�Ʈ������ ���: ScheduleView => Check ScheduleTimeView
		 */
		for(int i=0; i<v_schedule.v_st.length; i++) {
			v_schedule.v_st[i].tbt_time.addMouseListener(new MouseAdapter() {
			@Override
				public void mouseReleased(MouseEvent e) {		
				boolean flag = false;	//toggle button�� ���õǾ����� ���θ� Ȯ���ϴ� ����
				
			/*--------------------toggle button üũ Ȯ��------------------*/
				for(int i=0; i<v_schedule.v_st.length; i++) {
					if(v_schedule.v_st[i].tbt_time.isSelected()) {
						flag = true;
						seleted_time = i;
					}
				}
				
		/*--------------------toggle button üũ ���ο� ���� setEnabled() ȣ�� ------------------*/
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
		 * �ۼ���: ������
		 * ��������: 07/03 20:13
		 * �̺�Ʈ������ ���: ScheduleView => Check ScheduleDateView
		 * (MouseReleased)
		 * ��������(!flag): �� false�� �Ǵ� ���� tbt.setEnabled(true)
		 * ����(flag): �ϳ��� true �Ǵ� ����  ���õ� �� ���� ������ tbt.setEnabled(false)
		 */
		for(int i=0; i<v_schedule.v_sd.length; i++) {
			v_schedule.v_sd[i].addMouseListener(new MouseAdapter() {
			@Override
				public void mouseReleased(MouseEvent e) {		
				boolean flag = false;	//toggle button�� ���õǾ����� ���θ� Ȯ���ϴ� ����
				
			/*--------------------toggle button üũ Ȯ��------------------*/
				for(int i=0; i<v_schedule.v_sd.length; i++) {
					if(v_schedule.v_sd[i].isSelected()) {
						flag = true;
						seleted_date = i;
					}
				}
				
		/*--------------------toggle button üũ ���ο� ���� setEnabled() ȣ�� ------------------*/
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
		 * �ۼ���: ������
		 * ��������: 07/03 20:13
		 * �̺�Ʈ������ ���: ReserView => Move ReView
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
		 * �ۼ���: ������
		 * ��������: 07/03 20:13
		 * �̺�Ʈ������ ���: ReserView => Move ScheduleView
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
		 * �ۼ���: ������
		 * ��������: 07/01 10:19
		 * �̺�Ʈ������ ���: ReserveSubView Action Listener �߰�
		 */
		for(int i=0; i<v_reserve.subv_reserve.length; i++)
			for(int j=0; j<v_reserve.subv_reserve[i].tbt_stars.length;j++)
				v_reserve.subv_reserve[i].tbt_stars[j].addActionListener(this);

		/*
		 * �ۼ���: ������
		 * ��������: 07/01 10:01
		 * �̺�Ʈ������ ���: For View Change Event
		 */
		v_login.bt_login.addActionListener(this);
		v_schedule.bt_next.addActionListener(this);
		v_screen.pay_view.addActionListener(this);
		v_screen.select_movie.addActionListener(this);
		v_reserve.bt_mypage.addActionListener(this);
	}//������
	
	public static void main(String[] args) {
		new Controller();
	}
	
	/*
	 * �ۼ���: ������
	 * ��������: 07/01 12:35
	 * �̺�Ʈ������ ���: ReserveSubView���� Selected�� ���� �̹��� ����
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
	}//actionPerformed
	
}
