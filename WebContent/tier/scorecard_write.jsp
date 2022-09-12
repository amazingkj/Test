<%@ page import="com.GolForYou.SCBoardDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.GolForYou.SCBoardDAO" %>
<%@ page import="java.sql.*, java.util.*" %>
<%
	SCBoardDAO sdao = new SCBoardDAO();
%>

<jsp:include page="../include/header.jsp"></jsp:include>
<br>
<script src="../js/jquery.js"></script>

<%-- 스코어카드 게시판 글쓰기페이지 본문 --%>

<script>
	function check(){
		
	}
</script>

<article class="scboardwrite_main">
<br>
	<span class="rank_title_1" id="rank_tag">
		글쓰기
	</span>
	<hr style="padding:0.5px; background-color:grey; width:1300px; margin-left:	4%; border:0; margin-top:20px;">
	<form method="post" action="scorecard_write_ok.jsp" onsubmit="return check();">
	<table border="1">
		<tr>
			<td>제목 <input name="sc_title" class="sc_text" id="sc_title"></td>			
		</tr>
		
		<tr>
			<td>비밀번호 설정<input type="password" name="sc_pwd" class="sc_text" id="sc_pwd"></td>
		</tr>
		
		<tr>
			<td>파일 첨부
			<input type="file" name="sc_file" id="sc_file">
			<label for="sc_file" class="file_upload_button_sc">파일 등록</label>
			</td>
		</tr>
		
		<tr>
			<td>내용<textarea name="sc_cont" class="sc_text" id="sc_cont"></textarea></td>
		</tr>
		
		<tr>
			<td><input type="button" name="sc_submit" class="submitBtn" id="sc_submit" value="글쓰기" onclick="location:'scorecard_write.jsp'"></td>
		</tr>
	</table>
		
	
		
	</form>
</article>

<jsp:include page="../include/foot.jsp"></jsp:include>
<br>
