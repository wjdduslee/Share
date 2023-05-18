package study.dto;

import java.util.Date;

public class Board {
	
	//dto Board에 주석 추가
	private int boardno;
	private String title;
	private String userid;
	private String content;
	private int hit;
	private Date write_date;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", title=" + title + ", userid=" + userid + ", content=" + content
				+ ", hit=" + hit + ", write_date=" + write_date + "]";
	}

	public Board(int boardno, String title, String userid, String content, int hit, Date write_date) {
		super();
		this.boardno = boardno;
		this.title = title;
		this.userid = userid;
		this.content = content;
		this.hit = hit;
		this.write_date = write_date;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
	

}
