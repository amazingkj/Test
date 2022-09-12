<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/mypage.css" />
<div class="clear"></div>

<body>

	<div class="popupBody">
		<h3>비밀번호 변경하기</h3>
		<form id="password_Form" name="password_form" method="post"
			onsubmit="return false;" div>
		
			<div class="inputBox">
				<label for="mem_password">현재 비밀번호</label>
				<input type="password" id="mem_password" name="mem_password"
					placeholder="********" autocomplete="on">
			</div>
			
			<div class="inputBox">
			<label for="new_mem_password">새 비밀번호</label>
				<input type="password" id="new_mem_password" name="mem_password"
					placeholder="********" autocomplete="on" minlength="8"
					maxlength="20">
			</div>
			
			<div class="inputBox">
			<label for="new_mem_password_confirm">새 비밀번호 확인</label>
				<input type="password" id="new_mem_password_confirm"
					name="mem_password" placeholder="********" autocomplete="on"
					minlength="8" maxlength="20">
			</div>
			<button type="button" id="btn_change_password" class="checkBtn">변경하기</button>
		</form>
	</div>


</body>


