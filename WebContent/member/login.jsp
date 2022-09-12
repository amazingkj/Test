<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/login.css" />
<div class="clear"></div>
<html>
<head><title></title></head>
<body class="login">
<script src="../js/jquery.js"></script>
<%
  if(session.getAttribute("user_id") == null) {
	  //로그인 상태 확인, 로그아웃 상태
 %>
<script>
   function check() {
      if ($.trim($('#id').val()) == '') {//trim()함수는 양쪽 공백을 제거
         alert('아이디를 입력하세요!');
         $('#id').val('').focus();
         return false;
      }

      if ($.trim($('#pw').val()) == '') {
         alert('비밀번호를 입력하세요!');
         $('#pw').val('').focus();
         return false;
      }
   }
</script>
<div class="loginForm">
<form action="member_login_do.jsp" method=post>
<input type="text" name="user_id" class="textField" placeholder="아이디"><br>
<input type="password" name="user_pwd" class="textField" placeholder="비밀번호"><br>
<input type=submit class="submitBtn" value=로그인>
<input type=checkbox name=maintainlogin class="checkbox" value=로그인상태유지><span>로그인 상태 유지</span><br>
</form> 
<div class="links">
<a href="./join.jsp">회원가입</a>
<a href="./findpwd.jsp">비밀번호 찾기</a>
</div>
</div>

<%
}else{ //로그인 된 상태
%> 

 <%=session.getAttribute("user_id") %> 회원님, 로그인 하셨습니다. <br/>
 <a href="logout.jsp">[로그아웃]</a>
 
<%}%>
<%-- 로그인 페이지 --%>

</body>
</html>

