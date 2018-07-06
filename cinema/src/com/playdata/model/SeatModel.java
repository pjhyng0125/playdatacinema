package com.playdata.model;
/*
 * 저장소: 좌석 등의 정보를 저장하는 ArrayList
 */
public class SeatModel {
   private int screen_code;
   private String screen_time;
   private String seatnum;
   private String flag;

   public SeatModel() {
      // TODO Auto-generated constructor stub
   }

   @Override
   public String toString() {
      return "SeatModel [screen_code=" + screen_code + ", screen_time=" + screen_time + ", seatnum=" + seatnum
            + ", flag=" + flag + "]";
   }

   public SeatModel(int screen_code, String screen_time, String seatnum, String flag) {
      super();
      this.screen_code = screen_code;
      this.screen_time = screen_time;
      this.seatnum = seatnum;
      this.flag = flag;
   }

   public int getScreen_code() {
      return screen_code;
   }

   public void setScreen_code(int screen_code) {
      this.screen_code = screen_code;
   }

   public String getScreen_time() {
      return screen_time;
   }

   public void setScreen_time(String screen_time) {
      this.screen_time = screen_time;
   }

   public String getSeatnum() {
      return seatnum;
   }

   public void setSeatnum(String seatnum) {
      this.seatnum = seatnum;
   }

   public String getFlag() {
      return flag;
   }

   public void setFlag(String flag) {
      this.flag = flag;
   }
   
}