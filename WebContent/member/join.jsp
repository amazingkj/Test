<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/login.css" />
<div class="clear"></div>
<script src="../js/jquery.js"></script>

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

      if ($.trim($('#pw').val()) == '') {
          alert('비밀번호를 입력하세요!');
          $('#pw').val('').focus();
          return false;
       }

      
      if ($.trim($('#pwCheck').val()) == '') {
         alert('비밀번호를 다시 한 번 입력하세요!');
         $('#pwCheck').val('').focus();
         return false;
      }
      
      if ($.trim($('#phone').val()) == '') {
         alert('휴대폰 번호를 입력하세요!');
         $('#phone').val('').focus();
         return false;
      }
      
      if ($.trim($('#email').val()) == '') {
         alert('이메일을 입력하세요!');
         $('#email').val('').focus();
         return false;
      }
      
      if ($.trim($('input[name=gender]:radio:checked').val()) == '') {
          alert('성별을 선택하세요');
          $('#email').val('').focus();
          return false;
       }
      
   }
</script>

<%-- 회원가입 페이지 --%>

<body class="join">
<form method="post" action="member_join_ok.jsp.jsp"
      onsubmit="return check();">
<div class="joinForm">
<input type="text" name="id" id="id" class="textField" placeholder="아이디">
<input type=button class="CheckBtn" value=중복확인>
<input type="password" name="pw" id="pw" class="textField" placeholder="비밀번호"><br>
<input type="password" name="pwCheck" id="pwCheck" class="textField" placeholder="비밀번호 확인"><br>
<input type="tel" name=tel class="textField" id="phone"pattern="^[0][1][0]-\d{4}-\d{4}$" placeholder="휴대폰 번호"><br>
<input type=email name=email id=email class="textField" placeholder="이메일"><br>
<input type=button class="CheckBtn" value=이메일인증>
<input type="radio" name="gender" class="gender" value=1><label>남</label>
<input type="radio" name="gender" class="gender" value=2><label>여</label>
<input type=submit class="submitBtn" value=회원가입>
</div>
</form>
</body>

