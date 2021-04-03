package com.site.dto;

import java.sql.Timestamp;

public class BoardDto {

	public BoardDto() {
	}
	
	public BoardDto(int hb_Seq, int hb_Hit, int hb_Group, int hb_Step, int hb_Indent, String hb_User, String hb_Title,
			String hb_Content, String hb_File, Timestamp hb_Date) {
		this.hb_Seq = hb_Seq;
		this.hb_Hit = hb_Hit;
		this.hb_Group = hb_Group;
		this.hb_Step = hb_Step;
		this.hb_Indent = hb_Indent;
		this.hb_User = hb_User;
		this.hb_Title = hb_Title;
		this.hb_Content = hb_Content;
		this.hb_File = hb_File;
		this.hb_Date = hb_Date;
	}

	private int hb_Seq,hb_Hit,hb_Group,hb_Step,hb_Indent;
	private String hb_User,hb_Title,hb_Content,hb_File;
	private Timestamp hb_Date;
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

	public int getHb_Group() {
		return hb_Group;
	}

	public void setHb_Group(int hb_Group) {
		this.hb_Group = hb_Group;
	}

	public int getHb_Step() {
		return hb_Step;
	}

	public void setHb_Step(int hb_Step) {
		this.hb_Step = hb_Step;
	}

	public int getHb_Indent() {
		return hb_Indent;
	}

	public void setHb_Indent(int hb_Indent) {
		this.hb_Indent = hb_Indent;
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

	public String getHb_File() {
		return hb_File;
	}

	public void setHb_File(String hb_File) {
		this.hb_File = hb_File;
	}

	public Timestamp getHb_Date() {
		return hb_Date;
	}

	public void setHb_Date(Timestamp hb_Date) {
		this.hb_Date = hb_Date;
	}
	
	
	
}
