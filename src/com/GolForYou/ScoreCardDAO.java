package com.GolForYou;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ScoreCardDAO extends DBInfo{
	
	public List<ScoreCardDTO> ScoreInfo(String id){
		List<ScoreCardDTO> slist = new ArrayList<>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select * from score_card where s_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ScoreCardDTO sdto = new ScoreCardDTO();
				sdto.setS_id(rs.getString("s_id"));
				sdto.setS_location(rs.getString("s_location"));
				sdto.setS_putting(rs.getInt("s_putting"));
				sdto.setS_range(rs.getInt("s_range"));
				sdto.setS_handicap(rs.getInt("s_handicap"));
				sdto.setS_date(rs.getString("s_date"));
				
				slist.add(sdto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return slist;
	}
	
	public int monthConut(String id,String month) {
		int monthCount = -1;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select count(s_date) from score_card where s_id=? and s_date like '"+month+"%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			//pstmt.setString(2, month);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				monthCount = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return monthCount;
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
