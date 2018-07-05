package com.playdata.model;

import java.sql.Date;

public class Reserve {

	private String id;
	private String movie_name;
	private String ticket_key;
	private Date run_date;
	private String run_time;
	private String seatnum;
	private String screen_code;
	
	public Reserve() {
		// TODO Auto-generated constructor stub
	}

	public Reserve(String id, String movie_name, String ticket_key, Date run_date, String run_time, String seatnum,
			String screen_code) {
		super();
		this.id = id;
		this.movie_name = movie_name;
		this.ticket_key = ticket_key;
		this.run_date = run_date;
		this.run_time = run_time;
		this.seatnum = seatnum;
		this.screen_code = screen_code;
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

	public String getTicket_key() {
		return ticket_key;
	}

	public void setTicket_key(String ticket_key) {
		this.ticket_key = ticket_key;
	}

	public Date getRun_date() {
		return run_date;
	}

	public void setRun_date(Date run_date) {
		this.run_date = run_date;
	}

	public String getRun_time() {
		return run_time;
	}

	public void setRun_time(String run_time) {
		this.run_time = run_time;
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
