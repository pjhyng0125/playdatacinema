package com.playdata.model.vo;
/*
 * 무비빈즈: 영화의 정보를 저장 관리
 */

import java.sql.Date;

public class Movie {
	private String movie_name;
	private String director;
	private String actors;
	private String summary;
	private String genre;
	
	private double rate;
	private int avg_star;
	private int limit;
	private int price;
	private String path;
	private String start_date;
	private String run_date;
	private int run_time;
	private int onshow;
	

	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String movie_name, String genre, double rate, int avg_star, String path) { // reserView용
		super();
		this.movie_name = movie_name;
		this.genre = genre;
		this.rate = rate;
		this.avg_star = avg_star;
		this.path = path;
	}

	

	public Movie(String movie_name, String director, String actors, String summary, String genre, double rate, int rank,
			int avg_star, int limit, int price, String path, String start_date, String run_date, int run_time, int onshow) {
		super();
		this.movie_name = movie_name;
		this.director = director;
		this.actors = actors;
		this.summary = summary;
		this.genre = genre;
		this.rate = rate;
		this.avg_star = avg_star;
		this.limit = limit;
		this.price = price;
		this.path = path;
		this.start_date = start_date;
		this.run_date = run_date;
		this.run_time = run_time;
		this.onshow = onshow;
	}

	@Override
	public String toString() {
		return "Movie [movie_name=" + movie_name + ", director=" + director + ", actors=" + actors + ", summary="
				+ summary + ", genre=" + genre + ", rate=" + rate + ", avg_star=" + avg_star
				+ ", limit=" + limit + ", price=" + price + ", path=" + path + ", start_date=" + start_date
				+ ", run_date=" + run_date + ", run_time=" + run_time + ", onshow=" + onshow + "]";
	}

	public int getOnshow() {
		return onshow;
	}
	
	public void setOnshow(int onshow) {
		this.onshow = onshow;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getAvg_star() {
		return avg_star;
	}

	public void setAvg_star(int avg_star) {
		this.avg_star = avg_star;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getRun_date() {
		return run_date;
	}

	public void setRun_date(String run_date) {
		this.run_date = run_date;
	}

	public int getRun_time() {
		return run_time;
	}

	public void setRun_time(int run_time) {
		this.run_time = run_time;
	}
	
	
}

