package com.kong.JDBC;
//JDBC연동 클래스 

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO extends DBInfo{ //통합 할 때 1522 > 1521로 변경
	
	//리뷰 저장 
	public int insertReview(ReviewDTO r) {
		int re=-1;//저장 실패시 반환값 
		
		try {//모듈화
			Class.forName(driver); //JDBC Driver class 로드
			con=DriverManager.getConnection(url, user, password);//db연결 con생성 
			sql="insert into reviewbook (r_no,r_id,r_store,r_point,r_cont,"
					+"r_date) values(rno_seq.nextval,?,?,?,?,sysdate)"; 
			
			pstmt=con.prepareStatement(sql); //쿼리문 수행  pstmt생성 
			pstmt.setString(1,r.getR_id()); //쿼리문 첫번째 물음표에 문자열로 글쓴이를 저장 
			pstmt.setString(2,r.getR_store());
			pstmt.setString(3,r.getR_point());
			pstmt.setString(4,r.getR_cont());
			
						
			re=pstmt.executeUpdate(); //저장 쿼리문 수행후 성공한 레코드 행의 개수 반환 			
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(con !=null) con.close();
			}catch(Exception e) {e.printStackTrace();}
			
		}
		return re;
		
	}//insertReview	
	
	//리뷰 목록 
	public List<ReviewDTO> getKongList(){
		List<ReviewDTO> rlist=new ArrayList<>(); //업캐스팅 하면서 컬렉션 제네릭 객체 생성 
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			
			sql = " select m_no,r_id,r_store,r_point,r_cont,r_date from member_login l INNER JOIN reviewbook r on l.m_bn=r.r_store order by r_date desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// select문은 executeQuery()메서드로 실행
			
			while(rs.next()) {//복수개의 레코드이면 while반복문으로 처리하고, 다음 레코드가 존재하면 참 
				ReviewDTO r = new ReviewDTO(driver, driver, driver, driver);
				r.setR_no(rs.getInt(1)); 
				r.setR_id(rs.getString(2)); 
				r.setR_store(rs.getString(3));
				r.setR_point(rs.getString(4));
				r.setR_cont(rs.getString(5));
				r.setR_date(rs.getString("r_date"));
				
				rlist.add(r);
			}//while
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
			}
		 
		return rlist;	
	}//rList
	
	public String getBN() {
		String bn = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select m_bn from member where m_id='ceo1'";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bn = rs.getString("m_bn");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return bn;
	}
	
	public int reviewOn() {
		int re = -1;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select cus_no from pay_list2";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sql = "update reviewalarm set point=1, m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, rs.getString("cus_no"));
				
				re = pstmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return re;
	}
	
	public void reviewOff() {
		int re = -1;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "update reviewalarm set point=0 and m_id=null";
			pstmt = con.prepareStatement(sql);
			
			re = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}
	
	public void closeAll() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}