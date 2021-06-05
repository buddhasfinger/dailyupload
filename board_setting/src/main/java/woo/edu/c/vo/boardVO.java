package woo.edu.c.vo;

public class boardVO {
	private int bid;
	private String btitle,bwriter,bcontent,bdate;
	public boardVO(int bid, String btitle, String bwriter, String bcontent, String bdate) {
		this.bid = bid;
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bcontent = bcontent;
		this.bdate = bdate;
	}
	public boardVO() {
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
	
	@Override
	public String toString() {
		return "boardVO [bid=" + bid + ", btitle=" + btitle + ", bwriter=" + bwriter + ", bcontent=" + bcontent
				+ ", bdate=" + bdate + "]";
	}
	
	
}
