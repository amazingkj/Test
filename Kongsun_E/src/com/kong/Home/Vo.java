package com.kong.Home;
public class Vo {
	private int g_no;//방명록 번호
	private String g_name;//글쓴이
	private String g_title;//글제목
	private String g_cont;//글내용
	private int g_hit;//조회수
	private String g_date;//등록날짜
	
	
	
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_title() {
		return g_title;
	}
	public void setG_title(String g_title) {
		this.g_title = g_title;
	}
	public String getG_cont() {
		return g_cont;
	}
	public void setG_cont(String g_cont) {
		this.g_cont = g_cont;
	}
	public int getG_hit() {
		return g_hit;
	}
	public void setG_hit(int g_hit) {
		this.g_hit = g_hit;
	}
	public String getG_date() {
		return g_date;
	}
	public void setG_date(String g_date) {
		this.g_date = g_date;
	}
}
