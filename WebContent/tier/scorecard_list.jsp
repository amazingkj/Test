<%@ page import="com.GolForYou.SCBoardDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.GolForYou.SCBoardDAO" %>
<%@ page import="java.sql.*, java.util.*" %>
<%
	SCBoardDAO sdao = new SCBoardDAO();
	List<SCBoardDTO> slist = sdao.getBoardList();
	String id = "id1";
%>

<jsp:include page="../include/header.jsp"></jsp:include>
<br>


<%-- 스코어카드 업로드게시판 본문 --%>

<script src="../js/jquery.js"></script>

<article id="scorecard_main">
<br>
	<span class="rank_title_1" id="rank_tag">
		스코어카드 게시판
	</span>
	<hr style="padding:0.5px; background-color:grey; width:1300px; margin-left:	4%; border:0; margin-top:20px;">
	
	<div class="board_wrap">
		<table class="boardlist" id="board_sc">
			<thead>
				<tr>
					<th>번호</th>				
					<th>글제목</th>
					<th>글쓴이</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<% if(slist != null && slist.size() > 0){
				for(SCBoardDTO s : slist){ %>
			<tr>
				<td><%= s.getSc_no() %></td>
				<td><%= s.getSc_title() %></td>
				<td><%= s.getSc_name() %></td>
				<td><%= s.getSc_date() %></td>
				<td><%= s.getSc_hit() %></td>
			</tr>
			<% 		}
				}else{ 
			%>
			<tr>
				<td colspan="5">게시물이 존재하지 않습니다.</td>
			</tr>
			<% } %>
			<tr>
				<td colspan="5">
					
					<div class="search-box_sc">
						<input type="text" name="searchtxt" class="search-txt_sc" onkeyup="press();" id="search_txt" placeholder="검색어를 입력하세요">
						
						<button type="button" class="search-btn_sc" onclick="searching();"><i class="fas fa-search"></i></button>						
					</div>
					<select name="id_or_tier" class="searchboard" onchange="tierChange()">
						<option value="select_All">제목+내용</option>
						<option value="select_bornze">제목</option>
						<option value="select_silver">내용</option>
						<option value="select_gold">댓글</option>
						<option value="select_platinum">이름</option>
						<option value="select_diamond">닉네임</option>
					</select>
				<input type="button" class="CheckBtn" value="글쓰기" onclick="#">
				</td>
			</tr>
		</table>
		<div class="page_control">
	      <a href="#">이전</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a>
	      <a href="#">4</a> <a href="#">5</a> <a href="3">6</a> <a href="#">7</a>
	      <a href="#">8</a> <a href="#">9</a> <a href="#">10</a> <a href="#">다음</a>
  		</div>
	</div>

</article>

<jsp:include page="../include/foot.jsp"></jsp:include>
<br>






