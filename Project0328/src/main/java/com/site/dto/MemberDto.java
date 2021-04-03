package com.site.dto;

import java.sql.Timestamp;

public class MemberDto {
	
	public MemberDto() {}
	
	
	
	public MemberDto(String id, String pw, String name, String nName, String email1, String email2, String tel,
			String address1, String address2, String gender, String hobby, String mDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nName = nName;
		this.email1 = email1;
		this.email2 = email2;
		this.tel = tel;
		this.address1 = address1;
		this.address2 = address2;
		this.gender = gender;
		this.hobby = hobby;
		this.mDate = mDate;
	}


	private String id,pw,name,nName,email1,email2,tel,address1,address2,gender,hobby,mDate;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getnName() {
		return nName;
	}


	public void setnName(String nName) {
		this.nName = nName;
	}



	public String getEmail1() {
		return email1;
	}



	public void setEmail1(String email1) {
		this.email1 = email1;
	}



	public String getEmail2() {
		return email2;
	}



	public void setEmail2(String email2) {
		this.email2 = email2;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getAddress1() {
		return address1;
	}



	public void setAddress1(String address1) {
		this.address1 = address1;
	}



	public String getAddress2() {
		return address2;
	}



	public void setAddress2(String address2) {
		this.address2 = address2;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	public String getmDate() {
		return mDate;
	}



	public void setmDate(String mDate) {
		this.mDate = mDate;
	}



	
	
}
