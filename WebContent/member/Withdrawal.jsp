<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/mypage.css" />
<div class="clear"></div>

<body>

	<div class="WithdrawalBody">
		<h3>계정삭제하기</h3>
		<form id="Withdrawal_Form" name="Withdrawal_Form" method="post"
			onsubmit="return false;" div>
		
		<p class="deleteIdTxt01">계정 삭제 시 기존 수강권과 게시글 등 회원님의 모든 활동 정보가 삭제 됩니다. </p> 
		<p class="deleteIdTxt02"><strong>계정 삭제 사유</strong> </p> 
		<textarea id="Bye_cont" name="leave_content" 
		cols="30" rows="2" placeholder="계정 삭제 사유를 남겨주시면 보다 나은 서비스를 제공할 수 있도록 노력하는 golForYou가 되겠습니다."></textarea>
		<hr/>
		<p class="deleteIdTxt02"><strong>정말로 계정을 삭제하시겠습니다? </strong></p> 
		<button type="button" id="btn_change_password" class="checkBtn">계속 사용하기</button>
		<button type="button" id="RealByeButton" class="checkBtn">계정 삭제하기</button>
		</form>
	</div>
</body>


