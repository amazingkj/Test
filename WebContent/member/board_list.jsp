<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title> </title>
<link rel="stylesheet" type="text/css" href="../css/common.css" />
<link rel="stylesheet" type="text/css" href="../css/board.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>

</head>


<body>
<div class="headclear">
<div class="boardPage" >

			<div class="page_select_div"> 
			 <span class="page_select"> 
			 <select id="search_page">
					<option value="page5">5개씩</option>
					<option value="page10">10개씩</option>
					<option value="page20">20개씩</option>
					<option value="page30">30개씩</option>
					<option value="page40">40개씩</option>
					
			</select>
			</span> 
			</div>
			
<div class="boardListDiv">


</div>
<table class="boardlist">
	<thead>
		<tr>
			<th scope="col" class="boardNo"><a href="#">번호</a></th>
			<th scope="col" class="boardSubject"><a href="#">제목</a></th>
			<th scope="col" class="boardWriter"><span>글쓴이</span></th>
			<th scope="col" class="boardDate"><a href="#">날짜</a></th>
			<th scope="col" class="boardView"><a href="#">조회수</a></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td class="boardSubject">한놈</td>
			<td>한놈</td>
			<td>한놈</td>
			<td>한놈</td>
			
		</tr>
		<tr>
		
			<td>2</td>
			<td class="boardSubject">두시기</td>
			<td>두시기</td>
			<td>두시기</td>
			<td>두시기</td>
		</tr>
		<tr>
			<td>3</td>
			<td class="boardSubject">석삼</td>
			<td>석삼</td>
			<td>석삼</td>
			<td>석삼</td>

		</tr>
		<tr>
			<td>4</td>
			<td class="boardSubject">넷</td>
			<td>넷</td>
			<td>넷</td>
			<td>넷</td>
		</tr>
		<tr>
			<td>5</td>
			<td class="boardSubject">다섯</td>
			<td>다섯</td>
			<td>다섯</td>
			<td>다섯</td>
		</tr>
		
		<tr>
			<td>test</td>
			<td class="boardSubject">scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
		</tr>
		<tr>
			<td>test</td>
			<td class="boardSubject">scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
		</tr>
		
		<tr>
			<td>test</td>
			<td class="boardSubject">scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
		</tr>
		
		<tr>
			<td>test</td>
			<td class="boardSubject">scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
		</tr>
		
		<tr>
			<td>test</td>
			<td class="boardSubject">scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
			<td>scroll Test</td>
		</tr>
		
	</tbody>
</table>
</div>

<!-- 게시판 하단 목록 검색 쓰기 버튼-->
	<div class="fl_fr">
	<div class="fl">
			<input type="button" name="list" value="목록">

			<select id="search_target">
					<option value="title_content">제목+내용</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="comment">댓글</option>
					<option value="user_name">이름</option>
					<option value="nick_name">닉네임</option>
			</select>

				<div class="search_container" >
					<form class="searchForm" action="." method="post">
						<input id="search" class="search"  type="text" placeholder="검색어를 입력해 주세요">
						<button class="icon" type="submit" onclick="return false;"><i class="fas fa-search"></i>
						</button>
					</form>
				</div>

			</div>
		<div class="fr">
			<input type="button" name="write" value="쓰기">
		</div>
	<br><br>
	</div>
	<!-- 페이지 이동 바 -->
	<form action="./" method="get" class="pg_change">
	
	
	<div class="page_control">
      <a href="#">이전</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a>
      <a href="#">4</a> <a href="#">5</a> <a href="3">6</a> <a href="#">7</a>
      <a href="#">8</a> <a href="#">9</a> <a href="#">10</a> <a href="#">다음</a>
  	</div>
	
	
	</form>
	
</div>	

</body>
</html>