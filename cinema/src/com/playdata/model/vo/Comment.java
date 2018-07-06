package com.playdata.model.vo;

public class Comment {
	private String id = "id";
	private String content = "blank";
	private int star = 3;
	
	public Comment(String id, String content, int star) {
		super();
		this.id = id;
		this.content = content;
		this.star = star;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
