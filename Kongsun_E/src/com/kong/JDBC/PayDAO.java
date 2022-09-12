package com.kong.JDBC;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class PayDAO extends DBInfo{

	//결제내역 저장(주문번호,주문일시,픽업방법,결제수단,배달완료여부만)
	public int insertPayList(PayListDTO p) {

		int re = -1;//저장실패시 반환값

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "insert into pay_list2 values(payno_seq.nextval,?,sysdate,?,?,?,?,?,?,?,?,?,'배달 완료',?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getCus_no());
			pstmt.setString(2, p.getD_way());
			pstmt.setString(3, p.getP_with());
			pstmt.setString(4, p.getP_total());
			pstmt.setString(5, p.getD_tip());
			pstmt.setString(6, p.getP_sum());
			pstmt.setString(7, p.getAddr());
			pstmt.setString(8, p.getReq());
			pstmt.setString(9, p.getRest());
			pstmt.setString(10, p.getMenu());
			pstmt.setString(11, p.getImg());

			re = pstmt.executeUpdate();

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
	public List<PayListDTO> getPaylist() {
		List<PayListDTO> list = new ArrayList<PayListDTO>();

		try {
			Class.forName(driver);//jdbc드라이버 클래스 로드
			con = DriverManager.getConnection(url, user, password);//db연결 con생성
			//가장 최근 삽입된 레코드 출력
			sql = "select p_no,p_date,p_sum,p_with,d_way,addr,req "
					+ "from (select p_no,p_date,p_sum,p_with,d_way,addr,req,rownum as rn "
					+ "from (select p_no,p_date,p_sum,p_with,d_way,addr,req "
					+ "from pay_list2 order by p_no desc)"
					+ ") where rn=1";

			pstmt = con.prepareStatement(sql);//쿼리문 수행 pstmt 생성

			rs = pstmt.executeQuery();

			while(rs.next()) {
				PayListDTO pt = new PayListDTO();
				pt.setP_no(rs.getInt("p_no"));//주문번호
				pt.setP_date(rs.getString("p_date"));//주문일시
				pt.setP_sum(rs.getString("p_sum"));//총 결제금액
				pt.setP_with(rs.getString("p_with"));//결제수단
				pt.setD_way(rs.getString("d_way"));//픽업방법
				pt.setAddr(rs.getString("addr"));//배달주소
				pt.setReq(rs.getString("req"));;//요청사항

				list.add(pt);
			}
		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	//소비자 주문내역 조회(cus_id)
	public List<PayListDTO> Orderlist4() {
		List<PayListDTO> list4 = new ArrayList<PayListDTO>();

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select p_date,restaurant,menu "
					+ "from (select p_date,restaurant,menu,rownum as rn "
					+ "from (select p_date,restaurant,menu "
					+ "from pay_list2 p "
					+ "inner join member_login m on p.cus_no=m.m_id"
					+ "  order by p_no desc)) "
					+ "where rn=1";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				PayListDTO pt = new PayListDTO();
				pt.setP_date(rs.getString("p_date"));//주문일시
				pt.setRt(rs.getString("restaurant"));//상호명
				pt.setMenu(rs.getString("menu"));//음식
				list4.add(pt);            
			}
		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list4;
	}

	//소비자 주문내역 조회(cus_id)로
	public List<PayListDTO> Orderlist5() {
		List<PayListDTO> list5 = new ArrayList<PayListDTO>();

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select p_date,restaurant,menu "
					+ "from (select p_date,restaurant,menu,rownum as rn "
					+ "from (select p_date,restaurant,menu "
					+ "from pay_list2 p "
					+ "inner join member_login m on p.cus_no=m.m_id"
					+ "  order by p_no desc)) "
					+ "where rn=2";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				PayListDTO pt = new PayListDTO();
				pt.setP_date(rs.getString("p_date"));//주문일시
				pt.setRt(rs.getString("restaurant"));//상호명
				pt.setMenu(rs.getString("menu"));//음식
				list5.add(pt);            
			}
		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list5;
	}

	//소비자 주문내역 조회(cus_id)로
	public List<PayListDTO> Orderlist6() {
		List<PayListDTO> list6 = new ArrayList<PayListDTO>();

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select p_date,restaurant,menu "
					+ "from (select p_date,restaurant,menu,rownum as rn "
					+ "from (select p_date,restaurant,menu "
					+ "from pay_list2 p "
					+ "inner join member_login m on p.cus_no=m.m_id"
					+ "  order by p_no desc)) "
					+ "where rn=3";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				PayListDTO pt = new PayListDTO();
				pt.setP_date(rs.getString("p_date"));//주문일시
				pt.setRt(rs.getString("restaurant"));//상호명
				pt.setMenu(rs.getString("menu"));//음식
				list6.add(pt);            
			}
		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list6;
	}
	
	//점주 주문내역 조회1
	public List<PayListDTO> Orderlist7() {
		List<PayListDTO> list7 = new ArrayList<PayListDTO>();

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select p_date,restaurant,menu "
					+ "from (select p_date,restaurant,menu,rownum as rn "
					+ "from (select p_date,restaurant,menu "
					+ "from pay_list2 p "
					+ "inner join member_login m on p.restaurant=m.m_bn "
					+ "where m.m_id = 'ceo1' "
					+ "order by p_no desc)) "
					+ "where rn = 1";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				PayListDTO pt = new PayListDTO();
				pt.setP_date(rs.getString("p_date"));//주문일시
				pt.setRt(rs.getString("restaurant"));//상호명
				pt.setMenu(rs.getString("menu"));//음식
				list7.add(pt);            
			}
		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list7;
	}
	
	//점주 주문내역 조회2
	public List<PayListDTO> Orderlist8() {
		List<PayListDTO> list8 = new ArrayList<PayListDTO>();

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select p_date,restaurant,menu "
					+ "from (select p_date,restaurant,menu,rownum as rn "
					+ "from (select p_date,restaurant,menu "
					+ "from pay_list2 p "
					+ "inner join member_login m on p.restaurant=m.m_bn "
					+ "where m.m_id = 'ceo1' "
					+ "order by p_no desc)) "
					+ "where rn = 2";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				PayListDTO pt = new PayListDTO();
				pt.setP_date(rs.getString("p_date"));//주문일시
				pt.setRt(rs.getString("restaurant"));//상호명
				pt.setMenu(rs.getString("menu"));//음식
				list8.add(pt);            
			}
		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list8;
	}
	
	//점주 주문내역 조회3
	public List<PayListDTO> Orderlist9() {
		List<PayListDTO> list9 = new ArrayList<PayListDTO>();

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select p_date,restaurant,menu "
					+ "from (select p_date,restaurant,menu,rownum as rn "
					+ "from (select p_date,restaurant,menu "
					+ "from pay_list2 p "
					+ "inner join member_login m on p.restaurant=m.m_bn "
					+ "where m.m_id = 'ceo1' "
					+ "order by p_no desc)) "
					+ "where rn = 3";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				PayListDTO pt = new PayListDTO();
				pt.setP_date(rs.getString("p_date"));//주문일시
				pt.setRt(rs.getString("restaurant"));//상호명
				pt.setMenu(rs.getString("menu"));//음식
				list9.add(pt);            
			}
		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list9;
	}

	/*
	//주문내역 조회(가장 최근 삽입된 레코드 출력)
	public List<PayListDTO> Orderlist8() {
		List<PayListDTO> list = new ArrayList<PayListDTO>();

		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			sql = "select * from member_login l INNER JOIN pay_list2 p on l.m_bn=p.restaurant";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				PayListDTO pt = new PayListDTO();
				pt.setP_date(rs.getString("p_date"));//주문일시
				pt.setRt(rs.getString("restaurant"));//상호명
				pt.setMenu(rs.getString("menu"));//음식
				list.add(pt);            
			}
		} catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	*/
	
	public void reRoll() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "delete from pay_list2";
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

	public void reRoll2() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "delete from pay_list2"
					+ " where p_no =("
					+ "  select p_no"
					+ "  from("
					+ "    select p_no, row_number() over (order by p_no desc) as rn"
					+ "    from pay_list2)"
					+ "  where rn = 1"
					+ ")";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
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

	public List<PayListDTO> Outing() {
		List<PayListDTO> list = new ArrayList<>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql = "select * from pay_list2";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while(rs.next()) {
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
				p.setRest(rs.getString(11));
				p.setMenu(rs.getString(12));
				p.setStatement(rs.getString(13));
				p.setImg(rs.getString(14));


				list.add(p);
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
	}
}
