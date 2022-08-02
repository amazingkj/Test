package com.kong.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class PayListDAO extends DBInfo{

	//결제내역 저장
	public int insertPayList(PayListDTO p) {

		int re = -1;//저장실패시 반환값

		try {
			Class.forName(driver);//jdbc드라이버 클래스 로드
			con = DriverManager.getConnection(url, user, password);//db연결 con생성
			sql = "select m_id from member_login where m_lv=3";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Class.forName(driver);//jdbc드라이버 클래스 로드
				con = DriverManager.getConnection(url, user, password);//db연결 con생성
				sql = "insert into pay_list values(payno_seq,?,sysdate,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);//쿼리문 수행 pstmt 생성
				pstmt.setString(1, rs.getString("m_id"));
				pstmt.setString(2, p.getD_way());
				pstmt.setString(3, p.getP_with());
				pstmt.setString(4, p.getP_total());
				pstmt.setString(5, p.getD_tip());
				pstmt.setString(6, p.getP_sum());
				pstmt.setString(7, p.getAddr());
				pstmt.setString(8, p.getReq());

				re = pstmt.executeUpdate();//저장 쿼리문 수행후 성공한 레코드 행의 개수를 반환
			}
			

		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {e.printStackTrace();}
		}
		return re;
	}//insertPayList()

	//결제내역 조회
	public List<PayListDTO> getPayList(){
		List<PayListDTO> plist = new ArrayList<>();//업캐스팅 하면서 컬렉션 제네릭 객체 생성

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select * from pay_list order by p_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//select문은 executeQuery()메서드로 실행
			while(rs.next()) {//복수개의 레코드이면 while반복문으로 처리하고 다음 레코드가 존재하면 참
				PayListDTO p = new PayListDTO();
				p.setP_no(rs.getInt(1));//1의 의미는 select문 뒤에 나오는 컬럼 순번이다.
				//해당 컬럼의 레코드가 정수 숫자이면 getInt() 메서드로 가져옴
				p.setCus_no(rs.getString(2));//해당 컬럼의 레코드가 문자열이면 getString()메서드로 가져옴
				p.setP_date(rs.getString(3));
				p.setD_way(rs.getString(4));
				p.setP_with(rs.getString(5));
				p.setP_total(rs.getString(6));
				p.setD_tip(rs.getString(7));
				p.setP_sum(rs.getString(8));
				p.setAddr(rs.getString(9));
				p.setReq(rs.getString(10));

				plist.add(p);//컬렉션에 추가
			}//while
		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {e.printStackTrace();}
		}
		return plist;
	}//getPayList()	
	
	public String getPrice() {
		String price = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select price_2 from ceomenu";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				price = rs.getString("price_2");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return price;
	}
	
	public String getID() {
		String id = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select m_id from member_login where m_lv=3";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("m_id");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return id;
	}
	
	public String getAddr() {
		String addr = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select addr from ceomenu";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				addr = rs.getString("addr");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return addr;
	}
	
	public String getReq() {
		String req = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select once_2 from ceomenu";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				req = rs.getString("once_2");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return req;
	}
	
	public String getMenu() {
		String menu = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select menu from ceomenu";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				menu = rs.getString("menu");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return menu;
	}
	public String getRest() {
		String rest = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select rest from ceomenu";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rest = rs.getString("rest");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return rest;
	}
	
	public void getRest2() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select restaurant from pay_list2";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				PayListDTO p = new PayListDTO();
				p.setRest(rs.getString("restaurant"));
			}
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

