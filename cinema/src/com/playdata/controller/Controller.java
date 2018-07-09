package com.playdata.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.playdata.model.dao.MemberDAO;
import com.playdata.model.dao.MovieDAO;
import com.playdata.model.vo.Comment;
import com.playdata.model.vo.Member;
import com.playdata.model.vo.Movie;
import com.playdata.view.CreateReView;
import com.playdata.view.FindIdView;
import com.playdata.view.FindPwView;
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
//view
   LoginView v_login;
   ReserView v_reserve;
   ReView v_review;
   ScheduleView v_schedule;
   MyPageView v_mypage;
   ScreenView v_screen;
   PayView v_pay;
   CreateReView v_createreview;
   JoinView v_join;
   FindIdView v_findid;
   FindPwView v_findpw;
   
   Calendar cal = Calendar.getInstance();
//dao
   MovieDAO movie_dao;
   MemberDAO member_dao;
//int
   int selected_date;//ScheduleDateView���� ���õ� toggle button�� index�� �����ϴ� ����
   int selected_time;//ScheduleTimeView���� ���õ� toggle button�� index�� �����ϴ� ����

   String DB_movie; //������ ��ȭ�� �̸��� �����ϴ� ���� ... 0,1,2,3
   String DB_date; //Schedule â���� ������ ��¥�� �����ϴ� ���� ... 7/19
   String DB_time; //Schedule â���� ������ �ð��� �����ϴ� ���� ... 7/19
   
   int review_page; //�ı� â page ����
   int review_maxpage;   //�ı�â
//date
   String yoils[] = {"","��","��","ȭ","��","��","��","��"};
   int month = cal.get(Calendar.MONTH) + 1;
   int day = cal.get(Calendar.DATE);
   int yoil = cal.get(Calendar.DAY_OF_WEEK);
   String today = month+"/"+day+""+" ("+yoils[yoil]+")"; //month/day (yoil)
   

//String
   String login_id="login_id";
   String login_checkid=""; //�α��� �ߺ�Ȯ��
//arraylist
   ArrayList<Comment> list_comment;
   ArrayList<ReviewSubView> list_review;
   ArrayList<Movie> list_movie;
//boolean   
   boolean checkId = false; //�ߺ� üũ
   
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
      v_join = new JoinView();
      v_findid = new FindIdView();
      v_findpw = new FindPwView();
     
//dao
      movie_dao = new MovieDAO();
      member_dao = new MemberDAO();
//ScheduleDate
      for(int i=0; i<v_schedule.v_sd.length; i++) {
         v_schedule.v_sd[i].setText(combineDate(month, day)+" ("+yoils[yoil]+")");
         addDate();
      }
      v_schedule.la_date.setText("��¥ : "+today);
      
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
      review_maxpage = list_comment.size() / 4;   //�ִ� ������ ����
//set ReserView stars...
      v_reserve.setstarSelected(0, 4);
      v_reserve.setstarSelected(1, 3);
      v_reserve.setstarSelected(2, 2);
      v_reserve.setstarSelected(3, 1);
