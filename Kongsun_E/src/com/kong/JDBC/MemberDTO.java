package com.kong.JDBC;

public class MemberDTO {
	
	private int m_no;  //순번
	private String m_id;  //아이디
	private String m_pw;  //비밀번호
	private String m_name;  //이름
	private String m_addr;  //주소
	private String m_phone;  //폰번호
	
	private String joindate;  //가입일
	
	//개인회원 전용
	private String m_email;  //이메일
	private String m_gender;  //성별
	private String m_birth;  //생일
	//개인회원 전용
	
	//
	private String m_crn;  //사업자등록번호
	private String m_bn;  //상호명
	private String m_food;  //음식종류
	private String m_menu_1;  //메뉴1
	private String m_menu_2;  //메뉴2
	private String m_menu_3;  //메뉴3
	private String m_cost_1;  //가격1
	private String m_cost_2;  //가격2
	private String m_cost_3;  //가격3
	private String m_tip;  //배달팁
	
	public String getM_cost_1() {
		return m_cost_1;
	}

	public void setM_cost_1(String m_cost_1) {
		this.m_cost_1 = m_cost_1;
	}

	public String getM_cost_2() {
		return m_cost_2;
	}

	public void setM_cost_2(String m_cost_2) {
		this.m_cost_2 = m_cost_2;
	}

	public String getM_cost_3() {
		return m_cost_3;
	}

	public void setM_cost_3(String m_cost_3) {
		this.m_cost_3 = m_cost_3;
	}

	
	public String getM_menu_1() {
		return m_menu_1;
	}

	public void setM_menu_1(String m_menu_1) {
		this.m_menu_1 = m_menu_1;
	}

	public String getM_menu_2() {
		return m_menu_2;
	}

	public void setM_menu_2(String m_menu_2) {
		this.m_menu_2 = m_menu_2;
	}

	public String getM_menu_3() {
		return m_menu_3;
	}

	public void setM_menu_3(String m_menu_3) {
		this.m_menu_3 = m_menu_3;
	}

	public String getM_tip() {
		return m_tip;
	}

	public void setM_tip(String m_tip) {
		this.m_tip = m_tip;
	}

	private int m_lv;  //관리자(1),사업자(2),개인회원(3) 구분

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_gender() {
		return m_gender;
	}

	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}

	public String getM_birth() {
		return m_birth;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public String getM_crn() {
		return m_crn;
	}

	public void setM_crn(String m_crn) {
		this.m_crn = m_crn;
	}

	public String getM_bn() {
		return m_bn;
	}

	public void setM_bn(String m_bn) {
		this.m_bn = m_bn;
	}

	public String getM_food() {
		return m_food;
	}

	public void setM_food(String m_food) {
		this.m_food = m_food;
	}

	public int getM_lv() {
		return m_lv;
	}

	public void setM_lv(int m_lv) {
		this.m_lv = m_lv;
	}
	
}
