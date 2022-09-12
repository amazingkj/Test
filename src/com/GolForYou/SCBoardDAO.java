package com.GolForYou;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class SCBoardDAO extends DBInfo{
	public int insertBoard(SCBoardDTO s) {
		int re = -1;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "insert into scboard(sc_no,sc_name,sc_title,sc_pwd,sc_cont,sc_file,sc_date) values(test_scboard_seq,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getSc_name());
			pstmt.setString(2, s.getSc_title());
			pstmt.setString(3, s.getSc_pwd());
			pstmt.setString(4, s.getSc_cont());
			pstmt.setString(5, s.getSc_file());
			
			re = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return re;
	}
	
	public List<SCBoardDTO> getBoardList(){
		List<SCBoardDTO> slist = new ArrayList<>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select * from scboard order by sc_no desc";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SCBoardDTO s = new SCBoardDTO();
				
				s.setSc_name(rs.getString("sc_name"));
				s.setSc_title(rs.getString("sc_title"));
				s.setSc_pwd(rs.getString("sc_pwd"));
				s.setSc_cont(rs.getString("sc_cont"));
				s.setSc_file(rs.getString("sc_file"));
				s.setSc_hit(rs.getInt("sc_hit"));
				s.setSc_date(rs.getString("sc_date"));
				
				slist.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return slist;
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
