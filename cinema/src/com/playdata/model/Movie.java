package com.playdata.model;
/*
 * 무비빈즈: 영화의 정보를 저장 관리
 */

import java.util.Date;

public class Movie {
	
	String movie_code;		//영화 코드
	String name;			//영화 이름
	Date run_date;			//영화 상영 기간
	int rate;				//예매율
	int rank;				//영화 순위				?
	String genre;			//영화 장르
	int avg_grade;			//영화평점					?
	int limit;				//연령제한
	int price;				//가격				?
	String path;			//					?
	String run_time;		//영화 상영 시간
	
	public Movie() {
		
	}

	public Movie(String movie_code, String name, Date run_date, int rate, int rank, String genre, int avg_grade,
			int limit, int price, String path, String run_time) {
		super();
		this.movie_code = movie_code;
		this.name = name;
		this.run_date = run_date;
		this.rate = rate;
		this.rank = rank;
		this.genre = genre;
		this.avg_grade = avg_grade;
		this.limit = limit;
		this.price = price;
		this.path = path;
		this.run_time = run_time;
	}

	public String getMovie_code() {
		return movie_code;
	}

	public void setMovie_code(String movie_code) {
		this.movie_code = movie_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRun_date() {
		return run_date;
	}

	public void setRun_date(Date run_date) {
		this.run_date = run_date;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAvg_grade() {
		return avg_grade;
	}

	public void setAvg_grade(int avg_grade) {
		this.avg_grade = avg_grade;
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

	public String getRun_time() {
		return run_time;
	}

	public void setRun_time(String run_time) {
		this.run_time = run_time;
	}
	
	
}
