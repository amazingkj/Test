<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
 <head><meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="../css/common.css" />
 <link rel="stylesheet" type="text/css" href="../css/board.css" />
 <title>게시판</title>
 </head>
 <div class="clear"></div>
 <body class="tablebody">
   <table class="tablebox">
     <tr>
      <td>제목</td>
      <td class="bottom_line"><input name="title" size="50%" class="textField" maxlength="100"></td>
     </tr>
     <tr>
      <td>파일첨부</td>
      <td><input type="file" name="question_file" id="question_file" />
      <label for="question_file" class="file-upload-button">파일 등록</label><span
	class="file-upload-button-text">*첨부파일 용량은 최대 5Mbyte입니다.</span>
      </td>
     </tr>
     <tr>
      <td>내용</td>
      <td class="bottom_line"><textarea name="memo" id="memo" cols="50%" rows="25%" ></textarea></td>
     </tr>
   	<tr>
   	  <td></td>
      <td class="buttontd" colspan="2"><input type=button class="submitBtn" value="등록">
       <input type="button" class="CheckBtn" value="취소"></td>
     </tr>
    </table>

</body> 
</html>