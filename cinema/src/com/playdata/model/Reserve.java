package com.playdata.model;

import java.sql.Date;

public class Reserve {

	private String id;
	private String key;
	private Date run_date;
	private String seatnum;
	private String screen_code;
	
	public Reserve() {
		// TODO Auto-generated constructor stub
	}
	
	public Reserve(String id, String key, Date run_date, String seatnum, String screen_code) {
		super();
		this.id = id;
		this.key = key;
		this.run_date = run_date;
		this.seatnum = seatnum;
		this.screen_code = screen_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getRun_date() {
		return run_date;
	}
	public void setRun_date(Date run_date) {
		this.run_date = run_date;
	}
	public String getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(String seatnum) {
		this.seatnum = seatnum;
	}
	public String getScreen_code() {
		return screen_code;
	}
	public void setScreen_code(String screen_code) {
		this.screen_code = screen_code;
	}
	
	
	
}
