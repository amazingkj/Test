<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/mypage.css" />
<jsp:include page="../include/header.jsp"/>
<div class="clear"></div>


<%-- 회원가입 페이지 --%>
<html>
<body id="profile">
	<div class="profileForm">
		<div class="box">
			<img class="profileImg" src="../images/member/blank_profile.png">
		</div>
		<div class="inputBoxVertical">
			<span>아이디</span><input type="text" name="id" class="textField"
				placeholder="본인 아이디 표시 될 것"><br>

			<div class="inputBoxVertical">
				<span>닉네임</span><input type="text" name="nickname" class="textField"
					placeholder="이메일"><br>
			</div>

			<div class="inputBoxVertical">
				<span>휴대폰 번호</span><input type="tel" name=tel class="textField"
					pattern="^[0][1][0]-\d{4}-\d{4}$"
					placeholder="휴대폰 번호를 입력해주세요"><br> <input
					type="button" name=button class="checkBtn" value="인증전송">
			</div>
			<div class="inputBoxVertical">
				<span>인증번호 입력</span><input type="tel" name=tel class="textField"><br>
				<input type="button" name=button class="checkBtn" value="인증하기">
			</div>

			<input type=submit class="submitBtn" value=회원정보수정>
			<div class="links">
				<a href="javascript:openPasswordPop();">비밀번호 변경하기</a> <a
					href="javascript:openWithdrawalPop();">회원 탈퇴하기</a>

			</div>
		</div>
	</div>
</body>
</html>

<script>

function openPasswordPop(){
    var url = "pwdChange.jsp";
    var name = "pwdChangePop";
    var option = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=346, height=488, top=0,left=0"; 

    window.open(url, name, option);
}


function openWithdrawalPop(){
    var url = "Withdrawal.jsp";
    var name = "WithdrawalPop";
    var option = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=346, height=488, top=0,left=0"; 

    window.open(url, name, option);
}


</script>




