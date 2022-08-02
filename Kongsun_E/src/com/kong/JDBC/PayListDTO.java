package com.kong.JDBC;

public class PayListDTO {
	
	//주문번호
	private int p_no;
	
	//고객번호
	private String cus_no;
	
	//주문일시
	private String p_date;
	
	//픽업방법
	private String d_way;
	
	//결제수단
	private String p_with;
	
	//총주문금액
	private String p_total;
	
	//배달팁
	private String d_tip;
	
	//총결제금액
	private String p_sum;
	
	//배달주소
	private String addr;
	
	//요청사항
	private String req;
	
	//상호명
	private String rt;
	
	//음식
	private String menu;
	
	//배달 상태(완료 여부)
	private String statement;
	
	//이미지주소
	private String img;
	
	private String rest;

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getCus_no() {
		return cus_no;
	}

	public void setCus_no(String cus_no) {
		this.cus_no = cus_no;
	}

	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}

	public String getD_way() {
		return d_way;
	}

	public void setD_way(String d_way) {
		this.d_way = d_way;
	}

	public String getP_with() {
		return p_with;
	}

	public void setP_with(String p_with) {
		this.p_with = p_with;
	}

	public String getP_total() {
		return p_total;
	}

	public void setP_total(String p_total) {
		this.p_total = p_total;
	}

	public String getD_tip() {
		return d_tip;
	}

	public void setD_tip(String d_tip) {
		this.d_tip = d_tip;
	}

	public String getP_sum() {
		return p_sum;
	}

	public void setP_sum(String p_sum) {
		this.p_sum = p_sum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
	
}
