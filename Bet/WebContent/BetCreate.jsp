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
					<a href="index.jsp"><h1>내기의 神</h1></a>
					<p>what's up</p>
				</div>
				<c:choose>
					<c:when test="${loginUser eq null || loginUser.userId eq 'admin'}">
						<ul id="nav">
							<li><a href="BetOfOnelist.do?betWay=one">BetOfOne</a></li>
							<li><a href="BetOfOnelist.do?betWay=all">BetOfAll</a></li>
							<li><a href="BetOfOnelist.do?betWay=team">BetOfTeam</a></li>
							<li><a href="BetOfOnelistByState.do?state=대기">preseason
									game</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul id="nav">
							<li><a href="BetOfOnelist.do?betWay=one">BetOfOne</a></li>
							<li><a href="BetOfOnelist.do?betWay=all">BetOfAll</a></li>
							<li><a href="BetOfOnelist.do?betWay=team">BetOfTeam</a></li>
							<li><a href="BetOfOnelistByState.do?state=대기">Preseason
									game</a></li>
							<li><a href="#">Rank</a></li>
							<li><a href="attendance.jsp">Attendance</a></li>
						</ul>
					</c:otherwise>
				</c:choose>
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
							<form action="/Bet/registBet.do" method="POST">

								<table>
									<colgroup>
										<col width="90" />
										<col width="*" />
										<col width="100" />
										<col width="100" />
										<col width="100" />
									</colgroup>

									<thead>
										<tr>
											<th>제목</th>
											<td><input id="title" name="title" class="form-control"
												type="text" placeholder="제목을 입력하세요." size="60"></td>
										</tr>
										<tr>
											<th>내용</th>
											<td align="left"><input id="content" name="content"
												class="form-control" type="text" placeholder="내용을 입력하세요."
												size="60"><br> <br></td>
										</tr>

										<tr>

											<th>포인트</th>
											<td><input name="point" class="form-control" type="text"
												placeholder="포인트을 입력해주세요." size="20"></td>
										<tr>
											<th>종료날짜</th>
											<td><input id="endDate" name="endDate"
												class="form-control" type="text" placeholder="YYMMDD"
												size="50"></td>
										</tr>
										<tr>
											<th>공개여부</th>
											<td><input type="radio" name="openCheck" value="공개">공개
												<input type="radio" name="openCheck" value="비공개">비공개</td>
										</tr>

										<tr>
											<th>BetOf</th>
											<td><input type="radio" name="betWay"
												onClick="display1()" value="one">One <input
												type="radio" name="betWay" onClick="display1()" value="team">Team
												<input type="radio" name="betWay" onclick="display2()"
												value="all">All</td>
										</tr>

										<tr id="indivisual1">
											<th>포인트방식</th>
											<td><input type="radio" name="pointCheck" value="올인">올인
												<input type="radio" name="pointCheck" value="자유">자유
												<input type="radio" name="pointCheck" value="고정">고정</td>
										</tr>
								</table>
								<br>
								<div align="right">
									<button type="submit" class="btn btn btn-warning">내기생성</button>
								</div>

							</form>
						</div>
					</div>
				</div>
				<!-- // end #content -->
				<c:choose>
					<c:when test="${loginUser eq null }">
						<div id="sidebar">
							<div class="widget widget-search">
								<h2>Login</h2>
								<div class="contentarea" align="center">
									<form action="login.do" method="post">
										&nbsp;&nbsp;ID : <input type="text" name="userId"
											placeholder="아이디 " size="12"></input><br /> PW : <input
											type="password" name="password" placeholder="패스워드" size="12"></input><br></br>
										<button type="submit" class="btn btn btn-warning">로그인</button>
										<a href="signUp.jsp"><button type="button"
												class="btn btn btn-warning">회원 가입</button></a>

									</form>
								</div>
							</div>
						</div>
					</c:when>
					<c:when test="${loginUser.userId eq 'admin'}">
						<div id="sidebar">
							<div class="widget widget-search">
								<h2>회원</h2>
								<div class="contentarea" align="center">
									<form action="logout.do" method="post">
										<label>${loginUser.name }님 환영합니다.</label><br> <br> <label>포인트
											: ${loginUser.point }p</label> <br></br>
										<button type="submit" class="btn btn btn-warning">logout</button>
										<a href="adminpage.jsp"><button type="button"
												class="btn btn btn-warning">admin Page</button></a>

									</form>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div id="sidebar">
							<div class="widget widget-search">
								<h2>회원</h2>
								<div class="contentarea" align="center">
									<form action="logout.do" method="post">
										<label>${loginUser.name }님 환영합니다.</label><br> <br> <label>포인트
											: ${loginUser.point }p</label> <br></br>
										<button type="submit" class="btn btn btn-warning">logout</button>
										<a href="mypage.jsp"><button type="button"
												class="btn btn btn-warning">MyPage</button></a>

									</form>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
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
				<!-- Please don't remove my backlink -->

			</div>
			<!-- // end #footer -->
		</div>
		<!-- // end #container -->
	</div>
	<!-- // end #wrapper -->


</body>
</html>