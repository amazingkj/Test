<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.GolForYou.rankDAO" %>
<%@ page import="java.sql.*, java.util.*" %>



<%	
	String prov = request.getParameter("prov");
	rankDAO dao = new rankDAO();
	int member = dao.memberCount(prov);	
	
	if(prov == null){
		member = dao.memberCount();
	}else{
		member = dao.memberCount(prov);	
	}
	
%>


<jsp:include page="../include/header.jsp"></jsp:include>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
<br/>

<%-- 랭킹 본문 --%>


<script src="../js/jquery.js"></script>




<article id="ranking_main">
	<br>
	<span class="rank_title_1" id="rank_tag_1">
		전체랭킹
	</span>	
	<hr style="padding:0.5px; background-color:grey; width:1300px; margin-left:	4%; border:0; margin-top:20px;">
	<div class="rank_title" id="rank_tag">
		<form method="post">
			
		<div class="search-box">
			<input type="text" name="searchtxt" class="search-txt" onkeyup="press();" id="search_txt" placeholder="아이디 입력">
			
			<button type="button" class="search-btn" onclick="searching();"><i class="fas fa-search"></i></button>	
				
		</div>
		<select name="id_or_tier" class="searchtier" onchange="tierChange()">
			<option value="select_All">전체</option>
			<option value="select_bornze">브론즈</option>
			<option value="select_silver">실버</option>
			<option value="select_gold">골드</option>
			<option value="select_platinum">플레티넘</option>
			<option value="select_diamond">다이아몬드</option>
		</select>
		</form>
	</div>
	
	
	<div class="category">
		<ul class="province_1">
			<li><a href="ranking.jsp">전체</a></li>
			<li>서울・경기・인천
				<ul class="province_2">
					<li><i class="fas fa-map-marker-alt"></i><a href="ranking.jsp?prov=서울"> 서울</a></li>
					<li><i class="fas fa-map-marker-alt"></i><a href="ranking.jsp?prov=경기"> 경기</a></li>
					<li><i class="fas fa-map-marker-alt"></i><a href="ranking.jsp?prov=인천"> 인천</a></li>
				</ul>
			</li>
			<li>강원</li>
			<li>충청・대전・세종
				<ul class="province_2">
					<li><i class="fas fa-map-marker-alt"></i> 충청</li>
					<li><i class="fas fa-map-marker-alt"></i> 대전</li>
					<li><i class="fas fa-map-marker-alt"></i> 세종</li>
				</ul>
			</li>
			<li>전라・광주
				<ul class="province_2">
					<li><i class="fas fa-map-marker-alt"></i> 전라</li>
					<li><i class="fas fa-map-marker-alt"></i> 광주</li>
				</ul>
			</li>
			<li>경상・부산・대구・울산
				<ul class="province_2">
					<li><i class="fas fa-map-marker-alt"></i> 경상</li>
					<li><i class="fas fa-map-marker-alt"></i> 부산</li>
					<li><i class="fas fa-map-marker-alt"></i> 대구</li>
					<li><i class="fas fa-map-marker-alt"></i> 울산</li>
				</ul>
			</li>
		</ul>
	</div>
	<div class="rank_wrap"> 
		<table class="rankList" id="rank0">
			<tr>
				<th id="Listno">#</th>
				<th id="Listprofile">프로필</th>
				<th id="Listtier">티어</th>
				<th id="Listid">아이디</th>
				<th id="Listpoint">점수</th>
				<th id="Listdriver">최대비거리</th>				
				<th id="Listcard">플레이 횟수</th>
			</tr>
		</table>	
		<div class="rank_wrap2">
		
		</div>

	</div>
	
	<script>
		var memberCount = <%= member %>; //테스트용으로 회원이 8명 있다고 가정.  나중엔 데이터베이스 내의 자료 수를 불러와야함.
		var divCount = $('.rank').length;  //rank class에 해당하는 div 개수(현재 0).
		
		//div 생성 반복문
		while(memberCount > divCount){ //while문은 돌아가고있음
			<%int j=1;%>
			
			$(".rank_wrap2").append("<div class='rank' id='rank"+(divCount+1)+"'>");
					
			$("#rank"+(divCount+1)).html("<div class='rankno' id='rankno"+(divCount+1)+"'>"); //rankno클래스 div 생성
			
			var divrankprofile = $("<div></div>").addClass("rankprofile").attr('id',"rProfile_"+(divCount+1));
			$("#rankno"+(divCount+1)).after(divrankprofile); //rankprofile클래스 div 생성
			
			var divranktier = $("<div></div>").addClass("ranktier").attr('id',"rTier_"+(divCount+1));
			$("#rProfile_"+(divCount+1)).after(divranktier); //rankdriver클래스 div 생성
						
			var divrankid = $("<div></div>").addClass("rankid").attr('id',"rId"+(divCount+1));
			$("#rTier_"+(divCount+1)).after(divrankid); //rankid클래스 div 생성
			
			var divrankpoint = $("<div></div>").addClass("rankpoint").attr('id',"rPoint_"+(divCount+1));
			$("#rId"+(divCount+1)).after(divrankpoint); //rankpoint클래스 div 생성
			
			var divrankdriver = $("<div></div>").addClass("rankdriver").attr('id',"rDriver_"+(divCount+1));
			$("#rPoint_"+(divCount+1)).after(divrankdriver); //rankdriver클래스 div 생성
						
			var divrankcard = $("<div></div>").addClass("rankcard").attr('id',"rCard_"+(divCount+1));
			$("#rDriver_"+(divCount+1)).after(divrankcard); //rankcard클래스 div 생성
			
			var divrankprov = $("<div></div>").addClass("rankprov").attr('id',"rProv_"+(divCount+1));
			$("#rCard_"+(divCount+1)).after(divrankprov); //rankcard클래스 div 생성
			
			
			$("#rankpoint"+(divCount+1)).html("<span id='rPoint_"+(divCount+1)+"'></span>");
			
			document.getElementById('rankno'+(divCount+1)).innerHTML = (divCount+1)+"위";
			//document.getElementById('rProfile_'+(divCount+1)).innerHTML = "생성된프로필";
			//document.getElementById('rId'+(divCount+1)).innerHTML = (divCount+1)+"번째아이디";
			//document.getElementById('rankpoint'+(divCount+1)).innerHTML = "생성된점수";
			document.getElementById('rDriver_'+(divCount+1)).innerHTML = "생성된거리?";
			//document.getElementById('rTier_'+(divCount+1)).innerHTML = "티어";
			document.getElementById('rCard_'+(divCount+1)).innerHTML = "생성된방문횟수?";
						
			divCount = $('.rank').length; //div는 하나만 생기고있음. 
			
			//alert(divCount);
		}//while
			
		
	</script>
	
	
	<!-- 데이터베이스에서 정보 끌고오기 -->
	<% 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "kong";
		String password = "kong";
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		//String rankid;
		if(prov == null){
			try{
				Class.forName(driver);
				con = DriverManager.getConnection(url,user,password);
				sql = "select * from ranking order by r_sum asc";
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				int i = 1;
				
				while(rs.next()) { //그때그때 출력이 계속되어야 함.
					String rankid = rs.getString("r_id");
					int rankpoint = rs.getInt("r_sum"); 	
					String rankprov = rs.getString("r_province");
					%>
					<script>
						$('#rId'+<%=i%>).append("<%=rankid%>");
						$('#rPoint_'+<%=i%>).append("<%=rankpoint%>");
						$('#rProv_'+<%=i%>).append("<%=rankprov%>");
					</script>
					<%
					++i;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
		}else{
			try{
				Class.forName(driver);
				con = DriverManager.getConnection(url,user,password);
				sql = "select * from ranking where r_province=? order by r_sum asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, prov);
				
				rs = pstmt.executeQuery();
				
				int i = 1;
				
				while(rs.next()) { //그때그때 출력이 계속되어야 함.
					String rankid = rs.getString("r_id");
					int rankpoint = rs.getInt("r_sum"); 	
					String rankprov = rs.getString("r_province");
					%>
					<script>
						$('#rId'+<%=i%>).append("<%=rankid%>");
						$('#rPoint_'+<%=i%>).append("<%=rankpoint%>");
						$('#rProv_'+<%=i%>).append("<%=rankprov%>");
					</script>
					<%
					++i;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
		}
		
		
	%>
	<script>
	//indivrank 링크, 티어 만드는 스크립트
		var tier = '';
		for(var i=1 ; i<=memberCount ; ++i){
			$("#rank"+i).attr('onclick',"location.href='indivrank.jsp?rId="+document.getElementById("rId"+i).innerHTML+"&rPoint_="+$("#rPoint_"+i).text()+"&rankno="+$("#rankno"+i).text()+"'");
			
			var tierNum = $("#rPoint_"+i).text();
			if(tierNum < -4){
				tier = 'd.png';
				document.getElementById("rTier_"+i).innerHTML = "<img class='tierPic' alt='다이아' src='../images/t_"+tier+"'>";
				$("#rTier_"+i).append("다이아몬드");
			}else if(tierNum >= -4 && tierNum < -2){
				tier = 'p.png';
				document.getElementById("rTier_"+i).innerHTML = "<img class='tierPic' alt='플레' src='../images/t_"+tier+"'>";
				$("#rTier_"+i).append("플레티넘");
			}else if(tierNum >= -2 && tierNum < 0){
				tier = 'g.png';
				document.getElementById("rTier_"+i).innerHTML = "<img class='tierPic' alt='골드' src='../images/t_"+tier+"'>";
				$("#rTier_"+i).append("골드");
			}else if(tierNum >= 0 && tierNum < 4){
				tier = 's.png';
				document.getElementById("rTier_"+i).innerHTML = "<img class='tierPic' alt='실버' src='../images/t_"+tier+"'>";
				$("#rTier_"+i).append("실버");
			}else{
				tier = 'b.png';
				document.getElementById("rTier_"+i).innerHTML = "<img class='tierPic' alt='브' src='../images/t_"+tier+"'>";
				$("#rTier_"+i).append("브론즈");
			}

			$("#rProfile_"+i).css({
				"background-image": "url('../images/profile_default.png')",
				"background-repeat" : "no-repeat",
				"background-size" : "50px 50px"
			});
		}
		
		
	</script>
		
	<script>
	//검색 관련 스크립트

	var divCount = $('.rank').length;
	
	function searchname(){
		var search = document.getElementById("search_txt").value;
		return search;
	}
	
	
	function searching(){		
		$(".rank").css({
			"display" : "block"
		});
		for(var i=1 ; i<=divCount ; ++i){
			if(searchname() == ''){
				$(".rank").css({
					"display" : "block"
				});
			}else if(!(searchname() == document.getElementById("rId"+i).innerText)){
				$("#rank"+i).css({
					"display" : "none"
				});
			}
		}
	}
	
	//티어 selectbox제어 스크립트
	<%-- 다이아:상위memeber/5 플레:상위member/5*2 골드:상위member/5*3 실버:상위member/5*4 브론즈:나머지 --%>
	
	function tierChange(){
		$(".rank").css({
			"display" : "block"
		});
		if($(".searchtier option:checked").text() == "전체"){
			$(".rank").css({
				"display" : "block"
			});
		}else{
			for(var i=1 ; i<=memberCount ; ++i){
				if(!($("#rTier_"+i).text() == $(".searchtier option:checked").text())){
					$("#rank"+i).css({
						"display" : "none"
					});
				}
			}		
		}	
	}
	
	function press(){
		if(window.event.keyCode == 13){ //13이 enter을 의미
			searching();
		}
	}
	
	</script>

</article>


<jsp:include page="../include/foot.jsp"></jsp:include>
<br>




























