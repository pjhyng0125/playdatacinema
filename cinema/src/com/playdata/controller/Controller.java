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
	int seleted_date;//ScheduleDateView���� ���õ� toggle button�� index�� �����ϴ� ����
	int seleted_time;//ScheduleTimeView���� ���õ� toggle button�� index�� �����ϴ� ����
	int seleted_movie; //������ ��ȭ�� index�� �����ϴ� ���� ... 0,1,2,3
	int review_page; //�ı� â page ����
	int review_maxpage;	//�ı�â 
	
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

//review â �ı� ������ ����Ʈ�� ���� ---> �ı� â�� ��ﶧ���� �Ʒ��� 3���� �����־�� �Ѵ�.
		v_review.rewriteReview(selectReview(list_comment, 0));
		v_review.bt_back.setEnabled(false);
		review_maxpage = list_comment.size() / 4;	//�ִ� ������ ����
//set ReserView stars...
		v_reserve.setstarSelected(0, 4);
		v_reserve.setstarSelected(1, 3);
		v_reserve.setstarSelected(2, 2);
		v_reserve.setstarSelected(3, 1);
//ReserView => show movie list infos...
		list_movie = movie_dao.movieSelectAll();
		list_movie = new ArrayList<>();
		list_movie.add(new Movie("��Ʈ��", "�׼��ڹ̵�", 50.0, 4, "image/antman.png"));
		list_movie.add(new Movie("�����丮", "��ΰ���", 25.0, 3, "image/her_story.png"));
		list_movie.add(new Movie("Ž��", "�׼��ڹ̵�", 20.0, 2, "image/returns.png"));
		list_movie.add(new Movie("����", "�׼��ڹ̵�", 15.0, 0, "image/witch.png"));
		showReserveInfo(list_movie);
		
/*-------------------------------------EVENT LISTENER(�͸�)------------------------------------------*/
		
		/*
		 * �ۼ���: ������
		 * ��������: 07/03 23:18
		 * �̺�Ʈ������ ���: ReView => ���� ��ư Ŭ�� & ���� ��ư Ŭ��
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
	}//������
	
	/*
	 * �ۼ���: ������
	 * ��������: 07/04 17:34
	 * selectReview: ReView => �������� �ش��ϴ� 4���� ReviewSubView�� ��� ���� ��ȯ 
	 */
	public ArrayList<Comment> selectReview(ArrayList<Comment> v_in, int review_page){
		v_review.la_page.setText("- "+(review_page+1)+" -");	//review â ������ �� �ؽ�Ʈ ����
		ArrayList<Comment> v_out = new ArrayList<>();
		for(int i=0; i<v_in.size(); i++)
			if((i/4) == review_page)
				v_out.add(v_in.get(i));
		return v_out;
	}
	
	/*
	 * �ۼ���: ������
	 * ��������: 07/05 17:38
	 * selectReview: ReserView => 4���� ��ȭ ������ ReserView ȭ�鿡 �ѷ��ִ� �Լ�
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
	 * �ۼ���: ������
	 * ��������: 07/01 12:35
	 * �̺�Ʈ������ ���: ReserveSubView���� Selected�� ���� �̹��� ����
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
			if(v_reserve.sendConfirmedMsg("�α׾ƿ� �Ͻðڽ��ϱ�?") == 0) {
				v_reserve.sendshowMsg("�α׾ƿ� �Ǿ����ϴ�.");
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
