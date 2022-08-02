package com.kong.JDBC;

import java.sql.DriverManager;

public class MemberDAO extends DBInfo{
	
	public int Member_InsertCustomer(MemberDTO m) {
		int re = -1; //회원정보 수정 실패시 반환될 값
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			
			sql = "insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_email, m_gender, m_birth, m_lv) "
					+"values (m_no_seq.nextval, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, 3)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getM_id());
			pstmt.setString(2, m.getM_pw());
			pstmt.setString(3, m.getM_name());
			pstmt.setString(4, m.getM_addr());
			pstmt.setString(5, m.getM_phone());
			pstmt.setString(6, m.getM_email());
			pstmt.setString(7, m.getM_gender());
			pstmt.setString(8, m.getM_birth());
			re = pstmt.executeUpdate(); //쿼리문 수행 후 성공한 레코드 행의 개수 반환
			
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}finally {
			closeAll();
		}
		return re;
	}
	
	public int Member_InsertCeo(MemberDTO m) {
		int re = -1; //회원정보 수정 실패시 반환될 값
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			
			sql = "insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)"
					+"values (m_no_seq.nextval, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 2)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getM_id());
			pstmt.setString(2, m.getM_pw());
			pstmt.setString(3, m.getM_name());
			pstmt.setString(4, m.getM_addr());
			pstmt.setString(5, m.getM_phone());
			pstmt.setString(6, m.getM_crn());
			pstmt.setString(7, m.getM_bn());
			pstmt.setString(8, m.getM_food());
			pstmt.setString(9, m.getM_menu_1());
			pstmt.setString(10, m.getM_menu_2());
			pstmt.setString(11, m.getM_menu_3());
			pstmt.setString(12, m.getM_cost_1());
			pstmt.setString(13, m.getM_cost_2());
			pstmt.setString(14, m.getM_cost_3());
			pstmt.setString(15, m.getM_tip());
			re = pstmt.executeUpdate(); //쿼리문 수행 후 성공한 레코드 행의 개수 반환
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return re;
	}
	
	public int member_idExistCheck(String idtxt) {
		int re = 3;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select * from member where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idtxt.trim());
			rs = pstmt.executeQuery();
			if(rs.next()) { //있으면 2
				re = 2;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return re;
	}
	
	public String member_TakeId(String name, String phone) {
		String id = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select m_id from member where m_name = ? and m_phone = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("m_id");
				id = "당신의 아이디는 "+id+" 입니다.";
			}else {
				id = "해당하는 ID가 존재하지 않습니다.";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return id;
	}
	
	public String member_TakePw(String name,String id, String phone) {
		String pw = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select m_pw from member where m_name = ? and m_id = ? and m_phone = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, phone);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pw = rs.getString("m_pw");
				pw = "당신의 비밀번호는 "+pw+" 입니다.";
			}else {
				pw = "해당하는 비밀번호가 존재하지 않습니다.";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return pw;
	}
	
	public int member_Login(String id, String pw) {
		int lv = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select m_lv from member where m_id = ? and m_pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lv = rs.getInt("m_lv");		
				
				sql = "insert into member_login select * from member where m_id = ? and m_pw = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				
				pstmt.executeUpdate();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return lv;
	}
	
	public int member_Logincheck(String id) {
		int re = -1;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select * from member_login where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				re++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return re;
	}
	
	public String Customer_TakeName() {
		String name = "";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select m_name from member_login where m_lv=3";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("m_name");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return name;
	}
	
	public void customer_logout() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "delete from member_login where m_lv=3";
			pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}
	
	public void ceo_logout() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "delete from member_login where m_lv=2";
			pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}
	
	public String Ceo_Takename() {
		String name = "";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select m_name from member_login where m_lv=2";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("m_name");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}		
		return name;
	}
	
	public String Ceo_TakeID() {
		String id = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select m_id from member_login where m_lv=2";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getString("m_id");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}		
		return id;
	}
	
	public void member_Delete() {
		String id = "";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select m_id from member_login";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("m_id");
				sql = "delete from member where m_id=(select distinct m_id from member_login where m_id = ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				pstmt.executeUpdate();
				
				sql = "delete from member_login where m_id=(select distinct m_id from member_login where m_id = ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				pstmt.executeUpdate();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
	}
	
	public int member_Customerfix(MemberDTO m) {
		int re = -1;
		String id = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select distinct m_id from member_login";

			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("m_id");
				
				sql = "update member set m_pw=?, m_name=?, m_addr=?, m_phone=?, m_email=?, m_gender=?, m_birth=? "
						+ "where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m.getM_pw());
				pstmt.setString(2, m.getM_name());
				pstmt.setString(3, m.getM_addr());
				pstmt.setString(4, m.getM_phone());
				pstmt.setString(5, m.getM_email());
				pstmt.setString(6, m.getM_gender());
				pstmt.setString(7, m.getM_birth());
				pstmt.setString(8, id);
								
				re = pstmt.executeUpdate();
				
				sql = "update member_login set m_pw=?, m_name=?, m_addr=?, m_phone=?, m_email=?, m_gender=?, m_birth=? "
						+ "where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m.getM_pw());
				pstmt.setString(2, m.getM_name());
				pstmt.setString(3, m.getM_addr());
				pstmt.setString(4, m.getM_phone());
				pstmt.setString(5, m.getM_email());
				pstmt.setString(6, m.getM_gender());
				pstmt.setString(7, m.getM_birth());
				pstmt.setString(8, id);
				
				re = pstmt.executeUpdate();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return re;
	}
	
	public int member_Ceofix(MemberDTO m) {
		int re = -1;
		String id = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select distinct m_id from member_login";

			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				id = rs.getString("m_id");
				
				sql = "update member set m_pw=?, m_name=?, m_addr=?, m_phone=?, m_crn=?, m_bn=?, m_food=?, m_menu1=?, m_menu2=?, m_menu3=?, m_cost1=?, m_cost2=?, m_cost3=?, m_tip=? "
						+ "where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m.getM_pw());
				pstmt.setString(2, m.getM_name());
				pstmt.setString(3, m.getM_addr());
				pstmt.setString(4, m.getM_phone());
				pstmt.setString(5, m.getM_crn());
				pstmt.setString(6, m.getM_bn());
				pstmt.setString(7, m.getM_food());
				pstmt.setString(8, m.getM_menu_1());
				pstmt.setString(9, m.getM_menu_2());
				pstmt.setString(10, m.getM_menu_3());
				pstmt.setString(11, m.getM_cost_1());
				pstmt.setString(12, m.getM_cost_2());
				pstmt.setString(13, m.getM_cost_3());
				pstmt.setString(14, m.getM_tip());
				pstmt.setString(15, id);
								
				re = pstmt.executeUpdate();
				
				sql = "update member_login set m_pw=?, m_name=?, m_addr=?, m_phone=?, m_crn=?, m_bn=?, m_food=?, m_menu1=?, m_menu2=?, m_menu3=?, m_cost1=?, m_cost2=?, m_cost3=?, m_tip=? "
						+ "where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m.getM_pw());
				pstmt.setString(2, m.getM_name());
				pstmt.setString(3, m.getM_addr());
				pstmt.setString(4, m.getM_phone());
				pstmt.setString(5, m.getM_crn());
				pstmt.setString(6, m.getM_bn());
				pstmt.setString(7, m.getM_food());
				pstmt.setString(8, m.getM_menu_1());
				pstmt.setString(9, m.getM_menu_2());
				pstmt.setString(10, m.getM_menu_3());
				pstmt.setString(11, m.getM_cost_1());
				pstmt.setString(12, m.getM_cost_2());
				pstmt.setString(13, m.getM_cost_3());
				pstmt.setString(14, m.getM_tip());
				pstmt.setString(15, id);
								
				re = pstmt.executeUpdate();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return re;
	}
	
	public int member_TakeLV() {
		int lv = 0;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select distinct m_lv from member_login";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lv = rs.getInt("m_lv");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return lv;
	}
	
	public int  findNo(String ss) {
		  int ak=0;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql="select g_no from emp3 where g_sr=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,ss);//쿼리문의 첫번째 물음표에 정수 숫자로 번호 저장
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//검색 레코드가 하나이면 if문으로 처리
				ak=rs.getInt("g_no");
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
        try {
      	  closeAll();
        }catch(Exception e) {e.printStackTrace();}
		}
		return ak;
	}//findNo()
	
	public String TakeAddress() {
		String addr = "";
		
		try {			
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select m_addr from member_login where m_lv=3";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				addr = rs.getString("m_addr");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return addr;
	}
	
	public int  forReview() {
		int re = -1;
		String nameone = "1";
		String nametwo = "2";
		try {			
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select cusname from CeoMenu";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nameone = rs.getString("name");
				
				sql = "select m_name from member_login";
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					nametwo = rs.getString("m_name");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		if(nameone.equals(nametwo)) {
			re = 1;
		}
		return re;
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