//ReserView => show movie list infos...
//      list_movie = movie_dao.movieSelectAll();
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
            boolean flag = false;   //toggle button�� ���õǾ����� ���θ� Ȯ���ϴ� ����
            
         /*--------------------toggle button üũ Ȯ��------------------*/
            for(int i=0; i<v_schedule.v_st.length; i++) {
               if(v_schedule.v_st[i].tbt_time.isSelected()) {
                  flag = true;
                  selected_time = i;
               }
            }
            
      /*--------------------toggle button üũ ���ο� ���� setEnabled() ȣ�� ------------------*/
            if(!flag) {   
               for(int j=0; j<v_schedule.v_st.length; j++)
                  v_schedule.v_st[j].tbt_time.setEnabled(true);
            }
            else {
               for(int j=0; j<v_schedule.v_st.length; j++)
                  if(selected_time != j)
                     v_schedule.v_st[j].tbt_time.setEnabled(false);
            }
            DB_time = v_schedule.v_st[selected_time].tbt_time.getText();
            System.out.println("DB_time : "+DB_time);
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
            boolean flag = false;   //toggle button�� ���õǾ����� ���θ� Ȯ���ϴ� ����
         /*--------------------toggle button üũ Ȯ��------------------*/
            for(int i=0; i<v_schedule.v_sd.length; i++) {
               if(v_schedule.v_sd[i].isSelected()) {
                  flag = true;
                  selected_date = i;
               }
            }
            
      /*--------------------toggle button üũ ���ο� ���� setEnabled() ȣ�� ------------------*/
            if(!flag) {   
               for(int j=0; j<v_schedule.v_sd.length; j++)
                  v_schedule.v_sd[j].setEnabled(true);
            }
            else {
               for(int j=0; j<v_schedule.v_sd.length; j++)
                  if(selected_date != j)
                     v_schedule.v_sd[j].setEnabled(false);
                        
            }
            DB_date = splitTbtText(v_schedule.v_sd[selected_date].getText());
            System.out.println("DB_date : "+DB_date);
            }//mouseReleased   
         });//v_schedule.v_sd[i].addMouseListener
      }//for
      
      /*
       * �ۼ���: ������
       * ��������: 07/03 20:13
       * �̺�Ʈ������ ���: ReserView => Move ReView
       */
      for(int i=0; i<v_reserve.subv_reserve.length; i++)
         v_reserve.subv_reserve[i].la_image.addMouseListener(this);
      
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
//ȭ�� ��ȯ
      v_login.bt_login.addActionListener(this);
      v_schedule.bt_next.addActionListener(this);
      v_screen.pay_view.addActionListener(this);
      v_screen.select_movie.addActionListener(this);
      v_reserve.bt_mypage.addActionListener(this);
      v_reserve.bt_logout.addActionListener(this);
      v_mypage.bt_back.addActionListener(this);
      v_review.bt_reserve.addActionListener(this);
      v_mypage.bt_check.addActionListener(this);
      v_createreview.bt_mypage.addActionListener(this);
      v_login.bt_find.addActionListener(this);
      v_login.bt_join.addActionListener(this);
      v_join.bt_reset.addActionListener(this);
      v_join.bt_submit.addActionListener(this);
      v_join.bt_checkid.addActionListener(this);
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
      v_review.la_page.setText("- "+(review_page+1)+" -");   //review â ������ �� �ؽ�Ʈ ����
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
         v_reserve.subv_reserve[i].la_title.setText(list_movie.get(i).getMovie_name());
         v_reserve.subv_reserve[i].la_percent.setText(list_movie.get(i).getRate()+" %");
         v_reserve.subv_reserve[i].la_genre.setText(list_movie.get(i).getGenre());
         v_reserve.subv_reserve[i].la_image.setIcon(new ImageIcon(list_movie.get(i).getPath()));
         v_reserve.setstarSelected(i, list_movie.get(i).getAvg_star());
      }
   }
   
   /*
    * �ۼ���: ������
    * ��������: 07/05 17:38
    * Date 3�� ��� 1 �����ִ� �Լ�
    */
   public void addDate() {
      cal.add(Calendar.DATE, 1);
//      cal.add(cal.DATE, 1);
      month = cal.get(Calendar.MONTH) + 1;
      day = cal.get(Calendar.DATE);
      yoil = cal.get(Calendar.DAY_OF_WEEK);
   }
   
   //Ȥ�� ���� ��¥ �����ϴ� �Լ�
   public void setDate(int day) {
      cal.set(Calendar.DATE, day);
      month = cal.get(Calendar.MONTH) + 1;
      day = cal.get(Calendar.DATE);
      yoil = cal.get(Calendar.DAY_OF_WEEK);
   }
   /*
    * �ۼ���: ������
    * ��������: 07/05 17:38
    * Date => 4 5 ---> 4/5
    */
   public String combineDate(int m, int d) {
      return month+"/"+day+"";
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
//main
   public static void main(String[] args) {
      new Controller();
   }
   @Override
/*-------------------------------------EVENT LISTENER(mouseclicked)------------------------------------------*/
      public void mouseClicked(MouseEvent e) {
         Object ob = e.getSource();
      /*
       * �ۼ���: ������
       * ��������: 07/03 20:13
       * �̺�Ʈ������ ���: ReserView => Move ReView
       */
      for(int i=0; i<v_reserve.subv_reserve.length; i++)
         if(ob == v_reserve.subv_reserve[i].la_image){
               v_reserve.setVisible(false);
               v_review.setVisible(true);
               
               DB_movie = list_movie.get(i).getMovie_name();
               System.out.println("DB_movie (�� ��ư) = "+DB_movie);
            }
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

         //ReserView���� ���� ��ư Ŭ����
         for(int i=0; i<4; i++) {
            if(ob ==v_reserve.subv_reserve[i].bt_reserve) {
               DB_movie = list_movie.get(i).getMovie_name();
               System.out.println("DB_movie (���� ��ư) = "+DB_movie);
            }//if
         }//for
      
/*---------------View Change EVENT---------------*/   
      if(ob == v_login.bt_login) {
        String id = v_login.tf_id.getText();
        String pass = new String(v_login.tf_pass.getPassword());
        
        if(member_dao.login(id, pass)){
           System.out.println(id +","+pass);
           JOptionPane.showMessageDialog(v_login,id+" �α��� ����!");
           v_login.setVisible(false);
           v_reserve.setVisible(true);
        }else {
           JOptionPane.showMessageDialog(v_login,id+" �α��� ����!");           
        }
        
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
      else if(ob == v_mypage.bt_check) {
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
      else if(ob == v_login.bt_find) {
         v_login.setVisible(false);
         v_findid.setVisible(true);
         v_findpw.setVisible(true);
      }
      else if(ob == v_login.bt_join) {//ȸ������������ �̵�.
         v_join.tf_id.requestFocus(); //���̵� �ؽ�Ʈ�ʵ� ��Ŀ��.
         v_login.setVisible(false);
         v_join.setVisible(true);
      }
      else if(ob == v_join.bt_checkid) {//���̵� �ߺ�Ȯ��
         String id = v_join.tf_id.getText(); 
         if(new MemberDAO().duplicate(id)) {
            v_join.showMsg("�̹� �����ϴ� ���̵��Դϴ�!");
            v_join.tf_id.setText("");
            v_join.tf_id.requestFocus();
         }else {
            if(v_join.showConfirmMsg("��밡���մϴ�! ���� ���̵� ����Ͻðڽ��ϱ�?")) {
               checkId = true;
               login_checkid = id;
            }else {
               checkId = false;
               login_checkid = "";
            }
         }
      }
      else if(ob == v_join.bt_reset) {//ȸ������ ���.
         v_join.setVisible(false);
         v_login.setVisible(true);
      }
      else if(ob == v_join.bt_submit) {
         String id = v_join.tf_id.getText();
         String pass = new String(v_join.tf_pass.getPassword());
         String pass2 = new String(v_join.tf_pass2.getPassword());
         String hint = v_join.cb_hint.getSelectedItem().toString();
         String answer = v_join.tf_hint2.getText();
         String name = v_join.tf_name.getText();
         String birth1 = v_join.tf_birth1.getText();
         String birth2 = v_join.tf_birth2.getText();
         String birth3 = v_join.tf_birth3.getText();
             
         String gender="";
         if(v_join.rb_gender1.isSelected()) {
            gender = v_join.la_man.getText().substring(0,1);
         }else if(v_join.rb_gender2.isSelected()){
            gender = v_join.la_woman.getText().substring(0,1);            
         }
         
         String phone1 = v_join.tf_phone1.getText();
         String phone2 = v_join.tf_phone2.getText();
         String phone3 = v_join.tf_phone3.getText();
         
         String email1 = v_join.tf_email1.getText();
         String email2 = v_join.tf_email2.getText();
         
         String addr1 = v_join.tf_addr.getText();
         String addr2 = v_join.tf_addr2.getText();
         
         
         // �� üũ
         if(id.length()== 0) {
            v_join.showMsg("���̵� �Է����ּ���!");
            return;
         }
         else if(pass.length()==0 || pass2.length()==0) {
            v_join.showMsg("��й�ȣ�� �Է����ּ���!");
            if(pass.length()==0) v_join.tf_pass.requestFocus();
            else v_join.tf_pass.requestFocus();
            return;
         }
         else if(answer.length()==0) {
            v_join.showMsg("��Ʈ�� ���� ���� �Է����ּ���!");
            return;
         }
         else if(name.length()==0) {
            v_join.showMsg("�̸��� �Է����ּ���!");
            return;
         }
         else if(birth1.length()==0 || birth2.length()==0 || birth3.length() ==0) {
            v_join.showMsg("��������� �Է����ּ���!");
            if(birth1.length()==0) v_join.tf_birth1.requestFocus();
            else if(birth1.length()==0) v_join.tf_birth2.requestFocus();
            else v_join.tf_birth3.requestFocus();
            return;
         }
         else if(gender.length()==0) {
            v_join.showMsg("������ üũ���ּ���!");
            return;
         }
         else if(phone1.length()==0 || phone2.length()==0 || phone3.length()==0) {
            v_join.showMsg("����ó�� �Է����ּ���!");
            if(phone1.length()==0)v_join.tf_phone1.requestFocus();
            else if(phone1.length()==0)v_join.tf_phone2.requestFocus();
            else v_join.tf_phone3.requestFocus();
            return;
         }
         else if(email1.length()==0 || email2.length()==0) {
            v_join.showMsg("�̸����� �Է����ּ���!");
            if(email1.length()==0) v_join.tf_email1.requestFocus();
            else v_join.tf_email2.requestFocus();
            return;
         }
         else if(addr1.length()==0 || addr2.length()==0) {
            v_join.showMsg("�ּҸ� �Է����ּ���!");
            if(addr1.length()==0) v_join.tf_addr.requestFocus();
            else v_join.tf_addr2.requestFocus();
            return;
         }else if(!pass.equals(pass2)){//��й�ȣ Ȯ�� ��ġ ����
            v_join.showMsg("��й�ȣ�� ��ġ���� �ʽ��ϴ�!");
            return;
         }
        String birth = birth1+birth2+birth3;
        String phone = phone1+phone2+phone3;
        String email = email1+email2;
        String addr = addr1+addr2; //�ּ� �ؽ�Ʈ�ʵ� 2�� �ʿ�����.
        
        //-------------��ȿ�� �˻�!!---------------------------------
        
         //�ߺ�üũ ���� Ȯ��
         if(checkId==true && (login_checkid.equals(id))) {
            if(new MemberDAO().join(new Member(id, pass, gender, name, birth, 
                     phone, addr, email, 0, 0, 0, hint, answer))) {
             v_join.showMsg("ȸ�������� ���ϵ帳�ϴ� ^*^");  
             v_join.setVisible(false);
             v_login.setVisible(true);            
            }else {
              v_join.showMsg("ȸ�������� �����Ͽ����ϴ�!");
            }
         }else {
            checkId=false;
            login_checkid="";
            v_join.showMsg("���̵� �ߺ�Ȯ���� ���ּ���!");
         }
      }
   }//actionPerformed
   
}