package com.playdata.model;

/*
 * ScreenView용 빈즈, 상영관번호, 상영시간, 좌석번호, 잔석여부
*/
public class Screen {
	private int screen_code;
	private String screen_time;
	private String seatnum;
	private String flag;
	
	public Screen() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Screen(int screen_code, String screen_time, String seatnum, String flag) {
		super();
		this.screen_code = screen_code;
		this.screen_time = screen_time;
		this.seatnum = seatnum;
		this.flag = flag;
	}



	@Override
	public String toString() {
		return "Screen [screen_code=" + screen_code + ", screen_time=" + screen_time + ", seatnum=" + seatnum
				+ ", flag=" + flag + "]";
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
