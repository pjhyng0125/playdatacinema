package com.playdata.model.vo;

/*
 * ScreenView용 빈즈, 상영관번호, 상영시간, 좌석번호, 잔석여부
*/
public class Screen {
   private int screen_code;
   private String run_date;
   private String start_time;
   private String seatnum;
   private String flag;
   
   public Screen() {
      // TODO Auto-generated constructor stub
   }

public Screen(int screen_code, String run_date, String start_time, String seatnum, String flag) {
	super();
	this.screen_code = screen_code;
	this.run_date = run_date;
	this.start_time = start_time;
	this.seatnum = seatnum;
	this.flag = flag;
}

public int getScreen_code() {
	return screen_code;
}

public void setScreen_code(int screen_code) {
	this.screen_code = screen_code;
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

public String getFlag() {
	return flag;
}

public void setFlag(String flag) {
	this.flag = flag;
}

@Override
public String toString() {
	return "Screen [screen_code=" + screen_code + ", run_date=" + run_date + ", start_time=" + start_time + ", seatnum="
			+ seatnum + ", flag=" + flag + "]";
}
  
   
}