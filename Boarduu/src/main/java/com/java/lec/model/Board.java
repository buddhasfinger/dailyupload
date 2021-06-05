package com.java.lec.model;

public class Board {

	private int bid,bhit,bgroup,bstep,bindent;
	private String lm_user,lm_name,lm_nname,btitle,bcontent,bfilename,bdate,bpw;
	
	public Board() {
	}
	public Board(int bid, int bhit, int bgroup, int bstep, int bindent, String lm_user, String btitle, String bcontent,
			String bfilename, String bdate, String bpw,String lm_name, String lm_nname) {
		this.bid = bid;
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.lm_user = lm_user;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfilename = bfilename;
		this.bdate = bdate;
		this.bpw = bpw;
		this.lm_name= lm_name;
		this.lm_nname = lm_nname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}

	public String getLm_user() {
		return lm_user;
	}
	public void setLm_user(String lm_user) {
		this.lm_user = lm_user;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfilename() {
		return bfilename;
	}
	public void setBfilename(String bfilename) {
		this.bfilename = bfilename;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBpw() {
		return bpw;
	}
	public void setBpw(String bpw) {
		this.bpw = bpw;
	}
	public String getLm_nname() {
		return lm_nname;
	}
	public void setLm_nname(String lm_nname) {
		this.lm_nname = lm_nname;
	}
	public String getLm_name() {
		return lm_name;
	}
	public void setLm_name(String lm_name) {
		this.lm_name = lm_name;
	}
	
	
	
}
