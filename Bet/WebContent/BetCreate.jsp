<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>내기의 신</title>
<style>
/*   경고에 대한 style jQuery에서 사용*/
tr td.error input,tr td.error textarea,tr td.error label {
   background: red;
}
tr td p.error {
   margin: 0;
   color: red;
   font-weight: bold;
   margin-bottom: 1em;}
</style>
<link href="resources/css/style5.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style4.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="resources/js/site.js"></script>
</head>
<script>
	function display1(box) {
		indivisual1.style.display = 'block';
		company1.style.display = 'none';
	}

	function display2(box) {
		indivisual1.style.display = 'none';
		company1.style.display = 'block';
	}

	window.onload = display1
</script>
<body>
	<div id="wrapper">
		<div id="container">
			<div id="header" class="clearfix">
				<div id="logo">
					<a href="main.do"> <h1>내기의 神</h1></a>
					<p>what's up</p>
				</div>
				<%@ include file="menu.jsp"%>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">내기생성</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-head">
							<form action="registBet.do" method="POST" name="sub2">
								<c:if test="${userId eq 'admin' }">
								<table>
									<colgroup>
										<col width="150" />
										<col width="100" />
									</colgroup>
									
									<thead>
										<tr>
											<th>제목</th>
											<td><input id="title" name="title" class="form-control title validate"
												type="text" placeholder="제목을 입력하세요." size="60"></td>
										</tr>
										<tr>
											<th>내용</th>
											<td align="left"><input id="content" name="content"
												class="form-control validate content" type="text" placeholder="내용을 입력하세요."
												size="60"><br> <br></td>
										</tr>

										<tr>

											<th>포인트</th>
											<td><input name="point" class="form-control" type="text"
												placeholder="포인트을 입력해주세요." size="20"></td>
										<tr>
											<th>종료날짜</th>
											<td><input id="endDate" name="endDate"
												class="form-control validate endDate" type="Date" placeholder="YYMMDD"
												size="50"></td>
										</tr>
										
										<tr>
											<th>BetOf</th>
											<td><input type="radio" name="betWay validate All" onclick="display2()" value="All">All</td>
										</tr>
								</table>
								</c:if>
								
								
								
								<c:if test="${userId ne 'admin' }">
								<table>
									<colgroup>
										<col width="150" />
										<col width="100" />
									</colgroup>
									
									<thead>
										<tr>
											<th>제목</th>
											<td><input id="title" name="title" class="form-control validate title"
												type="text" placeholder="제목을 입력하세요." size="60"></td>
										</tr>
										<tr>
											<th>내용</th>
											<td align="left"><input id="content" name="content" class="form-control" type="text" placeholder="내용을 입력하세요."
												size="60"><br> <br></td>
										</tr>

										<tr>

											<th>포인트</th>
											<td><input name="point" class="form-control" type="text"
												placeholder="포인트을 입력해주세요." size="20">(0~${loginUser.point }p)</td>
										<tr>
											<th>종료날짜</th>
											<td><input id="endDate" name="endDate"
												class="form-control validate endDate" type="Date" placeholder="YYMMDD" size="50">(필수)</td>
										</tr>
										
										<tr>
											<th>BetOf</th>
											<td><input type="radio" name="betWay" onClick="display1()" value="One" class="validate one team all" id="one">One 
												<input type="radio" name="betWay" onClick="display1()" value="Team">Team
												<input type="radio" name="betWay" onclick="display2()" value="All">All</td>
										</tr>
										<tr>
											<th>포인트방식</th>
											<td id="indivisual1">
												<input type="radio" name="pointCheck"  value="ALLIN">올인 
												<input type="radio" name="pointCheck"  value="FREE">자유
												<input type="radio" name="pointCheck"  value="LOCK">고정</td>
										</tr>
								</table>
								</c:if>
								<br>
								<div align="right">
									<!-- <button type="button" class="btn btn btn-warning btn2">내기생성</button> -->
									<button type="submit" class="btn btn btn-warning btn2">내기생성</button>
								</div>
							</form>
<!-- <script type="text/javascript">
$('.btn2').click(function(){
	if (document.getElementById("title").value == "") {
         alert("제목을 입력해주세요");
	}else if(document.getElementById("content").value == ""){
		alert("내용을 입력해주세요");
	}else if(document.getElementById("point").value == ""){
		alert("포인트를 입력해주세요");
	}else if(document.getElementById("endDate").value == ""){
		alert("종료날짜를 입력해주세요");
	}else if($(":radio[name=" +  $(one).attr("name") + "]:checked").length==0){
		alert("팀을 선택해주세요");
	}else
		   document.sub2.submit();
	});
</script> -->
						</div>
					</div>
				</div>
				<!-- // end #content -->
				<%@ include file="usermenu.jsp"%>
			</div>
			<div id="footer">
				<p>
					&copy; copyright 2012 <a href="htp://www.dkntemplates.com"
						title="Dkntemplates">www.dkntemplates.com</a> All right reserved
				</p>

				<!-- Please don't remove my backlink -->
				<p>
					Free Web Design Templates by <a href="http://www.dkntemplates.com"
						title="Dkntemplates">Dkntemplates.com</a>
				</p>
			</div>
		</div>
	</div>

</body>
</html>