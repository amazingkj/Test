package com.GolForYou;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class rankDAO extends DBInfo{
	
	rankDTO rdto = new rankDTO();

	public int memberCount() { //검색조건에 맞는 게시물 개수 반환
		int totalCount = 0;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select count(*) from ranking";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return totalCount;
	}
	
	public int memberCount(String prov) { //검색조건에 맞는 게시물 개수 반환
		int totalCount = 0;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select count(*) from ranking where r_province=?";			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, prov);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return totalCount;
	}
	
	
	
	
	public List<rankDTO> rankInformation() {
		List<rankDTO> rlist = new ArrayList<>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select * from ranking order by r_sum asc";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rankDTO r = new rankDTO();
				r.setR_no(rs.getInt(1));
				r.setR_id(rs.getString(2));
				r.setR_sum(rs.getInt(3));
				r.setR_avg(rs.getInt(4));
				r.setR_putting(rs.getInt(5));
				r.setR_maxrange(rs.getInt(6));
				r.setR_avgrange(rs.getInt(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return rlist;
	}
	
	public List<String> rankId() {
		List<String> id = new ArrayList<>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select r_id from ranking order by r_sum asc";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				id.add(rs.getString(1));
				id.add(rs.getString(2));
				id.add(rs.getString(3));
				id.add(rs.getString(4));
				id.add(rs.getString(5));
				id.add(rs.getString(6));
				id.add(rs.getString(7));
				id.add(rs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return id;
	}
	
	public int rankSum(String id) {
		int sum = 9999;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			sql = "select r_sum from ranking where r_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sum = rs.getInt("r_sum");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return sum;
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
