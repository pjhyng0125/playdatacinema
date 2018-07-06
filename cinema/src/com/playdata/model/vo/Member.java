package com.playdata.model.vo;

import java.sql.Date;

/*
 * 멤버빈즈: 회원의 정보를 저장 관리
 */
public class Member {								// 필요사항 - 유저 비밀번호 찾기 기능 질문 해답 어디에 저장?
		
	private String id;			// 유저 id
	private String pass;		// 유저 비밀번호
	private String gender;		// 유저 성별
	private String name;		// 유저 이름
	private Date birth;			// 유저 생년월일
	private String phone;		// 유저 전화번호	
	private String addr;		// 유저 주소 -> 필요한가?
	private String mail;		// 유저 메일
	private int point;			// 유저 소유 포인트
	private int cash;			// 유저 잔액
	private int mem_grade;		// 유저 등급	
	private String hint;		// 유저 비번찾기 질문
	private String answer;		// 유저 비번찾기 답
	
	public Member() {
		
	}

	public Member(String id, String pass, String gender, String name, Date birth, String phone, String addr,
			String mail, int point, int cash, int mem_grade, String hint, String answer) {
		super();
		this.id = id;
		this.pass = pass;
		this.gender = gender;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.addr = addr;
		this.mail = mail;
		this.point = point;
		this.cash = cash;
		this.mem_grade = mem_grade;
		this.hint = hint;
		this.answer = answer;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getMem_grade() {
		return mem_grade;
	}

	public void setMem_grade(int mem_grade) {
		this.mem_grade = mem_grade;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
