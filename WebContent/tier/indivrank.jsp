<%@page import="com.GolForYou.ScoreCardDAO"%>
<%@page import="com.GolForYou.rankDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/header.jsp"></jsp:include>
<br/>

<%-- 개인 본문 --%>
<script src="../js/jquery.js"></script>

<%-- 개인랭크페이지는 유저 하나하나마다 페이지를 만든다? No 미친짓임 --%>
<%
	String id = request.getParameter("rId");
	String rPoint = request.getParameter("rPoint_");
	String rankno = request.getParameter("rankno");

	rankDAO dao = new rankDAO();
	ScoreCardDAO sdao = new ScoreCardDAO();
	
	int jan = sdao.monthConut(id, "1월");
	int feb = sdao.monthConut(id, "2월");
	int mar = sdao.monthConut(id, "3월");
	int apr = sdao.monthConut(id, "4월");
	int may = sdao.monthConut(id, "5월");
	int jun = sdao.monthConut(id, "6월");
	int jul = sdao.monthConut(id, "7월");
	int aug = sdao.monthConut(id, "8월");
	int sep = sdao.monthConut(id, "9월");
	int oct = sdao.monthConut(id, "10월");
	int nov = sdao.monthConut(id, "11월");
	int dec = sdao.monthConut(id, "12월");
	
	int point = dao.rankSum(id);
	
	String tierURL = null;
	String tierStr = null;
	
	if(point < -4){
		tierURL = "../images/t_d.png";
		tierStr = "다이아몬드";
	}else if(point >= -4 && point < -2){
		tierURL = "../images/t_p.png";
		tierStr = "플레티넘";
	}else if(point >= -2 && point < 0){
		tierURL = "../images/t_g.png";
		tierStr = "골드";
	}else if(point >= 0 && point < 4){
		tierURL = "../images/t_s.png";
		tierStr = "실버";
	}else{
		tierURL = "../images/t_b.png";
		tierStr = "브론즈";
	}
