package com.kong.JDBC;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;



public class MenuDAO extends DBInfo	{
	public String MenuImage() {
		String mimage="";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select meimg_2 from Menu_2";
			pstmt = con.prepareStatement(sql);
			
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				mimage = rs.getString("meimg_2");
				
			}

		}catch(Exception e) {
			
		}finally {
			closeAll();
		}
		
		return mimage;
	}
	
	
	
	
	
	public int insertImg (MenuDTO n) {
		int re = -1;		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql="insert into Menu_2 (meimg_2) values(?)"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n.getMeimg_2());
			
			re = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return re;
	}
	
	public String takeImg() {
		String addr = "";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "select meimg_2 from Menu_2";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				addr = rs.getString("meimg_2");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return addr;
	}
	
	public void insertMore(MenuDTO m,String menu,String rest) {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "select m_name from member_login where m_lv=3";
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				sql = "update Menu_2 set count_2=? , price_2=?, once_2=?, cusname = ?, addr = ?, menu = ?, rest = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, m.getCount_2());
				pstmt.setString(2, m.getPrice_2());
				pstmt.setString(3, m.getOnce_2());
				pstmt.setString(4, rs.getString("m_name"));
				pstmt.setString(5, m.getAddr());
				pstmt.setString(6, menu);
				pstmt.setString(7, rest);
				
				rs = pstmt.executeQuery();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}
	
	public void insertMore2() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "select m_tip from member where m_lv=2";
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				sql = "update Menu_2 set tip=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, rs.getString("m_tip"));
				
				rs = pstmt.executeQuery();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}
	
	
	
	public void Ordering() {
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "insert into CeoMenu select * from Menu_2";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}
	
	public String orderTakeMenu() {
		String menu = "";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "select menu from pay_list2";
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
	
	public void reRoll() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "delete from Menu_2";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			sql = "delete from CeoMenu";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}
	
	public List<MenuDTO> Outing() {
		List<MenuDTO> list = new ArrayList<>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "select * from CeoMenu";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuDTO dto = new MenuDTO();
				dto.setMeimg_2(rs.getString(1)); 
				dto.setCount_2(rs.getInt(2)); 
				dto.setPrice_2(rs.getString(3)); 
				dto.setOnce_2(rs.getString(4)); 
				dto.setCusName(rs.getString(5)); 
				dto.setAddr(rs.getString(6));
				dto.setMenu(rs.getString(7));
				dto.setTip(rs.getString(8));
				dto.setRest(rs.getString(9));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	public void closeAll() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//
}

