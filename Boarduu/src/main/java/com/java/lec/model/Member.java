package com.java.lec.model;


public class Member {
	
	private String lm_user, lm_pw1, lm_nname;

	public Member() {
	}

	public Member(String lm_user, String lm_pw1, String lm_nname) {
		this.lm_user = lm_user;
		this.lm_pw1 = lm_pw1;
		this.lm_nname = lm_nname;
	}



	public String getLm_user() {
		return lm_user;
	}

	public void setLm_user(String lm_user) {
		this.lm_user = lm_user;
	}

	public String getLm_pw1() {
		return lm_pw1;
	}

	public void setLm_pw1(String lm_pw1) {
		this.lm_pw1 = lm_pw1;
	}

	public String getLm_nname() {
		return lm_nname;
	}

	public void setLm_nname(String lm_nname) {
		this.lm_nname = lm_nname;
	}
	
	
	
}
