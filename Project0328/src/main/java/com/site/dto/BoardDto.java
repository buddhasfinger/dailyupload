package com.site.dto;

import java.sql.Timestamp;

public class BoardDto {

	public BoardDto() {
	}
	
	public BoardDto(int hb_Seq, int hb_Hit, String hb_User, String hb_Title,
			String hb_Content, String hb_Date) {
		this.hb_Seq = hb_Seq;
		this.hb_User = hb_User;
		this.hb_Title = hb_Title;
		this.hb_Content = hb_Content;
		this.hb_Date = hb_Date;
		this.hb_Hit = hb_Hit;
	}

	private int hb_Seq,hb_Hit;
	private String hb_User,hb_Title,hb_Content,hb_Date;
	//private Timestamp hb_Date;
	public int getHb_Seq() {
		return hb_Seq;
	}

	public void setHb_Seq(int hb_Seq) {
		this.hb_Seq = hb_Seq;
	}

	public int getHb_Hit() {
		return hb_Hit;
	}

	public void setHb_Hit(int hb_Hit) {
		this.hb_Hit = hb_Hit;
	}


	public String getHb_User() {
		return hb_User;
	}

	public void setHb_User(String hb_User) {
		this.hb_User = hb_User;
	}

	public String getHb_Title() {
		return hb_Title;
	}

	public void setHb_Title(String hb_Title) {
		this.hb_Title = hb_Title;
	}

	public String getHb_Content() {
		return hb_Content;
	}

	public void setHb_Content(String hb_Content) {
		this.hb_Content = hb_Content;
	}

	public String getHb_Date() {
		return hb_Date;
	}

	public void setHb_Date(String hb_Date) {
		this.hb_Date = hb_Date;
	}
	
	
	
}
