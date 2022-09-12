package com.kong.JDBC;

public class ReviewDTO {//데이터 저장 빈 클래스 
	
	int r_no; //번호 
	String r_id; //리뷰 남긴 계정
	String r_store; //리뷰남긴 가게
	String r_point; //평점 
	String r_cont; //리뷰내용 
	String r_date;//등록날짜
	
	//기본생성자 생략 됨 

	public ReviewDTO(String r_store,String r_id, String r_point,String r_cont) {
		this.r_store=r_store;
		this.r_id=r_id; //<<변경부분>>
		this.r_point=r_point;
		this.r_cont=r_cont;
	}
	
	
	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getR_store() {
		return r_store;
	}

	public void setR_store(String r_store) {
		this.r_store = r_store;
	}

	public String getR_point() {
		return r_point;
	}

	public void setR_point(String r_point) {
		this.r_point = r_point;
	}

	public String getR_cont() {
		return r_cont;
	}

	public void setR_cont(String r_cont) {
		this.r_cont = r_cont;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date.substring(0,16); 
		//.substring(0,10) >> 0이상 10미만 사이의 연월일만 반환, 0~16: 시간까지 반환
	}
	
	

}