%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script> <!-- chart.js -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
<article class="ind_main">
	<br>
	<span class="rank_title_1" id="rank_tag_1">
		랭킹존
	</span>
	<hr style="padding:0.5px; background-color:grey; width:1300px; margin-left:	4%; border:0; margin-top:20px;">
	<div class="ind_wrap">	
		<div class="one">		
			<div class="ind_info">
				<div class="ind_profile">
					
				</div>
				<div class="ind_ID">
					<div class="ind_prof">
						<strong><%= id %></strong> 님은
					</div>
					<div class="ind_prof">
						<img id="tier_img" src=<%= tierURL %> alt="티어이미지">
						<strong style="font-color:red;"><%= tierStr %></strong> 등급입니다
					</div>
					
					
				</div>
			</div>
			
		</div>
		
		<div class="two">
			
			<div class="graph_wrap">
				<canvas id="myChart" width="300" height="70"></canvas>
	            <script>
	               const ctx = document.getElementById('myChart').getContext('2d');
	               const myChart = new Chart(ctx, {
	                   type: 'bar',
	                   data: {
	                       labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	                       datasets: [{
	                           label: '월별 골프장 방문 횟수',
	                           data: [<%= jan%>, <%= feb%>, <%= mar%>, <%= apr%>, <%= may%>, <%= jun%>, <%= jul%>, <%= aug%>, 11, 14, 2, 14],
	                           backgroundColor: [
	                               'rgba(255, 99, 132, 0.2)',
	                               'rgba(54, 162, 235, 0.2)',
	                               'rgba(255, 206, 86, 0.2)',
	                               'rgba(75, 192, 192, 0.2)',
	                               'rgba(153, 102, 255, 0.2)',
	                               'rgba(255, 159, 64, 0.2)',
	                               'rgba(255, 0, 255, 0.2)',
	                               'rgba(255, 206, 86, 0.2)',
	                               'rgba(75, 192, 192, 0.2)',
	                               'rgba(153, 102, 255, 0.2)',
	                               'rgba(255, 159, 64, 0.2)',
	                               'rgba(255, 0, 255, 0.2)'
	                           ],
	                           borderColor: [
	                               'rgba(255, 99, 132, 1)',
	                               'rgba(54, 162, 235, 1)',
	                               'rgba(255, 206, 86, 1)',
	                               'rgba(75, 192, 192, 1)',
	                               'rgba(153, 102, 255, 1)',
	                               'rgba(255, 159, 64, 1)',
	                               'rgba(255, 0, 255, 1)',
	                               'rgba(255, 206, 86, 1)',
	                               'rgba(75, 192, 192, 1)',
	                               'rgba(153, 102, 255, 1)',
	                               'rgba(255, 159, 64, 1)',
	                               'rgba(255, 0, 255, 1)'
	                           ],
	                           borderWidth: 0.7
	                       }]
	                   },
	                   options: {
	                       scales: {
	                           y: {
	                               beginAtZero: true
	                           }
	                       }
	                   }
	               });
	            </script>
			</div>
		</div>
		
		<div class="three">			
			<div class="three_one">
				<div class="ind_infowrap">
					<div class="info_rank">
						<strong><%= rankno %></strong>
					</div>
					<div class="info2" id="iPoint">
						평균 점수 : &nbsp;<%= rPoint %>
					</div>
					
					<div class="info2" id="iPutting">
						평균 퍼팅 : <i class="far fa-clipboard"></i>
					</div>
					
					<div class="info2" id="iHandicap">
						핸디캡 : 0
					</div>
					
					<div class="info2" id="iLog">
						전적 : 0
					</div>							
				</div>
			</div>
			<hr>
			
			<div class="three_two">
				
			</div>
			
		</div>
	
	</div>
	
	<script>
		var historyCount = 40; //테스트용으로 전적이 40번 있다고 가정. 나중엔 데이터베이스 내의 자료 수를 불러와야함.
		var divCount = $('.ind_history').length;  //rank class에 해당하는 div 개수(현재 0).
		
		var id = "<%= id%>";
		
		$(".three_two").html("<div class='ind_history' id='ind_history_1'>");
		
		while(historyCount > divCount){
			
			
			var divHistory = $("<div></div>").addClass("ind_history").attr('id',"ind_history_"+(divCount+1)); //
			$("#ind_history_"+divCount).after(divHistory);	//rank클래스 div 생성	
			
			$("#ind_history_"+(divCount+1)).html("<div class='iDate' id='iDate_"+(divCount+1)+"'>"); //iDate클래스 div 생성
			
			var divLocation = $("<div></div>").addClass("iLocation").attr('id',"iLocation_"+(divCount+1));
			$("#iDate_"+(divCount+1)).after(divLocation); //iLocation클래스 div 생성
			
			var divPoint = $("<div></div>").addClass("iPoint2").attr('id',"iPoint_"+(divCount+1));
			$("#iLocation_"+(divCount+1)).after(divPoint); //iPoint클래스 div 생성
			
			var divHighScore = $("<div></div>").addClass("iHighScore").attr('id',"iHighScore_"+(divCount+1));
			$("#iPoint_"+(divCount+1)).after(divHighScore); //iHighScore클래스 div 생성
			
			var divScoreCard = $("<div></div>").addClass("iScoreCard").attr('id',"iScoreCard_"+(divCount+1));
			$("#iHighScore_"+(divCount+1)).after(divScoreCard); //iHighScore클래스 div 생성
			
			document.getElementById('iDate_'+(divCount+1)).innerHTML = "생성된날짜";
			document.getElementById('iLocation_'+(divCount+1)).innerHTML = "생성된골프장소";
			document.getElementById('iPoint_'+(divCount+1)).innerHTML = "생성된포인트";
			document.getElementById('iHighScore_'+(divCount+1)).innerHTML = "생성된그날최고득점";
			document.getElementById('iScoreCard_'+(divCount+1)).innerHTML = "<i class='far fa-clipboard'></i>";
			
			divCount = $('.ind_history').length;
		}
		
		$(".ind_profile").css({
			"background-image": "url('../images/profile_default.png')",
			"background-repeat" : "no-repeat",
			"background-size" : "90px 90px",			
		});
		
		function showSCImg(i){
			window.open("scorecardImg.jsp?iDate="+$('#iDate_'+i).text()+"&id="+id,"a","width=400,height=400,left=100,top=50");
		}
		
		for(var i=1 ; i<=historyCount ; ++i){			
			$("#iScoreCard_"+i).attr("onclick","showSCImg("+i+");");
		}
	</script>

	
</article>





<jsp:include page="../include/foot.jsp"/>


