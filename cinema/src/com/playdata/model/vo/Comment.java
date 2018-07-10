package com.playdata.model.vo;

public class Comment {
	private String id = "id";
	private String movie_name;
	private String content = "blank";
	private int star = 3;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String id, String movie_name, String content, int star) {
		super();
		this.id = id;
		this.movie_name = movie_name;
		this.content = content;
		this.star = star;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", movie_name=" + movie_name + ", content=" + content + ", star=" + star + "]";
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	 
}
