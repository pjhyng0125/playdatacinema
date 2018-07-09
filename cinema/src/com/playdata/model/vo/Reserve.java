package com.playdata.model.vo;

import java.sql.Date;

public class Reserve {

   private String id;
   private String movie_name;
   private String run_date;
   private String start_time;
   private String seatnum;
   private int screen_code;
   private int person_cnt;
   
   public Reserve() {
      // TODO Auto-generated constructor stub
   }

   public Reserve(String id, String movie_name, String run_date, String start_time, String seatnum, int screen_code,
         int person_cnt) {
      super();
      this.id = id;
      this.movie_name = movie_name;
      this.run_date = run_date;
      this.start_time = start_time;
      this.seatnum = seatnum;
      this.screen_code = screen_code;
      this.person_cnt = person_cnt;
   }

   @Override
   public String toString() {
      return "Reserve [id=" + id + ", movie_name=" + movie_name + ", run_date=" + run_date + ", start_time="
            + start_time + ", seatnum=" + seatnum + ", screen_code=" + screen_code + ", person_cnt=" + person_cnt
            + "]";
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getMovie_name() {
      return movie_name;
   }

   public void setMovie_name(String movie_name) {
      this.movie_name = movie_name;
   }

   public String getRun_date() {
      return run_date;
   }

   public void setRun_date(String run_date) {
      this.run_date = run_date;
   }

   public String getStart_time() {
      return start_time;
   }

   public void setStart_time(String start_time) {
      this.start_time = start_time;
   }

   public String getSeatnum() {
      return seatnum;
   }

   public void setSeatnum(String seatnum) {
      this.seatnum = seatnum;
   }

   public int getScreen_code() {
      return screen_code;
   }

   public void setScreen_code(int screen_code) {
      this.screen_code = screen_code;
   }

   public int getPerson_cnt() {
      return person_cnt;
   }

   public void setPerson_cnt(int person_cnt) {
      this.person_cnt = person_cnt;
   }

         
}